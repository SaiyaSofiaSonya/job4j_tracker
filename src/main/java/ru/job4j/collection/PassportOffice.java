package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class PassportOffice {
    private HashMap<String, Citizen> citizens = new HashMap<>();

    public boolean add(Citizen citizen) {
        boolean rsl = false;
        if (!citizens.containsKey(citizen.getPassport())) {
            citizens.put(citizen.getPassport(), citizen);
            rsl = true;
        }
        return rsl;
    }

    public Citizen get(String passport) {
        Citizen citizen = null;
        for (Map.Entry<String, Citizen> entry : citizens.entrySet()) {
            if (entry.getKey().equals(passport)) {
                citizen = entry.getValue();
            }
        }
        return citizen;
    }
}
