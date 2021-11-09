package ru.job4j.oop;

public class Builder extends Engineer {
    int house;

    public Builder(String name, String surname, String education, String birthday, boolean certificated, int house) {
        super(name, surname, education, birthday, certificated);
        this.house = house;
    }

    public void build() {
    }
}
