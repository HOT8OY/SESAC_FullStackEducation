package ohgiraffers.section01.extend;
/* [ inheritance 상속 ] */
public class Application {
    public static void main(String[] args) {

        Car car = new Car();

        // car의 메소드를 확인해보기
        car.run();
        car.soundHorn();
        car.stop();
        car.soundHorn();

        System.out.println("============ FireCar ==============");
        FireCar fireCar = new FireCar();
        // 자식(FireCar)의 메소드를 확인해보기
        // 부모(Car)의 메소드를 그대로 사용 가능하다
        fireCar.run();
        fireCar.soundHorn();
        fireCar.stop();
        fireCar.sprayWater();

        System.out.println("============ RacingCar ==============");
        // RacingCar
        RacingCar racingCar = new RacingCar();
        racingCar.run();
        racingCar.soundHorn();
    }
}
