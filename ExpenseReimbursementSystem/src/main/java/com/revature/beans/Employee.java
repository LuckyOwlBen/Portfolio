package com.revature.beans;

public class Employee {
	
	public Employee(int departmentId, String firstName, String lastName, String email, String userName, int reportsTo,
			int managerOf) {
		super();
		this.departmentId = departmentId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.userName = userName;
		this.reportsTo = reportsTo;
		this.managerOf = managerOf;
	}

	public Employee(int departmentId, String firstName, String lastName, String email, String userName,
			String password, int reportsTo, int dptNumber) {
		super();
		this.departmentId = departmentId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.userName = userName;
		this.password = password;
		this.reportsTo = reportsTo;
		this.managerOf = dptNumber;
	}
	
	


	private int employeeId;
	private int departmentId;
	private String firstName;
	private String lastName;
	private String email;
	private String userName;
	private String password;
	private int reportsTo;
	private int managerOf;
	

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
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


	public int getDepartmentId() {
		return departmentId;
	}


	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public int getReportsTo() {
		return reportsTo;
	}


	public void setReportsTo(int reportsTo) {
		this.reportsTo = reportsTo;
	}


	public int getManagerOf() {
		return managerOf;
	}


	public void setManagerOf(int dptNumber) {
		this.managerOf = dptNumber;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", departmentId=" + departmentId + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", email=" + email + ", userName=" + userName + ", password=" + password
				+ ", reportsTo=" + reportsTo + ", managerOf=" + managerOf + "]";
	}



	
	
}
