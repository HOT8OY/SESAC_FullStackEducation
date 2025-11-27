package com.ohgiraffers.associationmapping.section03.bidirection;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BiDirectionService {

    private BiDirectionRepository biDirectionRepository;

    public BiDirectionService(BiDirectionRepository biDirectionRepository) {
        this.biDirectionRepository = biDirectionRepository;
    }

    public Menu findMenu(int menuCode) {
        return biDirectionRepository.findMenu(menuCode);
    }

    @Transactional
    public Category findCategory(int categoryCode) {
        Category category = biDirectionRepository.findCategory(categoryCode);
        System.out.println(category.getMenuList()); // category에서 menuList 받아올 수 있음.
        System.out.println(category.getMenuList().get(0).getCategory()); // 양방향 참조가 가능하기에 menuList 쪽에서도 category를 가져올 수 있다.
        return category;
    }
}
