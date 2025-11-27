package com.ohgiraffers.section02.crud;

import com.ohgiraffers.section01.entitymanager.EntityManagerGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EntityManagerCRUDTests {

    private EntityManagerCRUD crud;

    @BeforeEach
    void initManager() {
        this.crud = new EntityManagerCRUD(); // 항상 test 전에 객체가 생성되게끔 함.
    }

    @DisplayName("메뉴 코드로 메뉴 조회 테스트")
    @ParameterizedTest // 하나의 테스트 메소드로 여러 개의 파라미터에 대한 테스트를 할 수 있다.
    @CsvSource({"2,2", "3,3"})  // 첫번째 테스트에선 menuCode에 2를 전달, expected에 2를 전달. 두 번째 테스트에선 3,3을 전달하여 테스트.
    void testFindMethodByMenuCode(int menuCode, int expected) {
        // given
//        int menucode = 1;
        // when
        Menu foundMenu = crud.findMenuByMenuCode(menuCode);
        // then
        // 기대하는 값이 foundMneu.getMenuName()과 일치하는지 확인하는 테스트 코드.
        assertEquals(expected, foundMenu.getMenuCode());
        System.out.println("foundMenu : " + foundMenu);
    }

    public static Stream<Arguments> newMenu() {
        return Stream.of(
                Arguments.of(
                        "신메뉴",
                        35000,
                        4,
                        "Y" // 값들은 순서대로 밑의 test메소드에서 호출 되면 사용됨.
                )
        );
    }

    @DisplayName("새로운 메뉴 추가 테스트")
    @ParameterizedTest
    @MethodSource("newMenu")    // newMenu 메소드의 반환값을 파라미터로 이용
    void testRegist(String menuName, int menuPrice, int categoryCode, String orderableStatus) {

        // when
        Menu newMenu = new Menu(menuName, menuPrice, categoryCode, orderableStatus);
        Long count = crud.saveAndReturnAllCount(newMenu);

        // then // expected는 추가 된 후니까 현재 db 갯수 + 1
        assertEquals(28, count);
    }

    @DisplayName("메뉴 이름 수정 테스트")
    @ParameterizedTest
    @CsvSource("2, 변경 된 이름")
    void testModifyMenuName(int menuCode, String menuName) {
        // when
        Menu modifiedMenu = crud.modifyMenuName(menuCode, menuName);
        // then
        assertEquals(menuName, modifiedMenu.getMenuName());
    }

    @DisplayName("메뉴 삭제 테스트")
    @ParameterizedTest
    @ValueSource(ints = {33, 31}) // 존재하는 menuCode 중 삭제할 것들을 넣음.
    void testRemoveMenu(int menuCode) {
        // when
        Long count = crud.removeAndReturnAllCount(menuCode);

        // then (삭제 후 개수를 비교)
        assertEquals(26, count);    // 33번 삭제 후 실패(1개가 삭제된 상태),31번 삭제 후 성공(2개가 삭제된 상태)
    }
}
