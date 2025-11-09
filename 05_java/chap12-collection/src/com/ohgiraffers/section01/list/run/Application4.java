package com.ohgiraffers.section01.list.run;

import java.util.EmptyStackException;
import java.util.Stack;

public class Application4 {
    public static void main(String[] args) {

        /* [ Stack ]
        * Stack 이란 ‘쌓다’, ‘더미’ 라는 뜻을 가진 자료 구조로 리스트 계열 클래스인 Vector 클래스를 상속받아 구현된 자료구조이다.
        * - 후입선출(LIFO) 방식의 자료구조이다.
        *
        * # 언제 사용하는가?
        * - 웹 브라우저의 '뒤로 가기' 기능
        * - 프로그램의 '실행 취소' 기능
        * - 재귀 알고리즘을 반복문으로 구현할 때
        *
        * # Stack은 Vector의 자식요소이다.
        * - 따라서 pop,push는 Stack의 고유 요소이기에 List에서는 사용 불가하다.
         */
        Stack<Integer> integerStack = new Stack<>();

        // stack에 값을 넣을때는 push() 사용
        integerStack.push(1);
        integerStack.push(2);
        integerStack.push(3);
        integerStack.push(4);

        System.out.println(integerStack);

        /*
        * peek() : 가장 꼭대기 요소를 '확인만'하고 제거하지는 않는다.
        * pop() : 가장 꼭대기 요소를 '꺼내고' 제거한다.
        * */

        System.out.println("peek() : " + integerStack.peek()); // peek() : 4
        System.out.println(integerStack); // [1, 2, 3, 4]

        System.out.println("pop() : " + integerStack.pop()); // pop() : 4
        System.out.println(integerStack); // [1, 2, 3]

        // 전부 비워버린 상황에서 peek과 pop을 한다면 Exception이 발생.
        // Exception 처리는 try catch로 처리해야 함.
        // try catch
        try{
            integerStack.pop();
            integerStack.pop();
            integerStack.pop(); // 이미 여기에서 stack이 다 비워짐
            integerStack.pop(); // EmptyStackException 에러 발생!
        } catch (EmptyStackException e) {   // EmptyStackException이 발생한다면
            System.out.println("스택이 비어있습니다."); // "스택이 비어있습니다."를 출력
        }
    }
}
