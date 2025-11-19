package com.ohgiraffers.section02.collection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context
                = new AnnotationConfigApplicationContext("com.ohgiraffers.section02");

        PokemonService pokemonService
                = context.getBean("collectionService", PokemonService.class);  // PokemonService가 동일한 이름으로 여러개 있기에 NAME으로 가져와야 함.

        pokemonService.pokemonAttack();
    }
}
