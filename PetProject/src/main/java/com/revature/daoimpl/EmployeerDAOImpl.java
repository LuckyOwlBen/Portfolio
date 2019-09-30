package com.revature.daoimpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.revature.beans.Employer;
import com.revature.dao.EmployeerDAO;
import com.revature.dao.SessionHandler;

public class EmployeerDAOImpl implements EmployeerDAO {

	SessionFactory sf = SessionHandler.getSessionFactory();
	
	public void addEmployee(Employer e) {
		// TODO Auto-generated method stub
		
	}

	public void updateEmployee(Employer e) {
		// TODO Auto-generated method stub
		
	}

	public Employer returnEmployeeByUsername(String email) {
		Employer result;
		try(Session s = sf.openSession()){
			result =s.get(Employer.class,email);
		}
		return result;
	}

	
}
