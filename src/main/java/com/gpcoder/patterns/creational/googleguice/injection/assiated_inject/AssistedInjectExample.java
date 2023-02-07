package com.gpcoder.patterns.creational.googleguice.injection.assiated_inject;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.assistedinject.Assisted;
import com.google.inject.assistedinject.FactoryModuleBuilder;

interface CallerFactory {
    UserController create(Integer callerId, String signature);
}

interface MessageService {
    void sendMessage(String message);
}

class EmailService implements MessageService {
    @Override
    public void sendMessage(String message) {
        System.out.println(message);
    }
}

class BasicModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(MessageService.class).to(EmailService.class);
        install(new FactoryModuleBuilder().build(CallerFactory.class));
    }
}

class UserController {
    private MessageService messageService;
    private Integer callerId;
    private String signature;

    @Inject
    public UserController(@Assisted Integer callerId, @Assisted String signature, MessageService messageService) {
        this.messageService = messageService;
        this.callerId = callerId;
        this.signature = signature;
    }

    public void send() {
        messageService.sendMessage("CallerId " + callerId + ": Assisted Inject example by " + signature);
    }
}

public class AssistedInjectExample {
    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new BasicModule());

        CallerFactory callerFactory = injector.getInstance(CallerFactory.class);
        UserController userController = callerFactory.create(1, "gpcoder.com");
        userController.send();
    }
}
