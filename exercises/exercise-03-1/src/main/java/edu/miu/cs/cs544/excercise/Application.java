package edu.miu.cs.cs544.excercise;

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
		sessionFactory = HibernateUtils.getSessionFactory(Arrays.asList(Car.class , Owner.class));
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
			
			
			Car car1 = new Car("Mercedes", new Date(2012, 3,4 ), 1200.00, new Owner("Bruke", "BLDNG144"));
			Car car2 = new Car("Toyota", new Date(2021, 2,5), 1000.00, new Owner("John", "BLDNG141"));
			
			// save the person
			session.persist(car1);
			
			System.out.println(car1 + "persisted to DB");
			session.persist(car2);
			System.out.println(car2 + "persisted to DB");

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
			List<Car> carList = session.createQuery("from Car").list();
			for (Car c : carList) {
				System.out.println(c);
			}
			tx.commit();
		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		
		// Close the SessionFactory (not mandatory)
		sessionFactory.close();
	}
}
