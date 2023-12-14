package hashtable;

public class HashTable implements HashTableInterface {
	private static final Object NO_SUCH_KEY = null;
	
	private final Integer initialSize = 16;
	private boolean usesDoubleHash;
	
	private Integer[] arr;
	private Integer size;
	
	public HashTable(boolean usesDoubleHash) {
		this.arr = new Integer[initialSize];
		this.size = initialSize;
		this.usesDoubleHash = usesDoubleHash;
	}
	
	public Object findElement(Integer key) {
		for (int i=0; i<size; i++) {
			if (arr[i] == key) return key; 
		}
		return NO_SUCH_KEY;
	}
	
	public Integer insertItem(Integer x) {
		if (arr[x%size] == null) {
			arr[x%size] = x;
		} else { // tratamento da colisão
			if (usesDoubleHash) {
				
			} else {
				while ()
			}
		}
		
		
		
		
		size++;
		return x;
	}
	
	public Object removeElement(Integer key) {
		for (int i=0; i<size; i++) {
			if (arr[i] == key) {
				Integer temp = arr[i];
				arr[i] = null;
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
	
	
	
}
