package com.hw1.model.dto;
// Run = Person(부모) -> Student(자식)
//                  └─> Employee(자식)
public class Student extends Person {
    // 필드
    private int grade;
    private String major;
    // 생성자
    public Student (){}
    public Student (String name, int age, double height, double weight, int grade, String major) {
        super(age, height, weight);
        this.name = name;
        this.grade = grade;
        this.major = major;
    }
    // 메서드(오버라이딩)
    @Override
    public String information() {
        return name + "학생의 " + super.information() + ", 학적정보[학년=" + grade + "학년, 전공=" + major + "]";
    }
    // setter, getter

    public int getGrade() {
        return grade;
    }
    public void setGrade(int grade) {
        this.grade = grade;
    }
    public String getMajor() {
        return major;
    }
    public void setMajor(String major) {
        this.major = major;
    }
}
