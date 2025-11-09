package ex1_ss;
// 1. `Book` 클래스 만들기
//    → 필드: `title`, `author`, `price`
//    → 생성자: 제목과 저자만 받는 버전
//    → 메서드: `showInfo()`, `discount(퍼센트)`
public class Application {
    public static void main(String[] args) {
        Book b1 = new Book("[불개미]", "[베르나른해베르베르르]");
        Book b2 = new Book("[혼자서 공부하는 자바]", "[단체미디어]");

        b1.setPrice(40000);
        b2.setPrice(60000);

        b1.showInfo();
        b2.showInfo();
    }
}
