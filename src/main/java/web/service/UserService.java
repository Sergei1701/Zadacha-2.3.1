package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();

    void safeUser(User user);

    User getUser(int id);

    void deleteUser(int id);
}
