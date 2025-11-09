package ex2_string_array;

import java.util.Scanner;

public class StringPractice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("이름 입력: ");
        String name = sc.nextLine().trim();  // 공백 제거

        System.out.println("길이: " + name.length());
        System.out.println("첫 글자: " + name.charAt(0));
        System.out.println("마지막 글자: " + name.charAt(name.length()-1));
        System.out.println("대문자: " + name.toUpperCase());

        if (name.contains("김")) {
            System.out.println("김씨입니다!");
        }

        sc.close();
    }
}
