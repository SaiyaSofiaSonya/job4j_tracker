package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     * @param key Ключ поиска.
     * @return Список подощедщих пользователей.
     */

    public ArrayList<Person> find(String key) {
        Predicate<Person> nameFilter = (person) -> key.equals(person.getName());
        Predicate<Person> surnameFilter = (person) -> key.equals(person.getSurname());
        Predicate<Person> phoneFilter = (person) -> key.equals(person.getPhone());
        Predicate<Person> addressFilter = (person) -> key.equals(person.getAddress());
        Predicate<Person> combine = nameFilter
                .or(surnameFilter
                        .or(phoneFilter
                                .or(addressFilter)));
        ArrayList<Person> result = new ArrayList<>();
        for (Person person: persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
