package service;

import objects.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import util.UserDao;

import java.util.List;

/**
 * Created by nz on 18.05.16.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    private UserDao userDao;

    @Override
    @Transactional
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    @Transactional
    public void deleteUser(int id) {
        userDao.deleteUser(id);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    @Transactional
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    @Transactional
    public User getUserById(int id) {
        return userDao.getUserById(id);
    }
}
