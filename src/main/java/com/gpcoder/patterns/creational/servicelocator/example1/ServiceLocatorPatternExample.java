package com.gpcoder.patterns.creational.servicelocator.example1;

import com.gpcoder.patterns.creational.servicelocator.MessageService;

public class ServiceLocatorPatternExample {
    public static void main(String[] args) {
        MessageService service = ServiceLocator.getService("EmailService");
        System.out.println(service.getMessageBody());

        MessageService smsService = ServiceLocator.getService("SMSService");
        System.out.println(smsService.getMessageBody());

        MessageService emailService = ServiceLocator.getService("EmailService");
        System.out.println(emailService.getMessageBody());
    }
}
