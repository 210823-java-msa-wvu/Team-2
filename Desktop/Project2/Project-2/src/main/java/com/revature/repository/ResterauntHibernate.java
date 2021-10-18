package com.revature.repository;


import com.revature.beans.Restaurants;
import com.revature.utils.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ResterauntHibernate implements RestaurantRepo {

    private HibernateUtil hu;

    @Autowired
    public ResterauntHibernate(HibernateUtil hu) {
        this.hu = hu;
    }

    @Override
    public Restaurants add(Restaurants restaurants) {
        Session s = hu.getSession();
        Transaction tx = null;

        try {
            tx = s.beginTransaction();
            s.save(restaurants);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (tx != null) tx.rollback();
        } finally {
            s.close();
        }
        return restaurants;

    }
    @Override
    public Restaurants getById(Integer id) {

        Session s = hu.getSession();
        Restaurants restaurants = s.get(Restaurants.class, id);
        s.close();
        return restaurants;
    }
    @Override
    public List<Restaurants> getAll() {
        List<Restaurants> restaurants;

        try (Session s = hu.getSession()) {
            Query q = s.createQuery("from Restaurants", Restaurants.class);
            restaurants = q.getResultList();

            return restaurants;
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public void update(Restaurants restaurants) {
        Session s = hu.getSession();
        Transaction tx = null;
        try {
            tx = s.beginTransaction();
            s.update(restaurants);
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

            Restaurants restaurants = this.getById(id);

            if (restaurants != null) {
                s.delete(restaurants);
                tx.commit();
            }

        } catch (HibernateException e) {
            e.printStackTrace();
            if (tx != null)
                tx.rollback();
        }
    }

}
