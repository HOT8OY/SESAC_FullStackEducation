package com.ohgiraffers.section01.intro;

@FunctionalInterface    // 이 인터페이스는 메소드가 딱 하나만 있어야해!! 라는 규칙을 강제하는 어노테이션이다
                        // 하나의 메소드만 정의되어 있어야지 그것을 추론하여 프로그램에서 사용한다.
                        /* 함수형 인터페이스 : 메소드가 단 하나만 정의된 인터페이스 (람다식 사용의 필수 조건!!) */
public interface Calculator {
    // lambda가 없던 시절(Calculator 인터페이스, CalculatorImpl)
    // 인터페이스에 작성하는 메소드는 추상메소드. 몸통{}이 없음.
    int sumTwoNumber(int a, int b);
}
