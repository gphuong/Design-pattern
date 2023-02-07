package com.gpcoder.patterns.creational.servicelocator.example2_reflection;

import com.gpcoder.patterns.creational.servicelocator.MessageService;

import java.util.ArrayList;
import java.util.List;

public class Cache {
    private static final List<MessageService> SERVICES = new ArrayList<>();

    public MessageService getService(String serviceName) {
        for (MessageService messageService : SERVICES) {
            if (messageService.getClass().getCanonicalName().equals(serviceName)) {
                return messageService;
            }
        }
        return null;
    }

    public void addService(MessageService newService) {
        SERVICES.add(newService);
    }

}
