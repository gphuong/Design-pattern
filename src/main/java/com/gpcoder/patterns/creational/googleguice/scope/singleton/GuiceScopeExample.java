package com.gpcoder.patterns.creational.googleguice.scope.singleton;

import com.google.inject.*;

interface MessageService {
    void sendMessage(String message);
}

class EmailService implements MessageService {
    @Override
    public void sendMessage(String message) {
        System.out.println(message + ": " + System.identityHashCode(this));
    }
}

class FirstModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(MessageService.class).to(EmailService.class).in(Singleton.class);
    }
}

class UserController {
    private MessageService messageService;

    @Inject
    public UserController(MessageService messageService) {
        this.messageService = messageService;
    }

    public void send() {
        messageService.sendMessage("Singleton Scoped example");
    }
}

public class GuiceScopeExample {
    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new FirstModule());

        UserController userController = injector.getInstance(UserController.class);
        userController.send();

        userController = injector.getInstance(UserController.class);
        userController.send();
    }
}
