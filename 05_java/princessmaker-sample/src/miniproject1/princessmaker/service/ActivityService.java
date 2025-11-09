package miniproject1.princessmaker.service;

import miniproject1.princessmaker.model.Activity;
import miniproject1.princessmaker.model.ActivityType;
import miniproject1.princessmaker.model.Princess;
import miniproject1.princessmaker.model.Stats;
import miniproject1.princessmaker.model.job.Job;
import miniproject1.princessmaker.util.RandomGenerator;
import miniproject1.princessmaker.view.GameView;

/**
 * 활동 실행과 관련된 비즈니스 로직을 처리하는 서비스 클래스
 * 활동 선택, 확률 계산, 능력치 증가, 직업 보너스 적용 등을 담당
 */
public class ActivityService {

    /**
     * 활동을 실행하는 메인 메서드
     * 1. 활동 전 능력치 저장 (변화량 계산용)
     * 2. 성공 수준 결정 (피로도에 따라 확률 달라짐)
     * 3. 활동 진행 애니메이션 출력
     * 4. 기본 능력치 증가 계산 (ActivityType에서)
     * 5. 직업 보너스 적용 (직업이 있는 경우)
     * 6. 실제 능력치에 적용
     * 7. 결과 출력
     * 8. 한 달 진행
     *
     * @param princess 프린세스 객체
     * @param activityType 선택한 활동 타입
     */
    public void executeActivity(Princess princess, ActivityType activityType) {
        Stats stats = princess.getStats();

        // 1. 활동 전 능력치 저장 (변화량 계산용)
        int beforePhysical = stats.getPhysical();
        int beforeIntelligence = stats.getIntelligence();
        int beforeCharm = stats.getCharm();
        int beforeFatigue = stats.getFatigue();

        // 2. 성공 수준 결정 (피로도에 따라 확률 달라짐)
        boolean isHighFatigue = stats.isHighFatigue();
        int successLevel = RandomGenerator.determineSuccessLevel(isHighFatigue);
        String successLevelName = RandomGenerator.getSuccessLevelName(successLevel);

        // 3. 활동 진행 애니메이션 출력
        boolean hasJob = princess.hasJob();
        String jobMessage = hasJob ?
                princess.getJob().getActivityStartMessage(activityType.getName()) : "";
        GameView.showActivityProgress(activityType.getName(), hasJob, jobMessage);

        // 4-6. 능력치 증가 계산 및 적용
        if (activityType == ActivityType.REST) {
            // 휴식은 특별 처리 (직업 보너스 없음, 항상 성공)
            activityType.execute(stats, successLevel);
        } else {
            // 일반 활동: 기본 증가량 계산 후 직업 보너스 적용
            applyActivityWithJobBonus(princess, activityType, successLevel);
        }

        // 7. 결과 출력 (변화량 계산을 위해 이전 값 전달)
        Stats beforeStats = createBeforeStats(beforePhysical, beforeIntelligence,
                beforeCharm, beforeFatigue);
        GameView.showActivityResult(activityType.getName(), successLevelName,
                princess, beforeStats);

        // 8. 한 달 진행
        princess.advanceMonth();
    }

    /**
     * 활동 실행 시 직업 보너스를 적용
     * 기본 증가량을 계산하고, 직업이 있으면 보너스를 곱한 후 적용
     *
     * @param princess 프린세스 객체
     * @param activityType 활동 타입
     * @param successLevel 성공 수준
     */
    private void applyActivityWithJobBonus(Princess princess, ActivityType activityType,
                                           int successLevel) {
        Stats stats = princess.getStats();

        // 기본 증가량 계산을 위해 임시 Stats 생성
        Stats tempStats = new Stats();
        activityType.execute(tempStats, successLevel);

        // 기본 증가량 계산 (임시 Stats - 초기값 10)
        int basePhysicalIncrease = tempStats.getPhysical() - 10;
        int baseIntelligenceIncrease = tempStats.getIntelligence() - 10;
        int baseCharmIncrease = tempStats.getCharm() - 10;

        // 직업 보너스 적용
        int finalPhysicalIncrease = basePhysicalIncrease;
        int finalIntelligenceIncrease = baseIntelligenceIncrease;
        int finalCharmIncrease = baseCharmIncrease;

        if (princess.hasJob() && successLevel > 0) {
            Job job = princess.getJob();
            // 각 능력치에 직업 보너스 적용
            finalPhysicalIncrease = job.applyBonus("physical", basePhysicalIncrease);
            finalIntelligenceIncrease = job.applyBonus("intelligence", baseIntelligenceIncrease);
            finalCharmIncrease = job.applyBonus("charm", baseCharmIncrease);
        }

        // 실제 능력치에 적용
        if (finalPhysicalIncrease > 0) {
            stats.increasePhysical(finalPhysicalIncrease);
        }
        if (finalIntelligenceIncrease > 0) {
            stats.increaseIntelligence(finalIntelligenceIncrease);
        }
        if (finalCharmIncrease > 0) {
            stats.increaseCharm(finalCharmIncrease);
        }

        // 피로도 증가 (활동 타입에 따라)
        stats.increaseFatigue(activityType.getFatigueIncrease());
    }

    /**
     * 이전 능력치 값으로 임시 Stats 객체 생성
     * 변화량 계산을 위해 사용
     *
     * @param physical 체력
     * @param intelligence 지력
     * @param charm 매력
     * @param fatigue 피로도
     * @return 생성된 Stats 객체
     */
    private Stats createBeforeStats(int physical, int intelligence, int charm, int fatigue) {
        Stats stats = new Stats();

        // 초기값(10)과의 차이만큼 증가
        int physicalDiff = physical - 10;
        int intelligenceDiff = intelligence - 10;
        int charmDiff = charm - 10;

        if (physicalDiff > 0) stats.increasePhysical(physicalDiff);
        if (intelligenceDiff > 0) stats.increaseIntelligence(intelligenceDiff);
        if (charmDiff > 0) stats.increaseCharm(charmDiff);

        // 피로도 설정
        if (fatigue > 0) stats.increaseFatigue(fatigue);

        return stats;
    }
}