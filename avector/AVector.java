package avector;

import exceptions.VectorPequenino;

public class AVector {
	// Essa implementação, se usada corretamente, mostra índices vazios do array como "null", diferente das outras.
	private Object[] arrai;
	private Integer capacity;
	private Integer size;
	
	public AVector() {
		arrai = new Object[10];
		capacity = 3;
		size = 0;
	}
	
	public void mimDaEssaDiamba() {
		System.out.printf("[ ");
		for (int i=0; i<capacity; i++) {
			System.out.printf("%s, ", arrai[i]);
		}
		System.out.printf("]"); System.out.printf(" size: %d, cap: %d, isEmpty: %b%n", size(), capacity, isEmpty());
	}
	
	private void doubleCap() {
		Object [] aux = new Object[capacity*2];
		for(int i=0; i<size; i++) {
			aux[i] = arrai[i];
		}
		arrai = aux;
		capacity *= 2;
	}
	
	public Object elemAtRank(Integer rank) {
		return arrai[rank];
	}
	
	public Object replaceAtRank(Integer rank, Object x) {
		if (rank > size) throw new VectorPequenino("Fora do range, amigão.");
		Object oldBoy = arrai[rank];
		arrai[rank] = x;
		if (oldBoy == null) size++;
		return oldBoy;
	}
	
	public void insertAtRank(Integer rank, Object x) {
		if (rank > size) throw new VectorPequenino("Fora do range, amigão.");
		if (size == capacity) doubleCap();
		
		for (int i=size; i>rank; i--) {
			arrai[i] = arrai[i-1];
		}
		arrai[rank] = x;
		size++;
	}
	
	public Object removeAtRank(Integer rank) {
		Object judas = arrai[rank];
		for (int i=rank; i<size; i++) {
			if (i == capacity-1) arrai[i] = null; else {
				arrai[i] = arrai[i+1];
			}
		}
		size--;
		return judas;
	}
	
	public Integer size() {
		return size;
	}
	
	public boolean isEmpty() {
		return (size<1);
	}
}
