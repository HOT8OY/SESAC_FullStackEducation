package com.ohgiraffers.section03.entity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class EntityLifeCycleTests {

    private EntityLifeCycle lifeCycle;

    @BeforeEach // 테스트 수행 전 동작시킬 코드
    void setup() {
        this.lifeCycle = new EntityLifeCycle();
    }
    /* [ 비영속 상태 ] */
    @DisplayName("비영속 테스트")
    @ParameterizedTest
    @ValueSource(ints = {2, 3})
    void testTransient(int menuCode) {
        // when
        // 영속성 컨텍스트에서 관리되는 영속 상태의 객체(entityManager가 find로 찾아온 객체)
        Menu foundMenu = lifeCycle.findMenuByMenuCode(menuCode);

        // 생성자 호출. foundMenu의 내용과, newMenu의 내용은 같으나 각자 가지고 있는 참조값은 다르다.
        Menu newMenu = new Menu(    // new로 만든 newMenu의 주소값은 영속성 컨텍스트에서 관리되는게 아님.
                foundMenu.getMenuCode(),
                foundMenu.getMenuName(),
                foundMenu.getMenuPrice(),
                foundMenu.getCategoryCode(),
                foundMenu.getOrderableStatus()
        );

        EntityManager entityManager = lifeCycle.getManagerInstance();

        // then
        assertNotEquals(foundMenu, newMenu);
        assertTrue(entityManager.contains(foundMenu));
        assertFalse(entityManager.contains(newMenu));
    }

    /* [ 영속성 테스트 ] */
    @DisplayName("다른 엔티티 매니저가 관리하는 엔티티의 영속성 테스트")
    @ParameterizedTest
    @ValueSource(ints = {2, 3})
    void testManagedOtherEntityManager(int menuCode) {

        // when
        // findMenuByMenuCode 메소드를 호출했을 때,
        // entity 매니저가 새로 만들어지기 때문에 영속성 컨텍스트가 두개 만들어 진 것과 같다.
        // entity 매니저는 싱글톤이 아님.
        Menu menu1 = lifeCycle.findMenuByMenuCode(menuCode);
        Menu menu2 = lifeCycle.findMenuByMenuCode(menuCode);

        // then
        assertNotEquals(menu1, menu2);
    }

    @DisplayName("같은 엔티티 매니저가 관리하는 엔티티의 영속성 테스트")
    @ParameterizedTest
    @ValueSource(ints = {2, 3})
    void testManagedSameEntityManager(int menuCode) {
        // given
        EntityManager entityManager = EntityManagerGenerator.getInstance();

        // when
        Menu menu1 = entityManager.find(Menu.class, menuCode);
        Menu menu2 = entityManager.find(Menu.class, menuCode);

        // then
        assertEquals(menu1, menu2);
    }

    /* [ 준영속화 테스트 ] */

    @DisplayName("준영속화 detach 테스트")
    @ParameterizedTest
    @CsvSource({"11,1000"})
    void testDetachEntity(int menuCode, int menuPrice) {
        // given
        EntityManager entityManager = EntityManagerGenerator.getInstance();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        // when
        entityTransaction.begin();
        Menu foundMenu = entityManager.find(Menu.class, menuCode);
        // detach : 특정 엔티티만 준영속 상태(영속성 컨텍스트가 관리하지 않는 상태)로 만든다.
        entityManager.detach(foundMenu);
        foundMenu.setMenuPrice(menuPrice);
        // 영속성 컨텍스트의 상태를 DB로 내보낸다. commit하지 않은 상태이므로 rollback 가능하다.
        entityManager.flush();
        // then
        assertNotEquals(menuPrice, entityManager.find(Menu.class, menuCode).getMenuPrice());
    }

    @DisplayName("준영속화 detach 후 다시 영속화(merge)")
    @ParameterizedTest
    @CsvSource({"11, 1000"})
    void testDetachAndMerge(int menuCode, int menuPrice) {
        // given
        EntityManager entityManager = EntityManagerGenerator.getInstance();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        // when
        entityTransaction.begin();
        Menu foundMenu = entityManager.find(Menu.class, menuCode);  // (11)
        entityManager.detach(foundMenu);    // detach
        foundMenu.setMenuPrice(menuPrice);  // Persistence Context에서 관리되지 않을 때 값을 변경(1000으로)
        entityManager.merge(foundMenu);     // merge (1000으로 P.C.에 반영됨)
        entityManager.flush();
        // then
        assertEquals(menuPrice, entityManager.find(Menu.class, menuCode).getMenuPrice());
        entityTransaction.rollback();
    }

    @DisplayName("detach 후 merge한 데이터 update테스트")
    @ParameterizedTest
    @CsvSource({"11, 하양 민트초코죽"})
    void testMergeUpdate(int menuCode, String menuName) {
        // given
        EntityManager entityManager = EntityManagerGenerator.getInstance();
        Menu foundMenu = entityManager.find(Menu.class, menuCode);
        entityManager.detach(foundMenu);    // 하양 민트 초코죽이 detach

        // when
        foundMenu.setMenuName(menuName);
        Menu refoundMenu = entityManager.find(Menu.class, menuCode); // 위에서 detach 했기 때문에 DB에서 menuCode 11에 해당하는것을 찾아옴.

        entityManager.merge(foundMenu);     // 하양 민트 초코죽을 다시 merge

        // then
        assertEquals(menuName, refoundMenu.getMenuName());
    }

    @DisplayName("detach 후 merge한 데이터 save 테스트")
    @Test
    void testMergeSave() {
        // given
        EntityManager entityManager = EntityManagerGenerator.getInstance();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        Menu foundMenu = entityManager.find(Menu.class, 20); // 20번을 찾아옴
        entityManager.detach(foundMenu); // 20번을 detach

        // when
        entityTransaction.begin();
        foundMenu.setMenuName("치약맛 초코 아이스크림");  // detach한것의 이름과 코드를 변경
        foundMenu.setMenuCode(999);    // 존재하지 않는 코드값(PK)으로 변경
        entityManager.merge(foundMenu); // PK가 기존 DB나 PC에 존재하지 않기 때문에 새로운 999번으로 들어감.
        entityTransaction.commit();

        // then // Menu에서 @GeneratedValue(strategy = GenerationType.IDENTITY) 를 주석처리 해야 Auto_Increment가 작동하지 않아서 테스트 가능.
        assertEquals("치약맛 초코 아이스크림", entityManager.find(Menu.class, 999).getMenuName());
    }

    @DisplayName("준영속화 clear 테스트")
    @ParameterizedTest
    @ValueSource(ints = {2, 3})
    void testClearPersistenceContext(int menuCode) {
        // given
        EntityManager entityManager = EntityManagerGenerator.getInstance();
        Menu foundMenu = entityManager.find(Menu.class, menuCode);

        // when
        // clear : 영속성 컨텍스트 초기화  -> 모든 엔티티를 준영속화(detach) 시킴
        entityManager.clear();

        // then
        Menu expectedMenu = entityManager.find(Menu.class, menuCode); // DB에서 새롭게 찾아옴
        assertNotEquals(foundMenu, expectedMenu);
    }

    @DisplayName("준영속화 close 테스트")
    @ParameterizedTest
    @ValueSource(ints = {2, 3})
    void testClosePersistenceContext(int menuCode) {
        // given
        EntityManager entityManager = EntityManagerGenerator.getInstance();
        Menu foundMenu = entityManager.find(Menu.class, menuCode);

        // when
        // close : 영속성 컨텍스트를 종료한다.
        entityManager.close();

        // then
        assertThrows(IllegalStateException.class, () -> entityManager.find(Menu.class, menuCode));
    }

    @DisplayName("영속성 엔티티 삭제 remove 테스트")
    @ParameterizedTest
    @ValueSource(ints = {6})
    void testRemoveEntity(int menuCode) {
        // given
        EntityManager entityManager = EntityManagerGenerator.getInstance();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        Menu foundMenu = entityManager.find(Menu.class, menuCode);

        // when
        entityTransaction.begin();
        // remove : 엔티티를 영속성 컨텍스트 및 데이터베이스에서 삭제
        entityManager.remove(foundMenu);

        // .flush() : 영속성 컨텍스트의 변경 내용을 데이터 베이스에 동기화
        // commit 까지 해야 DB에 온전히 반영된다.
        entityManager.flush();  // 위에서 remove 한 후 flush를 하면 NULL 값이 DB에 올라감

        // then
        Menu refoundMenu = entityManager.find(Menu.class, menuCode);
        assertNull(refoundMenu);
        entityTransaction.rollback();
    }
}
