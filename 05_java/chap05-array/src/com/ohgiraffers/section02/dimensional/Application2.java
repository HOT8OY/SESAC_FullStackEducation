package com.ohgiraffers.section02.dimensional;

public class Application2 {
    public static void main(String[] args) {

        /*
        [가변 배열]
        2차원 배열의 각 행(층)마다 열(방)의 길이가 다른 배열

        ※ 선언 방법:
        1. 층의 수만 먼저 지정하여 배열을 할당.
        2. 각 층마다 다른 길이의 배열을 개별적으로 할당.
        */

        // # 1. 층의 수만 지정하여 배열을 할당
        int[][] iarr = new int[3][];    // stack에서 iarr은 1차원 배열을 담을 수 있는 공간만 참조
        // # 2. 각 층마다 다른 길이의 배열을 개별적으로 할당
        iarr[0] = new int[3];
        iarr[1] = new int[2];
        iarr[2] = new int[5];

        // # 3. 중첩 반복문을 이용한 값 대입.(Application1에서 한것과 같은 방식으로 해도 작동)
        int value = 1;
        // '층'을 순회(0층, 1층, 2층)
        for(int i = 0; i < iarr.length; i++) {
            for(int j = 0; j < iarr[i].length; j++) {   // iarr[i].length -> i 배열 안쪽 배열의 길이(5)
                iarr[i][j] = value++;
            }
        }
        // 출력문
        for(int i = 0; i < iarr.length; i++) {
            for(int j = 0; j < iarr[i].length; j++) {
                System.out.print(iarr[i][j] + " ");
            }
            System.out.println();   // 첫번째 index가 끝날때마다 줄 바꾸기.
        }

    }
}
