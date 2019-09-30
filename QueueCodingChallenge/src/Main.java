
public class Main {

	public static void main(String[] args) {
		
		
		IDBean i1 = new IDBean();
		IDBean i2 = new IDBean();
		IDBean i3 = new IDBean();
		IDBean i4 = new IDBean();
		
		NodeMethods<IDBean> node = new NodeMethods<>();
		
		node.put(i1);
		node.put(i2);
		node.put(i3);
		node.put(i4);
		
		node.printList();
		
		
		
		
	}

}
