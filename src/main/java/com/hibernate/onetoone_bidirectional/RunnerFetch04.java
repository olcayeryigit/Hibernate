package com.hibernate.onetoone_bidirectional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class RunnerFetch04 {
    public static void main(String[] args) {

        Configuration con = new Configuration();
        con.configure("hibernate.cfg.xml");
        con.addAnnotatedClass(Student04.class);
        con.addAnnotatedClass(Diary04.class);
        SessionFactory sessionFactory = con.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        //bütün günlükler ve öğrencileri getirelim
        String hql = "SELECT s.name, d.name  FROM Student04 s FULL JOIN FETCH Diary04 d ON s.id=d.student.id";
        List<Object[]> list1 = session.createQuery(hql).getResultList();

        list1.forEach(oa->{
            System.out.println(Arrays.toString(oa));
        });

        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
