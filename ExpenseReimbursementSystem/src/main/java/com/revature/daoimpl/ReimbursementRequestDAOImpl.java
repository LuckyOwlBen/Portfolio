package com.revature.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.ReimbursementRequest;
import com.revature.dao.ConnFactory;
import com.revature.dao.ReimbursementRequestDAO;

public class ReimbursementRequestDAOImpl implements ReimbursementRequestDAO {

	public static ConnFactory cf = ConnFactory.getInstance();

	@Override
	public List<ReimbursementRequest> returnAllReimbursementRequestsSQL() throws SQLException {
		List<ReimbursementRequest> reimbursementList = new ArrayList<>();
		Connection conn = cf.getConnection();
		String sql = "SELECT * FROM REIMBURSEMENT_REQUEST";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		ReimbursementRequest rr = null;
		while (rs.next()) {
			rr = new ReimbursementRequest(rs.getInt(2), rs.getDouble(3), rs.getString(4), rs.getInt(6), rs.getInt(7),rs.getInt(8));
			rr.setReimbursementId(rs.getInt(1));
			reimbursementList.add(rr);
		}
		return reimbursementList;
	}

	@Override
	public List<ReimbursementRequest> returnReimbursementRequestByDptSQL(int dptId) throws SQLException {
		List<ReimbursementRequest> reimbursementList = new ArrayList<>();
		Connection conn = cf.getConnection();
		String sql = "SELECT * FROM REIMBURSEMENT_REQUEST WHERE DEPARTMENT_ID = ? ";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, dptId);
		ResultSet rs = ps.executeQuery();

		ReimbursementRequest rr = null;
		while (rs.next()) {
			rr = new ReimbursementRequest(rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getInt(6), rs.getInt(7),rs.getInt(8));
			rr.setReimbursementId(rs.getInt(1));
			reimbursementList.add(rr);
		}
		return reimbursementList;
	}

	@Override
	public void addReimbursementSQL(ReimbursementRequest rr) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "{ CALL INSERT_REIMBURSEMENT(?,?,?,?,?,?)";
		CallableStatement ps = conn.prepareCall(sql);
		ps.setInt(1, rr.getEmployeeId());
		ps.setDouble(2, rr.getDollarAmount());
		ps.setString(3, rr.getReason());
		/*
		 * if (rr.getImageFile() == null) { ps.setNull(4, java.sql.Types.BLOB); } else {
		 * ps.setBlob(4, rr.getImageFile()); }
		 */
		ps.setInt(4, rr.getStatus());
		ps.setInt(5, rr.getDptId());
		ps.setInt(6, 0);
		ps.execute();
	}

	@Override
	public void removeReimbusementRequestSQL(int rID) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "DELETE FROM REIMBURSEMENT_REQUEST WHERE REID = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, rID);
		ps.executeUpdate();
	}

	@Override
	public List<ReimbursementRequest> returnReimbursementRequestsByEmployeeID(int id) throws SQLException {
		List<ReimbursementRequest> reimbursementList = new ArrayList<>();
		Connection conn = cf.getConnection();
		String sql = "SELECT * FROM REIMBURSEMENT_REQUEST WHERE EMPLOYEE_ID = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();

		ReimbursementRequest rr = null;
		while (rs.next()) {
			rr = new ReimbursementRequest(rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getInt(6),rs.getInt(7),rs.getInt(8));
			rr.setReimbursementId(rs.getInt(1));
			reimbursementList.add(rr);
		}
		return reimbursementList;
	}
	@Override
	public void updateReimbursementSQL(ReimbursementRequest rr) throws SQLException {
		Connection conn = cf.getConnection();
		String sql ="UPDATE REIMBURSEMENT_REQUEST SET STATUS = ?,APPROVED_BY = ?  WHERE REID = ?" ;
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, rr.getStatus());
		ps.setInt(2, rr.getApprovedBy());
		ps.setInt(3, rr.getReimbursementId());
		ps.executeUpdate();
	}

}
