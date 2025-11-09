package miniproject1.princessmaker.service;

import miniproject1.princessmaker.model.Ending;
import miniproject1.princessmaker.model.Princess;
import miniproject1.princessmaker.model.Stats;
import miniproject1.princessmaker.view.GameView;

/**
 * 게임 엔딩 판정과 관련된 비즈니스 로직을 처리하는 서비스 클래스
 * 24개월 완료 후 최종 능력치에 따라 엔딩을 결정하고 출력
 */
public class EndingService {

    /**
     * 게임 엔딩 판정 및 출력
     * 1. 프린세스의 최종 능력치 확인
     * 2. 능력치에 맞는 엔딩 결정
     * 3. 엔딩 화면 출력
     *
     * @param princess 프린세스 객체
     */
    public void determineAndShowEnding(Princess princess) {
        // 1. 최종 능력치 가져오기
        Stats finalStats = princess.getStats();

        // 2. 엔딩 결정
        // Ending enum의 static 메서드를 통해 능력치에 맞는 엔딩 찾기
        Ending ending = Ending.determineEnding(finalStats);

        // 3. 엔딩 화면 출력
        GameView.showEnding(princess, ending);
    }
}