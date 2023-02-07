package com.gpcoder.patterns.behavioral.strategy.payment;

public class Item {
    private String upCode;
    private int price;

    public String getUpCode() {
        return upCode;
    }

    public int getPrice() {
        return price;
    }

    public Item(String upCode, int price) {
        this.upCode = upCode;
        this.price = price;
    }
}
