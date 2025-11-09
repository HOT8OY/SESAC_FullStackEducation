package com.ohgiraffers.section03.dto;

public class MemberDTO {

    // dto(data transfer object) : 데이터를 안전하게 정해진 규격대로 담아서 다른곳으로 옮겨주는 역할.
    // 오직 데이터를 담고(set) 꺼내는(get)역할만 제공한다.

    private int number;
    private String name;
    private int age;
    private char gender;
    private double height;
    private double weight;
    private boolean isActivated;

    public void setNumber(int number) {
        this.number = number;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setGender(char gender) {
        this.gender = gender;
    }
    public void setHeight (double height) {
        this.height = height;
    }
    public void setWeight (double weight) {
        this.weight = weight;
    }
    public void setActivated(boolean isActivated) {
        this.isActivated = isActivated;
    }
    public int getNumber() { // 반환값 타입이 정해져있으므로 void가 아닌 int를 사용한다.
        return number;
    }
    public int getAge() {
        return age;
    }
    public String getName() {
        return name;
    }
    public char getGender() {
        return gender;
    }
    public double getHeight() {
        return height;
    }
    public double getWeight() {
        return weight;
    }
    public boolean isActivated() {   // boolean은 get을 사용하지 않고 그대로 사용한다.
        return isActivated;
    }
}
