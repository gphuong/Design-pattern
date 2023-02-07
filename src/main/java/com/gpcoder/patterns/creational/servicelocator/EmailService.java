package com.gpcoder.patterns.creational.servicelocator;


public class EmailService implements MessageService {

    @Override
    public String getMessageBody() {
        return "This is message body of Email message";
    }

    @Override
    public String getServiceName() {
        return "EmailService";
    }
}
