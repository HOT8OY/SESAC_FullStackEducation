package ohgiraffers.section01.extend;
// 자식클래스 FireCar
// Car class를 FireCar가 상속받음
// 소방차는 자동차다(FireCar is a Car) A is B 관계가 성립할 때 상속을 할 수 있음.
// 그러나 Car is a FireCar처럼 하위개념이 상위개념이다 라는 관계는 성립할 수 없다.
// 반드시 부모클래스를 먼저 만든 후 자식클래스를 생성해야 한다.
public class FireCar extends Car {

    // 자식 클래스 기본 생성자
    public FireCar() {
        super();    // 부모 클래스의 생성자를 호출하는 구문(컴파일러가 자동으로 추가)
        System.out.println("2. FireCar 클래스의 기본 생성자 호출...");
    }

    /*
    * @Override 어노테이션
    * 부모 클래스로부터 물려받은 메소드를 내 입맛에 맞게 고쳐쓰는 것(재정의)를 의미한다.
    * 이 어노테이션(@Override)을 붙이면, 컴파일러가 오버라이딩 규칙을 잘 지켰는지 검사해준다.(실수 방지)
    * 작성 방법은 부모에 있는 메소드의 '반환형'과 '메소드 이름'을 똑같이 써준 후, 오버라이딩 내용을 작성한다.*/
    @Override
    public void soundHorn() {
        if(isRunning()) {
            System.out.println("빠아아아아아앙!!!!!!!!!!");
        } else {
            System.out.println("소방차가 앞으로 갈 수 없습니다. 비키세요 비켜요~~~");
        }
    }

    // 부모 클래스에 없는 기능을 추가할 수 있다
    // 부모에게는 없던, FireCar 만의 고유한 기능 추가 (확장)
    public void sprayWater() {
        System.out.println("불난 곳을 발견했습니다. 물을 뿌립니다 ==============>>>>>");
    }
}
