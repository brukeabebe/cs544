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
		sessionFactory = HibernateUtils.getSessionFactory(Arrays.asList(Customer.class , Order.class, OrderLine.class ,Product.class, CD.class, DVD.class, Book.class ));
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
			
			
			Customer customer1= new Customer("Bruke", "Abebe");
			Customer customer2= new Customer("Yohannis", "Gizaww");
			Customer customer3= new Customer("Minte", "Fikre");
			
			Product product1= new Product("Apples", "This is an apple");
			Product product2= new Product("Table", "This is a table");
			Product product3= new Product("Chair", "This is a chair");
			

			
			Product cd1= new CD("cd1", "This is a CD","Bruke");
			Product cd2= new CD("cd2", "This is a second CD","solomon");
			
			Product dvd1= new DVD("dvd1", "This is a DVD","action");
			Product dvd2= new DVD("dvd2", "This is a second DVD","comedy");
			
			
			Product book1= new Book("book1", "This is a Book","WAP");
			Product book2= new Book("book2", "This is a second Book","EA");
			
			
			Order order1= new  Order(123 , new Date(2012,6,5), customer1, 
					Arrays.asList(new OrderLine (5,product1),new OrderLine (6,product2),new OrderLine (7,product3)));
			Order order2= new  Order(456 , new Date(2013,8,7), customer1, 
					Arrays.asList(new OrderLine (15,product1),new OrderLine (61,product2)));
			
			Order order3= new  Order(676 , new Date(2018,9,7), customer2, 
					Arrays.asList(new OrderLine (34,product1),new OrderLine (54,product2), new OrderLine (71,product3)));
			
			Order order4= new  Order(953 , new Date(2019,3,5), customer3, 
					Arrays.asList(new OrderLine (34,product1),new OrderLine (67,product2), new OrderLine (56,product3)));
			// save the person
			session.persist(customer1);
			session.persist(customer2);
			session.persist(customer3);
			
			session.persist(product1);
			session.persist(product2);
			session.persist(product3);
			
			session.persist(order1);
			session.persist(order2);
			session.persist(order3);
			
			session.persist(order4);
			
			session.persist(cd1);
			session.persist(cd2);
			
			session.persist(dvd1);
			session.persist(dvd2);
			
			session.persist(book1);
			session.persist(book2);
			
			
			
			
			
			
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
			for (Customer c : customerList) {
				System.out.println(c);
			}
			List<Order> orderList = session.createQuery("from Order").list();
			for (Order o : orderList) {
				System.out.println(o);
			}
			List<OrderLine> orderLineList = session.createQuery("from OrderLine").list();
			for (OrderLine ol : orderLineList) {
				System.out.println(ol);
			}
			
			
			System.out.println("this is are the products  in table");
			List<Product> productList = session.createQuery("from Product").list();
			for (Product p : productList) {
				System.out.println(p);
			}
			
			
			System.out.println("this is are the books in table");
			List<Book> bookList = session.createQuery("from Book").list();
			for (Book b : bookList) {
				System.out.println(b);
			}
			
			System.out.println("this is are the dvds in table");
			List<DVD> dvdList = session.createQuery("from DVD").list();
			for (DVD d : dvdList) {
				System.out.println(d);
			}

			System.out.println("this is are the CDs in table");
			List<CD> cdList = session.createQuery("from CD").list();
			for (CD c : cdList) {
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
