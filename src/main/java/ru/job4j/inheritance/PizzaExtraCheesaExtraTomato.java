package ru.job4j.inheritance;

public class PizzaExtraCheesaExtraTomato extends PizzaExtraCheese {
    public String name() {
        return super.name() + " + extra tomato";
    }
}
