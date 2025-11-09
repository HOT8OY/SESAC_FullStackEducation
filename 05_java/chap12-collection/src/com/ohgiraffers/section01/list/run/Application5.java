package com.ohgiraffers.section01.list.run;

import java.util.LinkedList;
import java.util.Queue;

public class Application5 {
    public static void main(String[] args) {
        /* [ Queue (큐) ]
         * - 선입선출(FIFO) 방식의 자료구조이다.
         * - 큐는 인터페이스이므로, 실제로는 이를 구현한 LinkedList 등의 클래스를 사용해 인스턴스를 생성한다.
         * */
        Queue<String> que = new LinkedList<>();

        // queue에 데이터를 넣을 때는 offer()를 이용
        que.offer("first");
        que.offer("second");
        que.offer("third");

        System.out.println(que);

        // peek() : 가장 앞에 있는 요소를 '확인만' 하고 제거하지 않음
        System.out.println("peek() : " + que.peek()); // peek() : first
        System.out.println(que);                      // [first, second, third]

        // poll() : 가장 앞에 있는 요소를 '꺼내고' 큐에서 제거한다
        System.out.println("poll() : " + que.poll()); // poll() : first
        System.out.println(que);                      // [second, third]

        // 큐가 비어있는 경우 null을 반환한다.(에러를 발생시키지 않음)
        que.poll();
        que.poll(); // 여기서 다 비웠음.
        System.out.println(que.poll());

    }
}
