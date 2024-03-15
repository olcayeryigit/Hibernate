package com.hibernate.manytoone_unidirectional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class RunnerFetch05 {
    public static void main(String[] args) {
        Configuration con = new Configuration();
        con.configure("hibernate.cfg.xml");
        con.addAnnotatedClass(University.class);
        con.addAnnotatedClass(Student05.class);
        SessionFactory sessionFactory = con.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        String hql = "FROM Student05 s WHERE s.university.id=101";
        List<Student05> list = session.createQuery(hql, Student05.class).list();

        list.forEach(System.out::println);

        transaction.commit();
        session.close();
        sessionFactory.close();

    }
}
