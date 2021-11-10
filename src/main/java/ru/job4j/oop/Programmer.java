package ru.job4j.oop;

public class Programmer extends Engineer {
    private String language;

    public Programmer(
            String name, String surname, String education,
            String birthday, boolean certificated, String language) {
        super(name, surname, education, birthday, certificated);
        this.language = language;
    }

    public void code() {

    }
}
