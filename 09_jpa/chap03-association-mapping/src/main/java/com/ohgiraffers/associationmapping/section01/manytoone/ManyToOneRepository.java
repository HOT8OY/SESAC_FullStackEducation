package com.ohgiraffers.associationmapping.section01.manytoone;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class ManyToOneRepository {

    // 의존성 주입
    @PersistenceContext
    private EntityManager entityManager;

    // menuCode로 조회 기능
    public Menu find(int menuCode) {
        return entityManager.find(Menu.class, menuCode);
    }

    // JPQL문을 사용한 조회
    public String findCategoryName(int menuCode) {
        // 여기서 category는 db의 카테고리가 아닌 Menu entity의 category 임.
        // :menuCode는 menuCode를 파라미터로 받겠다는 것임.
        String jpql = "SELECT c.categoryName FROM menu_and_category m JOIN m.category c WHERE m.menuCode = :menuCode";
        return entityManager.createQuery(jpql, String.class)
                .setParameter("menuCode", menuCode)
                .getSingleResult();
    }

    public void regist(Menu menu) {
        entityManager.persist(menu);
    }
}
