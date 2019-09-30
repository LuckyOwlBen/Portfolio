package com.revature.datastructures;

public class MyBinaryTreeDemo {

	public static void main(String[] args) {
		
		boolean test;
		
		MyBinaryTree tree = new MyBinaryTree();
		
		System.out.println("Is the tree empty? " +tree.isEmpty());
		System.out.println("size of tree: "+tree.getSize());
		
		tree.add(8);
		tree.add(87);
		tree.add(4);
		tree.add(2);
		tree.add(17);
		
		
		System.out.println("after adding some values...");
		System.out.println("Is the tree empty? " +tree.isEmpty());
		System.out.println("size of tree: "+tree.getSize());
		
		System.out.println("Searching for 17");
		test = tree.containsNode(17);
		System.out.println(test);
		
	}

}
