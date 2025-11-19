package com.hw1.model.dto;

public class CookBook extends Book {
    // 필드
    private boolean coupon;
    //생성자
    public CookBook() {}
    public CookBook(String title, String author, String publisher, boolean coupon) {
        super(title, author, publisher);
        this.coupon = coupon;
    }

    @Override
    public String toString() {
        return "CookBook{" +
                "coupon=" + coupon +
                '}';
    }

    //getter,setter
    public boolean isCoupon() {
        return coupon;
    }
    public void setCoupon(boolean coupon) {
        this.coupon = coupon;
    }
}
