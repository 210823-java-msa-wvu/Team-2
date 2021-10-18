package com.revature.repository;


import com.revature.beans.User;
import com.revature.utils.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class UserHibernate implements UserRepo {

    private HibernateUtil hu;

    @Autowired
    public UserHibernate(HibernateUtil hu) {
        this.hu = hu;
    }

    @Override
    public User add(User user) {
        Session s = hu.getSession();
        Transaction tx = null;

        try {
            tx = s.beginTransaction();
            s.save(user);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (tx != null) tx.rollback();
        } finally {
            s.close();
        }
        return user;
    }

    @Override
    public User getById(Integer id) {

        Session s = hu.getSession();
        User u = s.get(User.class, id);
        s.close();
        return u;
    }
    @Override
    public User getByUsername(String username) {
        // Let's use the Criteria Interface
        Session s = hu.getSession();
        User u = null;

        try {

            // Get Criteria Builder from Session
            CriteriaBuilder criteriaBuilder = s.getCriteriaBuilder();

            // Create CriteriaQuery
            CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);

            // Create Root object
            Root<User> root = criteriaQuery.from(User.class);

            // Use Predicates to narrow down our query
            Predicate predicate = criteriaBuilder.equal(root.get("username"), username);
            // you can create multiple predicates (i.e. username AND password)

            // Bringing our Criteria Builder and our Criteria Query together...
            // select * from users where username = ?
            criteriaQuery.select(root).where(predicate); // if using multiple predicates -> .where(cb.and(pred1, pred2)

            // Save that result into an object
            u = s.createQuery(criteriaQuery).getSingleResult();

        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            s.close();
        }

        return u;

    }
    @Override
    public List<User> getAll() {
        List<User> users;

        try (Session s = hu.getSession()) {
            Query q = s.createQuery("from User", User.class);
            users = q.getResultList();

            return users;
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(User user) {
        Session s = hu.getSession();
        Transaction tx = null;
        try {
            tx = s.beginTransaction();
            s.update(user);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
        } finally {
            s.close();
        }
    }

    @Override
    public void delete(int id) {
        Transaction tx = null;

        try (Session s = hu.getSession()) {

            tx = s.beginTransaction();

            User u = this.getById(id);

            if (u != null) {
                s.delete(u);
                tx.commit();
            }

        } catch (HibernateException e) {
            e.printStackTrace();
            if (tx != null)
                tx.rollback();
        }
    }
}
