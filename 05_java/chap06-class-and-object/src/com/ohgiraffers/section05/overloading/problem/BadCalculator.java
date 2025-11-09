package com.ohgiraffers.section05.overloading.problem;

public class BadCalculator {
    /*
     * [ 오버로딩이 존재하지 않을 경우의 문제점 ]
     * 모든 메서드의 이름을 다르게 지어줘야 함.
     * */
    // 타입,연산 갯수가 다르다는 이유만으로 전부 하나씩 만들어줘야 함.
    public int addTwoInts(int num1, int num2) {
        return num1 + num2;
    }
    public double addTwoDoubles(double num1, double num2) {
        return num1 + num2;
    }
    public int addThreeInts(int num1, int num2, int num3) {
        return  num1 + num2 +num3;
    }
}
