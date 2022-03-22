package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
private final Map<User, List<Account>> users = new HashMap<>();

   public void addUser(User user) {
    if (!users.containsKey(user.getPassport())) {
        users.put(user, new ArrayList<>());
    }
   }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        List<Account> accounts = users.get(user);
        if (user != null && !accounts.contains(account)) {
            accounts.add(account);
            users.put(user, accounts);
        }
    }

    public User findByPassport(String passport) {
        User user = null;
        for (User each : users.keySet()) {
            if (each.getPassport().equals(passport)) {
                user = each;
                break;
            }
        }
        return user;
    }

    public Account findByRequisite(String passport, String requisite) {
       Account account = null;
       User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            for (Account each : accounts) {
                if (each.getRequisite().equals(requisite)) {
                    account = each;
                }
            }
        }
        return account;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                          String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        User srcUser = findByPassport(srcPassport);
        User destUser = findByPassport(destPassport);
        List<Account> srcAccounts = users.get(srcUser);
        List<Account> destAccounts = users.get(destUser);
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount != null
                && srcAccount.getBalance() >= amount) {
            srcAccounts.set(
                    srcAccounts.indexOf(srcAccount),
                    new Account(srcRequisite, srcAccount.getBalance() - amount));
            users.put(srcUser, srcAccounts);
            destAccounts.set(
                    destAccounts.indexOf(destAccount),
                    new Account(destRequisite, destAccount.getBalance() + amount)
            );
            users.put(destUser, destAccounts);
            rsl = true;
        }
        return rsl;
    }
}
