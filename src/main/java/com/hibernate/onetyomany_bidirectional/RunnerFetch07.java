package com.hibernate.onetyomany_bidirectional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class RunnerFetch07 {
    public static void main(String[] args) {
        Configuration con = new Configuration();
        con.configure("hibernate.cfg.xml");
        con.addAnnotatedClass(Student07.class);
        con.addAnnotatedClass(Book07.class);
        SessionFactory sessionFactory = con.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();


        Student07 student1 = session.get(Student07.class,1);
        student1.getBookList().set(0,null);//kitap listesindeki il kitabı nulla çektik

        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
