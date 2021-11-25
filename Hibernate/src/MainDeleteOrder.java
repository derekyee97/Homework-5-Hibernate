import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Entities.Customer;
import Entities.Order;

public class MainDeleteOrder 
{
	public static void main(String[] args)
	{
		SessionFactory factory = new Configuration().
                configure("hibernate.cfg.xml")
                .addAnnotatedClass(Customer.class)
                .addAnnotatedClass(Order.class)                
                .buildSessionFactory();
		Session session=factory.getCurrentSession();
		session.beginTransaction();
		
		Order order=session.get(Order.class,1);
		session.remove(order);
		session.getTransaction().commit();
	}
}
