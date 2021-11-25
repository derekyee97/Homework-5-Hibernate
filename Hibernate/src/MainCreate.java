import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Entities.Customer;
import Entities.Professor;

public class MainCreate 
{
	public static void main(String[] args)
	{
		SessionFactory factory = new Configuration().
                configure("hibernate.cfg.xml")
                .addAnnotatedClass(Customer.class)
                .addAnnotatedClass(Professor.class)
                .buildSessionFactory();
		
		Session session=factory.getCurrentSession();
		createCustomer("james","1234 Sunset Blvd, Los Angeles, CA, 91110","Building 8 Room 4","Computer Science",factory);
		
	}
	public static void createCustomer(String name, String address, String office, String research, SessionFactory factory)
	{
		Session session=factory.getCurrentSession();
		session.beginTransaction();
		Customer customer=new Customer(name,address); 
		session.save(customer);	
		session.getTransaction().commit();
		session=factory.getCurrentSession();
		session.beginTransaction();
		Professor professor=new Professor(office,research,customer.getId());
		session.save(professor);
		session.getTransaction().commit();
		
	}
}
