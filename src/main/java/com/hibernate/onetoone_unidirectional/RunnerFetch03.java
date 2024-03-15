package com.hibernate.onetoone_unidirectional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch03 {
    public static void main(String[] args) {
        Configuration con = new Configuration();
        con.configure("hibernate.cfg.xml");
        con.addAnnotatedClass(Student03.class);
        con.addAnnotatedClass(Diary.class);
        SessionFactory sessionFactory = con.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();


        Diary diary=session.get(Diary.class,101);
        System.out.println(diary);

        System.out.println("----------");

        System.out.println(diary.getStudent());

        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
