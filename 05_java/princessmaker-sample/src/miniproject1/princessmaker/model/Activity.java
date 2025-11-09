package miniproject1.princessmaker.model;

/**
 * 활동(Activity)의 공통 행동을 정의하는 인터페이스
 * 모든 활동은 이 인터페이스를 구현해야 함
 * 인터페이스를 사용하여 다양한 활동을 통일된 방식으로 처리 가능
 */
public interface Activity {
    /**
     * 활동을 실행하는 메서드
     * 각 활동 타입(군사훈련, 학업, 사교활동, 휴식)에서 구체적으로 구현
     *
     * @param stats 프린세스의 능력치 객체 (이 능력치를 수정함)
     * @param successLevel 활동의 성공 수준 (0: 실패, 1: 보통, 2: 성공, 3: 대성공)
     */
    void execute(Stats stats, int successLevel);

    /**
     * 활동 이름을 반환하는 메서드
     * @return 활동의 이름
     */
    String getName();

    /**
     * 활동으로 인한 피로도 증가량을 반환
     * @return 피로도 증가량
     */
    int getFatigueIncrease();
}