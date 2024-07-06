package alist;

import exceptions.NaoAcheiEsteTreco;
import exceptions.NemTemNadaAiRapaz;
import exceptions.TaVazioBicho;

// TAD lista feito com base em array de Position!
/* features:
 *  Aumento e redução dinâmicos de capacidade, 
 *  possibilidade de buscar os Positions por índice ou por valor (string) */

public class AList {
	Position[] arrai;
	Integer size;
	Integer cap;
	boolean getPositionsByRank;
	
	public AList() {
		size = 0;
		cap = 2;
		arrai = new Position[cap];
		getPositionsByRank = false;
	}
	
	public void mePrintaEssaListaMano() {
		System.out.printf("[ ");
		for (int i=0; i<size; i++) {
			if (arrai[i] == arrai[size-1]) System.out.printf("%s ", arrai[i]); else System.out.printf("%s, ", arrai[i]);
		}
		System.out.printf("]"); System.out.printf(" size: %d, cap: %d, isEmpty: %b%n", size(), cap, isEmpty());
	}
	
	public Integer size() {
		return size;
	}
	
	public boolean isEmpty() {
		return (size<1);
	}
	
	public boolean isFirst(Position x) {
		return (arrai[0] == x);
	}
	
	public boolean isLast(Position x) {
		return (arrai[size-1] == x);
	}
	
	public Position first() {
		if (size>0) return arrai[0]; else throw new TaVazioBicho("Mas nem tem nada aqui!");
	}
	
	public Position last() {
		if (size>0) return arrai[size-1]; else throw new TaVazioBicho("Mas nem tem nada aqui!");
	}
	
	public Position before(Position x) {
		Integer xindex = getIndex(x);
		if (xindex > 0) return arrai[xindex-1]; else throw new NemTemNadaAiRapaz("O que você espera achar antes do primeiro elemento?"); 
			
	}
	
	public Position after(Position x) {
		Integer xindex = getIndex(x);
		if (xindex < size-1) return arrai[getIndex(x)+1]; else throw new NemTemNadaAiRapaz("O que você espera achar depois do ultimo elemento?"); 
	}
	
	public void replaceElement(Position target, Object x) {
		target.setValue(x);
	}
	
	public void swapElements(Position target, Position anotherTarget) {
		Object aux = target.getValue();
		target.setValue(anotherTarget.getValue());
		anotherTarget.setValue(aux);
	}
	
	public void insertBefore(Position target, Object x) {
		doubleCap();
		Integer tindex = getIndex(target);
		for(int i = size; i>=tindex; i--)
			arrai[i] = new Position(arrai[i-1].getValue());
		arrai[tindex] = new Position(x);
		size++;
	}
	
	public void insertAfter(Position target, Object x) {
		doubleCap();
		Integer tindex = getIndex(target);
		for(int i = size; i>tindex+1; i--)
			 arrai[i] = new Position(arrai[i-1].getValue());
		arrai[tindex+1] = new Position(x);
		size++;
	}
	
	public void insertFirst(Object x) {
		doubleCap();
		for (int i=size; i>0; i--)
			arrai[i] = new Position(arrai[i-1].getValue());
		arrai[0] = new Position(x);
		size++;
	}
	
	public void insertLast(Object x) {
		doubleCap();
		arrai[size] = new Position(x);
		size++;
	}
	
	public Position remove(Position target) {
		Position judas = new Position(target.getValue()); 
		for (int i=getIndex(target); i<size-1; i++) 
			arrai[i].setValue(arrai[i+1].getValue());
		size--;
		cutCap();
		return judas;
	}
	
	// métodos auxiliares
	
	public void doubleCap() {
		if (size == cap) {
			Position aux[] = new Position[cap*2];
			for (int i=0; i<size; i++) 
				aux[i] = arrai[i];
			arrai = aux;
			cap *=2;
		}
	}
	
	public void cutCap() {
		if (size < cap/2) {
			Position aux[] = new Position[cap/2];
			for (int i=0; i<size; i++)
				aux[i] = new Position(arrai[i].getValue());
			arrai = aux;
			cap /=2;
		}
	}
	
	public Integer getIndex(Position x) {
		for (int i=0; i<size; i++)
			if (arrai[i] == x) return i; 
		throw new NaoAcheiEsteTreco("Receio que tal elemento não esteja nessa coleção, amigo.");
	}
	
	public Position getPos(String x) {
		if (getPositionsByRank) {
			Integer index = Integer.parseInt(x);
			if (index < size) return arrai[index]; else throw new NemTemNadaAiRapaz("Ratinho! Tá passando do limte, Ratinho!");
		} else {
			for (int i=0; i<size; i++)
				if (arrai[i].getValue().equals(x)) return arrai[i];
			throw new NaoAcheiEsteTreco("Não tem esse elemento aí não...");
		}
	
	}
}