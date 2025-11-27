package com.ohgiraffers.springdatajpa.menu.service;

import com.ohgiraffers.springdatajpa.menu.dto.MenuResponseDTO;
import com.ohgiraffers.springdatajpa.menu.entity.Menu;
import com.ohgiraffers.springdatajpa.menu.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor    // final 필드만을 파라미터로 받는 생성자를 자동으로 생성해줌
public class MenuService {

    private final MenuRepository menuRepository;

    // @RequiredArgsConstructor가 자동 생성해주는 구문
//    @Autowired
//    public MenuService(MenuRepository menuRepository) {
//        this.menuRepository = menuRepository;
//    }

    /* 1. 메뉴 코드로 상세 조회 */
    public MenuResponseDTO findMenuByMenuCode(int menuCode) {
        Menu foundMenu = menuRepository.findById(menuCode).orElseThrow(
                () -> new IllegalArgumentException("메뉴가 존재하지 않습니다."));

        return null;
    }
}
