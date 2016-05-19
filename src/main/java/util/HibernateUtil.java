package util;

import objects.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nz on 16.05.16.
 */
public class HibernateUtil {
    public static final SessionFactory sessionFactory;
    static
    {
        try
        {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        }
        catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed  " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void create(User user)
    {
        Session session = sessionFactory.openSession();

        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();

        session.close();
    }

    public static void update(User user)
    {
        Session session = sessionFactory.openSession();

        session.update(user);
        session.getTransaction().commit();

        session.close();
    }

    public static List<User> readAll()
    {
        return read("");
    }

    public static List<User> read(String where)
    {
        Session session = sessionFactory.openSession();
        List<User> listUsers = new ArrayList<User>(session.createQuery("from User ".concat(where)).list());
        session.close();
        return listUsers;
    }

    public static void delete(String param, String value)
    {
        if(param.equals("name"))
        {
            value = "'" + value + "'";
        }
        String query = "DELETE FROM User WHERE ".concat(param).concat(" = ").concat(value);
        executeQuery(query);

    }

    public static void executeQuery(String query)
    {
        Session session = sessionFactory.openSession();
        Query sessionQuery = session.createQuery(query);
        sessionQuery.executeUpdate();
        session.flush();
        session.close();
    }
}
