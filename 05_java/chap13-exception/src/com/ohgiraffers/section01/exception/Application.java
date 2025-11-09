package com.ohgiraffers.section01.exception;

public class Application {
    public static void main(String[] args) throws Exception {
        /* [Exception 예외] */
        // Exception을 처리하지 않고 throws만 할 경우
        ExceptionTest et = new ExceptionTest();

        // 정상 케이스
        System.out.println("정상 케이스");
        et.checkEnoughMoney(10000, 50000);

        // 예외 발생 케이스
        System.out.println("예외 발생 케이스");
        et.checkEnoughMoney(10000, 3000);   // Exception 발생
        // 예외를 메서드에 추가한다면(throws Exception) 예외 처리를 JVM에게 떠넘기게 된다
        // 에러 발생 시 JVM에서 처리를 못 하기 때문에 에러 발생하면 프로그램이 즉시 종료된다.

        // 실행이 잘 됐다면 프로그램 종료
        System.out.println("프로그램을 종료합니다.");
    }
}
