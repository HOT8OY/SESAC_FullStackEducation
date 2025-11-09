package miniproject1.princessmaker.model.job;

/**
 * 연예인 직업 클래스
 * Job 추상 클래스를 상속받아 연예인 고유의 보너스를 구현
 *
 * 보너스 효과:
 * - 매력 증가량 +50%
 * - 지력 증가량 -20%
 */
public class Celebrity extends Job {

    /**
     * Celebrity 생성자
     * 부모 클래스의 생성자를 호출하여 직업 이름 설정
     */
    public Celebrity() {
        super("연예인"); // 부모 클래스(Job)의 생성자 호출
    }

    /**
     * 연예인 직업의 보너스를 적용하는 메서드
     * Job 클래스의 추상 메서드를 구체적으로 구현 (오버라이딩)
     *
     * @param statType 능력치 타입 ("physical", "intelligence", "charm")
     * @param baseIncrease 기본 증가량
     * @return 직업 보너스가 적용된 최종 증가량
     */
    @Override
    public int applyBonus(String statType, int baseIncrease) {
        // 능력치 타입에 따라 다른 보너스 적용
        switch (statType) {
            case "charm":
                // 매력: +50% 보너스
                // 예: baseIncrease가 10이면 15 반환
                return (int) (baseIncrease * 1.5);

            case "intelligence":
                // 지력: -20% 페널티
                // 예: baseIncrease가 10이면 8 반환
                return (int) (baseIncrease * 0.8);

            case "physical":
                // 체력: 보너스 없음 (기본값 그대로)
                return baseIncrease;

            default:
                // 예외 케이스: 기본값 반환
                return baseIncrease;
        }
    }

    /**
     * 연예인 특유의 활동 시작 메시지
     * 부모 메서드를 오버라이딩하여 연예인다운 표현 사용
     *
     * @param activityName 활동 이름
     * @return 연예인 스타일의 메시지
     */
    @Override
    public String getActivityStartMessage(String activityName) {
        return String.format("연예인으로서 %s 활동을 하는 중입니다!", activityName);
    }
}