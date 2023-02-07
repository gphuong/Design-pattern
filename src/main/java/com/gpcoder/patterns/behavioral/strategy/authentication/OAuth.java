package com.gpcoder.patterns.behavioral.strategy.authentication;

public class OAuth implements AuthStrategy {
    @Override
    public void auth() {
        System.out.println("Open authentication");
    }
}
