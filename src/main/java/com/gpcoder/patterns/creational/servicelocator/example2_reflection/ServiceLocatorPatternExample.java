package com.gpcoder.patterns.creational.servicelocator.example2_reflection;

import com.gpcoder.patterns.creational.servicelocator.EmailService;
import com.gpcoder.patterns.creational.servicelocator.MessageService;
import com.gpcoder.patterns.creational.servicelocator.SMSService;

public class ServiceLocatorPatternExample {
    public static void main(String[] args) {
        MessageService service = ServiceLocator.getService(EmailService.class.getCanonicalName());
        System.out.println(service.getMessageBody());

        MessageService smsService = ServiceLocator.getService(SMSService.class.getCanonicalName());
        System.out.println(smsService.getMessageBody());

        MessageService emailService = ServiceLocator.getService(EmailService.class.getCanonicalName());
        System.out.println(emailService.getMessageBody());
    }
}
