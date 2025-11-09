package com.ohgiraffers.section04.scanner;


import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        /*
        * java.util.Scanner를 이용해 다양한 자료형 값 입력 받기
        *  */

        // 1. Scanner 객체 생성
        // import 할 것.
        Scanner sc = new Scanner(System.in );  // java.lang.System.in -> 키보드 입력 | java.lang은 생략 가능.

        // println() : 값 출력 후 커서를 다음줄로 이동
        // nextLine() : 엔터 키 이전까지의 한 줄 전체를 문자열로 읽음
        // sc.nextLine() : 사용자로부터 문자열로 값을 입력받음.
        System.out.print("이름을 입력하세요 : ");
        String name = sc.nextLine(); // 입력받은 값을 name에 담는다.
        System.out.println("입력하신 이름은 " + name + "입니다.");

        // next() : 공백문자나 개행문자 전 까지를 문자열로 읽음.
        // 예를 들어 "안녕하세요 반갑습니다"를 입력할 시 "안녕하세요"까지는 문자열로 읽어옴.
        // 단 "반갑습니다"가 버퍼에 남기 때문에 뒤쪽에서 알맞지 않은 데이터가 넘어가서 문제가 생길 수 있음.
        System.out.print("인사말을 입력해주세요 : ");
        String greeting = sc.next();
        System.out.println(greeting);

        // nextInt() : 공백 이전까지의 정수값을 읽음
        System.out.print("나이를 입력하세요 : ");
        int age = sc.nextInt();
        System.out.println("입력하신 나이는 " + age + "세 입니다.");

        // nextDouble() : 공백 이전까지의 실수 값을 읽음
        System.out.print("키를 입력해주세요");
        double height = sc.nextDouble();
        System.out.println("입력하신 키는 " + height + "cm 입니다.");

        /*
        * 문자를 직접 입력 받는 기능을 제공하지 않는다.
        * 따라서 문자열로 입력을 받고, 원하는 순번째 문자를 분리해서 사용해야 한다.
        * java.lang.String에 charAt(int index)를 사용한다. */
        sc.nextLine();
        System.out.println("아무 문자나 입력 해주세요~ : ");
        char ch = sc.nextLine().charAt(0);
        System.out.println("입력하신 문자는 " + ch + "입니다.");

    }
}
