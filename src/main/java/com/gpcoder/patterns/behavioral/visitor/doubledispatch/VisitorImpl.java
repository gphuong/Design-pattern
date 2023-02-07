package com.gpcoder.patterns.behavioral.visitor.doubledispatch;

public class VisitorImpl implements Visitor{
    @Override
    public void visit(BusinessBook book) {
        System.out.println(book.getPublisher());
    }

    @Override
    public void visit(DesignPatternBook book) {
        System.out.println(book.getBestSeller());
    }

    @Override
    public void visit(JavaCoreBook book) {
        System.out.println(book.getFavouriteBook());
    }
}
