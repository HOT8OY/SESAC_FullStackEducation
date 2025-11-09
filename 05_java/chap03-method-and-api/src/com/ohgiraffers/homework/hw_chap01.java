package com.ohgiraffers.homework;

public class hw_chap01 {
    public static void main(String[] args) {
        // 1. 정수형 변수 2개를 선언하여,
        //  각 20과 30으로 초기화 한 후,
        //  두 수의 더하기, 빼기, 곱하기, 나누기, 나머지를 다음과 같이 출력하세요.
        int num1 = 20;
        int num2 = 30;
        System.out.println("1-1 더하기 결과 : " + (num1 + num2));
        System.out.println("1-1 빼기 결과 : " + (num1 - num2));
        System.out.println("1-1 곱하기 결과 : " + (num1 * num2));
        System.out.println("1-1 나누기 결과 : " + (num1 / num2));
        System.out.println("1-1 나누기한 나머지 : " + (num1 % num2));

        // 2. 사각형의 넓이와 둘레를 구하여 출력합니다.
        //  너비 12.5 높이 36.4를 변수에 저장하고,
        //  넓이와 둘레를 계산한 뒤 각각 넓이와 둘레를 변수에 담아 아래와 같이 출력하세요.
        float width1 = 12.5f;
        float height1 = 36.4f;
        System.out.println("1-2 면적 : " + (width1 * height1));
        System.out.println("1-2 둘레 : " + (width1 * 2 + height1 * 2));

        // 3. 문자형 변수를 하나 선언하고 'a'를 대입한 후,
        //  문자 'a'가 가지는 유니코드값을 출력하세요.
        char ch_a = 'a';
        System.out.println("1-3 문자 a의 unicode : " + +ch_a);

        // 4. 국어점수 80.5점, 수학점수 50.6점, 영어점수 70.8점을 실수 형태로 저장한 뒤,
        //  총점과 평균을 정수 형태로 출력하세요.
        float koreanScore = 80.5f;
        float mathScore = 50.6f;
        float englishScore = 70.8f;
        int totalScore = (int)(koreanScore + mathScore + englishScore);
        System.out.println("1-4 총점 : " + (totalScore));
        System.out.println("1-4 평균 : " + (totalScore / 3));
    }
}
