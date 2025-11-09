package com.greddy.level01.basic;

public class Calculator {
    public void checkMethod(){
        System.out.println("메소드 함수 호출 확인");
    }
    public int sum1to10() {
        int sum1 = 0;
        for (int i = 1; i <= 10; i++) {
            sum1 += i;
        }
        return sum1;
    }
    public void checkMaxNumber(int a,int b) {
        int compareMax = a > b ? a : b;
        System.out.println(a + "와 " + b + " 중 큰 수는 " + compareMax + "이다.");
    }
    public int sumTwoNumber(int a, int b) {
        int sum = a + b;
        return sum;
    }
    public int minusTwoNumber(int a, int b) {
        int minus = a - b;
        return minus;
    }
}

