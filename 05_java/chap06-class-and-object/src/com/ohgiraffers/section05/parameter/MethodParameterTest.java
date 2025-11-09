package com.ohgiraffers.section05.parameter;

import java.util.Arrays;

public class MethodParameterTest {
    /* [값을 복사할 때] */

    /* 기본 자료형 : 파라미터로 '값'이 복사되어 넘어온다 (Pass by Value) */
    public void testPrimitiveType(int num) {
        System.out.println("전달받은 num : " + num); // 20
        num = 99;   // 복사본의 값을 변경
        System.out.println("변경 후 num : " + num); // 99
    }

    /* 배열(참조 자료형) : 파라미터로 '주소값'이 복사되어 넘어온다. (얕은 복사(같은 Heap영역)) */
    public void testArrayParameter(int[] arr) {
        System.out.println("전달받은 arr = " + Arrays.toString(arr));
        arr[0] = 99;
        System.out.println("변경 후 arr = " + Arrays.toString(arr));
    }

    /* 객체(참조 자료형) : 파라미터로 '주소값'이 복사되어 넘어온다. (얕은 복사(같은 Heap영역)) */
    public void testObjectParameter(Rectangle rect) {
        System.out.println("전달받은 사각형 너비 = " + rect.getWidth());
        rect.setWidth(100);
        System.out.println("변경 후 사각형 너비 = " + rect.getWidth());
    }

    /* 가변 인자 : 파라미터의 개수가 유동적일 때 사용한다. (자료형 뒤에 ...을 입력) */
    // toppings : 0개 이상의 선택 파라미터, 가변인자는 메소드 내부에서 배열로 취급된다.
    // 가변인자로 받을 수 있는 값은 0개 이상이다.
    public void orderPizza(String customerName, String... toppings) {
        System.out.println(customerName + "고객님!!");
        System.out.println("주문하신 피자 토핑: " + Arrays.toString(toppings));
    }

}
