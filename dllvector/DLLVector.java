package dllvector;

import exceptions.VectorPequenino;

public class DLLVector {
	private DNode start;
	private Integer size;
	
	public DLLVector() {
		size = 0;
	}
	
	public void mimDaOVectorMano() {
		System.out.printf("[ ");
		if (start == null) {} else {
			DNode actual = start;
			while (actual!=null) {
				if (actual == getLast()) System.out.printf("%s ", actual); else System.out.printf("%s, ", actual);
				actual = actual.getNext();
			}
		}
		System.out.printf("], size: %d, isEmpty: %b%n", size(), isEmpty());
	}
	
	public Object elemAtRank(Integer rank) {
		return atRank(rank).getValue();
	}
	
	public Object replaceAtRank(Integer rank, Object x) {
		DNode target = atRank(rank);
		DNode judas = new DNode(target.getValue(), null, null);
		atRank(rank).setValue(x);
		
		return judas;
	}
	
	public void insertAtRank(Integer rank, Object x) {
		if (rank>size) throw new VectorPequenino("Fora do range, amigão.");
		
		DNode newNode = new DNode(x, null, null);
		
		if (isEmpty()) { start = newNode; size++; }
		else if (rank == size) { newNode.setPrevious(getLast()); getLast().setNext(newNode); size++; }
		else if (rank == 0) { start.setPrevious(newNode); newNode.setNext(start); start = newNode; size++;}
		else { DNode target = atRank(rank); target.getPrevious().setNext(newNode); target.setPrevious(newNode); newNode.setNext(target); size++;}
	}
	
	public Object removeAtRank(Integer rank) {
		DNode target = atRank(rank);
		
		if (size == 1) start = null;
		else if (rank == size-1) target.getPrevious().setNext(null);
		else if (rank == 0) { start.getNext().setPrevious(null); start = start.getNext(); }
		else { target.getPrevious().setNext(target.getNext()); target.getNext().setPrevious(target.getPrevious()); }
		
		size--;
		return target;
	}
	
	Integer size() {
		return size;
	}
	
	boolean isEmpty() {
		return (size<1);
	}
	
	// métodos auxiliares
	
	public DNode atRank(Integer rank) {
		if (rank>size-1) throw new VectorPequenino("O rank enviado não existe, o vector é muito pequeno.");
		
		DNode actual = start;
		int actualRank = 0;
		while(true) {
			if (actualRank == rank) return actual; else {
				actual = actual.getNext();
				actualRank++;
			}
		}
	}
	
	public DNode getLast() {
		if(size < 1) throw new VectorPequenino("Não foi possível achar o último elemento pois vector está vazio");
		DNode actual = start;
		while(actual.getNext() != null) {
			actual = actual.getNext();
		}
		return actual;
	}
	
}
