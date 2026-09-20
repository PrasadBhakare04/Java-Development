package com.prasad;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        User u1 = new User();
        u1.setUid(102);
        u1.setUname("Doe");
        u1.setTech("Python");

        //hey hibernate save the user u1

        Configuration config = new Configuration();
        config.addAnnotatedClass(com.prasad.User.class);
        config.configure();

        SessionFactory factory = config.buildSessionFactory();

        Session session = factory.openSession();

        session.persist(u1);

        Transaction transaction = session.beginTransaction();
        transaction.commit();

    }
}
