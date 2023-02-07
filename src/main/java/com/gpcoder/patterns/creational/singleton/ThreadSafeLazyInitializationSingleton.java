package com.gpcoder.patterns.creational.singleton;

public class ThreadSafeLazyInitializationSingleton {
    private static volatile ThreadSafeLazyInitializationSingleton instance;

    private ThreadSafeLazyInitializationSingleton() {
    }

    public static synchronized ThreadSafeLazyInitializationSingleton getInstance() {
        if (instance == null) {
            instance = new ThreadSafeLazyInitializationSingleton();
        }
        return instance;
    }
}
