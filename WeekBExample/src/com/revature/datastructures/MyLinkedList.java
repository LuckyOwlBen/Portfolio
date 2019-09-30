package com.revature.datastructures;

public class MyLinkedList<T> {

	public MyLinkedList() {

	}

	// root node of the list or head
	private Node<T> head;

	// end node of the list or tail
	private Node<T> tail;

	// insert a node at the end of the list
	public void insert(T data) {

		// create a new node object for the data
		Node<T> newNode = new Node<>(null, data);

		// if the head is null, this new node will become the head
		if (this.head == null) {
			System.out.println("List is empty, adding first element");
			this.head = newNode;
			this.tail = newNode;
		}

		// otherwise, we add this as the tail
		else {
			this.tail.setNextNode(newNode);
			this.tail = newNode;
		}
	}

	// remove and return the first item in the list
	public T poll() {

		Node<T> firstNode = this.head;
		if (firstNode != null) {
			this.head = firstNode.getNextNode();
			return this.head.getData();
		}
		return null;

	}

	// return but do not remove the first item
	public T peek() {

		if (this.head != null) {
			return this.head.getData();
		} else {
			return null;
		}
	}

	// remove the first node whose data matches provided key
	public boolean removeByKey(T key) {
		if (key == null) {
			return false;
		}

		// create a reference to current node
		Node<T> currentNode = this.head;

		// create a reference to the next node(after the current)
		Node<T> nextNode = currentNode.getNextNode();

		// if first node matches the key, move the head to the next node
		if (currentNode != null && currentNode.getData().equals(key)) {
			this.head = nextNode;
			return true;
		}

		// iterate through list while currentNode is not null
		while (currentNode != null) {
			// if next node is not null and matches the key
			// point currentNode to the node after nextNode and return true
			if (nextNode != null && nextNode.getData().equals(key)) {
				currentNode.setNextNode(nextNode.getNextNode());
				return true;
			}

			// advance current node to next node of list
			currentNode = currentNode.getNextNode();

			// if nextNode is not null advance the next node to the one after it
			if (nextNode != null) {
				nextNode = nextNode.getNextNode();
			}
		}
		return false;
	}

	// convenience method for printing the list
	public void printList() {
		Node<T> currentNode = this.head;
		while (currentNode != null) {
			System.out.println("Node location: " + currentNode.hashCode() + ",Node Value: " + currentNode.getData());
			currentNode = currentNode.getNextNode();
		}
	}

	// remove all duplicates from the list
	public void removeDuplicates() {

		Node<T> currentNode = this.head;
		Node<T> runner;
		T currentValue = null;
		if (this.head != null) {
			currentValue = currentNode.getData();
			System.out.println("Top of the list, initial value = " + currentValue);
			do {
				System.out.println("at beginning of list, initial value = "+currentValue);
				runner = currentNode;	//have "runner" start in the same spot as the current node
				//don't need to re-check earlier nodes in the list
				while (runner != null && runner.getNextNode() != null ) {
					T nextValue = runner.getNextNode().getData();
					System.out.println("Comparing Values ("+currentValue+" ,"+nextValue+")");
					if (currentValue.equals(nextValue)) {
						System.out.println("removing first instance of the value: "+currentValue);
						removeByKey(currentValue);
					}
					System.out.println("Moving runner to next node");
					runner = runner.getNextNode();
				}
				//moving currentNode to next node
				if(currentNode.getNextNode() != null) {
					System.out.println("no more duplicates of: "+currentValue+" left");
					currentValue = currentNode.getNextNode().getData();
					currentNode = currentNode.getNextNode();
				}

			} while (currentValue != null && currentNode.getNextNode() != null);
			// exit iteration if current node's value is null or there is no exit node
			// a refinement would be to scrub out or skip all nodes with null values instead
			// of rage quitting if we find one

		}
	}
}
