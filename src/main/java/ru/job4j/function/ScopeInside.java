package ru.job4j.function;

import java.util.function.Supplier;

public class ScopeInside {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3};
        int total1 = 0;
        for (int number : numbers) {
            int total = total1;
            total1 = add(
                () -> total + number
            );
            System.out.println(total1);
        }
    }

    private static Integer add(Supplier<Integer> calc) {
        return calc.get();
    }
}
