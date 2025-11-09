package miniproject1.princessmaker.view;

import miniproject1.princessmaker.model.ActivityType;
import miniproject1.princessmaker.model.Ending;
import miniproject1.princessmaker.model.Princess;
import miniproject1.princessmaker.model.Stats;

/**
 * 게임의 모든 콘솔 출력을 담당하는 클래스
 * View 역할을 수행하며, 게임의 화면 표시 로직을 집중 관리
 * static 메서드로 구성되어 객체 생성 없이 사용 가능
 */
public class GameView {
    // 구분선 상수
    private static final String SEPARATOR = "================================================";
    private static final String THIN_SEPARATOR = "------------------------------------------------";

    /**
     * 게임 시작 환영 메시지 출력
     */
    public static void showWelcomeMessage() {
        System.out.println(SEPARATOR);
        System.out.println("     ✨ Princess Maker를 시작합니다! ✨");
        System.out.println(SEPARATOR);
        System.out.println();
    }

    /**
     * 활동 선택 메뉴 출력
     * @param princess 프린세스 객체 (날짜 정보 표시용)
     */
    public static void showActivityMenu(Princess princess) {
        System.out.println();
        System.out.println(SEPARATOR);
        System.out.printf("📅 현재 날짜: %s (%d개월차)%n",
                princess.getCurrentDateString(),
                princess.getCurrentMonth());

        // 직업이 있으면 표시
        if (princess.hasJob()) {
            System.out.printf("💼 현재 직업: %s%n", princess.getJob().getJobName());
        }

        System.out.println(THIN_SEPARATOR);
        System.out.println("오늘은 어떤 활동을 하시겠습니까?");
        System.out.println();

        // 활동 목록 출력
        System.out.println("1. 군사훈련 (체력 집중 상승, 피로도 +25)");
        System.out.println("2. 학업 (지력 집중 상승, 피로도 +15)");
        System.out.println("3. 사교활동 (매력 집중 상승, 피로도 +10)");
        System.out.println("4. 휴식 (피로도 -40, 모든 능력치 소폭 상승)");
        System.out.println("5. 현재 능력치 확인");
        System.out.println(SEPARATOR);
    }

    /**
     * 현재 능력치 상세 정보 출력
     * @param princess 프린세스 객체
     */
    public static void showDetailedStats(Princess princess) {
        Stats stats = princess.getStats();

        System.out.println();
        System.out.println(SEPARATOR);
        System.out.printf("📊 %s의 현재 능력치%n", princess.getName());
        System.out.println(THIN_SEPARATOR);
        System.out.printf("💪 체력:   %3d%n", stats.getPhysical());
        System.out.printf("📚 지력:   %3d%n", stats.getIntelligence());
        System.out.printf("✨ 매력:   %3d%n", stats.getCharm());
        System.out.printf("😴 피로도: %3d%%%n", stats.getFatigue());

        // 피로도 경고
        if (stats.isHighFatigue()) {
            System.out.println();
            System.out.println("⚠️  경고: 피로도가 매우 높습니다! 활동 실패 확률이 증가합니다!");
            System.out.println("    휴식을 취하는 것을 권장합니다.");
        }

        System.out.println(SEPARATOR);
    }

