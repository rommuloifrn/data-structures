package piles;

import exceptions.PilhaVaziaException;
import nodes.Node;

public class LinkedListPile {
	// Eu não estou usando sentinela!
	private Node start;
	private Node top;
	
	public LinkedListPile() {
	}
	
	public void mimDaAPilaMano() {
		
		System.out.printf("[ ");
		if (start == null) {} else {
			Node actual = getStart();
			while (actual!=null) {
				if (actual == top) System.out.printf("%s ", actual); else System.out.printf("%s, ", actual);
				actual = actual.getNext();
			}
		}
		System.out.printf("], size: %d, isEmpty: %b%n", size(), isEmpty());
	}
	
	public void push(Object x) {
		Node newNode = new Node();
		newNode.setValue(x);
		if (top != null) {
			top.setNext(newNode);
			top = newNode;
		} else {
			start = newNode;
			top = newNode;
		}
	}
	
	public Node pop() {
		// caso start seja nulo (pilha vazia)
		if (start == null) throw new PilhaVaziaException("A pilha tá vazia.");
		
		// caso start seja não-nulo e diferente de top (mais de 1 elemento na pilha)
		if (start != top) {
			Node actual = start;
			while (actual.getNext().getNext() != null) actual = actual.getNext();
			Node removed = actual.getNext();
			actual.setNext(null);
			top = actual;
			return removed;
		// caso start == end (pilha somente com 1 elemento) 
		} else {
			Node toPop = start;
			start = null;
			top = null;
			return toPop;
		}
	}
	
	public Node top() {
		return top;
	}
	
	public Integer size() {
		if (start == null) return 0;
		else {
			Node actual = start;
			Integer size = 1;
			while(actual.getNext() != null) {
				size++;
				actual = actual.getNext();
			}
			return size;
		}
		
	}
	
	public boolean isEmpty() {
		return (start == null);
	}
	
	
	
	
	
	

	public Node getStart() {
		return start;
	}

	public void setStart(Node start) {
		this.start = start;
	}

	public Node getTop() {
		return top;
	}

	public void setTop(Node top) {
		this.top = top;
	}
	
	
	
}
