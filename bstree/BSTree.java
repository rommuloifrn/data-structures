package bstree;

import java.util.ArrayList;
import java.util.Iterator;

public class BSTree {
	private BSTNode root;
	
	public BSTree() {
	}
	
	public Integer size() {
		return sizePreOrder(root, 0);
	}
	private Integer sizePreOrder(BSTNode x, Integer size) {
		if (x == null) return 0;
		size++;
		int childsSizeSum = sizePreOrder(x.getLeftChild(), 0) + sizePreOrder(x.getRightChild(), 0);  
		size += childsSizeSum;
		
		return size;
	}
	
	public Integer height() {
		return heightPreOrder(root, 0);
	}
	public Integer heightPreOrder(BSTNode x, int height) {
		if (x == null) return null;
		height++;
		//Iterator<BSTNode> it = x.ChildrenIterator();
		int leftChildQuantity = heightPreOrder(x.getLeftChild(), 0);
		int rightChildQuantity = heightPreOrder(x.getRightChild(), 0);
		height += Math.max(leftChildQuantity, rightChildQuantity);
		
		return height;
	}
	
	public Iterator<Object> elements() {
		ArrayList<Object> arr = new ArrayList<Object>();
		preOrderElements(root, arr);
		
		return arr.iterator();		
	}
	public void preOrderElements(BSTNode x, ArrayList<Object> arr) {
		if (x == null) return;
		arr.add(x.getElement());
		preOrderElements(x.getLeftChild(), arr);
		preOrderElements(x.getParent(), arr);
	}
	
	public Iterator<BSTNode> nodes() {
		ArrayList<BSTNode> arr = new ArrayList<BSTNode>();
		nodesPreOrder(root, arr);
		return arr.iterator();
	}
	public void nodesPreOrder(BSTNode x, ArrayList<BSTNode> arr) {
		if (x == null) return;
		arr.add(x);
		nodesPreOrder(x.getLeftChild(), arr);
		nodesPreOrder(x.getParent(), arr);
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
	
	
	public boolean isInternal(BSTNode x) {
		return (x.getLeftChild() != null || x.getRightChild() != null);
	}
	
	public boolean isExternal(BSTNode x) {
		return (x.getLeftChild() == null && x.getRightChild() == null);
	}
	
	public boolean isRoot(BSTNode x) {
		return (x == root);
	}
	
	public Integer depth(BSTNode x) {
		if (isRoot(x)) return 0;
		else return 1+depth(x);
	}
	
	public Object replace(BSTNode x, Object o) {
		Object aux = x.getElement();
		x.setElement(o);
		return aux;
	}
	
	// auxiliar methods
	
	public void setRoot(Object x) {
		root = new BSTNode(x);
	}
	public void add(BSTNode target, Object x, boolean onLeft) {
		if (root.getElement() == null) root.setElement(x); 
		else if (onLeft) target.setLeftChild(new BSTNode(x));
		else target.setRightChild(new BSTNode(x)); 
			
	}
}
