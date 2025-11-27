package com.ohgiraffers.associationmapping.section03.bidirection;

import jakarta.persistence.*;

@Entity (name = "bidirection_menu")
@Table(name = "tbl_menu")
public class Menu {

    // .yml 파일에 column명 규칙을 정해뒀기 때문에 @Column (name ="")을 사용하지 않고 자동으로 클래스명을 변환해준다.
    @Id
    private int menuCode;
    private String menuName;
    private int menuPrice;


    // category_code는 tbl_category의 FK
    // 따라서 Category class를 생성해줄 것
    /* cascade(영속성 전이)
    * 특정 엔티티를 영속화 할 때 연관 된 엔티티도 함께 영속화 한다(PERSIST)
    * fetch(즉시로딩 or 지연 로딩)
    * ManyToOne의 경우 기본적으로 즉시 로딩(EAGER)되지만 필요에 따라 지연 로딩(LAZY)으로 변경할 수 있다. */
    @ManyToOne
    @JoinColumn(name = "categoryCode")
    private Category category;
    private String orderableStatus;

    // 생성자
    public Menu() {
    }

    public Menu(int menuCode, String menuName, int menuPrice, Category category, String orderableStatus) {
        this.menuCode = menuCode;
        this.menuName = menuName;
        this.menuPrice = menuPrice;
        this.category = category;
        this.orderableStatus = orderableStatus;
    }

    // getter, setter
    public int getMenuCode() {
        return menuCode;
    }
    public void setMenuCode(int menuCode) {
        this.menuCode = menuCode;
    }
    public String getMenuName() {
        return menuName;
    }
    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }
    public int getMenuPrice() {
        return menuPrice;
    }
    public void setMenuPrice(int menuPrice) {
        this.menuPrice = menuPrice;
    }
    public Category getCategory() {
        return category;
    }
    public void setCategory(Category category) {
        this.category = category;
    }
    public String getOrderableStatus() {
        return orderableStatus;
    }
    public void setOrderableStatus(String orderableStatus) {
        this.orderableStatus = orderableStatus;
    }
    // toString
    @Override
    public String toString() {
        return "Menu{" +
                "menuCode=" + menuCode +
                ", menuName='" + menuName + '\'' +
                ", menuPrice=" + menuPrice +
                ", category=" + category +
                ", orderableStatus='" + orderableStatus + '\'' +
                '}';
    }
}
