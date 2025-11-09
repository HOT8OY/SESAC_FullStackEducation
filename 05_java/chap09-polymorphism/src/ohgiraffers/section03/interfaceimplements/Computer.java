package ohgiraffers.section03.interfaceimplements;

public class Computer {

    public void connectDevice(IConnectable device) { // 타입이 IConnectable이란것은 타입 상관 없이 IConnectable 규격을 지켰는지만을 확인하겠다는 것
        System.out.println("컴퓨터의 USB 포트에 장치를 연결합니다.");
        device.connect();
    }
}
