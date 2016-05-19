package service;

import objects.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by nz on 18.05.16.
 */
public interface UserService {
    void addUser(User user);
    void deleteUser(int id);
    void updateUser(User user);
    List<User> getAllUsers();
    User getUserById(int id);
}
