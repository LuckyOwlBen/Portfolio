
public class NodeMethods<T> {
	
	private Node<T> head;
	private Node<T> tail;
	

	public void put(T data) {

		Node<T> newNode = new Node<>(null,data);
		
		if(this.head == null) {
			
			System.out.println("List is empty, adding first element");
			this.head = newNode;
			this.tail = newNode;
		}
		else {
			this.tail.setNextNode(newNode);
			this.tail = newNode;
		}
	}

	public T peek() {
		if(this.head != null) {
			return this.head.getData();
		}
		else {
			return null;			
		}
	}

	public T pop() {

		Node<T> firstNode = this.head;
		if(firstNode != null) {
			this.head = firstNode.getNextNode();
			return this.head.getData();
		}
		return null;
	}

	public void printList() {
		Node<T> currentNode = this.head;
		while(currentNode != null) {
			System.out.println("Node location: " +currentNode.hashCode() + ",Node Value" +currentNode.getData());
			currentNode = currentNode.getNextNode();
		}
	}
}
