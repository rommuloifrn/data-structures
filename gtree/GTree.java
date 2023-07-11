package gtree;

import java.util.Iterator;

public class GTree {
	private GTNode root;
	
	public GTree() {
		this.root = new GTNode(null);
	}
	
	public void preOrder(GTNode x) {
		System.out.printf("%s\n", x.getValue());
		while (x.getChildsIt().hasNext()) {
			preOrder(x.getChildsIt().next());
		}
	}
	
	public GTNode getRoot() {
		return root;
	}
	
	public void add(GTNode target, Object x) {
		if (root == null) root.setValue(x); else {
			target.getChilds().add(new GTNode(x));
		}
	}
	
	/* inicio de preorder com impressao
	public void spacer(int space) {
		for (int i=0; i < space; i++) System.out.printf(" ");
	}
	public void preOrder(GTNode x) { preOrder(x, -3); }
	public void preOrder(GTNode x, int spacing) {
		System.out.printf("%s", x.getValue());
		spacer(spacing+3);
		for (int i; i<x.getChilds().size(); i++)
			preOrder()
		
	}
	*/
}
