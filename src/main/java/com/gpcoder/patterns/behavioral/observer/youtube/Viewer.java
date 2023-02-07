package com.gpcoder.patterns.behavioral.observer.youtube;

public class Viewer {
    private YoutubeChanel subscribedChanel;
    private String name;

    public Viewer(String name, YoutubeChanel subscribedChanel) {
        this.subscribedChanel = subscribedChanel;
        this.name = name;
        this.subscribedChanel.subscribe(this);
    }
    public void update(){
        System.out.println(name + ": Chanel " + subscribedChanel.getChanelName() + " has published a video!");
    }
}
