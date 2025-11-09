package miniproject1.princessmaker.controller;

import miniproject1.princessmaker.model.ActivityType;
import miniproject1.princessmaker.model.Princess;
import miniproject1.princessmaker.service.ActivityService;
import miniproject1.princessmaker.service.EndingService;
import miniproject1.princessmaker.service.JobService;
import miniproject1.princessmaker.util.InputValidator;
import miniproject1.princessmaker.view.GameView;

import java.util.Scanner;

/**
 * 게임의 전체 흐름을 제어하는 컨트롤러 클래스
 * 게임 시작부터 종료까지의 모든 단계를 관리
 * MVC 패턴의 Controller 역할 수행
 */
public class GameController {
    // Service 객체들 (비즈니스 로직 처리)
    private final ActivityService activityService;
    private final JobService jobService;
    private final EndingService endingService;

    // Scanner 객체 (사용자 입력용)
    private final Scanner scanner;

    /**
     * GameController 생성자
     * 필요한 Service 객체들과 Scanner를 초기화
     */
    public GameController() {
        this.activityService = new ActivityService();
        this.jobService = new JobService();
        this.endingService = new EndingService();
        this.scanner = new Scanner(System.in);
    }

    /**
     * 게임 시작 메서드
     * 전체 게임 흐름을 관리하는 메인 메서드
     *
     * 게임 흐름:
     * 1. 환영 메시지 출력
     * 2. 프린세스 이름 입력 및 객체 생성
     * 3. 24턴 동안 활동 반복
     *    - 12턴 후 직업 선택
     * 4. 엔딩 판정 및 출력
     * 5. Scanner 닫기
     */
    public void startGame() {
        // 1. 환영 메시지
        GameView.showWelcomeMessage();

        // 2. 프린세스 생성
        Princess princess = createPrincess();

        // 3. 게임 메인 루프 (24턴)
        while (!princess.isGameOver()) {
            // 12개월차에 직업 선택
            if (princess.getCurrentMonth() == 12) {
                jobService.selectJob(princess, scanner);
            }

            // 활동 선택 및 실행
            performMonthlyActivity(princess);
        }

        // 4. 엔딩
        endingService.determineAndShowEnding(princess);

        // 5. Scanner 닫기
        scanner.close();
    }

    /**
     * 프린세스 생성 메서드
     * 사용자로부터 이름을 입력받아 Princess 객체 생성
     *
     * @return 생성된 Princess 객체
     */
    private Princess createPrincess() {
        // 이름 입력받기 (빈 문자열 불가)
        String name = InputValidator.getValidatedString(scanner,
                "Princess의 이름을 설정해주세요: ");

        // Princess 객체 생성 및 반환
        return new Princess(name);
    }

    /**
     * 한 달의 활동을 수행하는 메서드
     * 1. 활동 메뉴 출력
     * 2. 사용자 선택 입력
     * 3. 선택에 따라 활동 실행 또는 능력치 확인
     *
     * @param princess 프린세스 객체
     */
    private void performMonthlyActivity(Princess princess) {
        // 무한 루프: 능력치 확인(5번) 선택 시 활동을 다시 선택해야 하므로
        while (true) {
            // 1. 활동 메뉴 출력
            GameView.showActivityMenu(princess);

            // 2. 사용자 선택 입력 (1~5)
            int choice = InputValidator.getValidatedInt(scanner,
                    "번호를 선택하세요: ",
                    1, 5);

            // 3. 선택에 따른 처리
            if (choice == 5) {
                // 능력치 확인 (활동하지 않음, 다시 메뉴로)
                GameView.showDetailedStats(princess);
                continue;  // 다시 활동 선택으로
            } else {
                // 활동 실행
                ActivityType activityType = getActivityTypeByChoice(choice);
                activityService.executeActivity(princess, activityType);
                break;  // 활동 완료, 다음 턴으로
            }
        }
    }

    /**
     * 선택 번호에 해당하는 ActivityType 반환
     *
     * @param choice 선택 번호 (1~4)
     * @return 해당하는 ActivityType enum
     */
    private ActivityType getActivityTypeByChoice(int choice) {
        switch (choice) {
            case 1:
                return ActivityType.MILITARY_TRAINING;  // 군사훈련
            case 2:
                return ActivityType.STUDY;              // 학업
            case 3:
                return ActivityType.SOCIAL;             // 사교활동
            case 4:
                return ActivityType.REST;               // 휴식
            default:
                // 예외 상황 (일어날 수 없음, InputValidator가 1~4만 허용)
                return ActivityType.REST;
        }
    }
}