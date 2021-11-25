import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Entities.Customer;
import Entities.Order;
import Entities.Product;
import Entities.Professor;

public class MainCreateOrder 
{
	public static void main(String[] args)
	{
		SessionFactory factory = new Configuration().
                configure("hibernate.cfg.xml")
                .addAnnotatedClass(Customer.class)
                .addAnnotatedClass(Order.class)                
                .buildSessionFactory();
		Session session=factory.getCurrentSession();
		
		Customer customer=session.get(Customer.class, 4);
		Date currDate=new Date();
		Order order=new Order(customer.getName(),currDate);
		session.save(order);
		session.getTransaction().commit();
		
		
	}
}
