package com.gpcoder.patterns.behavioral.interpreter.tree_traversal;

public class NumberExpression implements Expression {
    int number;

    public NumberExpression(int number) {
        this.number = number;
    }

    public NumberExpression(String s) {
        number = Integer.parseInt(s);
    }

    @Override
    public int interpret() {
        return number;
    }
}
