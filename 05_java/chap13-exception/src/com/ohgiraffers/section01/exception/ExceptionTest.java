package com.ohgiraffers.section01.exception;

public class ExceptionTest {

    // 상품 구매 시도 메소드
    public void checkEnoughMoney(int price, int money) throws Exception {

        System.out.println("가지고 계신 돈은 " + money + "원 입니다.");

        if(money >= price) {
            System.out.println("상품을 구입하기 위한 돈이 충분하다");
        } else {    // 돈이 부족할 경우 Exception을 발생시킴. Exception도 클래스이며, Throwable 클래스를 상속받는 요소임.
                    // throw new Exception을 사용한다면 꼭 메소드 시그니처에 'throws Exception'을 추가.
            throw new Exception("돈이 부족합니다"); // 호출한 곳으로 에러 메시지를 담아서 던질 수도 있다.
        }
        System.out.println("즐거운 쇼핑 하세요~");
    }
}
