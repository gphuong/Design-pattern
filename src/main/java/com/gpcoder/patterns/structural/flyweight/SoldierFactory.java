package com.gpcoder.patterns.structural.flyweight;

import java.util.HashMap;
import java.util.Map;

public class SoldierFactory {
    private static final Map<String, ISoldier> soldiers = new HashMap<>();

    public SoldierFactory() {
        throw new IllegalStateException();
    }

    public static synchronized ISoldier createSoldier(String name) {
        ISoldier soldier = soldiers.get(name);
        if (soldier == null) {
            waitingForCreateASoldier();
            soldier = new Soldier(name);
            soldiers.put(name, soldier);
        }
        return soldier;
    }

    private static void waitingForCreateASoldier() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static synchronized int getTotalOfSoldiers() {
        return soldiers.size();
    }
}
