package com.revature.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CREDENTIALS")
public class Credentials implements Serializable {

	private static final long serialVersionUID = 1L;

	public Credentials() {
		super();
	}

	public Credentials(String password) {
		super();
		this.password = password;
	}

	@Id
	@OneToOne
	@JoinColumn(name = "USER_ID")
	private User user;

	@Column(name = "PASSWORD")
	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Credentials [user= " + user + " password=" + password + "]";
	}
}
