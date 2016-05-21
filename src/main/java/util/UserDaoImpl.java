package util;

import objects.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by nz on 17.05.16.
 */
@Repository
public class UserDaoImpl /*extends HibernateDaoSupport */implements UserDao {

    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addUser(User user)
    {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession())
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

    @Override
    public void deleteUser(int id)
    {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession())
        {
            transaction = session.beginTransaction();
            User user = session.load(User.class, id);
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

    @Override
    public void updateUser(User user)
    {
        int id = user.getId();
        Transaction transaction = null;

        try (Session session = sessionFactory.openSession())
        {
            transaction = session.beginTransaction();
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

    @Override
    public List<User> getAllUsers()
    {
        List<User> allUsers = new ArrayList<>();
        try (Session session = sessionFactory.openSession())
        {
            allUsers = session.createQuery("from User").list();
        }
        catch (RuntimeException e)
        {
            e.printStackTrace();
        }
        return allUsers;
    }

    @Override
    public User getUserById(int id)
    {
        try (Session session = sessionFactory.openSession())
        {
            return (User) session.createQuery("from User where id = :id").setInteger("id", id).uniqueResult();
        }
        catch (RuntimeException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<User> getUsersByName(String requestName) {
        List<User> users = new ArrayList<>();
        try (Session session = sessionFactory.openSession())
        {
            users.addAll(session.createQuery("from User where name = :requestName").setString("requestName", requestName).list());
        }
        catch (RuntimeException e)
        {
            e.printStackTrace();
        }
        return users;
    }
}
