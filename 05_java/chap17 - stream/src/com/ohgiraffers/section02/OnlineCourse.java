package com.ohgiraffers.section02;

public class OnlineCourse {
    // 필드
    private String title;
    private String category;
    private int duration;
    private boolean isFree;
    // 생성자
    public OnlineCourse(String title, String category, int duration, boolean isFree) {
        this.title = title;
        this.category = category;
        this.duration = duration;
        this.isFree = isFree;
    }
    // getter
    public String getTitle() {
        return title;
    }
    public String getCategory() {
        return category;
    }
    public int getDuration() {
        return duration;
    }
    public boolean isFree() {
        return isFree;
    }
    // toString
    @Override
    public String toString() {
        return "OnlineCourse{" +
                "title='" + title + '\'' +
                ", category='" + category + '\'' +
                ", duration=" + duration +
                ", isFree=" + isFree +
                '}';
    }
}
