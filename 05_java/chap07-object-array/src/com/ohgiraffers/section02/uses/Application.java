package com.ohgiraffers.section02.uses;

import java.util.Scanner;
// Application = 여기서 사용자로 부터 입력을 받음(사용자 인터페이스)
// Member = DTO로 활용
// MemberRepository = 아직 DB를 배우지 않았기에 DB대신 회원 정보를 저장하는 창고 역할
// MemberService = Application에서 받은 정보를 처리
public class Application {
    public static void main(String[] args) {
        /*
        * [ 요구사항 ]
        1. 여러 명의 회원 정보를 받아 한 번에 여러 회원 정보를 등록
        2. 전체 회원 조회 시 여러 명의 회원 정보를 반환
         */

        Scanner sc = new Scanner(System.in);
        //객체생성
        MemberService memberService = new MemberService();

        while(true) {
            System.out.println("===== 회원 관리 프로그램 =====");
            System.out.println("1. 회원 등록");
            System.out.println("2. 회원 전체 조회");
            System.out.println("3. 회원 아이디로 검색");
            System.out.println("9. 프로그램 종료");
            System.out.print("메뉴 선택 : ");
            int no = sc.nextInt();
            // 위에서 입력한것으로 switch문 실행
            switch (no) {
                case 1 : memberService.signUpMembers(); break;
                case 2 : memberService.showAllMembers(); break;
                case 3 : memberService.searchMemberById(sc);break;
                case 9 :
                    System.out.println("프로그램을 종료합니다");
                    sc.close(); // Scanner 자원 반납
                    return;
                default:
                    System.out.println("잘못된 번호를 입력하셨습니다"); break;
            }

        }
    }
}
