package gtree;

public class GTree {
	private GTNode root;
	
	public GTree() {
	}
	public void preOrder(GTNode x) { preOrder(x, -3); }
	public void preOrder(GTNode x, int spacing) {
		System.out.printf("%s", x.getValue());
		spacer(spacing+3);
		for (int i; i<x.getChilds().size(); i++)
			preOrder()
		
	}
	
	public void spacer(int space) {
		for (int i=0; i < space; i++) System.out.printf(" ");
	}
	
	public void add(GTNode target, Object x) {
		if (root == null) root.setValue(x); else {
			root.getChilds().insertLast(x);
		}
	}
}
