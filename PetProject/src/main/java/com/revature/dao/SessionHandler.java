package com.revature.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionHandler {
	
	private SessionHandler(){
		super();
	}
	
	private static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory() {
		if(sessionFactory == null) {
			Configuration c = new Configuration();
			c.setProperty("hibernate.connection.username",System.getenv("DEMO_DB_USERNAME"));
			c.setProperty("hibernate.connection.password", System.getenv("Demo_DB_PASSWORD"));
			c.setProperty("hibernate.connection.url",System.getenv("DEMO_DB_URL"));
			c.configure();
			sessionFactory=c.buildSessionFactory();
		}
		return sessionFactory;
	}
}
