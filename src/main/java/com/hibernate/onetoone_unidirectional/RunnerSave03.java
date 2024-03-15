package com.hibernate.onetoone_unidirectional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave03 {
    public static void main(String[] args) {
        Student03 student1 = new Student03();
        student1.setId(1);
        student1.setName("olcay");
        student1.setGrade(50);

        Student03 student2 = new Student03();
        student2.setId(2);
        student2.setName("simge");
        student2.setGrade(60);

        Student03 student3 = new Student03();
        student3.setId(3);
        student3.setName("ahmet");
        student3.setGrade(70);

        Diary diary1 = new Diary();
        diary1.setId(101);
        diary1.setName("olcayın günlüğü");
        diary1.setStudent(student1);

        Diary diary2 = new Diary();
        diary2.setId(102);
        diary2.setName("simgenin günlüğü");
        diary2.setStudent(student2);

        Configuration con = new Configuration();
        con.configure("hibernate.cfg.xml");
        con.addAnnotatedClass(Student03.class);
        con.addAnnotatedClass(Diary.class);
        SessionFactory sessionFactory = con.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();


        session.save(student1);
        session.save(student2);
        session.save(student3);

        session.save(diary1);
        session.save(diary2);

        transaction.commit();
        session.close();
        sessionFactory.close();


    }
}
