package com.hibernate.embeddable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch02 {
    public static void main(String[] args) {
        Configuration con = new Configuration();
        con.configure("hibernate.cfg.xml");
        con.addAnnotatedClass(Student02.class);
        SessionFactory sessionFactory = con.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();


        Student02 student1 = session.get(Student02.class, 1);
        System.out.println(student1);

        System.out.println(student1.getAddress());


        transaction.commit();
        session.close();
        sessionFactory.close();

    }
}
