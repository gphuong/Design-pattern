package com.gpcoder.patterns.behavioral.mediator.trafficlight;

import java.util.Objects;

public class Light {
    enum State {
        ON, OFF
    }

    private String color;
    private LightMediator lightMediator;
    private State currentState;

    public Light(String color, LightMediator lightMediator) {
        this.color = color;
        this.lightMediator = lightMediator;
        this.currentState = State.OFF;
        lightMediator.registerLight(this);
    }

    public void turnOn() {
        this.currentState = State.ON;
        lightMediator.notifyMediator(this);
    }

    public void turnOff(){
        this.currentState = State.OFF;
        lightMediator.notifyMediator(this);
    }

    public String getColor() {
        return color;
    }

    public State getCurrentState() {
        return currentState;
    }

    @Override
    public boolean equals(Object o) {
        if(o==null){
            return false;
        }
        if(this.getClass() != o.getClass()){
            return false;
        }
        Light light = (Light) o;
        return color.equals(light.color);
    }

    @Override
    public int hashCode() {
        return color.hashCode();
    }
}
