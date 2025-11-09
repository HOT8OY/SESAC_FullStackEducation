package com.ohgiraffers.homework;

public class hw_chap02 {
    public static void main(String[] args) {
        String name = "보닌이름";

        // 1. 두 개의 정수형 변수를 선언하고, 삼항 연산자를 사용하여
        //  두 수 중 큰 수를 출력하는 프로그램을 작성해본다.
        int num1 = 13;
        int num2 = 51;
        int numCompare = (num1 > num2) ? num1 : num2;
        System.out.println("2-1 두 수 중 큰 수는" + numCompare + "입니다.");

        // 2. 정수형 변수를 선언하여 점수를 저장하고,
        //  삼항 연산자를 사용하여 점수가 60점 이상이면 “합격입니다”,
        //  그렇지 않으면 “아쉽지만 불합격입니다.” 을 출력하는 프로그램을 작성해본다.
        int num3 = 59;
        String numPass = (num3 >= 60) ? "합격입니다~~!!!" : "아쉽지만 불합격입니다...";
        System.out.println("2-2 " + numPass);

        // 3. 정수형 변수를 선언하고, 삼항연산자를 사용하여
        //입력된 수가 짝수인지 홀수인지 출력하는 프로그램을 작성해본다.
        // 참고사항 : 조건식에 %를 활용하여 짝수인지 홀수인지를 판단해 보세요~~
        int num4 = 55;
        String oddEven = (num4 % 2 == 0) ? "입력하신 수는 짝수입니다." : "입력하신 수는 홀수입니다.";
        System.out.println("2-3 " + oddEven);

        // 4. 실수를 변수로 선언하여 점수를 저장하고, 이를 정수로 변환하여
        //  점수가 90점 이상이면 ”A”,
        //  80점 이상이면 “B”,
        //  70점 이상이면 “C”,
        //  60점 이상이면”D
        //  60점 미만이면 “F”를 출력하는 프로그램을 작성해본다.
        float score1 = 76.766f;
        char scorePrint = ((int)score1 >= 90) ? 'A' : ((int)score1 >= 80) ? 'B' : ((int)score1 >= 70) ? 'C' : ((int)score1 >= 60) ? 'D' : 'F';
        System.out.println("2-4 홍길동의 이번 점수 등급은 " + scorePrint + "입니다.");

        // 5. 정수형 변수를 두개 선언하여 회원의 월(month)과 일(day)를 저장합니다.
        //월이 1월부터 6월까지이면서, 일이 1일부터 15일까지인 경우 “배민 쿠폰”을,
        //월이 7월부터 12월까지이면서, 일이 16일부터 31일까지인 경우 “스타벅스 커피”를
        //그 외의 경우는 “사탕”이 선물로 선택되는 프로그램을 작성해본다.
        byte month = 7;
        byte day = 2;
        String present = ((month >= 1) && (month <= 6) && (day >= 1) && (day <= 15)) ? "배민 쿠폰" : ((month >= 7) && (month <= 12) && (day >= 16) && (day <= 31)) ? "스타벅스 커피" : "사탕";
        System.out.println("2-5 " + name + "의 선물은 " + present + " 입니다.");
    }
}
