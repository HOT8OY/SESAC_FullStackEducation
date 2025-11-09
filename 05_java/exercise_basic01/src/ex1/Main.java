package ex1;

public class Main {
    public static void main(String[] args) {
        BankAccount a1 = new BankAccount("홍길동", 10000);
        BankAccount a2 = new BankAccount("김철수", 5000);

        a1.deposit(5000);
        a2.withdraw(7000);

        a1.showInfo();
        a2.showInfo();

        BankAccount.showInterestRate();  // static 메서드 호출
    }
}
