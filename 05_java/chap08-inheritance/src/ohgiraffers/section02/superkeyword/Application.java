package ohgiraffers.section02.superkeyword;
// Application = Product -> Computer
//                      └─> SmartPhone 구조
public class Application {
    public static void main(String[] args) {
        // Product 인스턴스 생성(기본 생성자)
        Product product = new Product();
        System.out.println(product.getInformation());
        // Product 인스턴스 생성(매개변수를 받은 생성자)
        Product product2 = new Product("S-0123", "갤럭시", 2000000);
        System.out.println(product2.getInformation());
        // Computer 인스턴스 생성(매개변수를 받은 생성자)
        Computer computer = new Computer("S-9123", "갤럭시", 23000000, "512", 12);
        System.out.println(computer.getInformation());
        // SmartPhone 인스턴스 생성(매개변수 다 받음)
        SmartPhone smartPhone = new SmartPhone("I-1011", "아이폰", 2555000, true, "SKTKTLGBT");
        System.out.println(smartPhone.getInformation());
    }
}
