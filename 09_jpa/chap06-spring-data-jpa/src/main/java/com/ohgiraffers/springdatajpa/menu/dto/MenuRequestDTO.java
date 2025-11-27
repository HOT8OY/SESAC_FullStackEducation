package com.ohgiraffers.springdatajpa.menu.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class MenuRequestDTO {

    // 메뉴 코드는 AUTO_INCREMENT 전략을 가지기 때문에 여기에는 쓰지 않음
    private String menuName;
    private int menuPrice;
    private int categoryCode;
    private String orderableStatus;
}
