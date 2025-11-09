package com.ohgiraffers.section06.singleton;

public class LazySingleton {

    /* 일단 변수만 만들어두고, 처음에는 비워둔다(null) */
    // 게으른 초기화. 일단 선언만 해두고 기본값으로 초기화만 해둠.
    private static LazySingleton lazy;

    // 생성자는 private으로 잠금
    private LazySingleton() {};

    // lazy가 null 일때만 한번만 인스턴스를 만들 수 있도록 함
    public static LazySingleton getInstance() {
        if (lazy == null) {
            lazy = new LazySingleton();
        }
        return lazy;
    }
}
