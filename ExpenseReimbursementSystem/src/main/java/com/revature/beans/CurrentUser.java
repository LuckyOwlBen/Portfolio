package com.revature.beans;

public class CurrentUser {

	private String employeeId;
	private String departmentID;
	private String firstName;
	private String lastName;
	private String email;
	private String username;
	private String reportsTo;
	private String managerOf;
	
	public CurrentUser(String employeeId,String departmentID, String firstName, String lastName, String email, String username,
			String reportsTo, String managerOf) {
		super();
		this.employeeId = employeeId;
		this.departmentID = departmentID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.username = username;
		this.reportsTo = reportsTo;
		this.managerOf = managerOf;
	}
	
	
	public String getDepartmentID() {
		return departmentID;
	}
	public void setDepartmentID(String departmentID) {
		this.departmentID = departmentID;
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getReportsTo() {
		return reportsTo;
	}
	public void setReportsTo(String reportsTo) {
		this.reportsTo = reportsTo;
	}
	public String getManagerOf() {
		return managerOf;
	}
	public void setManagerOf(String managerOf) {
		this.managerOf = managerOf;
	}


	public String getEmployeeId() {
		return employeeId;
	}


	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
}
