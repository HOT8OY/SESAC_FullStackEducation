package com.hw1.view;

import com.hw1.controller.LibraryManager;
import com.hw1.model.dto.AniBook;
import com.hw1.model.dto.Book;
import com.hw1.model.dto.CookBook;
import com.hw1.model.dto.Member;
import java.util.Scanner;

public class LibraryMenu {
    // 초기화 생성
    LibraryManager lm;
    Scanner sc = new Scanner(System.in);

    // 메소드
    public void mainMenu() {
        // 이름, 나이, 성별을 키보드로 입력 받은 후 Member 객체 생성
        lm = new LibraryManager();
        Member mem1 = new Member();
        System.out.println("통합 Library Management 시스템에 오신걸 환영합니다.");
        System.out.print("고객님의 이름을 입력해주세요 : ");
        mem1.setName(sc.next());
        System.out.print("고객님의 나이를 입력해주세요 : ");
        mem1.setAge(sc.nextInt());
        System.out.print("고객님의 성별(남/여)을 입력해주세요");
        mem1.setGender(sc.next().trim().charAt(0));

        // LibraryManager의 insertMember() 메소드에 전달
        lm.insertMember(mem1);

        // ==== 메뉴 ====    // 무한 반복 실행
        // 1. 마이페이지      // LibraryManager의 myInfo() 호출하여 출력
        // 2. 도서 전체 조회  // LibraryMenu의 selectAll() 호출
        // 3. 도서 검색      // LibraryMenu의 searchBook() 호출
        // 4. 도서 대여하기   // LibraryMenu의 rentBook() 호출
        // 0. 프로그램 종료하기
        while(true) {
            System.out.println("\n=== 메뉴 ===");
            System.out.println("1. 마이페이지");
            System.out.println("2. 도서 전체 조회");
            System.out.println("3. 도서 검색");
            System.out.println("4. 도서 대여하기");
            System.out.println("0. 프로그램 종료하기");
            int sel = sc.nextInt();
            switch (sel) {
                case 1 :
                    System.out.println("마이 페이지로 이동합니다");
                    System.out.println(lm.myInfo());
                    break;
                case 2 :
                    selectAll();
                    break;
                case 3 :
                    searchBook();
                    break;
                case 4 :
                    rentBook();
                    break;
                case 0 :
                    System.out.println("프로그램을 종료합니다. 이용해주셔서 갑사합니다.");
                    sc.close();
                    return;
                default :
                    System.out.println("입력은 숫자 1, 2, 3, 4, 0 만 가능합니다.");
                    break;
            }
        }

    }
    public void selectAll() {
        // LibraryManager의 selectAll() 메소드 호출하여 결과 값 Book[] 자료형에 담기
        //  Book[] bList = lm.selectAll();
        // for문 이용하여 bList의 모든 도서 목록 출력
        // 단, i를 이용하여 인덱스도 같이 출력  대여할 때 도서번호를 알기 위해
        // ex ) 0번도서 : 백종원의 집밥 / 백종원 / tvN / true
        System.out.println("==== 전체 도서 조회 ====\n전체 도서를 조회합니다.");
        Book[] allList;
        allList = lm.selectAll();
        for (int i = 0; i < allList.length; i++) {
            System.out.print(i+"번 도서 : "+allList[i].getTitle()+" / "+allList[i].getAuthor()+" / "+allList[i].getPublisher()+" / ");
            if (allList[i] instanceof AniBook) {
                System.out.println(((AniBook) allList[i]).getAccessAge());
            } else {
                System.out.println(((CookBook)allList[i]).isCoupon());
            }
        }
    }
    public void searchBook() {
        // “검색할 제목 키워드 : “ >> 입력 받음 (keyword)
        // LibraryManager의 searchBook() 에 전달
        // 그 결과 값을 Book[] 자료형에 담기
        //  Book[] searchList = lm.searchBook(keyword);
        // for each문(향상된 for문)을 이용하여 검색 결과의 도서 목록 출력
        // NullPointerException 발생 시 오류 해결하시오 ㅎㅎ
        System.out.println("==== 도서 검색 ====\n도서 검색을 실행합니다.\n검색하고 싶은 도서를 입력해주세요.");
        Book[] sBook;
        String searchKeyword = sc.next();
        System.out.println("[ " + searchKeyword + " ] 제목의 책을 검색합니다.");
        sBook = lm.searchBook(searchKeyword);
        if (0 < sBook.length) {
            System.out.println("검색 결과 " + sBook.length + "권의 책을 찾았습니다.\n찾은 책의 목록은 다음과 같습니다.");
            for(Book s : sBook){
                System.out.println(s.getTitle());
            }
        } else {
            System.out.println("해당 제목의 책을 찾을 수 없습니다.");
        }
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
        System.out.println("==== 도서 대여 ====\n도서 대여를 실행합니다.\n대여하고 싶은 도서의 도서번호를 입력해주세요.");
        int rentIndex = sc.nextInt();
        int rentSuccessCode = lm.rentBook(rentIndex);
        if(rentSuccessCode == 0 || rentSuccessCode == 2) {
            System.out.println("성공적으로 대여되었습니다.");
            if (rentSuccessCode == 2) {
                System.out.println("요리학원 쿠폰이 발급되었습니다.");
            }
        } else if (rentSuccessCode == 1) {
            System.out.println("나이 제한으로 대여 불가능입니다.");
        } else {
            System.out.println("시스템 오류 : 대여 실패!");
        }
    }
}
