package com.ohgiraffers.section02.enumtype;


public class Application {
    public static void main(String[] args) {
        // ENUM 만드는 법
        // + 선택 / JAVA 클래스 / 열거형 선택 후 명명

        // enum 타입으로 선언된 인스턴스는 싱글톤으로 관리되며 인스턴스가 한 개 임을 보장한다.
        Subjects subjects1 = Subjects.JAVA;
        Subjects subjects2 = Subjects.HTML;

        if (subjects1 == subjects2) {
            System.out.println("두 과목은 같은 과목입니다.");
        } else {
            System.out.println("두 과목은 다른 과목입니다.");
        }

        /* 타입 안정성 보장 : Subjects enum타입에 정의된 상수들 외에는 다른 값은 전달 할 수 없다. */
//        printSubject(2);  // Enumtype은 인스턴스이기 때문에 정수를 사용하는 경우 타입 불일치
        printSubject(Subjects.HTML);

        /* 순회 가능 */
        // .values() : enum에 정의된 상수들을 배열 형태로 반환
        // .values()를 이용하여 상수값 배열을 반환하고 연속처리 할 수 있다.
        for (Subjects s : Subjects.values()) {
            // .ordinal() : 상수가 정의된 순서를 반환 (0부터 시작)
            // .name() : 상수 이름 자체를 문자열로 반환
            System.out.println((s.ordinal() + 1) + "." + s.name());
        }
    }

    public static void printSubject(Subjects subject) {
        System.out.println("전달받은 과목 : " + subject.toString());
    }
}
