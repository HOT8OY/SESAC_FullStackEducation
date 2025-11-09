package com.ohgiraffers.section02.dimensional;

import java.util.Scanner;

public class Application3 {
    public static void main(String[] args) {

        // 학생 3명의 국어, 영어, 수학 점수를 저장할 2차원 배열
        // 행(층): 학생 3명
        // 열(방): 과목 점수 (국어, 영어, 수학)
        int[][] scores = {{80, 76, 85}, {78, 60 ,95}, {90, 80, 68}};

        // 각 학생의 총점과 평균 계산 및 출력
        for (int i = 0; i < scores.length; i++) {   // i는 학생 번호(0, 1, 2)
            int sum = 0;    // 총점을 저장할 변수
            for(int j =0; j < scores[i].length; j++) {
                sum += scores[i][j]; // 현재 학생의 j번째 과목 점수 누적
            }
            double avg = sum / (double) scores[i].length;
            System.out.println((i + 1) + "번 학생의 총점 : " + sum);
            System.out.println((i + 1) + "번 학생의 평균 : " + avg);
        }

        Scanner sc = new Scanner(System.in);

        // ==================================================== //

        // # 값을 입력 받아서 출력하기

        // 학생 수와 과목 수 입력받기
        System.out.print("학생 수를 입력하세요 : ");
        int studentCount = sc.nextInt();

        System.out.print("과목 수를 입력하세요 : ");
        int subjectCount = sc.nextInt();

        // 2차원 배열 할당
        int[][] scores2 = new int[studentCount][subjectCount];

        // 점수 입력받기
        for(int i = 0; i < scores2.length; i++){
            System.out.print((i + 1) + "번 학생의 점수를 입력하세요:");
            for(int j = 0; j < subjectCount; j++) {
                System.out.println(" " + (j + 1) + "번째 과목 점수: ");
                scores2[i][j] = sc.nextInt();
            }
            System.out.println();
        }
        // 출력
        for(int i = 0; i < studentCount; i++) {
            System.out.println((i + 1) + "번 학생: ");
            for(int j = 0; j < subjectCount; j++) {
                System.out.println(scores2[i][j]);
            }
            System.out.println();
        }

    }
}
