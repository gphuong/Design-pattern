package com.gpcoder.patterns.creational.googleguice.aop.handler;

import com.google.inject.Inject;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.util.logging.Logger;

public class LoggingInterceptor implements MethodInterceptor {
    @Inject
    private Logger logger;

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        logger.info("LoggingInterceptor");

        System.out.println("Handling before actual method execution");
        System.out.println("Gets the method being called: " + invocation.getMethod().getName());
        Object[] objectArray = invocation.getArguments();
        for (Object object : objectArray) {
            System.out.println("Get the arguments: " + object);
        }

        Object result = invocation.proceed();

        System.out.println("Handling after actual method execution");
        System.out.println("---");

        return result;
    }
}
