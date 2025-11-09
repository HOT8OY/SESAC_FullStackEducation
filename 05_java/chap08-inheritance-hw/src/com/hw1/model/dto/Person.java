package com.hw1.model.dto;
// Run = Person(부모) -> Student(자식)
//                  └─> Employee(자식)
public class Person {
    // 필드
    protected String name;
    private int age;
    private double height;
    private double weight;
    // 생성자
    public Person(){};
    public Person(int age, double height, double weight) {
        this.age = age;
        this.height = height;
        this.weight = weight;
    }
    // 메서드
    public String information() {
        return "신체 정보[나이=" + age + "세, 키=" + height + "cm, 무게=" + weight + "kg]";
    }
    // setter, getter
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
    public double getHeight() {
        return height;
    }
    public void setHeight(double height) {
        this.height = height;
    }
    public double getWeight() {
        return weight;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }
}
