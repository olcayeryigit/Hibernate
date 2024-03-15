package com.hibernate.annotations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.loader.custom.sql.SQLCustomQuery;
import org.hibernate.query.Query;
import org.postgresql.core.Field;
import org.postgresql.core.NativeQuery;

import javax.persistence.TypedQuery;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class RunnerFetch01 {

    public static void main(String[] args) {
        Configuration con = new Configuration();
        con.configure("hibernate.cfg.xml");
        con.addAnnotatedClass(Student01.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        //!!! DB den bilgi çekmek için 3 yol :
        // 1) get methodu
        // 2) SQL
        // 3) HQL ( Hibernate Query Language )

        String sql1 = "SELECT std_id FROM t_student01 WHERE std_name='Olcay'";
        Integer olcay_id= (Integer) session.createSQLQuery(sql1).uniqueResult();
        System.out.println(olcay_id);


        String sql2 = "SELECT std_id,grade FROM t_student01 WHERE std_name='Olcay'";
        Object [] objectArr= (Object[]) session.createSQLQuery(sql2).uniqueResult();
        System.out.println(Arrays.toString(objectArr));

        String hql1="SELECT id FROM Student01 WHERE name='Olcay'";
        int olcay_id2=session.createQuery(hql1, Integer.class).uniqueResult();
        System.out.println(olcay_id2);

        String hql3 = "FROM Student01 ORDER BY id DESC";
        List <Student01> list1=session.createQuery(hql3,Student01.class).getResultList();
        for (Student01 w:list1){
            System.out.println(w);
        }
//////ALIAS//////
        String hql2="FROM Student01 s WHERE s.name='Olcay'";
        Student01 student1=session.createQuery(hql2, Student01.class).uniqueResult();
        System.out.println(student1);



    }
}

