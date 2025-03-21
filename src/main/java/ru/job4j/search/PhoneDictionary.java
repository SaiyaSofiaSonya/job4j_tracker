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
        Predicate<Person> nameFilter = (person) -> key.contains(person.getName());
        Predicate<Person> surnameFilter = (person) -> key.contains(person.getSurname());
        Predicate<Person> phoneFilter = (person) -> key.contains(person.getPhone());
        Predicate<Person> addressFilter = (person) -> key.contains(person.getAddress());
        Predicate<Person> combine = nameFilter
                .or(surnameFilter
                        .or(phoneFilter
                                .or(addressFilter)));
        ArrayList<Person> result = new ArrayList<>();
        for (var person: persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
