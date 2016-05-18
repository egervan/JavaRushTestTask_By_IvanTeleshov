package util;

import objects.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
//import org.springframework.orm.hibernate3.HibernateTemplate;
//import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by nz on 17.05.16.
 */
public class UserDaoImpl /*extends HibernateDaoSupport */implements UserDao {

    public UserDaoImpl()
    {

    }
    public void addUser(User user)
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

    public void deleteUser(int id)
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

    public void updateUser(User user)
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

    public List<User> getAllUsers()
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

    public User getUserById(int id)
    {
        try (Session session = HibernateUtil.getSessionFactory().openSession())
        {
            return (User) session.createQuery("from User where id = :id").setInteger("id", id).uniqueResult();
        }
        catch (RuntimeException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    /*@Override
    protected HibernateTemplate createHibernateTemplate(SessionFactory sessionFactory) {
        HibernateTemplate result = super.createHibernateTemplate(sessionFactory);
        result.setAllowCreate(false);
        return result;
    }*/
}
