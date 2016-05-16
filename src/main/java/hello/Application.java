package hello;

import objects.User;
import org.hibernate.Session;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jager on 15.05.2016.
 */
@Configuration
@ComponentScan
public class Application {

    @Bean
    MessageService mockMessageService() {
        return new MessageService() {
            public String getMessage() {
                return "Hello World!";
            }
        };
    }

    public static void main(String[] args) {
       /* ApplicationContext context =
                new AnnotationConfigApplicationContext(Application.class);
        MessagePrinter printer = context.getBean(MessagePrinter.class);
        printer.printMessage();*/

        Session session = HibernateUtil.getSessionFactory().openSession();
        List<User> queryString = new ArrayList<User>(session.createQuery("from User").list());
        System.out.println(queryString.toString());

    }
}