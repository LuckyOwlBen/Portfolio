package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.beans.ReimbursementRequest;

public interface ReimbursementRequestDAO {
	
	public List<ReimbursementRequest> returnAllReimbursementRequestsSQL() 
	throws SQLException;
	
	public List<ReimbursementRequest> returnReimbursementRequestByDptSQL(int dptId)
	throws SQLException;
	
	public void addReimbursementSQL(ReimbursementRequest rr)
	throws SQLException;
	
	public void removeReimbusementRequestSQL(int rID)
	throws SQLException;
	
	public List<ReimbursementRequest> returnReimbursementRequestsByEmployeeID(int id)
	throws SQLException;

	void updateReimbursementSQL(ReimbursementRequest rr) throws SQLException;

}
