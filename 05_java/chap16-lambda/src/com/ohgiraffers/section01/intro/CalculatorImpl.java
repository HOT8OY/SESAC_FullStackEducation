package com.ohgiraffers.section01.intro;

public class CalculatorImpl implements Calculator {
    // lambda가 없던 시절(Calculator 인터페이스, CalculatorImpl)

    @Override
    public int sumTwoNumber(int a, int b) {
        return a + b;
    }
}
