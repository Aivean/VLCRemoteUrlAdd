package com.aivean.db.model;

import org.hibernate.Query;
import java.io.Serializable;
import java.util.List;

/**
 * Created by squirrel on 3/10/14.
 */
public interface GenDAO<T> {
    public void add(T entity);

    public void delete(T entity);

    public List<T> findEntities(Query query);

    public T findEntity(Query query);

    public List findAll(Class c);

    public T findByID(Class c, Long id);

}
