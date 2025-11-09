package com.ohgiraffers.section02.pakage_and_import;
import com.ohgiraffers.section01.method.Calculator;
import static com.ohgiraffers.section01.method.Calculator.maxNumberOf;

public class Application {
    public static void main(String[] args) {

        // ## non-static 메소드 호출
        // 패키지가 다르면 풀패키지명을 적어야 함.
        // 클래스명 사용할이름 = new 클래스명
        com.ohgiraffers.section01.method.Calculator calc = new com.ohgiraffers.section01.method.Calculator();
        int min = calc.minNumberOf(30, 20);
        System.out.println(min);

        // ## static 메소드 호출
        int max = com.ohgiraffers.section01.method.Calculator.maxNumberOf(30, 20);
        System.out.println(max);

        // 위와 같이 매번 풀패키지명을 사용하면 코드가 길고 불편해진다.
        // 그래서 사용하는것이 import이다.
        // 맨 위에 import로 해당 패키지를 사용할것이라고 먼저 선언. (import com.ohgiraff....Calculator)
        // import를 하지 않았어도, ALT + ENTER로 자동으로 import문 작성 가능.

        /* import 사용하여 다른 패키지의 클래스 사용하기 */
        // ## non-static
        Calculator calc2 = new Calculator();
        int min2 = calc2.minNumberOf(30, 20);
        System.out.println(min2);
        // ## static
        int max2 = Calculator.maxNumberOf(30, 20); // 클래스 이름은 여전히 필요하다.
        System.out.println(max2);

        /* static 메소드 클래스 이름 없이 직접 호출하게 하기 */
        // 상단에 import static com.ohg....maxNumberOf; 로 직접 import
        // 메소드 이름만으로 호출 가능하지만 권장하지 않음.
        // 이 기능이 어디에서 온건지 한눈에 파악하기 어려움.
        int max3 = maxNumberOf(40, 10); // static import 해서 클래스명 없이 메소드 이름만으로 호출 가능
        System.out.println(max3);
    }
}
