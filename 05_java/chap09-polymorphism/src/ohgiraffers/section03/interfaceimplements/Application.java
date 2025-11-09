package ohgiraffers.section03.interfaceimplements;

public class Application {
    public static void main(String[] args) {
        // 객체 생성
        Keyboard keyboard = new Keyboard();
        Mouse mouse = new Mouse();
        Computer computer = new Computer();

        computer.connectDevice(keyboard);   // 실제로 연결 된 객체의 메서드가 작동
        computer.connectDevice(mouse);
    }

}
