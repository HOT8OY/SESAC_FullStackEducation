package ohgiraffers.section01.extend;
// 부모클래스 Car
public class Car {

    // 달리는지 확인할 수 있는 불리언 필드(runningStatus)
    private boolean runningStatus;

    public Car() {
        System.out.println("1. Car 클래스의 기본 생성자 호출...");
    }

    public void run() {
        runningStatus = true;
        System.out.println("자동차가 달립니다.");
    }

    public void soundHorn() {
        if(isRunning()) {
            System.out.println("빵빵!!");
        } else {
            System.out.println("주행중이 아닌 상태입니다.");
        }
    }
    /* protected : 같은 패키지 내 + '상속 관계에 있는 자식' 클래스에서 접근 가능 */
    // 접근 제한자를 자식도 접근할 수 있도록 private가 아닌 protected로 한다.
    protected boolean isRunning() {
        return runningStatus;
    }

    public void stop(){
        runningStatus = false;
        System.out.println("자동차가 멈춥니다.");
    }
}
