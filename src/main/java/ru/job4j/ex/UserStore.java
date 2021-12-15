package ru.job4j.ex;

public class UserStore {

    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User rsl = null;
        for (User user: users) {
            if (user.getUsername().equals(login)) {
                rsl =  user;
                break;
            }
        }
        if (rsl == null) {
            throw new UserNotFoundException("Пользователь не найден");
        }
       return rsl;
    }

    public static boolean validate(User user) throws UserInvalidException {
        boolean rsl = true;
        if (!user.isValid() || user.getUsername().length() < 3) {
            rsl = false;
            throw new UserInvalidException("Пользователь не валидный");
        }
        return rsl;
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Pe", true)
        };
        try {
            User user = findUser(users, "Pe");
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
