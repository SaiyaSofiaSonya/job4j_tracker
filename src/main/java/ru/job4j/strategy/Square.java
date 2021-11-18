package ru.job4j.strategy;

import org.w3c.dom.ls.LSOutput;

public class Square implements Shape{
    @Override
    public String draw() {
        String ln = System.lineSeparator();
        return  " _______ " +
                "|       |" + ln +
                "|       |" + ln +
                "|_______|" + ln;
    }
}