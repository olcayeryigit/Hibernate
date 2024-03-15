package com.hibernate.onetyomany_unidirectional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;


public class RunnerFetch06 {
    public static void main(String[] args) {
        Configuration con = new Configuration();
        con.configure("hibernate.cfg.xml");
        con.addAnnotatedClass(Student06.class);
        con.addAnnotatedClass(Book06.class);
        SessionFactory sessionFactory = con.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Student06 student = session.get(Student06.class, 1);
        student.getBookList().forEach(System.out::println);

        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
