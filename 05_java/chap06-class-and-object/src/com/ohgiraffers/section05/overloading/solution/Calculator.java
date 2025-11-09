package com.ohgiraffers.section05.overloading.solution;

public class Calculator {
    /* [ 오버로딩을 적용 ] */
    // 이름은 같아도 매개변수가 다르기에 자바는 각 메소드를 호출 시 완전히 구분하여 호출해줌.
    public int add(int num1, int num2) {
        System.out.println("정수 2개를 더하는 add()");
        return num1 + num2;
    }
    public double add(double num1, double num2) {
        System.out.println("실수 2개를 더하는 add()");
        return num1 + num2;
    }
    public int add(int num1, int num2, int num3) {
        System.out.println("정수 3개를 더하는 add()");
        return num1 + num2 + num3;
    }
}
