package ohgiraffers.section01.object;

import java.util.Objects;

public class Book {

    private int number;
    private String title;
    private String author;
    private int price;

    // 기본 생성자
    public Book() {}
    // 모든 필드 초기화 생성자
    public Book(int number, String title, String author, int price) {
        this.number = number;
        this.title = title;
        this.author = author;
        this.price = price;
    }
    // getter,setter
    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }

    // toString ( alt + insert -> toString)
    // 부모인 Object의 toString을 오버라이드 하여 '클래스명@해시코드'이 아닌 주소의 객체 값을 보여주도록 재정의한다.
    @Override
    public String toString() {
        return "Book{" +
                "number=" + number +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                '}';
    }

    // equals 및 hashcode( alt + insert -> equals 및 hashcode)
    // 내용이 같은지 확인하기 위한 동등성 비교를 할 수 있도록 오버라이드
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return number == book.number && price == book.price && Objects.equals(title, book.title) && Objects.equals(author, book.author);
    }
    // 자바의 규칙에는 equals에 같다가 나와야 하면 hashCode도 같아야 한다.
    // 그래서 equals 오버라이드와 hashCode의 오버라이드는 세트
    // 규약을 지키기 위해 hashCode도 같은 값이 되도록 오버라이딩
    @Override
    public int hashCode() {
        return Objects.hash(number, title, author, price);
    }
}
