package com.gpcoder.patterns.creational.servicelocator.example2_reflection;

import com.gpcoder.patterns.creational.servicelocator.MessageService;

public class InitialContext {
    public MessageService lookup(String serviceName) {
        try {
            Class<MessageService> clazz = (Class<MessageService>) Class.forName(serviceName);
            Object newInstance = clazz.newInstance();
            return cast(newInstance, clazz);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> T cast(Object obj, Class<T> clazz) {
        if (clazz.isAssignableFrom(obj.getClass())) {
            return clazz.cast(obj);
        }
        throw new ClassCastException("Failed to cast instance");
    }
}
