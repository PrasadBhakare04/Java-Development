package com.prasad;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    static SessionFactory factory = new Configuration().addAnnotatedClass(com.prasad.User.class).configure().buildSessionFactory();
    static Session session = factory.openSession();

    static void main() {
        User u1 = new User();
        u1.setUid(104);
        u1.setUname("Zoro");
        u1.setTech("Dev Ops");

        saveUser(u1);
//        getUser(101);
//        updateUser(u1);
//        deleteUser(u1);
    }

    //hey hibernate save the user u1
    //Save the data
    //persist directly runs insert into query
    public static void saveUser(User u){
        //We need transaction when we are making changes in the table
        Transaction transaction = session.getTransaction();
        transaction.begin();

        session.persist(u);
        transaction.commit();

        session.close();
        factory.close();
    }

    //Retrieving the data from database
    public static void getUser(int id){
        //For fetching the data we don't need transaction

        User u = session.find(User.class,  id);
        session.close();
        factory.close();
        System.out.print(u.getUname());
    }

    //Update the user in database
    //this will update if present and insert if the data is not there
    //merge runs select first to check what is the condition
    public static void updateUser(User u){
        Transaction transaction = session.getTransaction();
        transaction.begin();

        session.merge(u);

        transaction.commit();
        session.close();
        factory.close();
    }

    //Delete the user
    //remove runs select first and then delete
    public static void deleteUser(User u){
        Transaction transaction = session.getTransaction();
        transaction.begin();

        session.remove(u);

        transaction.commit();

        session.close();
        factory.close();
    }
}
