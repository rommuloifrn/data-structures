package dllvector;

import exceptions.VectorPequenino;

public class DLLVector {
	DNode start;
	DNode size;
	
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
		// verificações: se o vector está vazio e se ele tem tamanho pra mostrar o elemento.
		DNode actual = start;
		int actualRank = 0;
		while(actual.getNext()!=null) {
			if (actualRank == rank) return actual; else {
				actual = actual.getNext();
				rank++;
			}
		}
		throw new VectorPequenino("O rank enviado não existe, o vector é muito pequeno.");
	}
	
	/* SERÁ QUE EU FAÇO UM MÉTODO PRA PERCORRER A LISTA? */
}
