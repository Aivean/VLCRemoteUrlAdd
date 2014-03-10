package com.aivean.db.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by squirrel on 3/10/14.
 */
abstract public class GenDAOImpl<T> implements GenDAO<T>{

    @Autowired
    SessionFactory sessionFactory;

    public void add(T entity) {
    Session session = sessionFactory.getCurrentSession();
    session.saveOrUpdate(entity);

    }

    @Override
    public void delete(T entity) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(entity);
    }

    @Override
    public List<T> findEntities(Query query) {
        List<T> t;
        t = (List<T>) query.list();
        return t;
    }

    @Override
    public T findEntity(Query query) {
        T t;
        t = (T) query.uniqueResult();
        return t;
    }

    @Override
    public List findAll(Class c) {
        T t = null;
        Session session = sessionFactory.getCurrentSession();
        List T = null;
        Query query = session.createQuery("from " + c.getName());
        T = query.list();
        return T;
    }

    @Override
    public T findByID(Class c, Long id) {
        T t = null;
        Session session = sessionFactory.getCurrentSession();
        t = (T) session.get(c, id);
        return t;
    }
}
