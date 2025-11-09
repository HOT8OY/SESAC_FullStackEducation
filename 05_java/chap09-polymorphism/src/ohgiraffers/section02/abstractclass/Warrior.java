package ohgiraffers.section02.abstractclass;

public class Warrior extends Player {
    // 추상 메소드 사용 전
    @Override
    public void attack00() {
        System.out.println("전사가 검으로 베기 공격을 합니다. 휙~!");
    }
    // 추상 메소드 사용
    @Override
    public void attack() {
        System.out.println("전사가 검으로 베기 공격을 합니다. 휙~!");
    }
}
