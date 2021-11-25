import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Entities.Customer;
import Entities.Order;
import Entities.Product;

public class MainDeleteProduct 
{
	public static void main(String[] args)
	{
		SessionFactory factory = new Configuration().
                configure("hibernate.cfg.xml")
                .addAnnotatedClass(Customer.class)
                .addAnnotatedClass(Product.class)                
                .buildSessionFactory();
		Session session=factory.getCurrentSession();
		session.beginTransaction();
		
		Product product=session.get(Product.class,1);
		session.remove(product);
		session.getTransaction().commit();
	}
}
