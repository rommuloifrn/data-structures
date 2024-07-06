package llqueue;

public class Node {
	private Object value;
	private Node next;
	
	public Node() {
	}
	
	public Node(Node next) {
		this.next = next;
	}
	
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	
	public String toString() {
		return String.format("%s", value);
	}
}
