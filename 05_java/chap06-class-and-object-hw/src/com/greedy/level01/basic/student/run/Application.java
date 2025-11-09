package com.greedy.level01.basic.student.run;

import com.greedy.level01.basic.student.model.dto.StudentDTO;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentDTO[] sArr = new StudentDTO[10]; // sArr에 10개의 배열만 초기화하여 생성해둠.
        int count = 0;  // 입력된 학생 수 카운트

        while(true) {
            if(count >= sArr.length) {  // 최대 10명까지만
                System.out.println("최대 10명까지 입력 가능합니다.");
                break;
            }
            // 학생 정보 입력
            sArr[count] = new StudentDTO(); // sArr[count]배열에 StudentDTO객체를 생성.
            System.out.print("학년 : ");
            sArr[count].setGrade(sc.nextInt());
            System.out.print("반 : ");
            sArr[count].setClassroom(sc.nextInt());
            System.out.print("이름 : ");
            sArr[count].setName(sc.next());
            System.out.print("국어점수 : ");
            sArr[count].setKor(sc.nextInt());
            System.out.print("영어점수 : ");
            sArr[count].setEng(sc.nextInt());
            System.out.print("수학점수 : ");
            sArr[count].setMath(sc.nextInt());

            count++;  // 학생 수 증가

            while(true) {
                System.out.print("계속 추가할 겁니까 ? (y/n) : ");
                String isContinue = sc.next();
                if (isContinue.charAt(0) == 'y' || isContinue.charAt(0) == 'Y') {
                    break;  // 다음 학생 입력으로
                } else if (isContinue.charAt(0) == 'n' || isContinue.charAt(0) == 'N') {
                    for(int i = 0; i < count; i++) {
                        System.out.println(sArr[i].getInformation());  // 입력된 학생들 정보 출력
                    }
                    sc.close();
                    return;  // 프로그램 종료(main메서드를 즉시 종료함)
                } else {
                    System.out.println("'y' 나 'n'만 입력 가능합니다.");
                }
            }
        }
    }
}
