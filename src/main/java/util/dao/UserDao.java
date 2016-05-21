package util.dao;

import objects.User;

import java.util.List;

/**
 * Created by Jager on 17.05.2016.
 */
public interface UserDao {
    void addUser(User user);
    void deleteUser(int id);
    void updateUser(User user);
    List<User> getAllUsers();
    List<User> getUsersByName(String name);
    User getUserById(int id);
}
