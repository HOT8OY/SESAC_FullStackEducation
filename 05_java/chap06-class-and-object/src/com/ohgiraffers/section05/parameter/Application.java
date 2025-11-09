package com.ohgiraffers.section05.parameter;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {

        /* [값을 복사할 때] */

        /* 기본 자료형 : 파라미터로 '값'이 복사되어 넘어온다 */

        MethodParameterTest pt = new MethodParameterTest();
        int num = 20;
        System.out.println("호출 전 main의 num : " + num); // 20
        pt.testPrimitiveType(num);  // num의 '값'인 20을 복사해서 전달
        System.out.println("호출 후 main의 num : " + num); // 20 | 원본은 불변!


        /* 배열(참조 자료형) : 파라미터로 '주소값'이 복사되어 넘어온다. (얕은 복사(같은 Heap영역)) */

        int[] iarr = {1, 2, 3, 4, 5};
        System.out.println("호출 전 : " + Arrays.toString(iarr));
        pt.testArrayParameter(iarr);    // iarr이 가리키는 '주소값'을 복사해서 전달
        System.out.println("호출 후 : " + Arrays.toString(iarr));  // 원본도 변경됨!!


        /* 객체(참조 자료형) : 파라미터로 '주소값'이 복사되어 넘어온다. (얕은 복사(같은 Heap영역)) */

        Rectangle r1 = new Rectangle(12.5, 22.5);
        System.out.print("호출 전 main 사각형 정보 : ");
        r1.printInfo();
        pt.testObjectParameter(r1); // r1이 가리키는 '주소값'을 복사해서 전달
        System.out.print("호출 후 main 사각형 정보 : ");
        r1.printInfo();


        /* 가변 인자 : 개수가 변하는 파라미터 */
        pt.orderPizza("홍길동");
        pt.orderPizza("유관순", "불고기");
        pt.orderPizza("이순신", "치즈", "페페로니", "올리브");
    }
}
