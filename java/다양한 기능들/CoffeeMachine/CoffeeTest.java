package CoffeeMachine;

public class CoffeeTest{
    public static void main(String[] args){

        Coffee etiopiaCoffee = new EtiopiaAmericano();
        etiopiaCoffee.brewing();

        System.out.println();
        Coffee etiopiaLatte = new Latte(etiopiaCoffee);
        etiopiaLatte.brewing();

        System.out.println();
        Coffee etiopiaMocha = new Mocha(new Latte(new EtiopiaAmericano()));
        etiopiaMocha.brewing();

        System.out.println();
        Coffee KeyaCoffee = new WhippingCream(new Mocha(new Latte(new KeyaAmericano())));
        KeyaCoffee.brewing();
    }
}
