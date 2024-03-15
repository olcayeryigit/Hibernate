package com.hibernate.onetyomany_bidirectional;
import com.hibernate.onetyomany_unidirectional.Student06;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave07 {
    public static void main(String[] args) {

        Student07 student1 = new Student07();
        student1.setId(1);
        student1.setName("olcay");
        student1.setGrade(50);

        Student07 student2 = new Student07();
        student2.setId(2);
        student2.setName("simge");
        student2.setGrade(60);

        Student07 student3 = new Student07();
        student3.setId(3);
        student3.setName("ahmet");
        student3.setGrade(70);

        Book07 book1 = new Book07();
        book1.setId(101);
        book1.setName("Olcayın Türkçe Kitabı");

        Book07 book2 = new Book07();
        book2.setId(102);
        book2.setName("Olcayın Matematik Kitabı");

        Book07 book3= new Book07();
        book3.setId(103);
        book3.setName("Simgenin Matematik Kitabı");

        Book07 book4 = new Book07();
        book4.setId(104);
        book4.setName("Ahmetin Türkçe Kitabı");

        Book07 book5 = new Book07();
        book5.setId(105);
        book5.setName("Ahmetin Matematik Kitabı");

        book1.setStudent(student1);
        book2.setStudent(student1);
        book3.setStudent(student2);
        book4.setStudent(student3);
        book5.setStudent(student3);

        Configuration con = new Configuration();
        con.configure("hibernate.cfg.xml");
        con.addAnnotatedClass(Student07.class);
        con.addAnnotatedClass(Book07.class);
        SessionFactory sessionFactory = con.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(student1);
        session.save(student2);
        session.save(student3);

        session.save(book1);
        session.save(book2);
        session.save(book3);
        session.save(book4);
        session.save(book5);

        transaction.commit();
        session.close();
        sessionFactory.close();

    }
}
