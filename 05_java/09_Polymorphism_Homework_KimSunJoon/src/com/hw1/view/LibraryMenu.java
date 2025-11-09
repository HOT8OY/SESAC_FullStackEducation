package com.hw1.view;

import com.hw1.controller.LibraryManager;
import com.hw1.model.dto.Member;
import java.util.Scanner;

public class LibraryMenu {
    // 초기화 생성
    LibraryManager lm;
    Scanner sc = new Scanner(System.in);

    // 메소드
    public void mainMenu() {
        // 이름, 나이, 성별을 키보드로 입력 받은 후 Member 객체 생성
        // LibraryManager의 insertMember() 메소드에 전달
        // ==== 메뉴 ====    // 무한 반복 실행
        // 1. 마이페이지      // LibraryManager의 myInfo() 호출하여 출력
        // 2. 도서 전체 조회  // LibraryMenu의 selectAll() 호출
        // 3. 도서 검색      // LibraryMenu의 searchBook() 호출
        // 4. 도서 대여하기   // LibraryMenu의 rentBook() 호출
        // 0. 프로그램 종료하기
        Member mem = new Member();
        System.out.println("통합 Library Management 시스템에 오신걸 환영합니다.");
        System.out.print("고객님의 이름을 입력해주세요 : ");
        mem.setName(sc.next());
        System.out.print("고객님의 나이를 입력해주세요 : ");
        mem.setAge(sc.nextInt());
        System.out.println("고객님의 성별(남/여)을 입력해주세요");
        mem.setGender(sc.next().trim().charAt(0));
        lm.insertMember(mem);



    }
    public void selectAll() {
        // LibraryManager의 selectAll() 메소드 호출하여 결과 값 Book[] 자료형에 담기
        //  Book[] bList = lm.selectAll();
        // for문 이용하여 bList의 모든 도서 목록 출력
        // 단, i를 이용하여 인덱스도 같이 출력  대여할 때 도서번호를 알기 위해
        // ex ) 0번도서 : 백종원의 집밥 / 백종원 / tvN / true

    }
    public void searchBook() {
        // “검색할 제목 키워드 : “ >> 입력 받음 (keyword)
        // LibraryManager의 searchBook() 에 전달
        // 그 결과 값을 Book[] 자료형에 담기
        //  Book[] searchList = lm.searchBook(keyword);
        // for each문(향상된 for문)을 이용하여 검색 결과의 도서 목록 출력
        // NullPointerException 발생 시 오류 해결하시오 ㅎㅎ

    }
    public void rentBook() {
        // 도서대여를 위해 도서번호를 알아야된다.  selectAll() 메소드 호출
        // “대여할 도서 번호 선택 : ” >> 입력 받음 (index)
        // LibraryManager의 rentBook() 에 전달
        // 그 결과 값을 result로 받고 그 result가
        // 0일 경우  “성공적으로 대여되었습니다.” 출력
        // 1일 경우  “나이 제한으로 대여 불가능입니다.” 출력
        // 2일 경우  “성공적으로 대여되었습니다. 요리학원 쿠폰이 발급되었습니다.
        // 마이페이지를 통해 확인하세요” 출력
    }
}
