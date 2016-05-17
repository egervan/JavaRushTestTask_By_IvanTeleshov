package util;

import objects.User;

import java.util.List;

/**
 * Created by Jager on 17.05.2016.
 */
public interface UserDaoInterface {
    void addUser(User user);
    void deleteUser(int id);
    void updateUser(User user);
    List<User> getAllUsers();
    User getUserById(int id);
}
