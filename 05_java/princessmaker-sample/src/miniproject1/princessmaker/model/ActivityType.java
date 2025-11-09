package miniproject1.princessmaker.model;

/*
 * 활동 종류를 정의하는 Enum 클래스
 * 각 활동의 이름, 피로도 증가량, 능력치 증가 로직을 포함
 * Enum을 사용하여 고정된 활동 목록을 안전하게 관리
 * Activity 인터페이스를 구현하여 통일된 방식으로 처리 가능
 */
public enum ActivityType implements Activity {
    /*
     * 군사훈련: 체력을 집중적으로 상승시킴
     * 피로도 증가가 가장 높음
     */
    MILITARY_TRAINING("군사훈련", 25) {
        @Override
        public void execute(Stats stats, int successLevel) {
            // successLevel: 0(실패), 1(보통), 2(성공), 3(대성공)
            switch (successLevel) {
                case 0: // 실패
                    // 능력치 증가 없음, 피로도만 증가
                    break;
                case 1: // 보통
                    stats.increasePhysical(3);  // 체력 +3
                    stats.increaseCharm(1);     // 매력 +1
                    break;
                case 2: // 성공
                    stats.increasePhysical(6);  // 체력 +6
                    stats.increaseCharm(2);     // 매력 +2
                    break;
                case 3: // 대성공
                    stats.increasePhysical(10); // 체력 +10
                    stats.increaseCharm(3);     // 매력 +3
                    break;
            }
            // 피로도 증가
            stats.increaseFatigue(this.getFatigueIncrease());
        }
    },

    /*
     * 학업: 지력을 집중적으로 상승시킴
     * 피로도 증가가 보통
     */
    STUDY("학업", 15) {
        @Override
        public void execute(Stats stats, int successLevel) {
            switch (successLevel) {
                case 0: // 실패
                    // 능력치 증가 없음
                    break;
                case 1: // 보통
                    stats.increaseIntelligence(3); // 지력 +3
                    stats.increaseCharm(1);        // 매력 +1
                    break;
                case 2: // 성공
                    stats.increaseIntelligence(6); // 지력 +6
                    stats.increaseCharm(2);        // 매력 +2
                    break;
                case 3: // 대성공
                    stats.increaseIntelligence(10); // 지력 +10
                    stats.increaseCharm(3);         // 매력 +3
                    break;
            }
            // 피로도 증가
            stats.increaseFatigue(this.getFatigueIncrease());
        }
    },

    /**
     * 사교활동: 매력을 집중적으로 상승시킴
     * 피로도 증가가 가장 낮음
     */
    SOCIAL("사교활동", 10) {
        @Override
        public void execute(Stats stats, int successLevel) {
            switch (successLevel) {
                case 0: // 실패
                    // 능력치 증가 없음
                    break;
                case 1: // 보통
                    stats.increaseCharm(3);        // 매력 +3
                    stats.increaseIntelligence(1); // 지력 +1
                    break;
                case 2: // 성공
                    stats.increaseCharm(6);        // 매력 +6
                    stats.increaseIntelligence(2); // 지력 +2
                    break;
                case 3: // 대성공
                    stats.increaseCharm(10);       // 매력 +10
                    stats.increaseIntelligence(3); // 지력 +3
                    break;
            }
            // 피로도 증가
            stats.increaseFatigue(this.getFatigueIncrease());
        }
    },

    /**
     * 휴식: 피로도를 크게 감소시키고 모든 능력치를 소폭 증가
     * 피로도가 감소함 (음수로 설정)
     */
    REST("휴식", -40) {
        @Override
        public void execute(Stats stats, int successLevel) {
            // 휴식은 항상 성공 (successLevel 무시)
            // 모든 능력치 소폭 증가
            stats.increasePhysical(2);
            stats.increaseIntelligence(2);
            stats.increaseCharm(2);

            // 피로도 감소 (음수이므로 감소 효과)
            stats.decreaseFatigue(40);
        }
    };

    // Enum의 필드 (각 활동이 가지는 속성)
    private final String name;             // 활동 이름
    private final int fatigueIncrease;     // 피로도 증가량 (음수면 감소)

    /**
     * ActivityType의 생성자
     * Enum 상수 생성 시 이름과 피로도 증가량을 설정
     *
     * @param name 활동 이름
     * @param fatigueIncrease 피로도 증가량
     */
    ActivityType(String name, int fatigueIncrease) {
        this.name = name;
        this.fatigueIncrease = fatigueIncrease;
    }

    /**
     * 활동 이름을 반환
     * @return 활동 이름
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * 피로도 증가량을 반환
     * @return 피로도 증가량
     */
    @Override
    public int getFatigueIncrease() {
        return fatigueIncrease;
    }

    /**
     * 활동을 실행하는 추상 메서드
     * 각 Enum 상수에서 구체적으로 구현됨
     *
     * @param stats 프린세스의 능력치
     * @param successLevel 성공 수준
     */
    @Override
    public abstract void execute(Stats stats, int successLevel);
}