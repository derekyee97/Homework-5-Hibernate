import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Entities.Customer;
import Entities.Professor;
public class MainDelete
{
	public static void main(String[] args)
	{
		SessionFactory factory = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Customer.class).
                addAnnotatedClass(Professor.class).
                buildSessionFactory();

		Session session = factory.getCurrentSession();
		
			try {
			
			session.beginTransaction();
			
			Customer customer = session.get(Customer.class, 1);
			CriteriaBuilder criteria=session.getCriteriaBuilder();
			CriteriaQuery<Professor> criteriaQuery=criteria.createQuery(Professor.class);
			Root<Professor> currProfessor=criteriaQuery.from(Professor.class);
			criteriaQuery.where(criteria.equal(currProfessor.get("customerID"), customer.getId()));
			List<Professor> result=session.createQuery(criteriaQuery).getResultList();
			Professor professor=result.get(0);//should only be one professor
			session.delete(professor);
			session.delete(customer);					
			session.getTransaction().commit();
			
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			factory.close();
		}
	}
}
