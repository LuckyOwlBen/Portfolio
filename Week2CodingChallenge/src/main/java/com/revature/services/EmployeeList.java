package com.revature.services;

import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Employee;

public class EmployeeList {

	public static List<Employee> employeeList = new ArrayList<>();
	
	public static void addEmployee(Employee e) {
		employeeList.add(e);
		return;
	}
	
	public static  void printAverageSalaryByDpt() {
		double dptOne = 0;
		int counterOne = 0;
		double dptTwo = 0;
		int counterTwo = 0;
		double dptThree = 0;
		int counterThree = 0;
		
		double resultOne = 0;
		double resultTwo = 0;
		double resultThree = 0;
		
		
		for(Employee e : employeeList) {
			if(e.getDepartmentId() == 1) {
				dptOne = dptOne + e.getSalary();
				counterOne++;
			}
			if(e.getDepartmentId() == 2) {
				dptTwo = dptTwo + e.getSalary();
				counterTwo++;
			}
			if(e.getDepartmentId() == 3) {
				dptThree = dptThree + e.getSalary();
				counterThree++;
			}
		}
		resultOne = dptOne / counterOne;
		resultTwo = dptTwo / counterTwo;
		resultThree = dptThree / counterThree;
		
		System.out.println("Average salary for Human Resources: "+resultOne);
		System.out.println("Average salary for Marketing: "+resultTwo);
		System.out.println("Average salary for Sales: "+resultThree);
	}
}
