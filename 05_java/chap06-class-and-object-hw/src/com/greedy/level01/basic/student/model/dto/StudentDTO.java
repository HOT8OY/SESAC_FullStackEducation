package com.greedy.level01.basic.student.model.dto;

public class StudentDTO {

    private int grade;
    private int classroom;
    private String name;
    private int kor;
    private int eng;
    private int math;

    public StudentDTO(){}; // 기본 생성자(constructor)

    // setter
    public void setGrade(int grade) {
        this.grade = grade;
    }
    public void setClassroom(int classroom) {
        this.classroom = classroom;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setKor(int kor) {
        this.kor = kor;
    }
    public void setEng(int eng) {
        this.eng = eng;
    }
    public void setMath(int math) {
        this.math = math;
    }
//    public int getGrade() {
//        return grade;
//    }
//    public int getClassroom() {
//        return classroom;
//    }
//    public String getName() {
//        return name;
//    }
//    public int getKor() {
//        return kor;
//    }
//    public int getEng() {
//        return eng;
//    }
//    public int getMath() {
//        return math;
//    }
    public String getInformation(){
        int avg = (this.kor + this.eng + this.math) / 3;
        return "학년=" + this.grade + ", 반=" + this.classroom + ", 이름=" + this.name + ", 국어=" + this.kor + ", 영어=" + this.eng + ", 수학=" + this.math + ", 평균=" + avg;
    }
}
