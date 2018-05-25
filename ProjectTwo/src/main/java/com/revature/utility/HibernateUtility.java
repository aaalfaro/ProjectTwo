package com.revature.utility;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtility {
	
	private HibernateUtility() {}
	
	private static SessionFactory sessionFactory = buildSessionFactory();
	
	private static SessionFactory buildSessionFactory() {
		Properties props = new Properties();
		Configuration config = new Configuration();
		try {
			props.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("hibernate.properties"));
			config.setProperties(props);
		}catch(FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}
		return config.configure().buildSessionFactory();
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public static void shutdown() {
		System.out.println("Shutting down session factory");
		getSessionFactory().close();
		System.out.println("Factory is closed");
	}
}
