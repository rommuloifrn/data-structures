package dpqueue;
import llpile.Pile;

public class DPQueue {
	// eh um pouco triste não ter chegado na solução sozinho, grande xavião me deu a solução e eu só vou implementar :c
	// Fila de dupla-pilha usando pilhas de lista ligada!
	Pile pileOne;
	Pile pileTwo;
	
	public DPQueue() {
		pileOne = new Pile();
		pileTwo = new Pile();
	}
	
	public void mimDaAFilaMano() {
		pileOne.mimDaAPilaMano();
	}
	
	void enqueue(Object x) {
		pileOne.push(x);
	}
	
	Object dequeue() {
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
	
	Object first() {
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
	
	Integer size() {
		return 1;
	}
	
	boolean isEmpty() {
		return pileOne.isEmpty();
	}
}
