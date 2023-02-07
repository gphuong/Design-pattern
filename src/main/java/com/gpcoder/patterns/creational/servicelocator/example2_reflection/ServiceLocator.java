package com.gpcoder.patterns.creational.servicelocator.example2_reflection;

import com.gpcoder.patterns.creational.servicelocator.MessageService;

public final class ServiceLocator {
    private static Cache cache = new Cache();

    private ServiceLocator() {
        throw new IllegalAccessError("Can't construct this class directly");
    }

    public static MessageService getService(String serviceName) {
        MessageService service = cache.getService(serviceName);
        if (service != null) {
            System.out.println("Get service from cache: " + serviceName);
            return service;
        }

        System.out.println("Create a new service and add to cache: " + serviceName);
        InitialContext context = new InitialContext();
        service = context.lookup(serviceName);
        cache.addService(service);
        return service;
    }
}
