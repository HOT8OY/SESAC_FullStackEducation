package o09_ConstructorAndInitialize;

public class ConstructorChainingExample {
    public static void main(String[] args) {
        Car car1 = new Car("소나타");
        Car car2 = new Car("그랜저", "흰색");
        Car car3 = new Car("아반떼", "검은색", 2023);

        System.out.println(car1.model + ", " + car1.color + ", " + car1.year);
        System.out.println(car2.model + ", " + car2.color + ", " + car2.year);
        System.out.println(car3.model + ", " + car3.color + ", " + car3.year);
    }
}

class Car {
    String model;
    String color;
    int year;

    // 생성자 1: 모델명만 받음
    Car(String model) {
        // this()를 사용해서 다른 생성자 호출
        // this()는 생성자의 첫 줄에 와야 함!
        this(model, "흰색");  // 생성자 2 호출
    }

    // 생성자 2: 모델명과 색상 받음
    Car(String model, String color) {
        // 생성자 3 호출
        this(model, color, 2024);  // 생성자 3 호출
    }

    // 생성자 3: 모든 필드 받음
    Car(String model, String color, int year) {
        // 실제 초기화는 여기서만 수행
        this.model = model;
        this.color = color;
        this.year = year;

        System.out.println("자동차 생성됨: " + model);
    }
}

/*
실행 흐름:
Car car1 = new Car("소나타");
-> Car(String model) 생성자 실행
   -> this(model, "흰색") 호출
      -> Car(String model, String color) 생성자 실행
         -> this(model, color, 2024) 호출
            -> Car(String model, String color, int year) 실행
               -> 실제 필드 초기화
*/
