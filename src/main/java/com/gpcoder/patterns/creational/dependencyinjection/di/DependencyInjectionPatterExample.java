package com.gpcoder.patterns.creational.dependencyinjection.di;

public class DependencyInjectionPatterExample {
    public static void main(String[] args) {
        MessageService messageService = new EmailService();
        UserController userController = new UserController(messageService);
        userController.send();
    }
}
