package com.ohgiraffers.section02.ecncapsulation.solution;

public class Application {
    public static void main(String[] args) {

        Children child1 = new Children();
        child1.setAge(-10);  // 잘못된 값을 넣어 잘 작동하는지 검증

        System.out.println("어린이 나이 : " + child1.getAge() + " 세");   // 필드에 직접 접근하지 않고, getter로 값을 가져옴.

//        child1.age = -30;   // Children 클래스 내의 필드를 private 필드로 만들어 다른 class에서는 직접 접근 불가.
        System.out.println("어린이 나이 : " + child1.getAge() + " 세");
    }
}
