package com.ohgiraffers.section02.crud;

import jakarta.persistence.*;

// Entity에 이름을 지어주는 이유 : 이름을 지어주지 않으면 기본적으로 class명으로 들어가기 때문에 중복될 가능성이 있으면 이름을 지어준다.
@Entity(name = "Section02Menu")
// @Table: "이 클래스는 DB의 'tbl_menu'라는 테이블과 연결됩니다"라고 지정.
// 생략하면 클래스 이름(Product)과 같은 테이블을 찾는다.
@Table(name = "tbl_menu")
public class Menu {

    // @Id: "이 필드가 이 테이블의 주민등록번호(PK)입니다"라고 알려준다.
    // 모든 Entity는 반드시 식별자(@Id)가 하나 있어야 한다.
    @Id
    @Column(name = "menu_code")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int menuCode;
    @Column (name = "menu_name" )
    private String menuName;
    @Column (name = "menu_price" )
    private int menuPrice;
    @Column (name = "category_code" )
    private int categoryCode;
    @Column (name = "orderable_status" )
    private String orderableStatus;

    // 외부에서 못 이용하는 기본생성자
    protected Menu() {}
    // menuCode를 제외한 생성자
    public Menu(String menuName, int menuPrice, int categoryCode, String orderableStatus) {
        this.menuName = menuName;
        this.menuPrice = menuPrice;
        this.categoryCode = categoryCode;
        this.orderableStatus = orderableStatus;
    }
    // 외부에서 사용 가능 한 전체생성자
    public Menu(int menuCode, String menuName, int menuPrice, int categoryCode, String orderableStatus) {
        this.menuCode = menuCode;
        this.menuName = menuName;
        this.menuPrice = menuPrice;
        this.categoryCode = categoryCode;
        this.orderableStatus = orderableStatus;
    }

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

    public int getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(int categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getOrderableStatus() {
        return orderableStatus;
    }

    public void setOrderableStatus(String orderableStatus) {
        this.orderableStatus = orderableStatus;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "menuCode=" + menuCode +
                ", menuName='" + menuName + '\'' +
                ", menuPrice=" + menuPrice +
                ", categoryCode=" + categoryCode +
                ", orderableStatus='" + orderableStatus + '\'' +
                '}';
    }
}
