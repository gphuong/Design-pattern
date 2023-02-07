package com.gpcoder.patterns.creational.googleguice.binding.constant;

import com.google.inject.*;
import com.google.inject.name.Named;
import com.google.inject.name.Names;

import java.util.Arrays;
import java.util.List;

class SecondModule extends AbstractModule {
    private final List<String> emails = Arrays.asList("email1", "email2");

    @Override
    protected void configure() {
        bind(new TypeLiteral<List<String>>() {
        }).annotatedWith(Names.named("messages")).toInstance(emails);
    }
}

class EmailController {
    private List<String> messages;

    @Inject
    public EmailController(@Named("messages") List<String> messages) {
        this.messages = messages;
    }

    public void send() {
        System.out.println(messages);
    }
}

public class GenericTypeConstantAnnotationBindingExample {
    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new SecondModule());
        EmailController emailController = injector.getInstance(EmailController.class);
        emailController.send();
    }
}
