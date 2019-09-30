package com.revature.datalayer;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.revature.beans.Credentials;
import com.revature.beans.User;

@Repository(value="loginDAO")
@Transactional
public class LoginDAO {

	private SessionFactory sf;

	@Autowired //constructor injection
	public LoginDAO(SessionFactory sf) {
		this.sf = sf;
	}
	
	@SuppressWarnings("unchecked")
	public List<User> getAllUsers() {
		Session s = sf.getCurrentSession();
		return s.createQuery("from User").getResultList();
	}
	
	public User getUser(int id) {
		return sf.getCurrentSession().get(User.class, id);
	}
	
	//email is annotated as a natural id
	public User getUserByEmail(String email) {
		return sf.getCurrentSession().byNaturalId(User.class).using("Email", email).load();
	}
	
	public Credentials getCredentials(int id) {
		return sf.getCurrentSession().get(Credentials.class, id);
	}
	
	//This DAO also takes in a password, which will be put in the credentials table
	public void createUser(User u, Credentials c) {
		Session s = sf.getCurrentSession();
		s.persist(u);
		s.persist(c);
	}
	
	@SuppressWarnings("unchecked")
	public List<Credentials> getAllCredentials() {
		Session s = sf.getCurrentSession();
		return s.createQuery("from Credentials").getResultList();
	}
}
