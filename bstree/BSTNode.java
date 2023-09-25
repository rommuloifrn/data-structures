package bstree;

import java.util.ArrayList;
import java.util.Iterator;

public class BSTNode {
	private BSTNode parent;
	private Object element;
	private BSTNode leftChild;
	private BSTNode rightChild;
	
	public BSTNode(Object x) {
		this.element = x;
	}
	
	public Iterator<BSTNode> ChildrenIterator() {
		ArrayList<BSTNode> arr = new ArrayList<BSTNode>();
		arr.add(leftChild);
		arr.add(rightChild);
		return arr.iterator();
	}
	
	
	

	public BSTNode getParent() {
		return parent;
	}

	public void setParent(BSTNode parent) {
		this.parent = parent;
	}

	public Object getElement() {
		return element;
	}

	public void setElement(Object element) {
		this.element = element;
	}

	public BSTNode getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(BSTNode leftChild) {
		this.leftChild = leftChild;
	}

	public BSTNode getRightChild() {
		return rightChild;
	}

	public void setRightChild(BSTNode rightChild) {
		this.rightChild = rightChild;
	}
}
