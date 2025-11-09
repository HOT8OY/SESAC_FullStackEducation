package com.ohgiraffers.section03.branching;

public class Application {
    public static void main(String[] args) {
        Application app = new Application();
//        app.simpleBreak();
//        app.nestedBreak();
//        app.simpleContinue();
//        app.nestedContinue();
        app.handleNestedBreak();
    }

    public void simpleBreak() {

        int sum = 0;
        int i = 0;
    /* 무한 반복 while문 탈출 방법 */
    // if로 탈출 조건을 만든다.
        while(true) {
            sum += i;
            System.out.println(i + "를 더했다. 현재 합계 : " + sum);

            // '만약 i가 10이 되면' 이라는 탈출 조건을 만든다.
            if (i == 10) {
                System.out.println("i가 10이 되어 break로 반복문을 탈출한다!");
                break; // 가장 가까운 반복문을 즉시 중단하고 탈출한다.
            }
            i++;    // break 조건이 아니면 i를 1 증가시키고 다시 반복.
        }
        System.out.println("최종 합은 " + sum + "입니다.");
    }

    /* 반복문 탈출 break문 */
    // break는 자신을 감싸고 있는 '가장 가까운' 반복문 하나만 탈출한다.
    public void nestedBreak() {
        for(int dan = 2; dan < 10; dan++) {
            System.out.println("---" + dan + "단 시작 ---");
            for(int su = 1; su < 10; su++) {
                if(su > 5) {
                    break;  // 안쪽 for문을 탈출하라는 신호
                }
                System.out.println(dan + " * " + su + " = " + (dan * su));
            }
        }
    }

    /* continue 문 */
    public void simpleContinue() {
        System.out.println("1부터 100사이의 4와 5의 공배수(20의 배수)만을 출력합니다.");

        for(int i = 1; i <= 100; i++) {
            // 4의 배수이면서 동시에 5의 배수가 아닌것을 검사
            if (!(i % 4 == 0 && i % 5 == 0)) {
                continue;   // 이번 반복 회차를 건너뛰고 증감식(i++)로 이동한다.
            }
            System.out.println(i);
        }
    }

    /* 중첩 continue 문 */
    public void nestedContinue() {
        // 구구단을 출력하되, 각 단에서 '홀수' 곱만 출력하는 continue 예제
        for(int dan = 2; dan < 10; dan++) {
            System.out.println("---" + dan + "단 시작 ---");
            for(int su = 1; su < 10; su++) {
                // 만약에 곱하는 수(su)가 짝수라면 '이번회차'만 건너뛰고 증감식(su++)으로 이동
                if (su % 2 == 0) {
                    continue;
                }
                System.out.println(dan + " * " + su + " = " + (dan * su));
            }
        }
    }

    /* 중첩 반복문을 바깥쪽까지 한번에 탈출하는 방법 2개 */

    // # 1. label 붙인곳을 탈출
    // 코드의 흐름을 예측하기 어려워 요즘은 거의 사용하지 않는 '안티 패턴'이다.
    public void handleNestedBreak() {
        ohgiraffers: // 바깥쪽 for문에 이름표를 붙임
        for(int dan = 2; dan < 10; dan++) {
            for(int su = 1; su < 10; su++) {
                if(dan == 3 && su == 5) {   // 3단 * 5에서 탈출
                    break ohgiraffers;  // 이름표가 붙은 반복문 전체를 탈출
                }
                System.out.println(dan + " * " + su + " = " + (dan * su));
            }
            System.out.println();
        }

        // # 2. Flag 변수를 사용한 탈출
        // 코드가 순차적으로 흘러가서 직관적이고 안정적이다. 실무에서 주로 사용하는 방식.
        System.out.println("Flag 변수 사용");
        boolean isBreak = false; // 탈출 신호를 보낼 Flag 변수(깃발)

        for(int dan = 2; dan < 10; dan++) {
            for(int su = 1; su < 10; su++) {
                if(dan == 3 && su == 5) {
                    isBreak = true; // 탈출 신호를 보냄
                    break ;  // 가장 가까운 반복문 탈출
                }
                System.out.println(dan + " * " + su + " = " + (dan * su));
            }
            // 안쪽 반복문이 끝난 직후, Flag 변수를 확인한다.
            if (isBreak) {
                break;  // 탈출신호가 있다면 바깥쪽 반복문도 탈출한다.
            }
            System.out.println();
        }
    }
}
