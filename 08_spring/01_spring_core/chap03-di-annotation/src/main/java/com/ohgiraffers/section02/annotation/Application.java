package com.ohgiraffers.section02.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext("com.ohgiraffers.section02");

        String[] beanNames = context.getBeanDefinitionNames();
        for(String beanName : beanNames) {
            System.out.println(beanName);
        }

        // @Primary 가 잘 작동하는지 확인
        PokemonService pokemonService = context.getBean(PokemonService.class);

        pokemonService.pokemonAttack(); // Charmander에 @Primary를 달아놨기 때문에 해당 클래스의 메소드가 실행된다.
    }
}
