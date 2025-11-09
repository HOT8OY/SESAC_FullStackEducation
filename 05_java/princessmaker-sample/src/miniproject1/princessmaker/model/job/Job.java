package miniproject1.princessmaker.model.job;

/**
 * 직업을 나타내는 추상 클래스
 * 모든 직업의 공통 속성과 메서드를 정의
 * 추상 클래스를 사용하여 직업의 기본 구조를 제공하고,
 * 각 직업별로 다른 보너스 적용 방식을 강제함
 */
public abstract class Job {
    // 직업 이름
    protected String jobName;

    /**
     * Job 생성자
     * @param jobName 직업 이름
     */
    public Job(String jobName) {
        this.jobName = jobName;
    }

    /**
     * 직업 이름 반환
     * @return 직업 이름
     */
    public String getJobName() {
        return jobName;
    }

    /**
     * 능력치 증가에 직업 보너스를 적용하는 추상 메서드
     * 각 직업 클래스에서 반드시 구현해야 함
     *
     * @param statType 능력치 타입 ("physical", "intelligence", "charm")
     * @param baseIncrease 기본 증가량
     * @return 직업 보너스가 적용된 최종 증가량
     */
    public abstract int applyBonus(String statType, int baseIncrease);

    /**
     * 활동 시작 시 출력할 메시지
     * 직업에 따라 다른 메시지를 출력할 수 있도록 오버라이딩 가능
     * @param activityName 활동 이름
     * @return 출력 메시지
     */
    public String getActivityStartMessage(String activityName) {
        return String.format("%s(으)로서 %s를 하는 중입니다...", jobName, activityName);
    }

    /**
     * 활동 완료 시 직업 관련 추가 메시지
     * @return 추가 메시지 (없으면 빈 문자열)
     */
    public String getJobBonusMessage() {
        return String.format("[%s 보너스가 적용되었습니다!]", jobName);
    }
}