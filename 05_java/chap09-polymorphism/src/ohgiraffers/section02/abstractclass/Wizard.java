package ohgiraffers.section02.abstractclass;

public class Wizard extends Player {
    // 바빠서 Wizard에 attack00 메소드를 오버라이딩 하는것을 못 했다면(Application에서)

    @Override
    public void attack() {
        System.out.println("마법사가 파이어볼 마법으로 공격합니다. 화르륵~!");
    }

}
