package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает логику работы банковского сервиса:
 * добавление пользователя, счета
 * поиск по номеру счета, имени пользователя
 * перевод со счета на счет
 * @author Natalia Grigoreva
 */
public class BankService {
    /**
     * хранение справочника пользователь, счета осуществляет в коллекции HashMap
     * Ключом является объект User
     * Значением - счета каждого пользователя, записанные в коллекцию ArrayList
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод принимает на вход объект пользователя
     * и добавляет пользователя, и пустую коллекцию счетов ArrayList справочник users
     * Если пользователь существует не добавляет ничего.
     * @param user имя пользователя
     */
    public void addUser(User user) {
    users.putIfAbsent(user, new ArrayList<>());
   }

    /**
     * Метод принимает на вход номер паспорта, и объект Account.
     * Добавляет новый счет в коллекцию accounts
     * Если пользователь не существует, или такой счет уже есть не добавляет ничего
     * @param passport номер пасспорта
     * @param account объект счета
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
        List<Account> accounts = users.get(user);
        if (!accounts.contains(account)) {
            accounts.add(account);
        }
    }
   }

    /**
     * Метод принимает на вход номер паспорта
     * возвращает объект User или null, если такого юзера не существует.
     * @param passport номер пасспорта
     * @return возвращает объект User
     */
    public User findByPassport(String passport) {
        return users
                .keySet()
                .stream()
                .filter(e -> e.getPassport().equals(passport))
                .findFirst()
                .orElse(null);
    }

    /**
     * Метод принимает на вход номер паспорта и номер счета
     * возвращает объект Account или null, если такого пользователя или счета не существует
     * @param passport номер пасспорта
     * @param requisite номер счета
     * @return возвращает объект Account или null, если такого пользователя или счета не существует
     */
    public Account findByRequisite(String passport, String requisite) {
        Account account = null;
        User user = findByPassport(passport);
        if (user != null) {
            return users
                    .get(user)
                    .stream()
                    .filter(e -> e.getRequisite().equals(requisite))
                    .findFirst()
                    .orElse(null);
        }
        return null;
    }

    /**
     * Метод на вход принимает номер паспорта и номер счета для источника и цели.
     * Метод возвращает true, если счет - источника и цели не равен нулю,
     * и на счете - источнике достаточно средств для перевода.
     * Если хотя бы одно из условий не соблюдается, то возвращает false.
     * При переводе баланс счета источника уменьшается на amount
     * @param srcPassport номер паспорта юзера, со счета которого будет перевод
     * @param srcRequisite номер счета, с которого будет перевод
     * @param destPassport номер паспорта юзера, на счет которого будет перевод
     * @param destRequisite номер счета, на который будет перевод
     * @param amount сумма перевода
     * @return возвращает true или false
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                          String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount != null
                && destAccount != null
                && srcAccount.getBalance() >= amount) {
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            destAccount.setBalance(destAccount.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}
