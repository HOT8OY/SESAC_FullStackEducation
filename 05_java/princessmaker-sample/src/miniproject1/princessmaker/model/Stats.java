package miniproject1.princessmaker.model;

/**
 * 프린세스의 능력치를 관리하는 클래스
 * 체력, 지력, 매력, 피로도를 저장하고 관리함
 * 캡슐화를 통해 데이터를 보호하고 접근을 제어함
 */
public class Stats {
    // 엔딩 능력치 (private으로 외부 직접 접근 차단)
    private int physical;      // 체력
    private int intelligence;  // 지력
    private int charm;         // 매력

    // 체력 관리 능력치
    private int fatigue;       // 피로도 (0~100)

    /**
     * Stats 생성자
     * 모든 능력치를 초기값으로 설정
     */
    public Stats() {
        this.physical = 10;      // 초기 체력
        this.intelligence = 10;  // 초기 지력
        this.charm = 10;         // 초기 매력
        this.fatigue = 0;        // 초기 피로도 (피로하지 않은 상태)
    }

    // ===== Getter 메서드 (능력치 조회) =====

    /**
     * 현재 체력을 반환
     * @return 체력 수치
     */
    public int getPhysical() {
        return physical;
    }

    /**
     * 현재 지력을 반환
     * @return 지력 수치
     */
    public int getIntelligence() {
        return intelligence;
    }

    /**
     * 현재 매력을 반환
     * @return 매력 수치
     */
    public int getCharm() {
        return charm;
    }

    /**
     * 현재 피로도를 반환
     * @return 피로도 수치 (0~100)
     */
    public int getFatigue() {
        return fatigue;
    }

    // ===== 능력치 증가 메서드 =====

    /**
     * 체력을 증가시킴
     * @param amount 증가시킬 양
     */
    public void increasePhysical(int amount) {
        this.physical += amount;
    }

    /**
     * 지력을 증가시킴
     * @param amount 증가시킬 양
     */
    public void increaseIntelligence(int amount) {
        this.intelligence += amount;
    }

    /**
     * 매력을 증가시킴
     * @param amount 증가시킬 양
     */
    public void increaseCharm(int amount) {
        this.charm += amount;
    }

    /**
     * 피로도를 증가시킴
     * 최대값은 100으로 제한
     * @param amount 증가시킬 양
     */
    public void increaseFatigue(int amount) {
        this.fatigue += amount;
        // 피로도가 100을 초과하지 않도록 제한
        if (this.fatigue > 100) {
            this.fatigue = 100;
        }
    }

    /**
     * 피로도를 감소시킴 (휴식 시 사용)
     * 최소값은 0으로 제한
     * @param amount 감소시킬 양
     */
    public void decreaseFatigue(int amount) {
        this.fatigue -= amount;
        // 피로도가 0 미만이 되지 않도록 제한
        if (this.fatigue < 0) {
            this.fatigue = 0;
        }
    }

    /**
     * 현재 피로도가 높은지 확인
     * 피로도가 80 이상이면 true 반환
     * @return 높은 피로도 여부
     */
    public boolean isHighFatigue() {
        return this.fatigue >= 80;
    }

    /**
     * 능력치 정보를 문자열로 반환
     * 디버깅이나 출력 시 사용
     * @return 능력치 정보 문자열
     */
    @Override
    public String toString() {
        return String.format("체력: %d | 지력: %d | 매력: %d | 피로도: %d%%",
                physical, intelligence, charm, fatigue);
    }
}