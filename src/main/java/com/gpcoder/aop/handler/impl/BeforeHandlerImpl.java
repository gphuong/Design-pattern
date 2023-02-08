package com.gpcoder.aop.handler.impl;

import com.gpcoder.aop.handler.BeforeHandler;

import java.lang.reflect.Method;

public class BeforeHandlerImpl extends BeforeHandler {
    @Override
    public void handleBefore(Object proxy, Method method, Object[] args) {
        System.out.println("Handling before actual method execution");
    }
}
