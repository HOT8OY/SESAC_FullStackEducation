package com.ohgiraffers.section07.kindsofvariable;

public class KindsOfVariable {
    /*
    * 클래스 영역에 작성하는 변수를 필드나 전역변수 또는 인스턴스라고 한다. */

    // non-static field를 인스턴스변수라고 한다.
    // not-static field는 객체가 생성될 때 heap에 생긴다
    // 수명은 해당 인스턴스변수를 참조하는것이 없을 때 GC가 삭제시킨다.
    private int globalNum;

    // static field를 정적필드(클래스 변수)라고 한다.
    // 프로그램이 시작될 떄 static 메모리 영역에 1개가 생성된다.
    // 수명 : 프로그램이 끝날 때 까지
    private static int staticNum;

    /* 메소드 영역에서 작성하는 변수를 지역변수라고 한다. */
    public void method(int num) {
        // 지역변수와 매개변수 모두 메소드 호출 시 stack 메모리에 생성된다.

        int localNum; // 메소드 내부에서 사용하는 지역변수는 선언 외에 다시 사용(호출)하기 위해서는 반드시 초기화가 되어야 한다.

        System.out.println(num); // 매개변수는 호출 시 값이 넘어오기 때문에 초기화가 필요 없다.

//        System.out.println(localNum); // 초기화 되지 않은 변수는 사용할 수 없다.


        System.out.println(globalNum); // 전역 변수는 클래스 전역에서 사용 가능하다.
        System.out.println(staticNum); // 전역 변수는 클래스 전역에서 사용 가능하다.
    }

    public void method2() {
        System.out.println(globalNum);
        System.out.println(staticNum);
        // 지역변수는 해당 지역(블럭 내)에서만 사용 가능하다.
//        System.out.println(localNum); // 다른 메소드의 지역변수는 해당 메소드가 끝나는 순간 사라지기 때문에 사용 불가.

    }
}
