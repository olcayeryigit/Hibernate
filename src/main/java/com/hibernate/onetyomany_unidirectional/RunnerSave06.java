package com.hibernate.onetyomany_unidirectional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class RunnerSave06 {
    public static void main(String[] args) {

        Book06 book1 = new Book06();
        book1.setId(101);
        book1.setName("Suç ve Ceza");

        Book06 book2 = new Book06();
        book2.setId(102);
        book2.setName("Fareler ve İnsanlar");

        Book06 book3 = new Book06();
        book3.setId(103);
        book3.setName("Hayvan Çiftliği");

        Student06 student1 = new Student06();
        student1.setId(1);
        student1.setName("olcay");
        student1.setGrade(80);
        List<Book06> bookList1 = student1.getBookList();
        bookList1.add(book1);
        bookList1.add(book2);
        student1.setBookList(bookList1);

        Student06 student2 = new Student06();
        student2.setId(2);
        student2.setName("simge");
        student2.setGrade(100);
        List<Book06> bookList2 = student2.getBookList();
        bookList2.add(book1);
        bookList1.add(book2);
        bookList2.add(book3);
        student2.setBookList(bookList2);

        Configuration con = new Configuration();
        con.configure("hibernate.cfg.xml");
        con.addAnnotatedClass(Student06.class);
        con.addAnnotatedClass(Book06.class);
        SessionFactory sessionFactory = con.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();


        session.save(book1);
        session.save(book2);
        session.save(book3);

        session.save(student1);
        session.save(student2);

        transaction.commit();
        session.close();
        sessionFactory.close();

    }
}
