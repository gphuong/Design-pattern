package com.gpcoder.patterns.creational.googleguice.firstexample;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

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
        bind(MessageService.class).to(EmailService.class);
    }
}

class UserController {
    private MessageService messageService;

    @Inject
    public UserController(MessageService messageService) {
        this.messageService = messageService;
    }

    public void send() {
        messageService.sendMessage("Dependency injection with Google Guice example");
    }
}

public class GoogleGuiceFirstApplication {
    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new FirstModule());
        UserController userController = injector.getInstance(UserController.class);
        userController.send();
    }
}
