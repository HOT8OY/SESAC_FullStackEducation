package com.ohgiraffers.section02.annotation;

import com.ohgiraffers.section02.common.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

// bean으로 관리하기 위해 Servive Annotation을 붙임.
@Service
public class PokemonService {

    // 의존성 주입(생성자 주입 방식)
    private Pokemon pokemon;

    // 생성자가 하나뿐이기에 @Autowired를 생략해도 된다.
    // @Qualifier : 여러개의 bean 객체중에 특정 객체를 이름으로 지정하는 어노테이션.
    // @Primary 어노테이션과 함께 쓰였을 때 @Qualifier가 우선으로 연결된다.
    @Autowired
    public PokemonService(@Qualifier("squirtle") Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    public void pokemonAttack() {
        pokemon.attack();
    }
}
