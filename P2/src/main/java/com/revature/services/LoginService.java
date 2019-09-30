package com.revature.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Credentials;
import com.revature.beans.User;
import com.revature.datalayer.LoginDAO;

@Service
public class LoginService {
	private LoginDAO loginDAO;
	
	@Autowired
	public LoginService(LoginDAO loginDAO) {
		this.loginDAO =loginDAO;
	}
	
	public User loginTest(String email, String password) {
		List<User> userList = new ArrayList<>(); 
		userList = loginDAO.getAllUsers();
		for(User u : userList ) {
			if(email.equals(u.getEmail())) {
				Credentials c = loginDAO.getCredentials(u.getUserId());
				if(c.getPassword().equals(password)) {
					return u;
				}
			}
		}
		return null;
	}
	
	public List<User> gimmeUsers(){
		List<User> tempList = new ArrayList<>();
		tempList = loginDAO.getAllUsers();
		return tempList;
	}
	
	public List<Credentials> gimmeUrPassword(){
		List<Credentials> tempList = new ArrayList<>();
		tempList = loginDAO.getAllCredentials();
		return tempList;
	}
}
