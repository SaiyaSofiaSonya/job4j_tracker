package ru.job4j.ex;

public class FindEl {
    public  static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        for (int i = 0; i < value.length; i++) {
            if (value[i].equals(key)) {
                rsl = i;
                break;
            }
        }
        if (rsl == -1) {
            throw new ElementNotFoundException("Element is not found!");
        }
        return rsl;
    }

    public static void main(String[] args) {
        String[] value = {"1", "2", "3"};
        try {
           System.out.println(indexOf(value, "1"));
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}
