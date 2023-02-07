package com.gpcoder.patterns.creational.servicelocator.example1;

import com.gpcoder.patterns.creational.servicelocator.MessageService;

import java.util.ArrayList;
import java.util.List;

public class Cache {
    private static final List<MessageService> SERVICES = new ArrayList<>();

    public MessageService getService(String serviceName) {
        for (MessageService messageService : SERVICES) {
            if (messageService.getClass().getSimpleName().equals(serviceName)) {
                return messageService;
            }
        }
        return null;
    }

    public void addService(MessageService newService) {
        SERVICES.add(newService);
    }
}
