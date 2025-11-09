package ex1;

public class BankAccount {
    // 필드
    String owner;
    int balance;
    static double interestRate = 0.01;  // 이자율 (공유)

    // 생성자
    public BankAccount(String owner, int initial) {
        this.owner = owner;
        this.balance = initial;
        System.out.println(owner + " 계좌 개설! 초기금액: " + initial);
    }

    // 메서드
    void deposit(int amount) {
        balance += amount;
        System.out.println(amount + "원 입금 → 잔액: " + balance);
    }

    void withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println(amount + "원 출금 → 잔액: " + balance);
        } else {
            System.out.println("잔액 부족!");
        }
    }

    void showInfo() {
        System.out.println("예금주: " + owner + ", 잔액: " + balance);
    }

    // static 메서드
    static void showInterestRate() {
        System.out.println("현재 이자율: " + (interestRate * 100) + "%");
    }
}