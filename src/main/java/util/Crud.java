package util;

import objects.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Created by Jager on 17.05.2016.
 */
public class Crud {
    private static final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
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

    }

    public static User read()
    {
        return null;
    }

    public static void delete(User user)
    {

    }

}
