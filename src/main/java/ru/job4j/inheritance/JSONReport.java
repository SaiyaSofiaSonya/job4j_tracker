package ru.job4j.inheritance;

public class JSONReport {
    public String generate(String name, String body) {
        return   "{"+ System.lineSeparator() + " \"name\"" + " : \"" + name + "\"," + System.lineSeparator() +
                     " \"body\"" + " : \"" +  body+ "\""+ System.lineSeparator() + "}";
    }
}
