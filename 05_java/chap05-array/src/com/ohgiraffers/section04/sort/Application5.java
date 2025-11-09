package com.ohgiraffers.section04.sort;

import java.util.Arrays;

public class Application5 {
    public static void main(String[] args) {

        /* 배열과 정렬을 응요하여 중복 없는 로또 번호를 생성해보자! */

        // 1. 6개의 숫자를 담을 배열 생성
        int[] lottoArr = new int[6];
        // 2. 중복되지 않는 난수를 생성하여 배열에 담기
        for(int i = 0; i < lottoArr.length; i++) {
            int num = (int)(Math.random() * 6) + 1;     // num에 1~45 난수 값을 저장
            lottoArr[i] = num;
            for(int j = 0; j < i; j++) {   // num과 배열 내부에 저장된 값이 맞는지 비교 후 중복이면 리셋(continue), 아니면 그대로 가서 값을 추가
                if(num == lottoArr[j]) {
                    i -= 1;
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(lottoArr));

        // 3. 오름차순으로 정렬하여 출력
        Arrays.sort(lottoArr);
        System.out.println("로또 번호는 " + Arrays.toString(lottoArr));
    }
}
