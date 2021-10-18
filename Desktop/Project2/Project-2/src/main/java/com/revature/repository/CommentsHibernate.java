package com.revature.repository;


import com.revature.beans.Comments;
import com.revature.utils.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CommentsHibernate implements CommentsRepo{

    private HibernateUtil hu;

    @Autowired
    public CommentsHibernate(HibernateUtil hu){this.hu = hu;}

    @Override
    public Comments add(Comments comments) {
        Session s = hu.getSession();
        Transaction tx = null;

        try {
            tx = s.beginTransaction();
            s.save(comments);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (tx != null) tx.rollback();
        } finally {
            s.close();
        }
        return comments;

    }
    @Override
    public Comments getById(Integer id) {

        Session s = hu.getSession();
        Comments comments = s.get(Comments.class, id);
        s.close();
        return comments;
    }
    @Override
    public List<Comments> getAll() {
        List<Comments> comments;

        try (Session s = hu.getSession()) {
            Query q = s.createQuery("from Comments", Comments.class);
            comments = q.getResultList();

            return comments;
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public void update(Comments comments) {
        Session s = hu.getSession();
        Transaction tx = null;
        try {
            tx = s.beginTransaction();
            s.update(comments);
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

            Comments comments = this.getById(id);

            if (comments != null) {
                s.delete(comments);
                tx.commit();
            }

        } catch (HibernateException e) {
            e.printStackTrace();
            if (tx != null)
                tx.rollback();
        }
    }


}
