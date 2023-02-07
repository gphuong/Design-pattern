package com.gpcoder.patterns.behavioral.nullobject.persistence.nullobject;

import com.gpcoder.patterns.behavioral.nullobject.persistence.Persistence;

public class EmptyPersistence implements Persistence {
    private static Persistence persistence;

    public static Persistence getInstance(){
        if(persistence==null){
            persistence = new EmptyPersistence();
        }
        return persistence;
    }

    public EmptyPersistence() {
    }

    @Override
    public void delete() {

    }

    @Override
    public void insert(String value) {

    }

    @Override
    public void update(String value) {

    }

    @Override
    public String get() {
        return null;
    }
}
