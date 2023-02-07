package com.gpcoder.patterns.creational.objectpool.taxi_enhance;

public interface TaxiPool {
    Taxi getTaxi();

    void release(Taxi taxi);
}
