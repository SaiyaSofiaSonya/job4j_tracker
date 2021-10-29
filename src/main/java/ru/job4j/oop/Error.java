package ru.job4j.oop;

public class Error {
    private boolean active;
    private int status;
    private String message;

    public Error() {
    }

    public Error(boolean active, int status, String message) {
    this.active = active;
    this.status = status;
    this.message = message;
    }

    public void printInfo() {
        System.out.println("active: " + active);
        System.out.println("status: " + status);
        System.out.println("message: " + message);
    }

    public static void main(String[] args) {
        Error first = new Error();
        Error second = new Error(true, 0, "Message");
        Error third = new Error(false, 1, "No message");
        first.printInfo();
        second.printInfo();
        third.printInfo();
    }
}
