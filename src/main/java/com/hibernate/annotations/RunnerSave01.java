package com.hibernate.annotations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave01 {
    public static void main(String[] args) {

        Student01 student01 = new Student01();
        student01.setId(1001);
        student01.setName("Olcay");
        student01.setGrade(90);


        Student01 student02 = new Student01();
        student02.setId(1002);
        student02.setName("onur");
        student02.setGrade(92);

        Student01 student03 = new Student01();
        student03.setId(1003);
        student03.setName("ahmet");
        student03.setGrade(80);

        Configuration con = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student01.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();

        Transaction tx = session.beginTransaction();


        //INSERT INTO t_student (std_id,std_name,std_grade) VALUES (?,?,?)
        session.save(student01);
        session.save(student02);
        session.save(student03);

        tx.commit();
        session.close();
        sf.close();


    }
}
