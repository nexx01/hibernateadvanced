package com.example.hibernateadvanced;

import com.example.hibernateadvanced.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Set;

@SpringBootApplication
public class ApplicationSortedSet {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = sessionFactory.getCurrentSession();

		try{
			Student tempStudent = new Student("Paul", "Wall", "ps@ss");
			Set<String> images = tempStudent.getImages();
			images.add("photo1.jpg");
			images.add("ahoto4.jpg");
			images.add("photo2.jpg");
			images.add("shoto3.jpg");
			images.add("photo4.jpg");
			images.add("photo4.jpg");
			images.add("photo4.jpg");
			session.beginTransaction();

			System.out.println("Saving the student and images");
			session.persist(tempStudent);

			session.getTransaction().commit();
			System.out.println("Done!");
		} finally {
			session.close();
			sessionFactory.close();
		}


		SpringApplication.run(ApplicationSortedSet.class, args);
	}

}
