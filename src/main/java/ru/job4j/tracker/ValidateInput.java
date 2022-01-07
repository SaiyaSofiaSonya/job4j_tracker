package ru.job4j.tracker;

public class ValidateInput implements Input {
    private final Input in;
    private final Output out;

    public ValidateInput(Output out, Input in) {
        this.out = out;
        this.in = in;
    }

    @Override
    public String askStr(String question) {
        return in.askStr(question);
    }

    @Override
    public int askInt(String question) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = in.askInt(question);
                invalid = false;
            } catch (NumberFormatException nbe) {
               out.println("Please enter validate data a gain.");
            }
        } while (invalid);
        return value;
    }
}
