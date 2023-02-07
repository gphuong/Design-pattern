package com.gpcoder.patterns.creational.objectpool.taxi_enhance;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class TaxiPool2 implements TaxiPool {
    private static final long EXPIRED_TIME_IN_MILLISECOND = 1000;
    private static final int NUMBER_OF_TAXI = 4;

    private final List<Taxi> available = Collections.synchronizedList(new ArrayList<>());
    private final List<Taxi> inUse = Collections.synchronizedList(new ArrayList<>());

    private final AtomicInteger count = new AtomicInteger(0);
    private final AtomicBoolean waiting = new AtomicBoolean(false);

    public TaxiPool2() {
        for (int i = 1; i <= NUMBER_OF_TAXI; i++) {
            Taxi taxi = this.createTaxi();
            available.add(taxi);
        }
    }

    private Taxi createTaxi() {
        Taxi taxi = new Taxi("Taxi " + count.incrementAndGet());
        System.out.println(taxi.getName() + " is created");
        return taxi;
    }

    @Override
    public Taxi getTaxi() {
        if (!available.isEmpty()) {
            Taxi taxi = available.remove(0);
            inUse.add(taxi);
            return taxi;
        }
        if (count.get() == NUMBER_OF_TAXI) {
            this.waitingWhenAvailable();
            return this.getTaxi();
        }
        Taxi taxi = this.createTaxi();
        inUse.add(taxi);
        return taxi;
    }

    private void waitingWhenAvailable() {
        if (waiting.get()) {
            waiting.set(false);
            throw new TaxiNotFoundException("No taxi available");
        }
        waiting.set(true);
        try {
            TimeUnit.MILLISECONDS.sleep(EXPIRED_TIME_IN_MILLISECOND);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void release(Taxi taxi) {
        inUse.remove(taxi);
        available.add(taxi);
        System.out.println(taxi.getName() + " is free");
    }
}
