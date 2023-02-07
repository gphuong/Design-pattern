package com.gpcoder.patterns.behavioral.nullobject.tax;

public class RealTax implements Tax {
    private String country;
    private double vat;

    public RealTax(String country, double vat) {
        this.country = country;
        this.vat = vat;
    }

    public String getCountry() {
        return country;
    }

    public double apply(double price) {
        return price * vat;
    }
}
