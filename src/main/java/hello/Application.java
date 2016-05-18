package hello;

import objects.User;
import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import util.HibernateUtil;
import util.UserDaoImpl;

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
        ApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
        MessagePrinter printer = context.getBean(MessagePrinter.class);
        printer.printMessage();

        String result = HibernateUtil.readAll().toString();
        System.out.println(result);
        System.out.println(new UserDaoImpl().getUserById(1));
        /*User user = new User();
        user.setId(0);
        HibernateUtil.delete("name", "Alexei");
        System.out.println("Finish");*/

    }
}