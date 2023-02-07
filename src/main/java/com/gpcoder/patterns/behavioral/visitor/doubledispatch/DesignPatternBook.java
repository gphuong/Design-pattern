package com.gpcoder.patterns.behavioral.visitor.doubledispatch;

public class DesignPatternBook implements ProgrammingBook {
    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

    @Override
    public String getResource() {
        return "https://github.com/gpcodervn/Design-Pattern-Tutorial/";
    }

    public String getBestSeller() {
        return "The best Seller of design pattern book";
    }
}
