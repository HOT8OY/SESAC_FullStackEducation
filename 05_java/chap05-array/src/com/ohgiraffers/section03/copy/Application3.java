package com.ohgiraffers.section03.copy;

import java.util.Arrays;

public class Application3 {
    public static void main(String[] args) {

        /* 향상된 for문 */
        // 배열의 내용을 처음부터 끝까지 흝어보는 '읽기 전용 뷰어'
        int[] arr = {1, 2, 3, 4, 5}; // 원본 배열


        // for문 안의 int value는 임시 변수이기 때문에 원본 배열에는 영향이 없다.
        // : 오른쪽의 배열을, : 왼쪽의 임시 변수에 '복사' 해서 사용
        for (int value : arr) { // 이 코드가 실행되면 배열 안에 있는 값들이 0부터 끝까지 value라는 변수에 복사하여 들어감.
            value += 10;
            System.out.println("임시 변수 value의 값: " + value);
        }
        System.out.println(Arrays.toString(arr));

        // 진짜 값을 변경하려면 일반 for문을 써야함.
        for (int i = 0; i < arr.length; i++) {
            arr[i] += 10;
        }
        System.out.println(Arrays.toString(arr));

        /*
          [목적에 따라 다르게 사용]
        - 값을 '읽을' 목적일 때 : 향상된 for문 (코드가 간결함)
        - 값을 '수정'할 목적일 때 : 일반 for문 (인덱스로 직접 접근)
        */
    }
}
