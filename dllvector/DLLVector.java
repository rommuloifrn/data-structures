package dllvector;

import exceptions.VectorPequenino;

public class DLLVector {
	DNode start;
	Integer size;
	
	public DLLVector() {
	}
	
	public void mimDaOVectorMano() {
		System.out.printf("[ ");
		DNode actual = start;
		if (start == null) {} else {
			while (actual.getNext() != null) {
				System.out.printf("%s, ");
			}
		}
		System.out.printf("]%n");
	}
	
	public Object elemAtRank(Integer rank) {
		if (rank>size-1) throw new VectorPequenino("O rank enviado não existe, o vector é muito pequeno.");
		
		DNode actual = start;
		int actualRank = 0;
		while(actual.getNext() != null) {
			if (actualRank == rank) return actual.getValue(); else {
				actual = actual.getNext();
				actualRank++;
			}
		}
		throw new VectorPequenino("O rank enviado não existe, o vector é muito pequeno.");
	}
	
	
	
	public void insertAtRank(Integer rank, Object x) {
		if (rank>size) throw new VectorPequenino("Fora do range, amigão.");
		
		DNode newNode = new DNode(x, null, null);
		
		if (isEmpty()) { start = newNode; size++; }
		else if (rank == size) { atRank(rank).setNext(newNode); size++; }
		else if (rank == 0) { start.setPrevious(newNode); start = start.getPrevious(); }
		else { DNode target = atRank(rank); target.get }
		
		
		DNode target = atRank(rank);
		
		if (target.getPrevious() == null) {
			target.setPrevious(newNode);
			start = newNode;
			size++;
		}
		
		
		
		
	}
	
	public DNode atRank(Integer rank) {
		if (rank>size-1) throw new VectorPequenino("O rank enviado não existe, o vector é muito pequeno.");
		
		DNode actual = start;
		int actualRank = 0;
		while(actual.getNext() != null) {
			if (actualRank == rank) return actual; else {
				actual = actual.getNext();
				actualRank++;
			}
		}
		throw new VectorPequenino("O rank enviado não existe, o vector é muito pequeno.");
	}
	
	boolean isEmpty() {
		return (size<1);
	}
	
}
