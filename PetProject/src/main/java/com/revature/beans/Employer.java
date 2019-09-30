package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Employer")
public class Employer {
	
	public Employer(int empId, String firstName, String lastName, String email, int managedBy, int reportsTo) {
		super();
		this.empId = empId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.managedBy = managedBy;
		this.reportsTo = reportsTo;
	}

	public Employer(int empId, String firstName, String lastName, String email, String password, int managedBy,
			int reportsTo) {
		super();
		this.empId = empId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.managedBy = managedBy;
		this.reportsTo = reportsTo;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO,generator="empSequence")
	@SequenceGenerator(allocationSize=1,name="empSequence",sequenceName="SQ_EMP_PK")
	@Column(name="EMPLOYEEID")
	private int empId;
	
	@Column(name="FIRSTNAME")
	private String firstName;
	
	@Column(name="LASTNAME")
	private String lastName;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="PASSWORD")
	private String password;
	
	@Column(name="MANAGEDBY")
	private int managedBy;
	
	@Column(name="REPORTSTO")
	private int reportsTo;

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getManagedBy() {
		return managedBy;
	}

	public void setManagedBy(int managedBy) {
		this.managedBy = managedBy;
	}

	public int getReportsTo() {
		return reportsTo;
	}

	public void setReportsTo(int reportsTo) {
		this.reportsTo = reportsTo;
	}

	@Override
	public String toString() {
		return "Employer [empId=" + empId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", managedBy=" + managedBy + ", reportsTo=" + reportsTo + "]";
	}
	
	
}
