package com.revature.example;

import java.util.Comparator;

import com.revature.beans.Car;

public class CarYearCompare implements Comparator<Car>{

	@Override
	public int compare(Car o1, Car o2) {
		
		return o1.getYearManufactured().compareTo(o2.getYearManufactured());
	}
	
	

}
