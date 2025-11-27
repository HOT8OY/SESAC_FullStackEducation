package com.ohgiraffers.section03.entity;

import jakarta.persistence.EntityManager;

public class EntityLifeCycle {

    private EntityManager entityManager;

    public Menu findMenuByMenuCode(int menuCode) {
        entityManager = EntityManagerGenerator.getInstance(); // 호출때마다 새로운 엔티티 매니저가 생성됨. 싱글톤이 아님.

        return entityManager.find(Menu.class, menuCode);
    }
    public EntityManager getManagerInstance() {
        return entityManager;
    }
}
