package ru.job4j.oop;

public class Surgeon extends Doctor {
    private int experience;

    public Surgeon(
            String name, String surname, String education,
            String birthday, String graduated, int experience) {
        super(name, surname, education, birthday, graduated);
        this.experience = experience;
    }

    public void operateOn() {

    }
}
