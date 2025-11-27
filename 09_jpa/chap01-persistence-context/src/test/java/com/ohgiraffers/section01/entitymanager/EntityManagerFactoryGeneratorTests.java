package com.ohgiraffers.section01.entitymanager;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EntityManagerFactoryGeneratorTests {

    @Test
    @DisplayName("엔티티 매니저 팩토리 생성 확인")
    void testGenerateEntityManagerFactory(){
        // 보통 테스트 코드는 주어진 값(given)이 있고, 어떤 테스트를 했을 때(when),
        // 어떤 결과(then)가 나온다.
        // given
        // when
        EntityManagerFactory factory = EntityManagerFactoryGenerator.getInstance();
        // then
        assertNotNull(factory);
    }

    @Test
    @DisplayName("엔티티 매니저 팩토리 싱글톤 인스턴스인지 확인해보는 TEST")
    void testIsEntityManagerFactorySingletonInstance() {
        // given

        // when (싱글톤인지 확인 위해 2개의 객체 생성 시도)
        EntityManagerFactory factory1 = EntityManagerFactoryGenerator.getInstance();
        EntityManagerFactory factory2 = EntityManagerFactoryGenerator.getInstance();
        // then
        assertEquals(factory1, factory2);
    }

    @Test
    @DisplayName("엔티티 매니저 생성 확인")
    void testGeneratorEntityManager() {
        // given (없음)
        // when
        EntityManager entityManager = EntityManagerGenerator.getInstance();
        //then
        assertNotNull(entityManager);
    }

    @Test
    @DisplayName("엔티티 매니저 스코프 확인")
    void testEntityManagerLifeCycle() {
        // given (없음)
        // when
        EntityManager entityManager1 = EntityManagerGenerator.getInstance();
        EntityManager entityManager2 = EntityManagerGenerator.getInstance();
        //then
        assertNotEquals(entityManager1, entityManager2);
    }
}
