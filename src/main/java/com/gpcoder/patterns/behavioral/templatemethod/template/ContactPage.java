package com.gpcoder.patterns.behavioral.templatemethod.template;

public class ContactPage extends PageTemplate {
    @Override
    protected void showNavigation() {

    }

    @Override
    protected void showBody() {
        System.out.println("Content of contact page");
    }
}
