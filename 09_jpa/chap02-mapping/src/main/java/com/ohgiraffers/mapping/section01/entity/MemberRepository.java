package com.ohgiraffers.mapping.section01.entity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class MemberRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Member member) {
        entityManager.persist(member);
    }

    /* JPQL 방식 */
    public String findNameById(String memberId) {
        // FROM에 table 명이 아닌 entity name이 들어감
        // 별칭(alias)는 필수. 여기서 별칭은 'm'.
        String jpql = "SELECT m.memberName FROM entityMember m WHERE m.memberId = '" + memberId + "'";
        return entityManager.createQuery(jpql, String.class).getSingleResult();
    }
}
