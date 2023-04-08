package redblackpile;

import exceptions.PilhaVaziaException;

public class RBPile {
	int totalSize;
	Object[] mainPile;
	int redTop;
	int blackTop;
	
	public RBPile(int totalSize) {
		this.totalSize = totalSize;
		mainPile = new Object[totalSize];
		redTop = -1;
		blackTop = totalSize;
	}
	
	public void mimDaAPilaMano() {
		System.out.printf("[ ");
		for(int i=0; i<totalSize; i++ ) {
			if (i==totalSize-1) {
				System.out.printf("%s ", mainPile[i]);
			}else {
				System.out.printf("%s, ", mainPile[i]);
			}
		}
		System.out.printf("], ");
		System.out.printf("capacidade: %d. ", totalSize);
		if (isRedEmpty()) System.out.printf("red tá vazia e"); else System.out.printf("redTop é \"%s\" (%d itens) e", redTop(), redSize());
		if (isBlackEmpty()) System.out.printf(" black tá vazia.%n"); else System.out.printf(" blackTop é \"%s\" (%d itens) %n", blackTop(), blackSize());
		
	}
	
	public void redPush(Object x) {
		if (redTop+1 == blackTop) {
			Object[] auxPile = new Object[totalSize*2];
			
			for (int i=0; i<=redTop; i++) {
				auxPile[i] = mainPile[i]; 
			}
			
			for (int i=blackTop; i<totalSize; i++) {
				auxPile[i+totalSize] = mainPile[i];
			}
			mainPile = auxPile;
			blackTop += totalSize;
			totalSize *= 2;
		}
		redTop++;
		mainPile[redTop] = x;
	}
	
	public Object redPop() {
		if (redTop < 0) {
			throw new PilhaVaziaException("Não dá pra popar a pinha vermelha, está vazia");
		}
		redTop--;
		return mainPile[redTop+1];
	}
	
	public Object redTop() {
		if (redTop < 0) {
			throw new PilhaVaziaException("Não há topo na pinha vermelha, está vazia");
		}
		return mainPile[redTop];
	}
	
	public boolean isRedEmpty() {
		if (redTop < 0) return true; else return false;
	}
	
	public int redSize() {
		return redTop+1;
	}
	
	public void blackPush(Object x) {
		if (blackTop-1 == redTop) {
			Object[] auxPile = new Object[totalSize*2];
			
			for (int i=0; i<=redTop; i++) {
				auxPile[i] = mainPile[i]; 
			}
			
			for (int i=blackTop; i<totalSize; i++) {
				auxPile[i+totalSize] = mainPile[i];
			}
			mainPile = auxPile;
			blackTop += totalSize;
			totalSize *= 2;
		}
		blackTop--;
		mainPile[blackTop] = x;
	}
	
	public Object blackPop() {
		if (blackTop > totalSize-1) {
			throw new PilhaVaziaException("Não dá pra popar a pilha preta, está vazia");
		}
		blackTop++;
		return mainPile[blackTop-1];
	}
	
	public Object blackTop() {
		if (blackTop > totalSize-1) {
			throw new PilhaVaziaException("Não há topo na pinha preta, está vazia");
		}
		return mainPile[blackTop];
	}
	
	public boolean isBlackEmpty() {
		if (blackTop < totalSize) return false; else return true;
	}
	
	public int blackSize() {
		return totalSize - blackTop; 
	}
}
