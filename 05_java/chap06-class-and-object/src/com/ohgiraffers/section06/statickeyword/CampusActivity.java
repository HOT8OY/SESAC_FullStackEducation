package com.ohgiraffers.section06.statickeyword;

public class CampusActivity {


    // non static : 개인 사물함
    private int personalLockerCount;

    // non-static 메소드
    public void openPersonalLocker() {
        this.personalLockerCount++;
        System.out.println("개인 사물함을 열었습니다. 사용 횟수: " + this.personalLockerCount);
    }

    // static 메소드
    public static void libraryAnnouncement() {
//        this.personalLockerCount++; // static 영역에선 heap 영역을 참조할 수 없음.
        System.out.println("도서관 공지 방송입니다.");

        /*
        * static 메소드 내에서는 non-static 멤버(필드, 메소드)를 직접 호출할 수 없다. (this가 없기 때문!)
        * */
    }
}
