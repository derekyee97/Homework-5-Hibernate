import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Entities.Customer;
import Entities.Order;
import Entities.Product;

public class MainCreateProduct 
{
	public static void main(String[] args)
	{
		SessionFactory factory = new Configuration().
                configure("hibernate.cfg.xml")
                .addAnnotatedClass(Customer.class)
                .addAnnotatedClass(Product.class)                
                .buildSessionFactory();
		Session session=factory.getCurrentSession();
		
		Product product=new Product("Apple");
		session.save(product);
		session.getTransaction().commit();
	}
}
