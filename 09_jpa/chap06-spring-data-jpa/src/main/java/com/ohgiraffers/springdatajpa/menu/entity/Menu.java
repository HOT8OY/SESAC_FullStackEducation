package com.ohgiraffers.springdatajpa.menu.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tbl_menu")
@Getter
// JPA 스펙상 기본생성자가 꼭 있어야 하지만 아무나 빈 객체를 만들 수 없도록 엑세스 레벨 설정
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int menuCode;
    private String menuName;
    private int menuPrice;
    @ManyToOne
    @JoinColumn(name = "categoryCode")
    private Category category;
    private String orderableStatus;

}
