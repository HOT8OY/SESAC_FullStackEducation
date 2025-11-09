package com.ohgiraffers.section04.scanner;

import java.util.Scanner;

public class Application2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /*
        * 숫자 입력 후 문자열 입력 시 발생하는 문제점
        * nextInt(), nextDouble(), next() 등은 입력된 값에서 해당 부분만 가져가고
        * 마지막에 입력된 '개행문자(\n)'는 입력 버퍼에 그대로 남겨둔다.
        * 이 상태에서 nextLine()을 호출하면, 버퍼에 남아있는 개행문자를 읽고 즉시 종료해버려
        * 우리가 원하는 문자열을 입력할 수 없게 된다.*/

        // 우리가 숫자 입력 후 Enter(\n)를 누르면 입력 버퍼(임시 공간)이라는 곳에 들어간다.
        // 예를 들어 5를 누르고 Enter를 누르면 5\n을 입력 버퍼에 넣은 후, 5만 age로 빼온다.
        // 그리고 문자열을 넣을 때가 되면 입력 버퍼에 남은 Enter(\n) 때문에 입력받지 않고 바로 끝난다.
        System.out.print("나이를 입력하세요 : ");
        int age = sc.nextInt(); // num/n(Enter) 중 num만 읽고 개행문자가 버퍼에 남게 된다.
        System.out.println("나이는 " + age + "세 입니다.");
        // 해결 방법 1: sc.nextLine()을 중간에 껴 넣음.
        sc.nextLine(); // 이걸 넣음으로써 버퍼에 남아있던 개행 문자(/n)를 얘가 가져가게 만든다.

        System.out.print("사는 곳을 입력하세요 : ");
        String address = sc.nextLine();
        System.out.println("사는 곳은 " + address + "입니다.");

        // 해결 방법 2: sc.nextLine()으로 통일
        // - 전부 sc.nextLine()으로 받은 후 원하는 형태로 parsing 하기.
        System.out.print("나이를 입력하세요 : ");
        String ageInput = sc.nextLine();    // "5"라는 문자열로
        int age1 = Integer.parseInt(ageInput);  // 문자열을 숫자(정수형)으로 변환
        System.out.println("입력한 나이는 " + age1 + "세 입니다.");

        System.out.print("사는 곳을 입력하세요 : ");
        String address1 = sc.nextLine();
        System.out.println("사는 곳은 " + address1 + "입니다.");

        // sc.close(): Scanner 객체 사용이 끝나면 close 해주면 좋음.
        sc.close();
    }
}
