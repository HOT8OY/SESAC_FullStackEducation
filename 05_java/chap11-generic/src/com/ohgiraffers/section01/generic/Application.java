package com.ohgiraffers.section01.generic;

public class Application {
    public static void main(String[] args) {

        // [ NormalBox 이용 ]
        // Object 타입에는 뭐든지 받을 수 있음(String, 기본타입 등 모두)
        NormalBox normalBox = new NormalBox();

        normalBox.setContent("안녕하세요");
        // 실수로 잘못된 값을 넣어도 컴파일 에러가 나지 않는다(Object는 모든걸 받아주니까)
//        normalBox.setContent(123);  // 실행 해야 오류(ClassCastException)를 알 수 있음. 런타임 오류

        // 그냥 꺼내면 object타입으로 꺼내지므로 String에 담아서 꺼내야 한다.
        // 다만 그냥 꺼내면 타입이 맞지 않으므로 강제형변환(다운캐스팅)을 해야한다.
        String content = (String)normalBox.getContent();


        // [ Generic 이용 ] //
        /* String 타입 사용 */
        // <> 안에다가 내가 정해주고 싶은 자료형을 넣는다
        // <String>을 쓰면 이 박스는 오직 String 타입만 담겠다는 뜻
        GenericBox<String> stringBox = new GenericBox<>();  // 이 순간 GenericBox에 써 놓은 T의 자리는 String이 됨.

        stringBox.setContent("Hello World!");
//        stringBox.setContent(123);  // 컴파일 에러!!

        String strcontent = stringBox.getContent();
        System.out.println(strcontent);

        /* Integer 타입 사용 */
        // Generic에 들어가는 타입은 "객체타입"만 가능하다.
        // 따라서 기본형을 사용하고 싶다면 int -> Integer, char -> Charater 등 Wrapper Class를 사용해야 한다.
        GenericBox<Integer> integerBox = new GenericBox<>();
        integerBox.setContent(100);
        int intContent = integerBox.getContent();
        System.out.println(intContent + 1);
    }
}
