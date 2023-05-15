package llqueue;

import exceptions.PilhaVaziaException;

public class Queue {
	// estou usando sentinelas!
	private Node start;
	private Node end;
	
	public Queue() {
		end = new Node();
		start = new Node(end);
	}
	
	public void mimDaAFilaMano() {
		Node actual = getStart().getNext();
		System.out.printf("[ ");
		while (actual!=end) {
			if (actual.getNext() == end) System.out.printf("%s ", actual); else System.out.printf("%s, ", actual);
			actual = actual.getNext();
		}
		System.out.printf(" ], size: %d, isEmpty: %b %n", size(), isEmpty());
	}
	
	public void enqueue(Object value) {
		Node x = new Node();
		x.setValue(value);
		Node y = start;
		while (y.getNext() != end) {
			y = y.getNext();
		}
		y.setNext(x);
		x.setNext(end);
	}
	
	public Node dequeue() {
		if (start.getNext() == end) throw new PilhaVaziaException("a pilha tá vazia, bicho");
		Node judas = start.getNext();
		start.setNext(judas.getNext());
		return judas;
	}
	
	public Node first() {
		return start.getNext();
	}

	public int size() {
		int size = 0;
		Node actual = start.getNext();
		while(actual != end) {
			size++;
			actual = actual.getNext();
		}
		return size;
	}
	
	public boolean isEmpty() {
		return (start.getNext() == end);
	}
	
	
	
	
	
	
	
	
	public Node getStart() {
		return start;
	}
	public void setStart(Node start) {
		this.start = start;
	}
	public Node getEnd() {
		return end;
	}
	public void setEnd(Node end) {
		this.end = end;
	}
	
	
	
}
