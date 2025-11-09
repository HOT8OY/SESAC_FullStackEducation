package ohgiraffers.section03.interfaceimplements;

/* interface는 쉼표로 여러개를 implements 할 수 있다.
(자바의 단일 상속 한계 극복, 다중 상속의 효과를 내는 방법)
public class Keyboard implements IConnectable, Iterable {} */

// interface를 구현할 땐 implements 를 쓰고 해당 interface(IConnectable)를 입력한다.
public class Keyboard implements IConnectable {

    // 오버라이딩 해야할 것을 오버라이딩
    @Override
    public void connect() {
        System.out.println("키보드가 USB 포트에 연결되었습니다.");
    }

    @Override
    public void disconnect() {
        System.out.println("키보드 연결을 해제합니다.");
    }
}
