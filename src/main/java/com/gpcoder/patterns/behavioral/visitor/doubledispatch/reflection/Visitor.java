package com.gpcoder.patterns.behavioral.visitor.doubledispatch.reflection;

import java.lang.reflect.Method;

public abstract class Visitor {
    public abstract void visit(Book book);

    protected Method getMethod(Class<?> clazz) {
        while (!clazz.equals(Object.class)) {
            try {
                return this.getClass().getDeclaredMethod("visit", clazz);
            } catch (NoSuchMethodException e) {
                clazz = clazz.getSuperclass();
            }
            Class<?>[] interfaces = clazz.getInterfaces();
            for (Class<?> anInterface : interfaces) {
                try {
                    return this.getClass().getDeclaredMethod("visit", anInterface);
                } catch (NoSuchMethodException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return null;
    }

    protected void defaultVisit(Book book) {
        System.out.println("A book");
    }
}
