package com.gpcoder.patterns.behavioral.state.trafficlight;

public class TrafficLightContext {
    private State red;
    private State yellow;
    private State green;
    private State state;

    public TrafficLightContext() {
        red = new RedTrafficLightState(this);
        yellow = new YellowTrafficLightState(this);
        green = new GreenTrafficLightState(this);

        state = red;
    }

    public void changeState() {
        state.handleRequest();
    }

    @Override
    public String toString() {
        return state.toString();
    }

    public State getRedLightState() {
        return red;
    }

    public State getYellowLightState() {
        return yellow;
    }

    public State getGreenLightState() {
        return green;
    }

    public void setState(State state) {
        this.state = state;
    }
}