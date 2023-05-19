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
		for (int i=lasting+1; i>1; i--) {
			queueTwo.enqueue(queueOne.dequeue());
		}
		Object judas = queueOne.dequeue();
		for (int i=lasting; i>0; i--) {
			queueOne.enqueue(queueTwo.dequeue());
		}
		return judas;
	}
}
