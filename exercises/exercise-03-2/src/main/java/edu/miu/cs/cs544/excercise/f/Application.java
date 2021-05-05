package edu.miu.cs.cs544.excercise.f;

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
		sessionFactory = HibernateUtils.getSessionFactory(Arrays.asList(Department.class , Employee.class, Office.class));
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
			
			
			Department department1 = new Department("HR");
			
			Office  office1= new Office(23, "buiding1");
			Employee Employee1 = new Employee(123, "Bruke" , department1, office1);
			Employee Employee2= new Employee(453, "Haile " , new Department("Accounting"), new Office(25, "buiding2"));
			Employee Employee3 = new Employee(7123, "solomon" , new Department("Logostics"), new Office(25, "buiding3"));
			
			
			
			
			// save the person
			session.persist(department1);
			
			System.out.println(department1 + "persisted to DB");
			session.persist(Employee1);
			System.out.println(Employee1 + "persisted to DB");
			session.persist(Employee2);
			System.out.println(Employee2 + "persisted to DB");
			
			session.persist(Employee3);
			System.out.println(Employee3 + "persisted to DB");


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
			List<Employee> employeeList = session.createQuery("from Employee").list();
			for (Employee e : employeeList) {
				System.out.println(e);
			}
			
			List<Department> departmentList = session.createQuery("from Department").list();
			for (Department d : departmentList) {
				System.out.println(d);
			}
			
			List<Office> officeList = session.createQuery("from Office").list();
			for (Office o : officeList) {
				System.out.println(o);
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

