package com.revature.driver;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.revature.beans.Employer;
import com.revature.dao.SessionHandler;

public class AddEmployeesToTable {

	public static void main(String[] args) {
		Employer e = new Employer(0, null, null, null, 0, 0);
		
		SessionFactory sf = SessionHandler.getSessionFactory();
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();

	}

}
