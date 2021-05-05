package edu.miu.cs.cs544.excercise.c;

import java.util.Arrays;import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import edu.miu.cs.cs544.examples.HibernateUtils;

public class Application {

	
private static final SessionFactory sessionFactory;
	
	static {
		// If there is more than one entity, you will have to pass them as a comma delimited argument list to the method below
		sessionFactory = HibernateUtils.getSessionFactory(Arrays.asList(Student.class , Course.class));
	}

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// Hibernate placeholders
		Session session = null;
		Transaction tx = null;
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			
			// Create new instance of Employee and set values in it
			
			
			Course course1 = new Course("vb12", "EA");
			Course course2 = new Course("kt24", "WAP");
			Course course3 = new Course("jc67", "Algorithms");
			
			//public Student(String studentId, String firstName, String lastName, List<Course> courses) {
			
			
			
			Student student1= new Student("st123", "Bruke", "Abebe");
			Student student2= new Student("st234", "Abinet", "Yonas");
			Student student3= new Student("st256", "Michael", "Abebe");
			
			student1.addCourse(course3);
			student1.addCourse(course2);
			
			student2.addCourse(course1);
			student3.addCourse(course2);
			
			student3.addCourse(course1);
			
			// save the person
			
			
			session.persist(student1);
			
			
			
			session.persist(student2);
	
			
			session.persist(student3);
		


			tx.commit();
			
			System.out.println(student1 + "persisted to DB");
			System.out.println(student2 + "persisted to DB");
			System.out.println(student3 + "persisted to DB");
			System.out.println(course1 + "persisted to DB");
			System.out.println(course2 + "persisted to DB");
			System.out.println(course3 + "persisted to DB");
		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		
		
		
		
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			// retrieve all persons
			List<Student> studentList = session.createQuery("from Student").list();
			for (Student s : studentList) {
				System.out.println(s);
			}
			
			List<Course> courseList = session.createQuery("from Course").list();
			for (Course c : courseList) {
				System.out.println(c);
			}
			tx.commit();
		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		} 
		finally {
			if (session != null)
				session.close();
		}
		
		// Close the SessionFactory (not mandatory)
		sessionFactory.close();
	}
}

