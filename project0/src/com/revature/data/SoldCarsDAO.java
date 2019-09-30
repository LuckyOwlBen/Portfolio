package com.revature.data;

import java.sql.SQLException;

import com.revature.beans.Car;

public interface SoldCarsDAO {
	
	public void addNewCarSQL(Car c)
	throws SQLException;
	
	public void populateSoldCarsSQL()
	throws SQLException;  

}
