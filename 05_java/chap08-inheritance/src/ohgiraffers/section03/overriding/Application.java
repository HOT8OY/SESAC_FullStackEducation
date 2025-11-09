package ohgiraffers.section03.overriding;
// Application = VendingMachine -> CoffeeVendingMachine
//
public class Application {
    public static void main(String[] args) {

        CoffeeVendingMachine coffeeVendingMachine = new CoffeeVendingMachine();
        System.out.println(coffeeVendingMachine.vend());
    }
}
