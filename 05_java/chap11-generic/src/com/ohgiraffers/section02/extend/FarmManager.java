package com.ohgiraffers.section02.extend;

public class FarmManager {

    // <?> : 와일드 카드. 매개변수로 받는 타입에 신경쓰지 않겠다는 것.
    // RabbitFarm<?> : Rabbit의 자손이라면 어떤 타입이든 상관없는 RabbitFarm을 매개변수로 받는다.
    public void manageAniFarm(RabbitFarm<?> farm) {
        System.out.println("어떤 토끼 농장이든 관리 가능해요:");
        farm.getAnimal().cry(); // farm이 가지고 있는 동물들을 가져와서 메소드 실행
    }

    // <? extends Bunny> : 와일드 카드에도 제한을 걸 수 있음
    // Bunny이거나 Bunny의 자손타입만 담긴 RabbitFarm만 받는다
    public void manageBunnyFarm(RabbitFarm<? extends Bunny> farm) {
        System.out.println("버니 혹은 더 특별한 버니 농장만 관리해요:");
        farm.getAnimal().cry();
    }

    // <? super Bunny> : 와일드 카드에도 부모타입만 받아오도록 제한
    // Bunny이거나 Bunny의 부모 타입만 담긴 RabbitFarm만 받는다.
    public void manageRabbitorBunnyFarm(RabbitFarm<? super Bunny> farm) {
        farm.getAnimal().cry();
    }
}
