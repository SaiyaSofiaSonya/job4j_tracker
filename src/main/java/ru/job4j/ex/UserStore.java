package ru.job4j.ex;

public class UserStore {

    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User rsl = null;
        for (User user: users) {
            if (user.getUsername().equals(login)) {
                rsl =  user;
                break;
            } else {
                throw new UserNotFoundException("Пользователя не найдено");
            }
        }
        return rsl;
    }

    public static boolean validate(User user) throws UserInvalidException {
        boolean rsl;
        if (user.isValid() && user.getUsername().length() < 3) {
            rsl = true;
        } else {
           throw new UserInvalidException("Пользователь не валидный");
        }
        return rsl;
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Petr Arsentev", true)
        };
        try {
            User user = findUser(users, "Petr Arsentev");
            if (validate(user)) {
            System.out.println("This user has an access");
            }
        } catch (UserInvalidException valid) {
            valid.printStackTrace();
        } catch (UserNotFoundException found) {
            found.printStackTrace();
        }
    }
}
