package com.ohgiraffers.section02.userexception;

import com.ohgiraffers.section02.userexception.exception.MoneyNegativeException;
import com.ohgiraffers.section02.userexception.exception.NotEnoughMoneyException;
import com.ohgiraffers.section02.userexception.exception.PriceNegativeException;

public class ExceptionTest {

    // 상품 구매 시도 메소드
    // 발생할 수 있는 모든 예외를 시그니처 메소드에 추가한다!
    public void checkEnoughMoney(int price, int money) throws PriceNegativeException, MoneyNegativeException, NotEnoughMoneyException {

        System.out.println("가지고 계신 돈은 " + money + "원 입니다.");

        // 가격이 음수라면?
        if(price < 0) {
            throw new PriceNegativeException("상품 가격은 음수일 수 없습니다");
        }
        // 가진 돈이 음수라면?
        if(money < 0) {
            throw new MoneyNegativeException("가진 돈은 음수일 수 없습니다");
        }
        // 가진 돈 보다 가격이 더 크다면
        if(money < price) {
            throw new NotEnoughMoneyException("가진 돈 보다 상품 가격이 더 비쌉니다.");
        }
        // 위에서 예외를 만나면 그 뒤의 코드는 실행되지 않는다.
        // 따라서 예외 시 밑의 코드는 실행되지 않음!
        System.out.println("가진 돈이 충분합니다. 즐거운 쇼핑 하세요~");
    }
}
