package ohtu.services;

import ohtu.domain.User;
import java.util.ArrayList;
import java.util.List;
import ohtu.data_access.UserDao;

import static java.lang.Character.isLetter;

public class AuthenticationService {

    private UserDao userDao;

    public AuthenticationService(UserDao userDao) {
        this.userDao = userDao;
    }

    public boolean logIn(String username, String password) {
        for (User user : userDao.listAll()) {
            if (user.getUsername().equals(username)
                    && user.getPassword().equals(password)) {
                return true;
            }
        }

        return false;
    }

    public boolean createUser(String username, String password) {
        if (userDao.findByName(username) != null) {
            return false;
        }

        if (invalid(username, password)) {
            return false;
        }

        userDao.add(new User(username, password));

        return true;
    }

    private boolean invalid(String username, String password) {
        boolean hasOnlyAlphabets = true;
        char[] chars = password.toCharArray();
        for (char c : chars) {
            if (!(isLetter(c))) {
                hasOnlyAlphabets = false;
            }
        }

        if (username.length() < 3 || password.length() < 8 || hasOnlyAlphabets == true) {
            return true;
        }

        return false;
    }
}
