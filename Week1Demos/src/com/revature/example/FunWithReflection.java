package com.revature.example;

import java.lang.reflect.Field;
import java.util.Arrays;

import com.revature.beans.Car;

public class FunWithReflection {

	public static void main (String[] args) {
		//Reflections API
		//Allows us to inspect objects and classes at runtime
		
		//declared type is object
		//actual type is car
		Object o = new Car(2003,"Lamborghini","Gallardo", 0.0);
		System.out.println("Is it a car? " + isItACar(o));
		
		Object o2 = new Object();
		System.out.println("Is it a car? "+ isItACar(o2));
		
		//get a Class by its fully qualified class name(package.className)
		try {
			//this can throw a checked exception - ClassNotFoundException
			Class clazz = Class.forName("com.revature.beans.Car");
			System.out.println(clazz.getTypeName());
			
			//get the fields of a car 
			Field[] fields = clazz.getDeclaredFields();
			System.out.println(Arrays.toString(fields));
			for(Field f: fields) {
				System.out.println(f.getName());
			}
			//remember yesterday with string.split?
			String[] redundantFieldsArray = Arrays.toString(fields).split(",");
			for(String s : redundantFieldsArray) {
				System.out.println(s);
			}
			
			//new instance of car
			Car c = (Car)clazz.newInstance();
			Field yearManufactured = clazz.getDeclaredField("yearManufactured");
			yearManufactured.setAccessible(true);	//what's the fun of rules if you can't break them
			yearManufactured.set(c,1998);
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//if you're doing the same thing in every catch block just use Exception e (a more general catch block)
		
	}
	public static boolean isItACar(Object o) {
		boolean b = o instanceof Car;
		return b;
	}
}
