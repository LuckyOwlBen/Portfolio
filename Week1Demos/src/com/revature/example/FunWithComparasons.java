package com.revature.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import com.revature.beans.Car;

public class FunWithComparasons {

	public static void main(String[] args) {
		List<Car> carList = new ArrayList<>();
		carList.add(new Car(1997,"Mustang","Mustang",0.0));
		carList.add(new Car(1999,"Nissan","GTR",0.0));
		carList.add(new Car(1993,"Porche","911 Turbo S",0.0));
		carList.add(new Car(2014,"Ford","Mustang",0.0));
		carList.add(new Car(2045,"Tesla","SpaceShip",100.0));
		System.out.println("Cars before sort: ");
		printCars(carList);
		System.out.println("Cars after sort with Comparator");
		sortWithComparator(carList,new CarYearCompare());
		printCars(carList);
		
		sortWithComparable(carList);
		System.out.println("Cars after sort with comparable: ");
		printCars(carList);
	}

	
	static void sortWithComparator(List<Car> cars, Comparator<Car> carComp) {
		Collections.sort(cars,carComp);
	}
	static void sortWithComparable(List<Car> cars) {
		Collections.sort(cars);
	}
	
	
	static void printCars(List<Car> cars) {
		Iterator<Car> it = cars.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
