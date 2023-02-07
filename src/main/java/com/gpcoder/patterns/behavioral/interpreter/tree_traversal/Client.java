package com.gpcoder.patterns.behavioral.interpreter.tree_traversal;

import java.util.Stack;

public class Client {
    public static void main(String[] args) {
        String tokenString = "7 3 - 2 1 + * ";
        Stack<Expression> stack = new Stack<>();

        String[] tokenList = tokenString.split(" ");
        for (String s : tokenList) {
            if (isOperator(s)) {
                Expression rightExpression = stack.pop();
                Expression leftExpression = stack.pop();
                Expression operator = getOperatorInstance(s, leftExpression, rightExpression);
                int result = operator.interpret();
                stack.push(new NumberExpression(result));
            } else {
                Expression i = new NumberExpression(s);
                stack.push(i);
            }
        }
        System.out.println("Result: " + stack.pop().interpret());
    }

    public static Expression getOperatorInstance(String s, Expression left, Expression right) {
        switch (s) {
            case "+":
                return new PlusExpression(left, right);
            case "-":
                return new MinusExpression(left, right);
            case "*":
                return new MultiplyExpression(left, right);
        }
        return null;
    }

    public static boolean isOperator(String s) {
        if (s.equals("+") || s.equals("-") || s.equals("*"))
            return true;
        else
            return false;
    }
}
