package com.gpcoder.patterns.behavioral.templatemethod.game;

public class Chess extends Game{
    @Override
    protected void initialize() {
        System.out.println("Chess Game initialized! Start playing.");
    }

    @Override
    protected void start() {
        System.out.println("Game started. Welcome to in the chess game!");
    }

    @Override
    protected void end() {
        System.out.println("Game Finished!");
    }
}
