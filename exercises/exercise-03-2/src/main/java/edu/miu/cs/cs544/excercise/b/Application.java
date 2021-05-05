package edu.miu.cs.cs544.excercise.b;

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
		sessionFactory = HibernateUtils.getSessionFactory(Arrays.asList(Book.class , Publisher.class));
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
			
			Publisher publisher1=  new Publisher ("Bruke, Publishing");
			Publisher publisher2=  new Publisher ("John, Publishing");
			
			
			Book book1= new Book("123abc", "java", "solomon");
			Book book2= new Book("456cbd", "c#", "kevin");
			Book book3= new Book("768tyu", "javascript", "ryan", new Publisher("Steven Publising"));
			
			
			// save the person
			session.persist(publisher1);
			System.out.println(publisher1 + "persisted to DB");
			
			
			session.persist(publisher2);
			System.out.println(publisher2 + "persisted to DB");
			
			
			session.persist(book1);
			System.out.println(book1 + "persisted to DB");
			
			session.persist(book2);
			System.out.println(book2 + "persisted to DB");
			
			session.persist(book3);
			System.out.println(book3 + "persisted to DB");


			tx.commit();
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
			List<Publisher> publisherList = session.createQuery("from Publisher").list();
			for (Publisher p : publisherList) {
				System.out.println(p);
			}
			
			List<Book> bookList = session.createQuery("from Book").list();
			for (Book b : bookList) {
				System.out.println(b);
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

