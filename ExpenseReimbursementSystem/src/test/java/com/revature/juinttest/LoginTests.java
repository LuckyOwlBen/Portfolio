package com.revature.juinttest;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.junit.runners.*;
import org.junit.FixMethodOrder;
import org.junit.Test;

import com.revature.beans.Employee;
import com.revature.beans.ReimbursementRequest;
import com.revature.daoimpl.EmployeeDAOImpl;
import com.revature.daoimpl.ReimbursementRequestDAOImpl;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LoginTests {

	EmployeeDAOImpl edi = new EmployeeDAOImpl();
	ReimbursementRequestDAOImpl rdi = new ReimbursementRequestDAOImpl();

	//a method used for a few of the tests on here
	public Employee returnAllEmployeesByDptTest() {
		List<Employee> tempList = new ArrayList<>();
		try {
			tempList.addAll(edi.returnAllEmployeesSQL());
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		for (Employee e : tempList) {
			if (e.getUserName().equals("the")) {
				return e;
			}
		}
		return null;
	}
	
	@Test(expected = Test.None.class)
	public void CaddEmployeeTest() {
		Employee e = new Employee(0, "Tony", "Danza", "whoseTheBoss@gmail.com", "the", "boss", 0, 0);
		try {
			edi.addEmployeeSQL(e);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	@Test(expected = Test.None.class)
	public void DreturnEmployeeTest() {
		Employee e = returnAllEmployeesByDptTest();
		try {
			edi.returnEmployeeSQL(e.getUserName());
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}


	@Test(expected = Test.None.class)
	public void EupdateEmployeeTest() {
		Employee e = returnAllEmployeesByDptTest();
		e.setEmail("newemail@gmail.com");
		try {
			edi.updateEmployeeSQL(e);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	@Test(expected=Test.None.class)
	public void FaddReimbursementTest() {
		Employee e = returnAllEmployeesByDptTest();
		ReimbursementRequest rr = new ReimbursementRequest(e.getEmployeeId(), 20.00, "test", 1,e.getDepartmentId(),1);
		try {
			rdi.addReimbursementSQL(rr);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	@Test(expected=Test.None.class)
	public void GReturnReimbursementByDptSQLTest() {
		List<ReimbursementRequest> tempList = new ArrayList<>();
		try {
			tempList.addAll(rdi.returnReimbursementRequestByDptSQL(2));
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Test(expected=Test.None.class)
	public void HReturnAllReimbursementRequestsSQLTest() {
		List<ReimbursementRequest> tempList = new ArrayList<>();
		try {
			tempList.addAll(rdi.returnAllReimbursementRequestsSQL());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test(expected=Test.None.class)
	public void IReturnReimbursementRequestsbyEmployeeIDTest() {
		Employee e = returnAllEmployeesByDptTest();
		try {
			rdi.returnReimbursementRequestsByEmployeeID(e.getEmployeeId());
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	@Test(expected=Test.None.class)
	public void JremoveReimbursementRequestSQLTest() {

		List<ReimbursementRequest> tempList = new ArrayList<>();
		Employee e = returnAllEmployeesByDptTest();
		try {
			tempList.addAll(rdi.returnReimbursementRequestsByEmployeeID(e.getEmployeeId()));
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		ReimbursementRequest rr = tempList.get(0);
		try {
			rdi.removeReimbusementRequestSQL(rr.getReimbursementId());
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	@Test(expected=Test.None.class)
	public void zDeleteEmployeeTest() {
		Employee e = returnAllEmployeesByDptTest();
		try {
			edi.removeEmployeeSQL(e.getEmployeeId());
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	
	@Test(expected=Test.None.class)
	public void AupdateRe() {
		ReimbursementRequest rr = new ReimbursementRequest(111, 20.00, "NO WIFIN", 3,1,1);
		rr.setReimbursementId(70);
		try {
			rdi.updateReimbursementSQL(rr);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
