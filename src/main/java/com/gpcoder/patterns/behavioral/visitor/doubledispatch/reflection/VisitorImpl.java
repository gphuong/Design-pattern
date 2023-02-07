package com.gpcoder.patterns.behavioral.visitor.doubledispatch.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class VisitorImpl extends Visitor {
    @Override
    public void visit(Book book) {
        Method downPolymorphic = getMethod(book.getClass());
        if (downPolymorphic == null) {
            defaultVisit(book);
        } else {
            try {
                downPolymorphic.invoke(this, book);
            } catch (IllegalAccessException | InvocationTargetException | IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
    }

    public void visit(BusinessBook book) {
        System.out.println(book.getPublisher());
    }

    public void visit(DesignPatternBook book) {
        System.out.println(book.getBestSeller());
    }

    public void visit(JavaCoreBook book) {
        System.out.println(book.getFavouriteBook());
    }
}
