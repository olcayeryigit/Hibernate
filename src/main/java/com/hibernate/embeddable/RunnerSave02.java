package com.hibernate.embeddable;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave02 {
    public static void main(String[] args) {
        Student02 student1 = new Student02();
        Address address1 = new Address();

        student1.setId(1);
        student1.setName("olcay");
        student1.setGrade(90);

        address1.setStreet("Pinar");
        address1.setCity("Bursa");
        address1.setCountry("Turkey");
        address1.setZipCode(16000);
        student1.setAddress(address1);

        Student02 student2 = new Student02();
        Address address2 = new Address();

        student2.setId(2);
        student2.setName("onur");
        student2.setGrade(95);

        address2.setStreet("65.");
        address2.setCity("Sivas");
        address2.setCountry("Turkey");
        address2.setZipCode(58000);
        student2.setAddress(address2);

        Configuration con = new Configuration();
        con.configure("hibernate.cfg.xml");
        con.addAnnotatedClass(Student02.class);
        SessionFactory sessionFactory = con.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(student1);
        session.save(student2);

        transaction.commit();
        sessionFactory.close();
        session.close();
    }
}
