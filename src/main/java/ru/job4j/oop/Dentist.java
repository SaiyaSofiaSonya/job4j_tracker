package ru.job4j.oop;

public class Dentist extends Doctor {
    private Boolean selfemployed;

    public Dentist(
            String name, String surname, String education,
            String birthday, String graduated, Boolean selfemployed) {
        super(name, surname, education, birthday, graduated);
        this.selfemployed = selfemployed;
    }

    public void treatTheTeeth() {

    }
}

