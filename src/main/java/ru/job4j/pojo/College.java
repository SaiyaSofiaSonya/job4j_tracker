package ru.job4j.pojo;

public class College {
    public static void main(String[] args) {
    Student student = new Student();
    student.setEntered("01.09.2021");
    student.setGroup("History28");
    student.setName("Ivanov I.I");
    System.out.println(student.getName() + " поступил " + student.getEntered() + " в " + student.getGroup());
    }
}
