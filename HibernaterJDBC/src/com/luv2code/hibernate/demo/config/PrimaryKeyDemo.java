package com.luv2code.hibernate.demo.config;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            System.out.println("Creating 3 student objects...");
            Student tempStudent1 = new Student("Sai", "Teja", "teja@gmail.com");
            Student tempStudent2 = new Student("Pa", "Rahul", "rahul@gmail.com");
            Student tempStudent3 = new Student("Sharath", "Nair", "sharath@gmail.com");

            // start a transaction
            session.beginTransaction();

            // save the student object
            System.out.println("Saving the students...");
            session.save(tempStudent1);
            session.save(tempStudent2);
            session.save(tempStudent3);

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        }
        finally {
            factory.close();
        }


    }

}