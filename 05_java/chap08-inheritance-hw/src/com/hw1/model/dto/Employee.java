package com.hw1.model.dto;
// Run = Person(부모) -> Student(자식)
//                  └─> Employee(자식)
public class Employee extends Person {
    // 필드
    private int salary;
    private String dept;
    // 생성자
    public Employee () {}
    public Employee (String name, int age, double height, double weight, int salary, String dept) {
        super(age, height, weight);
        this.name = name;
        this.salary = salary;
        this.dept = dept;
    }
    // 메서드(오버라이딩)
    @Override
    public String information() {
        return name + "사원의 " + super.information() + ", 금융정보[월급=" + salary + "원, 부서=" + dept + "원]";
    }

    // setter, getter

    public String getDept() {
        return dept;
    }
    public void setDept(String dept) {
        this.dept = dept;
    }
    public int getSalary() {
        return salary;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }
}
