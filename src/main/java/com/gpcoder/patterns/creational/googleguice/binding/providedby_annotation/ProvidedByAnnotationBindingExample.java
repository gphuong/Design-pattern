package com.gpcoder.patterns.creational.googleguice.binding.providedby_annotation;

import com.google.inject.*;

class EmailService implements MessageService {
    @Override
    public void sendMessage(String message) {
        System.out.println(message);
    }
}

class MessageServiceProvider implements Provider<MessageService> {
    @Override
    public MessageService get() {
        return new EmailService();
    }
}

@ProvidedBy(MessageServiceProvider.class)
interface MessageService {
    void sendMessage(String message);
}

class UserController {
    @Inject
    private MessageService messageService;

    public void send() {
        messageService.sendMessage("@ProvidedBy annotation binding example");
    }
}

public class ProvidedByAnnotationBindingExample {
    public static void main(String[] args) {
        Injector injector = Guice.createInjector();
        UserController userController = injector.getInstance(UserController.class);
        userController.send();
    }
}
