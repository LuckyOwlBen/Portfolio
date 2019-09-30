package com.revature.services;

import java.util.ArrayList;
import java.util.List;

import com.revature.beans.DepartmentBean;

public class DepartmentList {
	
	public static List<DepartmentBean> departmentList = new ArrayList<>();
	
	public static void populateDepartmentList(DepartmentBean d) {
		departmentList.add(d);
		return;
	}

}
