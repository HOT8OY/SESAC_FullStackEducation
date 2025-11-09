package miniproject1.princessmaker;

import miniproject1.princessmaker.controller.GameController;

/**
 * Princess Maker 게임의 진입점 클래스
 * 프로그램 실행 시 가장 먼저 실행되는 main 메서드를 포함
 */
public class Main {
    /**
     * 프로그램의 시작점
     * GameController 객체를 생성하고 게임을 시작함
     *
     * @param args 커맨드 라인 인자 (사용하지 않음)
     */
    public static void main(String[] args) {
        // GameController 객체 생성
        GameController controller = new GameController();

        // 게임 시작
        controller.startGame();
    }
}