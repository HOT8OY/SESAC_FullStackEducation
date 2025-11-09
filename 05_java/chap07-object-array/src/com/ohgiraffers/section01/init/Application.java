package com.ohgiraffers.section01.init;

public class Application {
    public static void main(String[] args) {
        /* [ objectarray 객체배열 ] */

        /* Object Array를 사용하지 않았을 때 */
//        Car car1 = new Car(); // 매개변수 있는 생성자를 만들었기 때문에 컴파일러가 자동으로 기본생성자를 추가해주지 않아서 사용 불가.
        Car car1 = new Car("페라리", 300);
        Car car2 = new Car("람보르기니", 350);
        Car car3 = new Car("롤스로이스" ,250);
        Car car4 = new Car("부가티베이론", 400);
        Car car5 = new Car("포터", 200);

        car1.driveMaxSpeed();
        car2.driveMaxSpeed();
        car3.driveMaxSpeed();
        car4.driveMaxSpeed();
        car5.driveMaxSpeed();

        System.out.println("=============================");

        /* Object Array를 사용 */
        /* 객체배열은 레퍼런스변수들을 보관하는 배열이다.
        * 동일한 타입의 여러 객체들을 하나의 묶음으로 관리하여 연속적으로 처리할 때 유용하다. */
        Car[] carArray = new Car[5];

        /* 배열을 선언만 하면 기본값으로 초기화된다.
        * 기본자료형(int, double 등)은 0, 0.0으로 초기화 되지만,
        * 참조자료형(Car, String 등)의 기본값은 null 이다. */
        System.out.println(carArray[0]); // null

        // try{시도 할 행동} catch(잡아낼 에러) {해당 에러를 잡아냈을 시 할 행동}
        try{
            carArray[0].driveMaxSpeed();    // 아무것도 할당하지 않았기에 NullPointException 에러 발생, 프로그램 종료
        } catch (NullPointerException e){   // NullPointException은 자료형 이기에 e 라는 이름을 붙임
            System.out.println("!!! NullPointerException 발생!!!");
        }

        /* 각 객체에 값 넣기 */
        carArray[0] = new Car("페라리", 300);
        carArray[1] = new Car("람보르기니", 350);
        carArray[2] = new Car("롤스로이스" ,250);
        carArray[3] = new Car("부가티베이론", 400);
        carArray[4] = new Car("포터", 200);

        // 배열의 장점: 반복문 사용 가능
        for (int i = 0; i < carArray.length; i++) {
            carArray[i].driveMaxSpeed();
        }

        System.out.println("=============================");
        /* 선언과 동시에 초기화 */
        // 객체배열도 선언과 동시에 리터럴({})로 초기화 할 수 있다.
        Car[] carArray2 = {
                new Car("페라리", 300),
                new Car("람보르기니", 350),
                new Car("롤스로이스", 250)
        };
        // 향상된 for문 사용
        // 향상된 for문은 읽기 전용이다
        // carArray2 객체 배열에서 객체를 하나씩 꺼내 'car'라는 임시 변수에 '복사' 해주는 방식
        // 주의: 실제 car가 복사되는것이 아니고, car를 가리키는 '주소값'만 복사된다
        for(Car car : carArray2) {
            car.driveMaxSpeed();
        }

        /* 가장 빠른 차를 찾기 */
        /* 1. 가장 빠르다고 '가정'할 차를 담을 변수 선언(첫 번째 차로 초기화) */
        Car fatestCar = carArray[0];

        /* 2. 반복문을 돌며 현재까지 가장 빨랐던 차(fastestCar)와 다음 차를 비교 */
        for(int i = 1; i < carArray.length; i++) {
            if(carArray[i].getMaxSpeed() > fatestCar.getMaxSpeed()) {
                fatestCar = carArray[i]; // 만약 다음 차가 더 빠르다면, '가장 빠른 차' 변수를 그 차로 교체
            }
        }
        System.out.println("가장 빠른 자동차는 " + fatestCar.getModelName() + "이며 시속은" + fatestCar.getMaxSpeed() + "입니다.");
    }
}
