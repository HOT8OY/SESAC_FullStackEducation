package com.ohgiraffers.section04.constructor;

import java.util.Date;

public class Application1 {
    public static void main(String[] args) {

        // 이 방법의 문제점 : 번거롭게 하나씩 값을 넣어줘야 함.
        // # 1. 기본 생성자 함수 호출 방식
        User user = new User();
        System.out.println(user.getInformation()); // 값을 넣기 전 내용
        user.setId("user01");
        user.setPwd("pass01");
        user.setName("홍길동");
        System.out.println(user.getInformation());  // 값을 넣은 후 내용

        // # 2. 매개변수 있는 생성자 함수 호출 방식
        // id, pwd, name 초기화하는 생성자
        User user1 = new User("user02", "pass02", "유관순");
        System.out.println(user1.getInformation());

        // # 3. 모든 필드를 초기화 하는 생성자 호출 방식
        User user2 = new User("user03", "pass03", "이순신", new Date());
        System.out.println(user2.getInformation());
    }
}
