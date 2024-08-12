package hashtable;

public interface HashTableInterface {
	Object findElement(Integer k);
	
	Object insertItem(Integer k);
	
	Object removeElement(Integer k);
	
	Integer size();
	
	Boolean isEmpty();
	
	Object[] keys();
}
