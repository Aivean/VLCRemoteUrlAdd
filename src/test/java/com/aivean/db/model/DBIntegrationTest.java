package com.aivean.db.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:ivan.zaytsev@webamg.com">Ivan Zaytsev</a>
 *         2014-02-03
 */
@TransactionConfiguration(defaultRollback = false)
@ContextConfiguration(locations = "classpath:spring-context.xml")
public class DBIntegrationTest extends AbstractTransactionalTestNGSpringContextTests {

    @Autowired
    SessionFactory sessionFactory;

    @Test
    public void testPersist() throws Exception {
        Session session = sessionFactory.getCurrentSession();
//        Show show = new Show();
//
//        show.setId(1L);
//        show.setTitle("Title");
//        show.setStatus("wathing");
//        session.persist(show);

        Show show = (Show) session.get(Show.class, 1L);
        show.setTitle("title5");

        session.merge(show);

//        show.setTitle("newtitle");
//        session.persist(show);

    }


}
