package com.luv2code.hibernate.demo.config;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudentDemo {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            System.out.println("Creating new Student Object");

            Student tempStudent = new Student("yashwanth", "Tej", "tej092@gmail.com");

            session.beginTransaction();

            System.out.println("Saving the student");

            session.save(tempStudent);

            session.getTransaction().commit();

            System.out.println("Done");
        }
        finally {
            factory.close();
        }

    }
}
