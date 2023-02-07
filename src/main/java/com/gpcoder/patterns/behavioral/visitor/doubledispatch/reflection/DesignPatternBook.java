package com.gpcoder.patterns.behavioral.visitor.doubledispatch.reflection;

public class DesignPatternBook implements ProgrammingBook{
    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

    @Override
    public String getResource() {
        return "https://github.com/gpcodervn/Design-Pattern-Tutorial/";
    }
    public String getBestSeller(){
        return "Head first design pattern";
    }
}
