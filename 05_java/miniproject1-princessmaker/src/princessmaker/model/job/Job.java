package princessmaker.model.job;

import princessmaker.model.Stats;

/* - Job.java: 직업의 기본 틀을 정의하는 추상 클래스
    - applyBonus(): 활동 후 스탯에 직업 보너스 적용 (자식 클래스에서 구현)
    - 각 직업은 특정 스탯에 대해 상승률 보정을 적용
- 구체적인 직업 클래스들: Job을 상속받아 각자의 보너스 로직 구현 */
public abstract class Job {
    public void applyBonus(Stats stats, int baseStat) {}
    public abstract String
}
