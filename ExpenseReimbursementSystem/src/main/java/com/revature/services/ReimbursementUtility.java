package com.revature.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.ReimbursementRequest;
import com.revature.daoimpl.ReimbursementRequestDAOImpl;

public class ReimbursementUtility {
	
	ReimbursementRequestDAOImpl rrdi = new ReimbursementRequestDAOImpl();
	
	public boolean generateReimbursement(ReimbursementRequest rr) {
		try {
			rrdi.addReimbursementSQL(rr);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public List<ReimbursementRequest> returnRequestsByEmployeeID(int id){
		
		List<ReimbursementRequest> tempList = new ArrayList<>();
		try {
			tempList.addAll(rrdi.returnReimbursementRequestsByEmployeeID(id));
			return tempList;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<ReimbursementRequest> returnRequestsByDptId(int id){
		List<ReimbursementRequest> tempList = new ArrayList<>();
		try {
			tempList.addAll(rrdi.returnReimbursementRequestByDptSQL(id));
			return tempList;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void approveReimbursementRequest(int reid, int empId) {
		List<ReimbursementRequest> tempList = new ArrayList<>();
		try {
			tempList.addAll(rrdi.returnAllReimbursementRequestsSQL());
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		ReimbursementRequest target = null;
		for(ReimbursementRequest rr :tempList) {
			if(rr.getReimbursementId() == reid) {
				target = rr;
			}
		}
		if(target == null) {
			return;
		}
		target.setApprovedBy(empId);
		target.setStatus(2);
		try {
			rrdi.updateReimbursementSQL(target);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void denyReimbursementRequest(int reid, int empId) {
		List<ReimbursementRequest> tempList = new ArrayList<>();
		try {
			tempList.addAll(rrdi.returnAllReimbursementRequestsSQL());
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		ReimbursementRequest target = null;
		for(ReimbursementRequest rr :tempList) {
			if(rr.getReimbursementId() == reid) {
				target = rr;
			}
		}
		if(target == null) {
			return;
		}
		target.setApprovedBy(empId);
		target.setStatus(3);
		try {
			rrdi.updateReimbursementSQL(target);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<ReimbursementRequest> returnAllReimbursementRequests(){
		List<ReimbursementRequest> tempList = new ArrayList<>();
		try {
			tempList.addAll(rrdi.returnAllReimbursementRequestsSQL());
			return tempList;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		
	}

}
