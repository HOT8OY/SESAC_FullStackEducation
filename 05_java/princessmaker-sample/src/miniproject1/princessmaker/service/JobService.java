package miniproject1.princessmaker.service;

import miniproject1.princessmaker.model.Princess;
import miniproject1.princessmaker.model.job.Celebrity;
import miniproject1.princessmaker.model.job.Job;
import miniproject1.princessmaker.model.job.Scholar;
import miniproject1.princessmaker.model.job.Soldier;
import miniproject1.princessmaker.util.InputValidator;
import miniproject1.princessmaker.view.GameView;

import java.util.Scanner;

/**
 * 직업 선택과 관련된 비즈니스 로직을 처리하는 서비스 클래스
 * 12개월 시점에 직업을 선택하는 기능 제공
 */
public class JobService {

    /**
     * 직업 선택 프로세스 실행
     * 1. 직업 선택 메뉴 출력
     * 2. 사용자 입력 받기
     * 3. 선택한 직업 객체 생성
     * 4. 프린세스에 직업 설정
     * 5. 직업 선택 완료 메시지 출력
     *
     * @param princess 프린세스 객체
     * @param scanner Scanner 객체 (사용자 입력용)
     */
    public void selectJob(Princess princess, Scanner scanner) {
        // 1. 직업 선택 메뉴 출력
        GameView.showJobSelectionMenu(princess);

        // 2. 사용자 입력 받기 (1~3 사이의 숫자)
        int jobChoice = InputValidator.getValidatedInt(scanner,
                "선택할 직업 번호를 입력하세요: ",
                1, 3);

        // 3. 선택한 직업 객체 생성 (다형성 활용)
        Job selectedJob = createJobByChoice(jobChoice);

        // 4. 프린세스에 직업 설정
        princess.setJob(selectedJob);

        // 5. 직업 선택 완료 메시지 출력
        GameView.showJobSelected(princess);
    }

    /**
     * 선택 번호에 따라 직업 객체 생성
     * 다형성을 활용하여 Job 타입으로 반환
     *
     * @param choice 선택 번호 (1: 군인, 2: 학자, 3: 연예인)
     * @return 생성된 Job 객체
     */
    private Job createJobByChoice(int choice) {
        switch (choice) {
            case 1:
                // 군인 객체 생성 (Soldier는 Job의 자식 클래스)
                return new Soldier();
            case 2:
                // 학자 객체 생성 (Scholar는 Job의 자식 클래스)
                return new Scholar();
            case 3:
                // 연예인 객체 생성 (Celebrity는 Job의 자식 클래스)
                return new Celebrity();
            default:
                // 예외 상황 (일어날 수 없음, InputValidator가 1~3만 허용)
                return new Soldier();
        }
    }
}