package web.dao;

import web.model.User;

import java.util.List;

public interface UserDAO {
    List<User> getAllUsers();

    void safeUser(User user);

    User getUser(int id);

    void deleteUser(int id);
}
