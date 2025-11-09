package miniproject1.princessmaker.model;

/**
 * 게임의 엔딩을 정의하는 Enum 클래스
 * 각 엔딩의 이름, 조건, 메시지를 포함
 */
public enum Ending {
    /**
     * 백수 엔딩 (특수 엔딩 - 최우선)
     * 모든 능력치가 40 미만일 때 발생
     */
    UNEMPLOYED(
            "평범한 백수",
            "24개월 간의 육성이 끝났습니다.\n" +
                    "하지만 특별한 재능을 발견하지 못했습니다.\n" +
                    "평범한 일상을 보내며 자신만의 길을 찾아가고 있습니다.\n" +
                    "때로는 평범함도 하나의 행복입니다."
    ) {
        @Override
        public boolean checkCondition(Stats stats) {
            // 모든 능력치가 40 미만인 경우
            return stats.getPhysical() < 40
                    && stats.getIntelligence() < 40
                    && stats.getCharm() < 40;
        }
    },

    /**
     * 장군 엔딩
     * 체력 80 이상, 지력 40 이상
     */
    GENERAL(
            "전설의 장군",
            "24개월 간의 혹독한 훈련 끝에 뛰어난 장군이 되었습니다!\n" +
                    "강인한 체력과 뛰어난 전략으로 왕국을 지키는 수호자가 되었습니다.\n" +
                    "많은 병사들이 당신을 따르고 존경합니다.\n" +
                    "왕국의 평화는 당신의 손에 달려있습니다!"
    ) {
        @Override
        public boolean checkCondition(Stats stats) {
            return stats.getPhysical() >= 80 && stats.getIntelligence() >= 40;
        }
    },

    /**
     * 교수 엔딩
     * 지력 80 이상, 매력 40 이상
     */
    PROFESSOR(
            "명망 높은 교수",
            "24개월 간의 끊임없는 학습 끝에 저명한 교수가 되었습니다!\n" +
                    "깊은 지식과 우아한 품격으로 많은 제자들을 가르치고 있습니다.\n" +
                    "당신의 연구는 학계에 큰 영향을 미치고 있습니다.\n" +
                    "지식의 전당에서 빛나는 별이 되었습니다!"
    ) {
        @Override
        public boolean checkCondition(Stats stats) {
            return stats.getIntelligence() >= 80 && stats.getCharm() >= 40;
        }
    },

    /**
     * 슈퍼스타 엔딩
     * 매력 80 이상, 체력 40 이상
     */
    SUPERSTAR(
            "세계적인 슈퍼스타",
            "24개월 간의 노력 끝에 세계적인 슈퍼스타가 되었습니다!\n" +
                    "압도적인 매력과 에너지 넘치는 무대로 전 세계를 사로잡았습니다.\n" +
                    "수많은 팬들이 당신의 이름을 외치고 있습니다.\n" +
                    "당신은 이 시대의 아이콘이 되었습니다!"
    ) {
        @Override
        public boolean checkCondition(Stats stats) {
            return stats.getCharm() >= 80 && stats.getPhysical() >= 40;
        }
    },

    /**
     * 균형잡힌 시민 엔딩 (기본 엔딩)
     * 위의 조건에 해당하지 않는 모든 경우
     */
    BALANCED_CITIZEN(
            "균형잡힌 시민",
            "24개월 간의 육성이 끝났습니다.\n" +
                    "다양한 경험을 통해 균형잡힌 사람으로 성장했습니다.\n" +
                    "특별히 뛰어난 분야는 없지만, 어떤 일이든 해낼 수 있는 능력을 갖췄습니다.\n" +
                    "행복하고 안정적인 삶을 살아가고 있습니다."
    ) {
        @Override
        public boolean checkCondition(Stats stats) {
            // 다른 모든 엔딩 조건에 해당하지 않을 때 선택됨
            return true;
        }
    };

    // Enum 필드
    private final String title;    // 엔딩 제목
    private final String message;  // 엔딩 메시지

    /**
     * Ending Enum 생성자
     * @param title 엔딩 제목
     * @param message 엔딩 메시지
     */
    Ending(String title, String message) {
        this.title = title;
        this.message = message;
    }

    /**
     * 엔딩 제목 반환
     * @return 엔딩 제목
     */
    public String getTitle() {
        return title;
    }

    /**
     * 엔딩 메시지 반환
     * @return 엔딩 메시지
     */
    public String getMessage() {
        return message;
    }

    /**
     * 현재 능력치로 이 엔딩 조건을 만족하는지 확인
     * 각 Enum 상수에서 구체적으로 구현
     * @param stats 프린세스의 능력치
     * @return 조건 만족 여부
     */
    public abstract boolean checkCondition(Stats stats);

    /**
     * 능력치에 맞는 엔딩을 찾아 반환
     * 특수 엔딩(백수)을 먼저 체크하고, 능력치가 높은 순서로 체크
     * @param stats 프린세스의 능력치
     * @return 해당하는 엔딩
     */
    public static Ending determineEnding(Stats stats) {
        // 1. 특수 엔딩 먼저 체크 (백수)
        if (UNEMPLOYED.checkCondition(stats)) {
            return UNEMPLOYED;
        }

        // 2. 능력치 기반 엔딩 체크 (높은 수치 우선)
        // 각 엔딩을 체크하여 조건을 만족하는 첫 번째 엔딩 반환
        if (GENERAL.checkCondition(stats)) {
            return GENERAL;
        }
        if (PROFESSOR.checkCondition(stats)) {
            return PROFESSOR;
        }
        if (SUPERSTAR.checkCondition(stats)) {
            return SUPERSTAR;
        }

        // 3. 어떤 조건도 만족하지 않으면 기본 엔딩
        return BALANCED_CITIZEN;
    }
}