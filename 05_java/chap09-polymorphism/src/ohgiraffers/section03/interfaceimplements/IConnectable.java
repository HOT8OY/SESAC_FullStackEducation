package ohgiraffers.section03.interfaceimplements;

public interface IConnectable {
    // Interface는 클래스들이 갖춰야 할 규격을 만드는 것이다.
    // interface의 이름은 관례적으로 대문자 I 로 시작한다.
    // class 자리에 interface라고 쓴다.

    // interface에는 모든 구현체가 공유해야 할 공통 규격 값(상수)을 정의할 수 있다.
    // interface에 선언된 변수는 자동으로 public static final 상수가 된다.
    int MAX_CONNECTION_COUNT = 4;
//  public static final int MAX_CONNECTION_COUNT = 4; // 위에서 선언한것은 이것과도 같음.

    // 인터페이스 추상 메소드 : 반드시 구현해야 할 기능의 목록 정의 -> 강제성 부여
    // 자동으로 public abstract 추상 메소드가 된다.
    void connect(); // public abstract void connect(); // 자동으로 이렇게 컴파일러가 인식함.
    void disconnect();


    /* default 메소드는 기존 구현체들을 수정하지 않고 새로운 기능을 추가하기 위해 사용된다. (하위 호환성) */
    public default void showStatus() {
        System.out.println("장치가 대기 상태입니다.");
    }

}
