package com.gpcoder.patterns.creational.googleguice.binding.override.module_v3;

import com.google.inject.AbstractModule;
import com.gpcoder.patterns.creational.googleguice.binding.override.base_service.ConcreteA;
import com.gpcoder.patterns.creational.googleguice.binding.override.base_service.ServiceA;

public class BaseModule2 extends AbstractModule {
    @Override
    protected void configure() {
        bind(ServiceA.class).to(ConcreteA.class);
    }
}
