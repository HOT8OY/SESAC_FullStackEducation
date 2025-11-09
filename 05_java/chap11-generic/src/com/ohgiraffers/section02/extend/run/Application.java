package com.ohgiraffers.section02.extend.run;

import com.ohgiraffers.section02.extend.*;

public class Application {
    public static void main(String[] args) {

        // Rabbit 또는 그 자손만으로 농장 생성할 수 있다.
        RabbitFarm<Rabbit> farm1 = new RabbitFarm<>(new Rabbit());
        RabbitFarm<Bunny> farm2 = new RabbitFarm<>(new Bunny());
        RabbitFarm<DrunkenBunny> farm3 = new RabbitFarm<>(new DrunkenBunny());
        // <T extends Rabbit> 규칙 위반
//        RabbitFarm<Snake> farm4 = new RabbitFarm<>(new Snake());  // 에러발생

        /* [ wildcard 동작 확인 ] */

        FarmManager manager = new FarmManager();

        manager.manageAniFarm(farm1);
        manager.manageAniFarm(farm2);
        manager.manageAniFarm(farm3);

//        manager.manageBunnyFarm(farm1); // Bunny와 자손만 들어갈 수 있기 때문에 Rabbit은 컴파일 에러 발생
        manager.manageBunnyFarm(farm2);
        manager.manageBunnyFarm(farm3);

        manager.manageRabbitorBunnyFarm(farm1);
        manager.manageRabbitorBunnyFarm(farm2);
//        manager.manageRabbitorBunnyFarm(farm3); // Bunny의 자손인 DrunkenBunny는 불가
    }
}
