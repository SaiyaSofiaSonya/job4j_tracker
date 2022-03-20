package ru.job4j.collection;

import ru.job4j.tracker.StubOutput;

import java.util.HashMap;
import java.util.Map;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> names = new HashMap<>();
        names.put("1@mail.ru", "Vasilii Pavlov");
        names.put("2@mail.ru", "Pavel Vasiliev");
        for (Map.Entry<String, String> entry : names.entrySet()) {
            System.out.println(entry.toString());
        }
    }
}
