package com.gpcoder.patterns.creational.servicelocator;

public class SMSService implements MessageService{
    @Override
    public String getMessageBody() {
        return "This is message body of SMS message";
    }

    @Override
    public String getServiceName() {
        return "SMSService";
    }
}
