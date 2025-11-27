package com.ohgiraffers.associationmapping.section01.manytoone;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class MenuDTO {

    // .yml 파일에 column명 규칙을 정해뒀기 때문에 @Column (name ="")을 사용하지 않고 자동으로 클래스명을 변환해준다.
    private int menuCode;
    private String menuName;
    private int menuPrice;
    private CategoryDTO category;
    private String orderableStatus;

    // 생성자
    public MenuDTO() {
    }

    public MenuDTO(int menuCode, String menuName, int menuPrice, CategoryDTO category, String orderableStatus) {
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
    public CategoryDTO getCategory() {
        return category;
    }
    public void setCategory(CategoryDTO category) {
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
        return "MenuDTO{" +
                "menuCode=" + menuCode +
                ", menuName='" + menuName + '\'' +
                ", menuPrice=" + menuPrice +
                ", category=" + category +
                ", orderableStatus='" + orderableStatus + '\'' +
                '}';
    }
}
