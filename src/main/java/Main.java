import objects.User;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import service.UserService;
import service.UserServiceImpl;
import util.UserDao;

/**
 * Created by Jager on 18.05.2016.
 */
public class Main {
    public static void main(String[] args) {
        /*ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[] { "applicationContext.xml" }, true);*/
        try {
            Class.forName("org.hibernate.annotations.common.reflection.java.JavaReflectionManager");
        } catch (ClassNotFoundException e) {
            System.out.println("Не нашли JavaReflectionManger");
            e.printStackTrace();
        }
        FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext("src/main/resources/applicationContext.xml");
        UserDao userDao = (UserDao) context.getBean("userDao");

        User user = userDao.getUserById(6);
        user.setAge(48);
        userDao.updateUser(user);
        User data1 = new User("Alex", 20, false);
        userDao.addUser(data1);

        //Надо использовать бины, а не на прямую объявлять классы
        UserService userService = (UserService) context.getBean("userService");
        userService.addUser(new User("Kirill", 20, false));
                /*while(userDao.getAllUsers().size() > 7)
        {
            userDao.deleteUser(userDao.getAllUsers().size()-1);
        }*/
      /*  User data1 = new User("Alex", 20, false);
        userDao.addUser(data1);
        User data2 = new User("Bob", 21, false);
        userDao.addUser(data2);
        User data3 = new User("Alice", 19, false);
        userDao.addUser(data3);*/
        System.out.println(userDao.getAllUsers().size());
    }
}
