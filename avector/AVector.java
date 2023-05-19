package avector;

public class AVector {
	private Object[] arrai;
	private Integer capacity;
	private Integer size;
	
	public AVector() {
		arrai = new Object[10];
		capacity = 10;
		size = 0;
	}
	
	public void mimDaEssaDiamba() {
		System.out.printf("[ ");
		for (int i=0; i<capacity; i++) {
			System.out.printf("%s ", arrai[i]);
		}
		System.out.printf("]"); System.out.printf(" size: %d, cap: %d, isEmpty: %b%n", size(), capacity, isEmpty());
	}
	
	public Object elemAtRank(Integer rank) {
		return arrai[rank];
	}
	
	public Object replaceAtRank(Integer rank, Object x) {
		Object oldBoy = arrai[rank];
		arrai[rank] = x;
		return oldBoy;
	}
	
	public void insertAtRank(Integer rank, Object x) {
		// criar o aumento de tamanho do Vector, diabos!!!
		for (int i=size; i>=rank; i--) {
			arrai[i] = arrai[i-1];
		}
		arrai[rank] = x;
		size++;
	}
	
	public Object removeAtRank(Integer rank) {
		Object judas = arrai[rank];
		for (int i=rank; i<size-1; i++) {
			arrai[i] = arrai[i+1];
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
