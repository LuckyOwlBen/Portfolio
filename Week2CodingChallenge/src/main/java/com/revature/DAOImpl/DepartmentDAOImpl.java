package com.revature.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.DAO.ConnectionFactory;
import com.revature.DAO.DepartmentDAO;
import com.revature.beans.DepartmentBean;
import com.revature.services.DepartmentList;


public class DepartmentDAOImpl implements DepartmentDAO {

	public static ConnectionFactory cf = ConnectionFactory.getInstance();
	
	@Override
	public void returnAllDepartments() throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "SELECT * FROM Department";
		 PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		DepartmentBean d = null;
		while(rs.next()) {
			d = new DepartmentBean(rs.getString(2));
			d.setDepartmentId(rs.getInt(1));
			DepartmentList.populateDepartmentList(d);
		}

	}

}
