package com.ohgiraffers.section02.ecncapsulation.problem;

public class Application {
    public static void main(String[] args) {

        /* 필드에 직접 접근할 때 발생하는 문제점 */
        Children children = new Children();
        // 문제1 : 데이터의 신뢰성이 훼손
        // 나이는 음수일 수 없는데, 직접 접근을 막을 방법이 없다.
        children.name = "김영희";
        children.age = -10; // 음수가 들어가서 잘못된 데이터.
        System.out.println(children.name + "는 " + children.age + "세 입니다.");

        // 문제2 : 유지보수의 어려움
        // 클래스 내부의 변경이 클래스 바깥까지 영향을 미치는 '높은 의존성' 상태이다.
        // 예시: 만약 Children 클래스의 필드명이 변경된다면, 즉시 에러를 발생시킨다.
        // (Children 내부의 name을 user로 바꾸면 여기서 에러가 발생.

        // 나머지 내용은 solution폴더에서...


    }
}
