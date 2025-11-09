package com.ohgiraffers.section04.sort;

import java.util.Arrays;

public class Application2 {
    public static void main(String[] args) {

        /*
          [선택 정렬]
          비유 : 반에서 키가 가장 작은 사람을 찾아 맨 앞으로 보내는 과정을 반복하는 것
          */

        int[] arr = {2, 5, 4, 6, 1, 3};
        System.out.println("정렬 전" + Arrays.toString(arr));
        // i번 인덱스에 들어갈 가장 작은값
        // i < arr.length - 1 은 마지막에 가장 큰 값이 남아있기 때문에 굳이 찾지 않게 하는 것
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;   // 일단 현재 자리(i)에 있는 사람이 가장 작다고 가정
            for (int j = i + 1; j < arr.length; j++) {
                if(arr[minIndex] > arr[j]) { // minIndex 인덱스의 사람과, j인덱스의 사람을 비교하여 for문을 순회하며 가장 작은 값을 가진 minIndex가 남음.
                    minIndex = j;
                }
            }
            // 현재 찾은 최소값(arr[minIndex])과 현재 자리(arr[i]) 값을 교환 (swap)
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
            System.out.println((i + 1) + "회차 정렬 후: " + Arrays.toString(arr));
        }
        System.out.println("정렬 후" + Arrays.toString(arr));
    }
}
