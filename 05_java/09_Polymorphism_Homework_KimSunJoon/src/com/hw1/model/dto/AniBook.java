package com.hw1.model.dto;

public class AniBook extends Book {
    // 필드
    private int accessAge;
    //생성자
    public AniBook() {}
    public AniBook(String title, String author, String publisher, int accessAge) {
        super(title, author, publisher);
        this.accessAge = accessAge;
    }

    @Override
    public String toString() {
        return "AniBook{" +
                "accessAge=" + accessAge +
                '}';
    }

    // getter, setter
    public int getAccessAge() {
        return accessAge;
    }
    public void setAccessAge(int accessAge) {
        this.accessAge = accessAge;
    }
}
