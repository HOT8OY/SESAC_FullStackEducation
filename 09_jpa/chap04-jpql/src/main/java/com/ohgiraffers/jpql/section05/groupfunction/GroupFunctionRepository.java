package com.ohgiraffers.jpql.section05.groupfunction;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GroupFunctionRepository {

    @PersistenceContext
    private EntityManager entityManager;

    // 해당 카테고리에 몇개의 menu(menuCode)가 있는지를 확인하는 메소드
    public long countMenuOfCategory(int categoryCode) {
    String jpql = "SELECT COUNT(m.menuCode) FROM Section05Menu m WHERE m.categoryCode = :categoryCode";
    long countOfMenu = entityManager.createQuery(jpql, Long.class)
            .setParameter("categoryCode", categoryCode)
            .getSingleResult();

    return countOfMenu;
    }

    // 해당 카테고리에 속하는 메뉴의 가격 합계를 구하는 메소드
    public Long otherWithNoResult(int categoryCode) {
        /* COUNT 외 다른 그룹함수는 결과 값이 없을 경우 NULL을 반환하기 떄문에 기본 자료형으로 다룰 경우 문제가 생김.
        * Long과 같이 Wrapper 클래스 자료형으로 다루어주어야 함. */
        String jpql = "SELECT SUM(m.menuPrice) FROM Section05Menu m WHERE m.categoryCode = :categoryCode";
        Long sumOfMenu = entityManager.createQuery(jpql, Long.class)
                .setParameter("categoryCode", categoryCode)
                .getSingleResult();

        return sumOfMenu;
    }

    public List<Object[]> selectByGroupByHaving(long minPrice) {
        String jpql = "SELECT m.categoryCode, SUM(m.menuPrice) FROM Section05Menu m"
                +" GROUP BY m.categoryCode HAVING SUM(m.menuPrice) >= :minPrice";
        List<Object[]> sumPriceOfCategoryList = entityManager.createQuery(jpql)
                .setParameter("minPrice", minPrice)
                .getResultList();

        return sumPriceOfCategoryList;
    }
}
