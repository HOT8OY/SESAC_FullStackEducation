package com.ohgiraffers.section01.intenum;

public class Application {
    public static void main(String[] args) {
        // [Enum이 없던 시절 정수 열거 패턴]
        int subject1 = Subjects.JAVA;    // 값은 0
        int subject2 = Subjects.HTML;   // 값은 0
        // 같은 과목인지 확인해보기
        if ( subject1 == subject2 ) {
            System.out.println("두 과목은 같은 과목입니다."); // 우리에겐 다른 과목이지만, 컴퓨터에선 같은 과목이라고 인식한다.
        }

        printSubject(Subjects.MYSQL);
        printSubject(2);
        printSubject(100);

        /*
        * [Enum이 없던 시절 정수 열거 패턴의 문제]
        * 문제상황1 : 이름이 겹칠경우 접두어를 붙여야해서 코드가 지저분해질 수 있다.
        * BACKEND_JAVASCRIPT
        * FRONTEND_JAVASCRIPT
        *
        * 문제상황2 : 순회 불가능
        * 길이를 모르기 때문? */
    }

    // 타입 안정성이 보장되지 않음. 아무 int값이나 다 받는다.
    public static void printSubject(int subjectNumber) {
        String subject = "";
        switch (subjectNumber) {
            case Subjects.JAVA: subject = "JAVA";
            break;
            case Subjects.MYSQL: subject = "MYSQL";
            break;
            case Subjects.JDBC: subject = "JDBC";
            break;
        }
        System.out.println("전달받은 과목 : " + subject);
    }
}
