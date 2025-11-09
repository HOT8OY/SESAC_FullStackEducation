package ohgiraffers.section02.abstractclass;

public class Application {
    public static void main(String[] args) {
        /* 추상 클래스와 추상 메서드 */

        // [추상클래스 사용 전]
        // 객체 생성
        Warrior warrior = new Warrior();
        Wizard wizard = new Wizard();

        // 메소드사용(추상 클래스 사용 전)
        warrior.attack00();
        wizard.attack00();    // 플레이어가 공격합니다 || 실행을 해 보면 wizard에 attack메소드를 오버라이드 안 했다는 걸 알게 됨.

        // [추상클래스 사용]
//        Player player = new Player(); // 추상 클래스는 인스턴스화 할 수 없다.

        // 추상 클래스는 그 자체로 객체가 될 순 없지만 '대표 타입'의 역할을 한다.
        // 다형성을 적용하기 위한 완벽한 조건이다.
        Player[] players = new Player[2];
        players[0] = new Warrior();
        players[1] = new Wizard();

        for(Player player : players) {
            player.attack();
            player.levelUp();
        }
    }
}