    /**
     * 활동 진행 중 애니메이션 출력
     * @param activityName 활동 이름
     * @param hasJob 직업 유무
     * @param jobMessage 직업 관련 메시지 (직업이 있을 때만)
     */
    public static void showActivityProgress(String activityName, boolean hasJob, String jobMessage) {
        System.out.println();

        // 활동 시작 메시지
        if (hasJob) {
            System.out.println(jobMessage);
        } else {
            System.out.printf("%s를(을) 하는 중", activityName);
        }

        // 시간 경과 애니메이션 (점 3개, 0.5초 간격)
        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(500);  // 0.5초 대기
                System.out.print(".");
            } catch (InterruptedException e) {
                // 인터럽트 발생 시 무시
            }
        }
        System.out.println();
    }

    /**
     * 활동 결과 출력
     * @param activityName 활동 이름
     * @param successLevelName 성공 수준 이름 (실패, 보통, 성공, 대성공)
     * @param princess 프린세스 객체
     * @param beforeStats 활동 전 능력치 (변화량 계산용)
     */
    public static void showActivityResult(String activityName, String successLevelName,
                                          Princess princess, Stats beforeStats) {
        Stats afterStats = princess.getStats();

        System.out.println();
        System.out.println(THIN_SEPARATOR);

        // 성공 수준 표시
        String resultEmoji = getResultEmoji(successLevelName);
        System.out.printf("%s %s %s!%n", resultEmoji, activityName, successLevelName);

        // 능력치 변화량 계산 및 출력
        int physicalChange = afterStats.getPhysical() - beforeStats.getPhysical();
        int intelligenceChange = afterStats.getIntelligence() - beforeStats.getIntelligence();
        int charmChange = afterStats.getCharm() - beforeStats.getCharm();
        int fatigueChange = afterStats.getFatigue() - beforeStats.getFatigue();

        // 변화가 있는 능력치만 출력
        if (physicalChange != 0) {
            System.out.printf("💪 체력 %s%d%n", formatChange(physicalChange), Math.abs(physicalChange));
        }
        if (intelligenceChange != 0) {
            System.out.printf("📚 지력 %s%d%n", formatChange(intelligenceChange), Math.abs(intelligenceChange));
        }
        if (charmChange != 0) {
            System.out.printf("✨ 매력 %s%d%n", formatChange(charmChange), Math.abs(charmChange));
        }
        if (fatigueChange != 0) {
            System.out.printf("😴 피로도 %s%d%%%n", formatChange(fatigueChange), Math.abs(fatigueChange));
        }

        // 직업 보너스 메시지
        if (princess.hasJob() && !successLevelName.equals("실패")) {
            System.out.println(princess.getJob().getJobBonusMessage());
        }

        // 현재 능력치 출력
        System.out.println();
        System.out.println("📊 현재 능력치:");
        System.out.printf("   체력: %d | 지력: %d | 매력: %d | 피로도: %d%%%n",
                afterStats.getPhysical(),
                afterStats.getIntelligence(),
                afterStats.getCharm(),
                afterStats.getFatigue());
        System.out.println(THIN_SEPARATOR);
    }

    /**
     * 직업 선택 메뉴 출력
     * @param princess 프린세스 객체
     */
    public static void showJobSelectionMenu(Princess princess) {
        System.out.println();
        System.out.println(SEPARATOR);
        System.out.println("🎉 12개월이 지났습니다! 직업을 선택할 시간입니다!");
        System.out.println(SEPARATOR);

        // 현재 능력치 표시
        Stats stats = princess.getStats();
        System.out.printf("%s의 현재 능력치: 체력 %d | 지력 %d | 매력 %d%n",
                princess.getName(),
                stats.getPhysical(),
                stats.getIntelligence(),
                stats.getCharm());
        System.out.println();

        // 직업 목록
        System.out.println("선택 가능한 직업:");
        System.out.println("1. 군인 (체력 상승률 +50%, 지력 상승률 -20%)");
        System.out.println("2. 학자 (지력 상승률 +50%, 체력 상승률 -20%)");
        System.out.println("3. 연예인 (매력 상승률 +50%, 지력 상승률 -20%)");
        System.out.println(SEPARATOR);
    }

    /**
     * 직업 선택 완료 메시지 출력
     * @param princess 프린세스 객체
     */
    public static void showJobSelected(Princess princess) {
        System.out.println();
        System.out.println(THIN_SEPARATOR);
        System.out.printf("🎊 %s은(는) %s에 취직했습니다!%n",
                princess.getName(),
                princess.getJob().getJobName());
        System.out.println("이제부터 각 활동 시 직업에 따른 능력치 상승률 보정이 적용됩니다!");
        System.out.println(THIN_SEPARATOR);

        // 잠시 대기
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // 무시
        }
    }

    /**
     * 엔딩 출력
     * @param princess 프린세스 객체
     * @param ending 엔딩 enum
     */
    public static void showEnding(Princess princess, Ending ending) {
        System.out.println();
        System.out.println(SEPARATOR);
        System.out.println("🎭 24개월의 육성이 끝났습니다! 🎭");
        System.out.println(SEPARATOR);
        System.out.println();

        // 최종 능력치
        Stats stats = princess.getStats();
        System.out.println("📊 최종 능력치:");
        System.out.printf("   체력: %d | 지력: %d | 매력: %d%n",
                stats.getPhysical(),
                stats.getIntelligence(),
                stats.getCharm());
        System.out.println();
        System.out.println(SEPARATOR);

        // 엔딩 제목
        System.out.printf("✨ 엔딩: %s ✨%n", ending.getTitle());
        System.out.println(SEPARATOR);
        System.out.println();

        // 엔딩 메시지
        System.out.println(ending.getMessage());
        System.out.println();
        System.out.println(SEPARATOR);
        System.out.println("게임을 플레이해주셔서 감사합니다!");
        System.out.println(SEPARATOR);
    }

    // ===== Private 헬퍼 메서드 =====

    /**
     * 성공 수준에 따른 이모지 반환
     * @param successLevelName 성공 수준 이름
     * @return 이모지 문자열
     */
    private static String getResultEmoji(String successLevelName) {
        switch (successLevelName) {
            case "대성공":
                return "🌟";
            case "성공":
                return "✅";
            case "보통":
                return "⭐";
            case "실패":
                return "❌";
            default:
                return "❓";
        }
    }

    /**
     * 능력치 변화량을 포맷팅 (+ 또는 - 기호 추가)
     * @param change 변화량
     * @return 포맷된 문자열
     */
    private static String formatChange(int change) {
        if (change > 0) {
            return "+";
        } else if (change < 0) {
            return "-";
        } else {
            return " ";
        }
    }
}