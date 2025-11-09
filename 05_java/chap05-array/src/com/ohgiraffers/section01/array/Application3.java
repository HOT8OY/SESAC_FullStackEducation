package com.ohgiraffers.section01.array;

import java.util.Scanner;

public class Application3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        /* 5명의 자바 점수를 정수로 입력받아 합계와 평균을 실수로 구하는 프로그램을 만들어보자 */

        // 1. 5명의 자바 점수를 저정할 배열을 할당한다.
        int[] fiveguysJavaScore = new int[5];
        // 2. 키보드로 점수를 입력받는다.
        for (int i = 0 ; i < fiveguysJavaScore.length; i++) {
            System.out.print((i + 1) + "번 째 guy의 score를 입력해 : ");
            fiveguysJavaScore[i] = sc.nextInt();
        }
        // 3. 합계와 평균을 계산한다.
        double total = 0;
        for (int i = 0; i < fiveguysJavaScore.length; i++) {
            total += fiveguysJavaScore[i];
        }
        double avg = total / fiveguysJavaScore.length;
        // 4. 합계와 평균 출력하기
        System.out.println("5guys의 자바 점수 합계는 " + total + "이야.");
        System.out.println("5guys의 자바 점수 평균은 " + avg + "이야.");
    }
}
