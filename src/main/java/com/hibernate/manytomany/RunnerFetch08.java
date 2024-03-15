package com.hibernate.manytomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch08 {
    public static void main(String[] args) {
        Configuration con = new Configuration();
        con.configure("hibernate.cfg.xml");
        con.addAnnotatedClass(Student08.class);
        con.addAnnotatedClass(Teacher08.class);
        SessionFactory sessionFactory = con.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Student08 student1 = session.get(Student08.class, 1);
        System.out.println(student1.getListTeacher());

        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
