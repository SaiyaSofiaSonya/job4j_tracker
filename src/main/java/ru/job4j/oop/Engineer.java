package ru.job4j.oop;

public class Engineer extends Profession {
    boolean certificated;

    public Engineer(String name, String surname, String education, String birthday, boolean certificated) {
        super(name, surname, education, birthday);
        this.certificated = certificated;
    }

    public void makeAProject() {

    }
}
