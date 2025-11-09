package com.ohgiraffers.section05.overloading.problem;

public class Problem {
    public static void main(String[] args) {
    /*
    * [ 오버로딩이 존재하지 않을 경우의 문제점 ]
    * * 모든 메서드의 이름을 다르게 지어줘야 함.
    * */

        BadCalculator bc = new BadCalculator();

        bc.addTwoInts(10, 20);
        bc.addTwoDoubles(10.5, 20.5);
        bc.addThreeInts(10, 20, 30);

    }
}
