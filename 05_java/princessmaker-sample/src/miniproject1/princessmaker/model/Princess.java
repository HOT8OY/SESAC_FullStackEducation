package miniproject1.princessmaker.model;

import miniproject1.princessmaker.model.job.Job;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * 프린세스를 나타내는 클래스
 * 프린세스의 이름, 능력치, 현재 날짜, 직업 정보를 관리
 */
public class Princess {
    // 프린세스의 기본 정보
    private String name;              // 이름
    private Stats stats;              // 능력치 (Has-A 관계)
    private LocalDate currentDate;    // 현재 게임 날짜
    private int currentMonth;         // 현재 진행 개월 수 (1~24)
    private Job job;                  // 현재 직업 (다형성 - Job의 자식 클래스가 들어감)

    // 날짜 포맷터 (yy/MM 형식으로 출력하기 위함)
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yy/MM");

    /**
     * Princess 생성자
     * 프린세스 객체를 초기화하고 게임 시작 날짜를 설정
     *
     * @param name 프린세스의 이름
     */
    public Princess(String name) {
        this.name = name;
        this.stats = new Stats();              // 새로운 능력치 객체 생성
        this.currentDate = LocalDate.of(2025, 1, 1);  // 게임 시작일: 2025년 1월 1일
        this.currentMonth = 1;                 // 1개월차부터 시작
        this.job = null;                       // 처음에는 직업 없음
    }

    // ===== Getter 메서드 =====

    /**
     * 프린세스 이름 반환
     * @return 이름
     */
    public String getName() {
        return name;
    }

    /**
     * 능력치 객체 반환
     * @return Stats 객체
     */
    public Stats getStats() {
        return stats;
    }

    /**
     * 현재 날짜 반환 (yy/MM 형식 문자열)
     * @return 포맷된 날짜 문자열
     */
    public String getCurrentDateString() {
        return currentDate.format(DATE_FORMATTER);
    }

    /**
     * 현재 개월 수 반환
     * @return 현재 개월 (1~24)
     */
    public int getCurrentMonth() {
        return currentMonth;
    }

    /**
     * 현재 직업 반환
     * @return Job 객체 (직업이 없으면 null)
     */
    public Job getJob() {
        return job;
    }

    /**
     * 직업 유무 확인
     * @return 직업이 있으면 true, 없으면 false
     */
    public boolean hasJob() {
        return job != null;
    }

    // ===== Setter 메서드 =====

    /**
     * 직업 설정
     * @param job 설정할 Job 객체
     */
    public void setJob(Job job) {
        this.job = job;
    }

    // ===== 게임 진행 메서드 =====

    /**
     * 한 달을 진행시킴
     * 현재 날짜를 1개월 증가시키고, 개월 수를 1 증가
     */
    public void advanceMonth() {
        this.currentDate = this.currentDate.plusMonths(1);  // 날짜 1개월 증가
        this.currentMonth++;                                 // 개월 수 증가
    }

    /**
     * 게임이 중간 시점(12개월)인지 확인
     * 직업 선택 시점 판단에 사용
     * @return 12개월이면 true, 아니면 false
     */
    public boolean isMidPoint() {
        return currentMonth == 12;
    }

    /**
     * 게임이 끝났는지 확인
     * 24개월이 지나면 게임 종료
     * @return 24개월 이상이면 true, 아니면 false
     */
    public boolean isGameOver() {
        return currentMonth > 24;
    }

    /**
     * 프린세스 정보를 문자열로 반환
     * @return 프린세스 정보
     */
    @Override
    public String toString() {
        String jobInfo = hasJob() ? job.getJobName() : "무직";
        return String.format("[이름: %s | 직업: %s | 현재: %s (%d개월차)]",
                name, jobInfo, getCurrentDateString(), currentMonth);
    }
}