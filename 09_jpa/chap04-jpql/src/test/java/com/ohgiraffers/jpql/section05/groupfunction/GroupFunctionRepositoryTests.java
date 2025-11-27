package com.ohgiraffers.jpql.section05.groupfunction;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class GroupFunctionRepositoryTests {

    @Autowired
    private GroupFunctionRepository groupFunctionRepository;

    @DisplayName("특정 카테고리에 등록 된 메뉴 수 조회")
    @Test
    void testCountMenuOfCategory() {
        int categoryCode = 4;
        long countOfMenu = groupFunctionRepository.countMenuOfCategory(categoryCode);
        assertTrue(countOfMenu >= 0);
        System.out.println("countOfMenu : " + countOfMenu);
    }

    @DisplayName("COUNT의 다른 그룹함수 조회 결과가 없는 경우")
    @Test
    void testOtherWithNoResult() {
        int categoryCode = 777; // 존재하지 않는 카테고리 코드를 전달.

        assertDoesNotThrow( // assertDoesNotThrow : 에러를 던지지 않으면 테스트 성공 (long이 아닌 Long으로 받기에 에러 없음)
                () -> {
                    Long sumOfMenu = groupFunctionRepository.otherWithNoResult(categoryCode);
                    System.out.println(sumOfMenu);
                }
        );
    }

    @DisplayName("HAVING절 조회 테스트")
    @Test
    void testSelectByHaving() {
//        int minPrice = 50000;
        Long minPrice = 50000L; // 그룹 함수의 반환 자료형은 Long 또는 Double 형이었으나 현재는 개선이 되었는지 long, int등을 사용하여도 문제가 없다.
        List<Object[]> sumPriceOfCategoryList = groupFunctionRepository.selectByGroupByHaving(minPrice);
        assertNotNull(sumPriceOfCategoryList);
    }
}
