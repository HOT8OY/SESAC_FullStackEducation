package com.ohgiraffers.section01.exception;

public class Application2 {
    public static void main(String[] args) {
        ExceptionTest et = new ExceptionTest();

        // 정상 케이스
        /* 빨간색 밑줄에 alt + enter을 누르면, 2가지 옵션이 제공된다.
           메서드에 throw Exception으로 호출한 곳으로 예외처리를 넘길지,
           try,catch로 여기서 예외를 처리할 지 */
        System.out.println("=======정상케이스=======");
        try {
            // 상품 구매시도
            et.checkEnoughMoney(10000, 300000);
            // try 블럭에서 예외가 발생하지 않으면, catch 블럭은 실행되지 않고 건너뛴다.
            System.out.println("상품 구입 가능!!");
        } catch (Exception e) {
            System.out.println("상품 구입 불가!!");
        }
        System.out.println("=======예외 발생 케이스=======");

        // 실패 케이스
        // 던져진 예외(Exception)을 받아서, 여기서 책임지고 처리한다.
        try {
            et.checkEnoughMoney(30000,10000);
            System.out.println("상품 구입 가능!!");
        } catch (Exception e) {
            System.out.println("상품 구입 불가!!");
            System.out.println(e.getMessage()); // e.getMessage : 에러가 발생 시 보내준 message를 확인할 수 있음.
            e.printStackTrace(); // e.printStackTrace : 프로그램이 끝난 후 예외가 발생한 경로를 출력해줌.
        }

        // 프로그램이 중간에 멈추지 않고 끝까지 실행된다면 이것이 출력됨
        System.out.println("프로그램을 정상적으로 종료합니다.");
    }
}
