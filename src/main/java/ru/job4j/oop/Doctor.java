package ru.job4j.oop;

public class Doctor extends Profession {
    String graduated;

    public Doctor(String name, String surname, String education, String birthday, String graduated) {
        super(name, surname, education, birthday);
        this.graduated = graduated;
    }

    public  void heal(Pacient pacient) {
    }

}
