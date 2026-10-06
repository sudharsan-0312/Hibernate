package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

    public static void main(String[] args) {

        Configuration con = new Configuration();

        con.setProperty("hibernate.connection.driver_class",
                "com.mysql.cj.jdbc.Driver");

        con.setProperty("hibernate.connection.url",
                "jdbc:mysql://db01.dbhost.dev:5051/db_44z6gwm7q");

        con.setProperty("hibernate.connection.username",
                "user_44z6gwm7q");

        con.setProperty("hibernate.connection.password",
                "p44z6gwm7q");

        con.setProperty("hibernate.hbm2ddl.auto", "update");
        con.setProperty("hibernate.show_sql", "true");

        con.addAnnotatedClass(StudentApp.class);

        SessionFactory factory = con.buildSessionFactory();
        Session session = factory.openSession();

        // INSERT 4 STUDENTS

        session.beginTransaction();

        session.persist(new StudentApp(6, "Sudharsan",
                "sudharsan@gmail.com", "Information Technology"));

        session.persist(new StudentApp(7, "Karthik",
                "karthik@gmail.com", "Information Technology"));

        session.persist(new StudentApp(8, "Ramanan",
                "ramanan@gmail.com", "Computer Applications"));

        session.persist(new StudentApp(9, "Sanjai",
                "sanjai@gmail.com", "Data Science"));

        session.persist(new StudentApp(10, "Vignesh",
                "vignesh@gmail.com", "Computer Science"));

        session.getTransaction().commit();

        System.out.println("5 Students inserted successfully!");

        // UPDATE 1 STUDENT

        session.beginTransaction();

        StudentApp student = session.get(StudentApp.class, 1);

        student.setCourse("Information Technology");

        session.getTransaction().commit();

        System.out.println("sudhar updated successfully!");

        session.close();
        factory.close();
    }
}