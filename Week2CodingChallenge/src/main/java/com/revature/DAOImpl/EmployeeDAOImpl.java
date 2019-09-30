package com.revature.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.DAO.ConnectionFactory;
import com.revature.DAO.EmployeeDAO;
import com.revature.beans.Employee;
import com.revature.services.EmployeeList;

public class EmployeeDAOImpl implements EmployeeDAO {

	public static ConnectionFactory cf = ConnectionFactory.getInstance();
	@Override
	public void addNewEmployee(Employee e) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "INSERT INTO EMPLOYEE(Emp_FIRSTNAME,EMP_LASTNAME,DEPARTMENT_ID,SALARY,EMP_EMAIL) VALUES(?,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1,e.getEmployeeFirstName());
		ps.setString(2, e.getEmployeeLastName());
		ps.setInt(3, e.getDepartmentId());
		ps.setDouble(4, e.getSalary());
		ps.setString(5, e.getEmployee_Email());
		ps.executeUpdate();

	}

	@Override
	public void returnAllEmployees() throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "SELECT * FROM EMPLOYEE";
		 PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		Employee c = null;
		while(rs.next()) {
			c = new Employee(rs.getString(2),rs.getString(3),rs.getInt(4),rs.getDouble(5),rs.getString(6));
			c.setEmployeeId(rs.getInt(1));
			EmployeeList.addEmployee(c);
		}
	}
	
	public void returnAvgByDpt() throws SQLException{
		
		Connection conn = cf.getConnection();
		String sql = "SELECT AVG((SALARY))FROM EMPLOYEE GROUP BY DEPARTMENT_ID";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		int iterator = 1;
		while(rs.next()) {
			
			if(iterator == 1) {
				System.out.println("Average salary for Human Resources: "+rs.getDouble(1));
				iterator++;
			}
			else if(iterator == 2) {
				System.out.println("Average salary for Marketing: "+rs.getDouble(1));
				iterator++;
			}
			else if(iterator == 3) {
				System.out.println("Average salary for Sales: "+rs.getDouble(1));	
				iterator++;
			}
			
		}
	}

}
