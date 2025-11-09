package ohgiraffers.section01.polymorphism;
// polymorphism = Animal -> Cat
//   └─> ZooKeeper      └─> Tiger
public class Cat extends Animal {

    // 오버라이드
    @Override
    public void eat() {
        System.out.println("고양이가 생선을 먹고 있습니다.");
    }
    @Override
    public void run() {
        System.out.println("고양이가 달려갑니다~ 슝~");
    }
    @Override
    public void cry() {
        System.out.println("고양이가 울음소리를 냅니다. 야옹~");
    }

    // 고양이만 가지고 있는 기능
    public void jump() {
        System.out.println("고양이가 점프합니다. 점프~~");
    }
}
