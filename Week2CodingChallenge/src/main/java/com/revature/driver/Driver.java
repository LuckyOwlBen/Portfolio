package com.revature.driver;

import com.revature.DAOImpl.DAOUtility;
import com.revature.beans.Employee;
import com.revature.services.EmployeeList;

public class Driver {

	public static void main(String[] args) {

		//DAOUtility.tryReturnAllDepartments();
		//DAOUtility.tryReturnAllEmployees();
		//EmployeeList.printAverageSalaryByDpt();		java side solution
		Employee e = new Employee("Barry", "Blue", 1, 123455, "barryblue@gmail.com");
		DAOUtility.tryaddNewEmployee(e);

		DAOUtility.tryReturnAvgByDpt();
	}

}
