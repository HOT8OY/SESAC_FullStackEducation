package com.ohgiraffers.section01.method;

import java.sql.SQLOutput;

public class Application2 {
    public static void main(String[] args) {

        // 클래스 인스턴스(객체) 생성
        Application2 app2 = new Application2();
        /* 전달인자(argument)와 매개변수(parameter)
        * - 메소드를 호출할 때 넘겨주는 값을 '전달인자'라고 하며
        * - 메소드에서 이 값을 받기 위해 선언된 변수를 '매개변수'라고 한다.*/
        app2.printAge(30);  // 값을 직접 전달

        int myAge = 25;
        app2.printAge(myAge);   // 변수에 담긴 값을 전달

        /* 여러 개의 전달인자를 이용해 메소드를 호출할 수 있다.
        * - 매개변수의 타입, 개수, 순서를 정확히 맞춰서 전달해야 한다. */
        app2.printUserInfo( "홍길동", 20, '남'); // 이름: 홍길동, 나이: 20세, 성별: 남

        String name = "유관순";
        int age = 18;
        char gender = '여';
        app2.printUserInfo(name, age, gender); // 이름: 유관순, 나이: 18세, 성별: 여

        /* - 'void'가 아닌 다른 타입이 명시된 메소드는 반드시 해당 타입의 값을 반환(return)해야 한다.
        * - 반환된 값은 변수에 저장하거나 다른 메소드의 전달인자로 즉시 사용할 수 있다. */
        String message = app2.createGreetingMessage();  // message라는 곳에 create...의 반환값을 받음
        System.out.println(message);                    // 즉 String message = "Hello World!"

        String profile = app2.createProfileString("신사임당", 40);
        System.out.println(profile);

    }

    // int age가 들어간 자리를 '매개변수'라고 부름. JAVA에서는 매개변수를 넣을 때 '자료형'까지 같이 넣어줘야 한다.
    public void printAge(int age) {
        System.out.println("당신의 나이는 " + age + "세 입니다.");
    }

    public void printUserInfo(String name, int age, char gender) {
        System.out.println("이름: " + name + ", 나이: " + age + "세, 성별: " + gender);
        return; // void 메소드의 경우 return을 명시적으로 작성하지 않아도 마지막줄에 컴파일러가 자동으로 추가해줌.
    }
    // void는 return하는 값이 없다는 것을 명시하는 것
    // 'public String ...'으로 만들었다면 반드시 String 형식으로 return하게 만들어야 한다.
    /* - 'void'가 아닌 다른 타입이 명시된 메소드는 반드시 해당 타입의 값을 반환(return)해야 한다.
     * - 반환된 값은 변수에 저장하거나 다른 메소드의 전달인자로 즉시 사용할 수 있다. */
    public String createGreetingMessage() {
        return "Hello World!";
    }

    public String createProfileString(String name, int age) {
        String profile = name + "님의 나이는 " + age + "세입니다.";
        return profile;
    }
}
