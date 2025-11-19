package com.hw1.model.dto;

public class Member {
    // 필드
    private String name;
    private int age;
    private char gender;
    private int couponCount;

    // 생성자
    public Member() {}
    public Member(String name, int age, char gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Member{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", couponCount=" + couponCount +
                '}';
    }

    // getter, setter
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public char getGender() {
        return gender;
    }
    public void setGender(char gender) {
        this.gender = gender;
    }
    public int getCouponCount() {
        return couponCount;
    }
    public void setCouponCount(int couponCount) {
        this.couponCount = couponCount;
    }
}
