package ohgiraffers.section01.extend;

public class RacingCar extends Car {

    // alt + insert
    // Override 나 메서드 재정의를 클릭
    // 재정의 할 것을 클릭(여기서는 run 메소드)
    @Override
    public void run() {
                     // [ super ]
        super.run(); // super는 부모를 가리키는 키워드
                     // 부모의 run() 메소드를 먼저 실행 시키라는 뜻!
                     // super. 으로 부모의 메소드나 필드에 접근할 수 있음.
        System.out.println("레이싱카가 전속력으로 질주합니다!!!!!!!!"); // super 없이 이렇게만 쓰면 완전히 이 내용으로 덮어씌우기 때문에 Car의 isRunning=true;가 사라져서 작동하지 않음.
    }
}
