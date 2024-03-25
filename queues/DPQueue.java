package queues;
import exceptions.PilhaVaziaException;
import piles.LinkedListPile;

public class DPQueue implements IQueue {
	// eh um pouco triste não ter chegado na solução sozinho, grande xavião me deu a solução e eu só vou implementar :c
	// Fila de dupla-pilha usando pilhas de lista ligada!
	LinkedListPile pileOne;
	LinkedListPile pileTwo;
	
	public DPQueue() {
		pileOne = new LinkedListPile();
		pileTwo = new LinkedListPile();
	}
	
	public void mimDaAFilaMano() {
		pileOne.mimDaAPilaMano();
	}
	
	public void push(Object x) {
		pileOne.push(x);
	}
	
	public Object top() {
		if (isEmpty()) return new PilhaVaziaException("Vazio, mano.");
		Object ximbas = pileOne.pop();
		pileOne.push(ximbas);
		return ximbas; 
	}
	
	public Object pop() {
		int lasting = pileOne.size()-1;
		while (pileOne.size()>1) {
			pileTwo.push(pileOne.pop());
		}
		
		Object judas = pileOne.pop();
		
		for (int i=lasting; i>0; i--) {
			pileOne.push(pileTwo.pop());
		}
		return judas;
	};
	
	public Object first() {
		int lasting = pileOne.size()-1;
		while (pileOne.size()!=1) {
			pileTwo.push(pileOne.pop());
		}
		
		Object judas = pileOne.pop();
		// Em teoria, a única diferença desse first para o dequeue eh que depois de popar o judas eu o colocarei novamente.
		pileOne.push(judas);
		for (int i=lasting; i>0; i--) {
			pileOne.push(pileTwo.pop());
		}
		return judas;
	};
	
	public int size() {
		return 1;
	}
	
	public boolean isEmpty() {
		return pileOne.isEmpty();
	}
}
