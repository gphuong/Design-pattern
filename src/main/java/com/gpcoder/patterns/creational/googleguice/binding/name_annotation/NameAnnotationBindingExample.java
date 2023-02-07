package com.gpcoder.patterns.creational.googleguice.binding.name_annotation;

import com.google.inject.*;
import com.google.inject.name.Named;
import com.google.inject.name.Names;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@BindingAnnotation
@Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface SmsMessageService {
}

interface MessageService {
    void sendMessage(String message);
}

class EmailService implements MessageService {
    @Override
    public void sendMessage(String message) {
        System.out.println("Email message: " + message);
    }
}

class SmsService implements MessageService {
    @Override
    public void sendMessage(String message) {
        System.out.println("Sms message: " + message);
    }
}

class FirstModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(MessageService.class).to(EmailService.class);
        bind(MessageService.class).annotatedWith(Names.named("SmsMessageService")).to(SmsService.class);
    }
}

class User1Controller {
    private MessageService messageService;

    @Inject
    public User1Controller(MessageService messageService) {
        this.messageService = messageService;
    }

    public void send() {
        messageService.sendMessage("Default annotation binding example");
    }
}

class User2Controller {
    private MessageService messageService;

    @Inject
    public User2Controller(@Named("SmsMessageService") MessageService messageService) {
        this.messageService = messageService;
    }
    public void send(){
        messageService.sendMessage("Sms annotation binding example");
    }
}

public class NameAnnotationBindingExample {
    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new FirstModule());
        User1Controller user1Controller = injector.getInstance(User1Controller.class);
        user1Controller.send();

        User2Controller user2Controller = injector.getInstance(User2Controller.class);
        user2Controller.send();
    }
}
