package com.ohgiraffers.section02.extend;

// 타입 제한 : <T extends Rabbit>는 Rabbit과 Rabbit의 자손들만 들어올 수 있음
public class RabbitFarm<T extends Rabbit> {
    // RabbitFarm 제네릭 사용
    // <T>라고 하면 누구든지 들어올 수 있음
    // 따라서 들어오는 타입을 제한하기 위해 extends를 사용
    // 즉 geniric에는 뭐든 넣을 수 있기 때문에, 가려서 받을 수 있게 하는것이 extends

    private T animal;

    // 생성자
    public RabbitFarm() {
    }
    public RabbitFarm(T animal) {
        this.animal = animal;
    }

    // setter,getter
    public T getAnimal() {
        return animal;
    }
    public void setAnimal(T animal) {
        this.animal = animal;
    }
}
