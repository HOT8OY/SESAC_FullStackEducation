package com.ohgiraffers.section06.statickeyword;

public class Application {

    /*
    * [ static ]
    * 정적 메모리 영역에 프로그램이 시작될 때 할당을 하는 키워드이다.
    * 인스턴스를 생성하지 않고도 사용할 클래스의 멤버(필드, 메소드)에 지정할 수 있다.
    * 여러 인스턴스가 공유해서 사용할 목적의 공간이다. */

    /* 1. 필드에서 사용 */
    public static void main(String[] args) {
        UniversityStudent student1 = new UniversityStudent();
        // 첫 카운트 확인
        System.out.println("개인 : " + student1.getPersonalLockerCount()); // 개인 : 0
        System.out.println("공용 : " + student1.getSharedLockerCount()); // 공용 : 0

        // 카운트 1증가
        student1.increasePersonalLocker();
        student1.increaseSharedLocker();

        // 다시 count 확인
        System.out.println("개인 : " + student1.getPersonalLockerCount()); // 개인 : 1
        System.out.println("공용 : " + student1.getSharedLockerCount());  // 공용 : 1
        
        // 두 번째 학생 생성
        System.out.println("두 번째 학생");
        UniversityStudent student2 = new UniversityStudent();
        
        // count 확인
        System.out.println("개인 : " + student2.getPersonalLockerCount()); // 개인 : 0
        System.out.println("공용 : " + student2.getSharedLockerCount());  // 공용 : 1

        /* 2. */
        // non-static 메소드 호출 : 반드시 인스턴스를 먼저 생성해야 한다.
        CampusActivity student = new CampusActivity();  // 학생에게 할 수 있는것이므로 반드시 학생 인스턴스를 생성해야 한다.
        student.openPersonalLocker();

        // static 메소드 호출 : 인스턴스 없이 클래스 이름으로 바로 호출하는 것이 올바른 방법이다.
        CampusActivity.libraryAnnouncement();
    }
}
