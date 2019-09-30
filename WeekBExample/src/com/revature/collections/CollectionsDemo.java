package com.revature.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Vector;

//imports all classes/interfaces in the com.revature.example package
import com.revature.example.User;

public class CollectionsDemo {

	public static void main(String[] args) {

		// funWithLists();
		// funWithSets();
		// funWithQueues();
		// funWithMapsd();
		funWithIterator();

	}
	
	public static void funWithIterator() {
		// initialize a collection which extends the iterable interface
		Set<User> userSet = new HashSet<>();
		userSet.add(new User("Gandalf", "Grey", "mithrandir", "you shall not pass"));
		userSet.add(new User("Paul", "Hewson", "bono", "u2RuleZ"));
		userSet.add(new User("David", "Tennant", "doc10", "tardis"));

		/*
		 * Iterator: -Iterable is an interface which is extended by Collection -Iterable
		 * provides methods for easy traversal of any concrete subtype -defines the
		 * iterator method which returns an Iterator -Iterator has methods .next(),
		 * .hasNext(), .remove() -using the iterator allows us to safely remove elements
		 * in place and traverse multiple Collections at once
		 */

		Iterator<User> userIterator = userSet.iterator();

		// use hasNext() method (returns a boolean) as the condition for a while loop
		while (userIterator.hasNext()) {
			User u = userIterator.next(); // next() (returns the next element, and steps forward the position of the
											// iterator
			// can use the .remove operator to remove elements from the Collection
			// (filtering a Collection)
			System.out.println(u);
		}
	}

	public static void funWithMaps() {
		/*
		 * Map: -an object which maps keys to values -no duplicate keys -every key may
		 * map to at most one value -most implementations allow keys to be null
		 * 
		 */

		Map<String, String> credentialsMap = new HashMap<>();
		credentialsMap.put("mithrandir", "you_shall_not");
		credentialsMap.put("null", ""); // fine as long as there is only one null key
		credentialsMap.put("bono", null); // null values are fine, any number of keys may have null values
		credentialsMap.put("bono2", ""); // also fine
		credentialsMap.put("doc10", "tardis");

		// retrieve objects by their keys
		System.out.println(credentialsMap.get("doc10"));

		// iterate through the map
		for (Map.Entry<String, String> entry : credentialsMap.entrySet()) {
			System.out.println("Key: " + entry.getKey() + ", Value:" + entry.getValue());
		}

	}

	public static void funWithQueues() {

		/*
		 * Queue:
		 * 
		 * -typically for holding elements while waiting to process them -provides
		 * methods for adding, removing, and, inspecting elements -two versions for each
		 * of these behaviors: one which throws an exception if the operation fails, and
		 * one which does not. -FIFO (first-in, first-out, except for PriorityQueue,
		 * which uses a Comparator or elements' natural ordering -duplicates are allowed
		 * 
		 * https://docs.oracle.com/javase/8/docs/api/java/util/Queue.html
		 */

		Queue<User> userQueue = new LinkedList<>();

		User u1 = new User("Gandalf", "Grey", "mithrandir", "you_shall_not");
		User u2 = new User("Paul", "Hewson", "bono", "u2RuleZ");
		User u3 = new User("David", "Tennant", "doc10", "tardis");

		userQueue.add(u1);
		userQueue.add(u2);
		userQueue.add(u3);
		userQueue.add(u1);

		while (userQueue.size() != 0) {
			System.out.println("Queue size: " + userQueue.size());
			System.out.println("Processing: " + userQueue.poll()); // removes and returns head of queue
		}

	}

	public static void funWithSets() {
		/*
		 * Set:
		 * 
		 * -Sets are unordered -Duplicate elements are not allowed -Two sets are equal
		 * if they have the same elements(enforced by equals() and hashcode()
		 * implementations)
		 */

		Set<User> userSet = new HashSet<>();

		User u1 = new User("Gandalf", "Grey", "mithrandir", "you shall not pass");
		User u2 = new User("Paul", "Hewson", "bono", "u2RuleZ");
		User u3 = new User("David", "Tennant", "doc10", "tardis");

		userSet.add(u1);
		userSet.add(u2);
		userSet.add(u3);

		// no duplicates... addition of duplicate elements will be ignored
		userSet.add(u1); // same object as an existing element

		for (User user : userSet) {
			System.out.println(user);
		}

		// notice that insertion order is ignored

		User u4 = new User("David", "Tennant", "doc10", "tardis");
		userSet.add(u4); // different object with the same fields as an existing element

		// both are ignored, so the .equals() comparison that's being used(equality not
		// identity)

		for (User user : userSet) {
			System.out.println(user);
		}

		System.out.println(u4 == u3);

	}

	public static void funWithLists() {

		/*
		 * Lists are ordered collections duplicates are allowed
		 * 
		 * some additional list features(beyond methods defined in Collection)
		 * -positional access : access/manipulate elements based on position in list
		 * -search: search for an element and retrieve its numerical position
		 * -iteration: listIterator() expands on the abilities of Iterator -Range-view:
		 * access/manipulate the subsets of the List
		 *
		 * 
		 */

		List<User> users = new ArrayList<>();
		// generally want to use the super type of whatever Collection
		// User is the type of each element in the List, replaces the generic type
		// parameter in List<E> specification

		User u1 = new User("Gandalf", "Grey", "mithrandir", "you shall not pass");
		User u2 = new User("Paul", "Hewson", "bono", "u2RuleZ");
		User u3 = new User("David", "Tennant", "doc10", "tardis");

		users.add(u1);
		users.add(u2);
		users.add(u3);

		// we have an addAll method but it take a Collection

		// duplicates are allowed
		users.add(u1);

		for (User user : users) {
			System.out.println(user);
		}

		System.out.println("Size of list: " + users.size());

		System.out
				.println("------------------------------------------------------------------------------------------");
		// List of Integers must use wrapper class Integer to have numeric values
		// wrapper Class is a datatype which wraps around a primative value
		// Every primative datatype has a corresponding wrapper class

		List<Integer> integerList = new Vector<>();

		integerList.add(10); // implicitly converting from int(primitive) to Integer(Object). This is called
								// autoboxing
		integerList.add(-255);
		integerList.add(new Integer(9)); // not autoboxing
		integerList.add(-12);

		System.out.println("integer list, in insertion order");

		for (Integer integer : integerList) {
			System.out.println(integer);
		}
		/*
		 * Collections utility class has static methods for operating on Collection
		 * objects.
		 * 
		 * sort() method: must be used with a Collection of Comparable elements (or be
		 * provided a Comparator for that datatype)
		 */
		System.out.println(
				"---------------------------------------------------------------------------------------------------------");
		Collections.sort(integerList);
		System.out.println("integer list, sorted");

		for (Integer integer : integerList) {
			System.out.println(integer);
		}
		System.out.println(
				"----------------------------------------------------------------------------------------------------");

	}
}
