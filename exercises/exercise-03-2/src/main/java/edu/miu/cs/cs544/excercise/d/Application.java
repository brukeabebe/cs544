package edu.miu.cs.cs544.excercise.d;

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
		sessionFactory = HibernateUtils.getSessionFactory(Arrays.asList(Reservation.class , Customer.class));
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
			
			
			Reservation reservation1=new Reservation (new Date(2012,6,5));
			Reservation reservation2=new Reservation (new Date(2013,7,2));
			Reservation reservation3=new Reservation (new Date(2014,4,2));
			Reservation reservation4=new Reservation (new Date(2015,9,6));
			Reservation reservation5=new Reservation (new Date(2016,8,7));
			Reservation reservation6=new Reservation (new Date(2017,7,8));
			
			
			
			Customer customer1 = new Customer("Bruke", Arrays.asList(reservation1,reservation2));
			Customer customer2 = new Customer("Michael", Arrays.asList(reservation3,reservation4));
			Customer customer3 = new Customer("Solomon", Arrays.asList(reservation5,reservation6));
			
			//public Student(String studentId, String firstName, String lastName, List<Course> courses) {
			
			
		
			// save the person
			
			
			session.persist(customer1);
			
			
			
			session.persist(customer2);
	
			
			session.persist(customer3);
		


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
			List<Customer> customerList = session.createQuery("from Customer").list();
			for (Customer s : customerList) {
				System.out.println(s);
			}
			
			List<Reservation> reservationList = session.createQuery("from Reservation").list();
			for (Reservation c : reservationList) {
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

