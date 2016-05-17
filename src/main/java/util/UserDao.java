package util;

import objects.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nz on 17.05.16.
 */
public class UserDao {
    public static void addUser(User user)
    {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession())
        {
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        }
        catch (RuntimeException e)
        {
            if(transaction != null)
            {
                transaction.rollback();
            }
        }
    }

    public static void deleteUser(int id)
    {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession())
        {
            transaction = session.beginTransaction();
            User user = session.load(User.class, new Integer(id));
            session.delete(user);
            session.getTransaction().commit();
        }
        catch (RuntimeException e)
        {
            if(transaction != null)
            {
                transaction.rollback();
            }
        }
    }

    public static void updateUser(User user)
    {
        int id = user.getId();
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession())
        {
            transaction = session.beginTransaction();
          //  session.load(User.class, new Integer(id));
            session.update(user);
            session.getTransaction().commit();
        }
        catch (RuntimeException e)
        {
            if(transaction != null)
            {
                transaction.rollback();
            }
        }
    }

    public static List<User> getAllUsers()
    {
        List<User> allUsers = new ArrayList<>();
        try (Session session = HibernateUtil.getSessionFactory().openSession())
        {
            allUsers = session.createQuery("from User").list();
        }
        catch (RuntimeException e)
        {
            e.printStackTrace();
        }
        return allUsers;
    }

    public static User getUserById(int id)
    {
        try (Session session = HibernateUtil.getSessionFactory().openSession())
        {
            return (User) session.createQuery("from User where id = " + id).uniqueResult();
        }
        catch (RuntimeException e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
