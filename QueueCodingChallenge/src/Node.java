
public class Node<T> {

	public Node(Node<T> nextNode, T data){
		this.nextNode = nextNode;
		this.data = data;
	}
	
	private Node <T> nextNode;
	private T data;
	
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	
	public Node<T> getNextNode(){
		return nextNode;
	}
	public void setNextNode(Node<T> nextNode) {
		this.nextNode = nextNode;
	}
}
