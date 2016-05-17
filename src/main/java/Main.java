import objects.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import util.UserDaoInterface;

/**
 * Created by Jager on 18.05.2016.
 */
public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[] { "applicationContext.xml" }, true);
        UserDaoInterface userDao = (UserDaoInterface) context.getBean("dataDao");
        User data1 = new User("Alex", 20, false);
        userDao.addUser(data1);
        User data2 = new User("Bob", 21, false);
        userDao.addUser(data2);
        User data3 = new User("Alice", 19, false);
        userDao.addUser(data3);
        System.out.println(userDao.getAllUsers().size());
    }
}
