package com.hibernate.onetoone_bidirectional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave04 {
    public static void main(String[] args) {
        Student04 student1 = new Student04();
        student1.setId(1);
        student1.setName("olcay");
        student1.setGrade(70);

        Student04 student2 = new Student04();
        student2.setId(2);
        student2.setName("simge");
        student2.setGrade(70);

        Student04 student3= new Student04();
        student3.setId(3);
        student3.setName("onur");
        student3.setGrade(70);

        Diary04 diary1 = new Diary04();
        diary1.setId(101);
        diary1.setName("olcayın günlüğü");
        diary1.setStudent(student1);

        Diary04 diary2 = new Diary04();
        diary2.setId(102);
        diary2.setName("simgenin günlüğü");
        diary2.setStudent(student2);

        Diary04 diary3 = new Diary04();
        diary3.setId(103);
        diary3.setName("sahipsiz");

        Configuration con = new Configuration();
        con.configure("hibernate.cfg.xml");
        con.addAnnotatedClass(Student04.class);
        con.addAnnotatedClass(Diary04.class);
        SessionFactory sessionFactory = con.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(student1);
        session.save(student2);
        session.save(student3);

        session.save(diary1);
        session.save(diary2);
        session.save(diary3);

        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
