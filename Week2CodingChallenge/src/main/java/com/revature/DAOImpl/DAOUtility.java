package com.revature.DAOImpl;

import java.sql.SQLException;

import com.revature.beans.Employee;

public class DAOUtility {

	public static EmployeeDAOImpl edi = new EmployeeDAOImpl();
	public static DepartmentDAOImpl ddi = new DepartmentDAOImpl();
	
	public static void tryaddNewEmployee(Employee e) {
		try {
			edi.addNewEmployee(e);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public static void tryReturnAllEmployees() {
		try {
			edi.returnAllEmployees();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void tryReturnAllDepartments() {
		try {
			ddi.returnAllDepartments();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void tryReturnAvgByDpt() {
		try {
			edi.returnAvgByDpt();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
