package test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import pojo.Vente;


public class TesterHibernateUtil {

	public static void main(String[] args) {
		
		Session session = null;
		session = HibernateUtil.instance().openSession();		
		Transaction tx = null;

		try{
			tx = session.beginTransaction();
			
			
			
			tx.commit();
		}
		catch (HibernateException e) {
			if (tx != null) tx.rollback();
			e.printStackTrace(); 
		}
		finally {
			session.close(); 
		}
		
		
		
	}

}
