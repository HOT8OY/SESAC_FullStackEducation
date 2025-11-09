package com.ohgiraffers.section06.singleton;

public class EagerSingleton {

    /* [EagerSingleton] */
    /* 1. 클래스가 초기화 되는 시점에 인스턴스를 생성한다 */
    // 객체를 호출할 때 heap에 초기화 하는게 아니라, static이라는 곳에 초기화 함.
    private static EagerSingleton eager = new EagerSingleton(); // static 변수를 초기화 하는 코드. JVM이 로드 될 때 딱 한번 실행이 된다.

    /* 2. 싱글톤 패턴은 생성자 호출을 통해 외부에서 인스턴스 생성하는 것을 제한 */
    private EagerSingleton() {}

    /* 3. public 인터페이스로 인스턴스를 반환하도록 한다. */
    public static EagerSingleton getInstance(){
        return eager;
    }
}
