package com.ohgiraffers.section01.generic;

/* [ Generics ] */
// 데이터의 타입을 일반화한다는 의미를 가진다.
// 제네릭스를 이용하는 제네릭 클래스는 (T, E, K, V)가 있음
// T는 타입. 정해지지 않은 타입이라는 뜻.
// 사용할 때 타입을 지정할 수 있게 해준다.
public class GenericBox<T> {

    private T content;

    public void setContent(T content) {
        this.content = content;
    }

    public T getContent() {
        return this.content;
    }
}
