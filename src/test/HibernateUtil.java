package test;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtil {

	private static SessionFactory factory = null;
	private static ServiceRegistry serviceRegistry;
	
	
	private static void createFactory(){
		try{
			Configuration configuration = new Configuration();
			configuration.configure("hibernate.cfg.xml");
			serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
			factory = configuration.buildSessionFactory(serviceRegistry);
		}	
		catch (Throwable ex) { 
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex); 
		}
	}
	
	public static SessionFactory instance() {
		if ( factory == null ){
			createFactory();
		}
		return factory;
	}
	public static void shutdown() {
		if ( factory != null ){
			factory.close();
		}
			
	}
}
