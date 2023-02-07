package com.gpcoder.patterns.behavioral.strategy.payment;

public class StrategyPatternExample {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        Item item1 = new Item("Elements of Reusable Object-Oriented Software GOF", 40);
        Item item2 = new Item("Design Pattern for Dummy", 50);

        cart.addItem(item1);
        cart.addItem(item2);

        cart.pay(new PaypalStrategy("phuongheh@gmail.com", "LapTrinhJava"));

        cart.pay(new CreditCardStrategy("GP Coder", "12345667", "102", "2/2"));
    }
}
