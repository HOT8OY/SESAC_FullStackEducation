package ex1_ss;
// 1. `Book` 클래스 만들기
//    → 필드: `title`, `author`, `price`
//    → 생성자: 제목과 저자만 받는 버전
//    → 메서드: `showInfo()`, `discount(퍼센트)`
public class Book {
    String title;
    String author;
    int price;
    static double interestRate = 0.02;
    public Book (String title, String author) {
        this.title = title;
        this.author = author;
    }
    void showInfo(){
        System.out.println(this.title + "의 저자는 " + this.author + "이고 가격은 " + this.price + "이며, 할인 가격은 " + discount() + "입니다.");
    }
    double discount() {
        return this.price * (1 - interestRate);
    }
    public void setPrice (int price) {
        this.price = price;
    }
}
