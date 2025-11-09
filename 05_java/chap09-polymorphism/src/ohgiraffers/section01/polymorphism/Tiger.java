package ohgiraffers.section01.polymorphism;
// polymorphism = Animal -> Cat
//   └─> ZooKeeper      └─> Tiger

public class Tiger extends Animal {

    // 오버라이딩
    @Override
    public void cry() {
        System.out.println("호랑이가 울부짖습니다. 어흥~~!!!");
    }

    // 고유기능 추가
    public void bite() {
        System.out.println("호랑이가 물어뜯습니다. 와앙!!");
    }
}
