package com.hibernate.manytomany;

import com.hibernate.manytoone_unidirectional.Student05;
import com.hibernate.manytoone_unidirectional.University;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class RunnerSave08 {
    public static void main(String[] args) {

        Student08 student1 = new Student08();
        student1.setId(1);
        student1.setName("olcay");

        Student08 student2 = new Student08();
        student2.setId(2);
        student2.setName("simge");

        Student08 student3 = new Student08();
        student3.setId(3);
        student3.setName("ahmet");

        Teacher08 teacher1 = new Teacher08();
        teacher1.setId(101);
        teacher1.setName("onur");
        teacher1.setBranch("Tarih");

        Teacher08 teacher2 = new Teacher08();
        teacher2.setId(102);
        teacher2.setName("şeyma");
        teacher2.setBranch("Kimya");

        Teacher08 teacher3 = new Teacher08();
        teacher3.setId(103);
        teacher3.setName("zeynep");
        teacher3.setBranch("Matematik");

        List<Student08> studentList1 = new ArrayList<>();
        studentList1.add(student1);
        studentList1.add(student2);

        List<Student08> studentList2 = new ArrayList<>();
        studentList2.add(student2);
        studentList2.add(student3);

        List<Student08> studentList3 = new ArrayList<>();
        studentList3.add(student1);
        studentList3.add(student3);

        teacher1.setListtStudent(studentList1);
        teacher2.setListtStudent(studentList2);
        teacher3.setListtStudent(studentList3);

        Configuration con = new Configuration();
        con.configure("hibernate.cfg.xml");
        con.addAnnotatedClass(Student08.class);
        con.addAnnotatedClass(Teacher08.class);
        SessionFactory sessionFactory = con.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(teacher1);
        session.save(teacher2);
        session.save(teacher3);

        session.save(student1);
        session.save(student2);
        session.save(student3);

        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
