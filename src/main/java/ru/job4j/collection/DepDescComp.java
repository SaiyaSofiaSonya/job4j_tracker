package ru.job4j.collection;

import java.util.Comparator;
import java.util.List;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        List<String> o1List = List.of(o1.split("/"));
        List<String> o2List = List.of(o2.split("/"));
        int rsl = o2List.get(0).compareTo(o1List.get(0));
        if (rsl != 0) {
            return rsl;
        }
        for (int i = 1; i < Integer.min(o1List.size(), o2List.size()); i++) {
            rsl = +o1List.get(i).compareTo(o2List.get(i));
            if (rsl != 0) {
                return rsl;
            }
        }
        return  Integer.compare(o1.length(), o2.length());
    }
}
