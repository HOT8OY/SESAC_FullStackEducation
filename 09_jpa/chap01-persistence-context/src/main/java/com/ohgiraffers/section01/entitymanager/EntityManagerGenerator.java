package com.ohgiraffers.section01.entitymanager;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerGenerator {

    /* [ EntityManagerFactory ] */
//    private static EntityManagerFactory factory =
//            Persistence.createEntityManagerFactory("jpatest"); // xml파일의 persistence-unit name="jpatest"

    public EntityManagerGenerator() {}

    public static EntityManager getInstance() {
        EntityManagerFactory factory = EntityManagerFactoryGenerator.getInstance();
        return factory.createEntityManager();
    }
}
