package alist;

public class DNode {
	private Object value;
	private DNode previous;
	private DNode next;
	
	public DNode() {
	}
	
	public DNode(DNode next) {
		this.next = next;
	}
	
	public DNode(DNode previous, Object value, DNode next) {
		this.value = value;
		this.previous = previous;
		this.next = next;
	}
	
	public String toString() {
		return String.format("%s", value);
	}
	
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}
	public DNode getPrevious() {
		return previous;
	}
	public void setPrevious(DNode previous) {
		this.previous = previous;
	}
	public DNode getNext() {
		return next;
	}
	public void setNext(DNode next) {
		this.next = next;
	}
	
	
}
