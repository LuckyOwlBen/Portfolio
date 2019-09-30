package com.revature.datastructures;

public class MyBinaryTree {

	private TreeNode root;

	// add a new value to the tree
	public void add(int value) {

		root = addRecursive(root, value);
	}

	private TreeNode addRecursive(TreeNode current, int value) {

		if (current == null) {
			return new TreeNode(value);
		}

		if (value < current.value) {
			current.left = addRecursive(current.left, value);
		} else if (value > current.value) {
			current.right = addRecursive(current.right, value);
		}
		return current; // if value is == value of current node ignore insertion
	}

	// check if tree is empty
	public boolean isEmpty() {
		return root == null;
	}

	// public determine size of tree
	public int getSize() {
		return getSizeRecursive(root);
	}

	// how big is the tree underneath this node
	private int getSizeRecursive(TreeNode current) {

		// base case current node is null no nodes are beneath it
		// ternary operator[condition]?[value to return if condition is true: value to
		// return if condition is false]
		return current == null ? 0 : getSizeRecursive(current.left) + 1 + getSizeRecursive(current.right);

	}

	public boolean containsNode(int value) {
		
		TreeNode current = root;
		boolean a = false;

		if (current == null) {
			System.out.println("head is null");
			return false;
		}

		while (current != null) {

			if (current.value == value) {
				System.out.println("value is same");
				a = true;
				break;
			} 
			else if (current.value > value) {
					System.out.println("going left");
					current = current.left;	
			}

			else if (current.value < value) {
				System.out.println("going right");
					current = current.right;
			}

			else {
				System.out.println("else is null");
				return false;
			}
			
		}
		return a;
	}

	// inner class
	// never actually need TreeNode outside the binary tree
	private class TreeNode {

		int value;
		TreeNode left;
		TreeNode right;

		TreeNode(int value) {
			this.value = value;
			right = null;
			left = null;
		}
	}

}
