package com.gpcoder.patterns.creational.googleguice.binding.provide_annotation;

import com.google.inject.*;

interface MessageService {
    void sendMessage(String message);
}

class EmailService implements MessageService {
    @Override
    public void sendMessage(String message) {
        System.out.println("Email message: " + message);
    }
}

class FirstModule extends AbstractModule {
    @Override
    protected void configure() {

    }

    @Provides
    public MessageService provideMessageService() {
        return new EmailService();
    }
}

class UserController {
    private MessageService messageService;

    @Inject
    public UserController(MessageService messageService) {
        this.messageService = messageService;
    }

    public void send() {
        messageService.sendMessage("Provides Annotation Binding example");
    }
}

public class ProvidesAnnotationBindingExample {
    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new FirstModule());
        UserController userController = injector.getInstance(UserController.class);
        userController.send();
    }
}
