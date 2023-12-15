package hashtable;

public class HashTable implements HashTableInterface {
	private static final Object NO_SUCH_KEY = null;
	
	private final Integer initialCap = 16;
	private boolean usesDoubleHash;
	
	private Integer[] arr;
	private Integer cap;
	private Integer size;
	
	public HashTable(boolean usesDoubleHash) {
		this.arr = new Integer[initialCap];
		this.size = 0;
		this.cap = initialCap;
		this.usesDoubleHash = usesDoubleHash;
	}
	
	public Object findElement(Integer key) {
		for (int i=0; i<cap; i++) {
			if (arr[i] == key) return key; 
		}
		return NO_SUCH_KEY;
	}
	
	public Integer insertItem(Integer x) {
		if (size == cap-1) doubleCap();
		
		if (arr[x%11] == null) {
			arr[x%11] = x;
		} else if (usesDoubleHash) { // tratamento de colisão: hash duplo
			int q = 11;
			int i = q-x%q;
			if (arr[i] != null) {
				i = q + 2%cap; // segundo hash
				
				while (arr[i] != null) {
					if (i == size-1) i = 0;
					else i++;
				}
			}
			arr[i] = x;
		} else { // tratamento de colisão: linear probing
			int i = x%7;
			while (arr[i] != null) {
				if (i == size-1) i = 0;
				else i++;
			}
			arr[i] = x;
				
			
		}
		
		
		size++;
		return x;
	}
	
	public Object removeElement(Integer key) {
		System.out.println("aAAAAAAAAAAAAAAAAAAAAA!");
		for (int i=0; i<cap; i++) {
			if (arr[i] == key) {
				Integer temp = arr[i];
				System.out.println("um!");
				arr[i] = null;
				System.out.println("dois!!");
				size--;
				return temp;
			}
		}
		return NO_SUCH_KEY;
	}
	
	public Integer size() {
		return size;
	}
	
	public Boolean isEmpty() {
		return (size==0);
	}
	
	public Integer[] keys() {
		return arr;
	}
	
	// métodos auxiliares
	
	private void doubleCap() {
		Integer [] aux = new Integer[cap*2];
		for(int i=0; i<size; i++) {
			aux[i] = arr[i];
		}
		arr = aux;
		cap *= 2;
	}
	
	public void print() {
		System.out.printf("[ ");
		for (int i=0; i<cap; i++) {
			System.out.printf("%s, ", arr[i]);
		}
		System.out.printf("]"); System.out.printf(" size: %d, cap: %d, isEmpty: %b%n", size(), cap, isEmpty());
	}
	
}
