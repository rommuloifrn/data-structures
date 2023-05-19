package dqpile;

import llqueue.Queue;

public class DQPile {
	// Pilha de duas filas usando filas de lista ligada!
	Queue queueOne;
	Queue queueTwo;
	
	public DQPile() {
		queueOne = new Queue();
		queueTwo = new Queue();
	}
	
	public void mimDaAPilaMano() {
		queueOne.mimDaAFilaMano();
	}
	
	public void push(Object x) {
		queueOne.enqueue(x);
	}
	
	public Object pop() {
		int lasting = queueOne.size()-1;
		for (int i=lasting; i>0; i--) {
			queueTwo.enqueue(queueOne.dequeue());
		}
		Object judas = queueOne.dequeue();
		for (int i=lasting; i>0; i--) {
			queueOne.enqueue(queueTwo.dequeue());
		}
		return judas;
	}
	
	public Object top() {
		int lasting = queueOne.size()-1;
		for (int i=lasting; i>0; i--) {
			queueTwo.enqueue(queueOne.dequeue());
		}
		Object judas = queueOne.first();
		queueTwo.enqueue(queueOne.dequeue());
		
		for (int i=lasting+1; i>0; i--) {
			queueOne.enqueue(queueTwo.dequeue());
		}
		return judas;
	}
	
	Integer size() {
		return queueOne.size();
	}
	
	boolean isEmpty() {
		return queueOne.isEmpty();
	}
}
