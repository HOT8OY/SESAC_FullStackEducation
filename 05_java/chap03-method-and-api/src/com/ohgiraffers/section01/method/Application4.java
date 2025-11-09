package com.ohgiraffers.section01.method;

public class Application4 {
    public static void main(String[] args) {

        /* 다른 클래스에서 작성한 메소드 호출 */

        int first = 100;
        int second = 50;

        /* non-static 메소드의 경우 */
        /* 클래스가 다르더라도 사용하는 방법은 동일하다.
           (사용 방법)
           사용할이름.메소드명();
           */
        Calculator calc = new Calculator();
        int min = calc.minNumberOf(first, second);
        System.out.println("최소값은 : " + min);

        /* static 메소드인 경우 */
        /* 다른 클래스에 작성한 static 메소드의 경우 호출할 때 클래스명을 반드시 기술
           (사용방법)
           클래스명.메소드명();
           */
//        int max = maxNumberof(first, second);
        int max = Calculator.maxNumberOf(first, second);
        System.out.println("최대값은 : " + max);

        int max2 = calc.maxNumberOf(first, second); // 이렇게 객체로 접근 가능하나 권장하지 않음.
        System.out.println("최대값은 : " + max2);
    }
}
