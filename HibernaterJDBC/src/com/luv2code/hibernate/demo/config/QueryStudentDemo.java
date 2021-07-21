package com.luv2code.hibernate.demo.config;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            session.beginTransaction();

            List theStudents = session.createQuery("from Student").getResultList();

            displayStudents(theStudents);

            // query students: lastName='Sai'
            theStudents = session.createQuery("from Student s where s.lastName='Sai'").getResultList();


            System.out.println("\n\nStudents who have last name of Doe");
            displayStudents(theStudents);

            // query students: lastName='Sai' OR firstName='Sai'
            theStudents =  session.createQuery("from Student s where s.lastName='Sai' OR s.firstName='Sai'").getResultList();

            System.out.println("\n\nStudents who have last name of Doe OR first name Daffy");
            displayStudents(theStudents);

            // query students where email LIKE '%gmail.com'
            theStudents = session.createQuery("from Student s where s.email LIKE '%gmail.com'").getResultList();

            System.out.println("\n\nStudents whose email ends with gmail.com");
            displayStudents(theStudents);

            session.getTransaction().commit();

            System.out.println("Done!");
        }
        finally {
            factory.close();
        }
    }

    private static void displayStudents(List<Student> theStudents) {
        for (Student tempStudent : theStudents) {
            System.out.println(tempStudent);
        }
    }

}
