package bstree;

import java.util.Iterator;

public class BinarySearchTree {
	private BSTNode root;
	
	public BinarySearchTree() {
	}
	
	public Integer size() {
		
	}
	private Integer sizePreOrder(BSTNode x, Integer size) {
		if (x == null) return 0; 
		size++;
		Iterator<BSTNode> it = x.ChildrenIterator();
		int leftChildQuantity = sizePreOrder(x.getLeftChild(), 0);
		int rightChildQuantity = sizePreOrder(x.getRightChild(), 0);
		if (leftChildQuantity > rightChildQuantity)
		
		
	}
	
	public BSTNode root() {
		return root;
	}
	
	public BSTNode parent(BSTNode x) {
		return x.getParent();
	}
	
	public Iterator<BSTNode> children(BSTNode x) {
		return x.ChildrenIterator();
	}
}
