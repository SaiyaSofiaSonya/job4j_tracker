package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String right, String left) {
        int rsl = 0;
        for (int i = 0; i < Integer.min(right.length(), left.length()); i++) {
                rsl = Character.compare(right.charAt(i), left.charAt(i));
                if (rsl != 0) {
                    return rsl;
                }
        }
        return  Integer.compare(right.length(), left.length());
    }
}
