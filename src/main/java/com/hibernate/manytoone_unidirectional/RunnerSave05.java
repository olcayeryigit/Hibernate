package com.hibernate.manytoone_unidirectional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave05 {
    public static void main(String[] args) {

        University university1 = new University();
        university1.setId(101);
        university1.setName("Cumhuriyet Üniversitesi");

        University university2 = new University();
        university2.setId(102);
        university2.setName("Anadolu Üniversitesi");

        Student05 student1 = new Student05();
        student1.setId(1);
        student1.setName("olcay");
        student1.setUniversity(university1);

        Student05 student2 = new Student05();
        student2.setId(2);
        student2.setName("simge");
        student2.setUniversity(university2);

        Student05 student3 = new Student05();
        student3.setId(3);
        student3.setName("ahmet");
        student3.setUniversity(university1);

        Configuration con = new Configuration();
        con.configure("hibernate.cfg.xml");
        con.addAnnotatedClass(Student05.class);
        con.addAnnotatedClass(University.class);
        SessionFactory sessionFactory = con.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(university1);
        session.save(university2);
        session.save(student1);
        session.save(student2);
        session.save(student3);


        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
