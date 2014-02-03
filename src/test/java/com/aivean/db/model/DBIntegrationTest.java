package com.aivean.db.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.Test;

/**
 * @author <a href="mailto:ivan.zaytsev@webamg.com">Ivan Zaytsev</a>
 *         2014-02-03
 */
@ContextConfiguration(locations = "classpath:spring-context.xml")
public class DBIntegrationTest extends AbstractTransactionalTestNGSpringContextTests {

    @Autowired
    SessionFactory sessionFactory;

    @Test
    public void testPersist() throws Exception {
        Session session = sessionFactory.getCurrentSession();
        Show show = new Show();

        show.setId(1L);
        show.setTitle("Title");
        show.setStatus("wathing");

        session.persist(show);
    }
}
