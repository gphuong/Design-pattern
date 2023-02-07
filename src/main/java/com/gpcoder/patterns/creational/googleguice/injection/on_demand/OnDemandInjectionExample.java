package com.gpcoder.patterns.creational.googleguice.injection.on_demand;

import com.google.inject.*;
import com.google.inject.name.Named;
import com.google.inject.name.Names;

@ImplementedBy(EmailService.class)
interface MessageService {
    void sendMessage(String message);
}

class EmailService implements MessageService {
    @Inject
    @Named("signature")
    private String signature;

    @Override
    public void sendMessage(String message) {
        System.out.println("Email message: " + message + " by " + signature);
    }
}

class BaseModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(String.class).annotatedWith(Names.named("signature")).toInstance("gpcoder.com");
    }
}

class UserController {
    private MessageService messageService;

    public UserController(MessageService messageService) {
        this.messageService = messageService;
    }

    public void send() {
        messageService.sendMessage("On-Demand injection example");
    }
}

public class OnDemandInjectionExample {
    public static void main(String[] args) {
        EmailService emailService = new EmailService();

        Injector injector = Guice.createInjector(new BaseModule());
        injector.injectMembers(emailService);

        UserController userController = new UserController(emailService);
        userController.send();

    }
}
