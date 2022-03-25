package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает модель данных юзера
 * @author Natalia Grigoreva
 */
public class User {
    /**
     * хранение номера паспорта осуществляется в поле passport
     * хранение имени пользователя в поле username
     */
    private String passport;
    private String username;

    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * Метод позволяет получить номер поспорта
     * @return возвращает номер поспорта или null, если номер паспорта пустой
     */
    public String getPassport() {
        return passport;
    }

    /**
     * Метод позволяет присвоить номер поспорта
     * @param passport номер паспорта
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * Метод позволяет получить имя пользователя
     * @return возвращает имя пользователя или null, если имя пустое
     */
    public String getUsername() {
        return username;
    }

    /**
     * Метод позволяет присвоить имя пользователя
     * @param username  имя пользователя
     */
    public void setUsername(String username) {
        this.username = username;
    }


    /**
     * Переопределенный метод класса Object
     * Метод принимает на вход Object o, проверяет, что он совпадает с текущим объектом
     * по полю requisite
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    /**
     * Переопределенный метода класса Object
     * Метод возращает hash - код объекта, сгенерированному по полю requisite
     * return возвращает hash - код объекта, сгенерированному по полю requisite
     */
    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}
