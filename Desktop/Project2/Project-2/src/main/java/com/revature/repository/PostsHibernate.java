package com.revature.repository;

import com.revature.beans.Posts;
import com.revature.utils.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PostsHibernate implements PostsRepo{

    private HibernateUtil hu;

    @Autowired
    public PostsHibernate(HibernateUtil hu) {
        this.hu = hu;
    }

    @Override
    public Posts add(Posts posts) {
        Session s = hu.getSession();
        Transaction tx = null;

        try {
            tx = s.beginTransaction();
            s.save(posts);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (tx != null) tx.rollback();
        } finally {
            s.close();
        }
        return posts;

    }
    @Override
    public Posts getById(Integer id) {

        Session s = hu.getSession();
        Posts posts = s.get(Posts.class, id);
        s.close();
        return posts;
    }
    @Override
    public List<Posts> getAll() {
        List<Posts> posts;

        try (Session s = hu.getSession()) {
            Query q = s.createQuery("from Posts", Posts.class);
            posts = q.getResultList();

            return posts;
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public void update(Posts posts) {
        Session s = hu.getSession();
        Transaction tx = null;
        try {
            tx = s.beginTransaction();
            s.update(posts);
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

            Posts posts = this.getById(id);

            if (posts != null) {
                s.delete(posts);
                tx.commit();
            }

        } catch (HibernateException e) {
            e.printStackTrace();
            if (tx != null)
                tx.rollback();
        }
    }


}
