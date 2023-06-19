package alist;

import exceptions.TaVazioBicho;

public class AList {
	private Integer size;
	private DNode start;
	private DNode end;
	
	public AList() {
		size = 0;
		end = new DNode();
		start = new DNode(end);
		end.setPrevious(start);
	}
	
	public Integer size() {
		return size;
	}
	
	public boolean isEmpty() {
		return (start.getNext() == end);
	}
	
	public boolean isFirst(DNode x) {
		return (start.getNext() == x);
	}
	
	public boolean isLast(DNode x) {
		return (end.getPrevious() == x);
	}
	
	public DNode first() {
		if (!isEmpty()) return start.getNext();
		else throw new TaVazioBicho("a lista tá vazia");
	}
	
	public DNode last() {
		if (!isEmpty()) return end.getPrevious();
		else throw new TaVazioBicho("a lista tá vazia");
	}
	
	public DNode before(DNode x) {
		if (x.getPrevious()!=start) return x.getPrevious(); 
		else throw new TaVazioBicho("a lista tá vazia");
	}
	
	public DNode after(DNode x) {
		if (x.getNext()!=end) return x.getNext(); 
		else throw new TaVazioBicho("a lista tá vazia");
	}
	
	public void replaceElement(DNode target, Object x) {
		target.setValue(x);
	}
	
	public void swapElements(DNode target, DNode anotherTarget) {
		Object aux = target.getValue();
		target.setValue(anotherTarget.getValue());
		anotherTarget.setValue(aux);
	}
	
	public void insertBefore(DNode target, Object x) {
		DNode novice = new DNode(target.getPrevious(), x, target);
		target.getPrevious().setNext(novice);
		target.setPrevious(novice);
	}
	
	public void insertAfter(DNode target, Object x) {
		DNode novice = new DNode(target, x, target.getNext());
		target.getNext().setPrevious(novice);
		target.setPrevious(novice);
	}
	
	public void insertFirst(Object x) {
		DNode novice = new DNode(start, x, start.getNext());
		start.getNext().setPrevious(novice);
		start.setNext(novice);
	}
	
	public void insertLast(Object x) {
		DNode novice = new DNode(end.getPrevious(), x, end);
		end.getPrevious().setNext(novice);
		end.setPrevious(novice);
	}
	
	public void remove(DNode target) {
		target.getPrevious().setNext(target.getNext());
		target.getNext().setPrevious(target.getPrevious());
	}
}
