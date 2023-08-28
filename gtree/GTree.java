package gtree;

import java.util.Iterator;

public class GTree {
	private GTNode root;
	
	public GTree() {
		//this.root = new GTNode(null);
	}
	
	public void printaEssaTree() {
		if (root==null) System.out.println("Está vazia!"); 
		else {
		preOrderPrint(root, 0);
		System.out.printf("\nsize: %d\n", size(root));
		}
	}
	
	public void preOrderPrint(GTNode x, int depth) { // o que o Iterator.next() faz eh retornar o elemento atual e acessar o próximo.
		/* Uma coisa que eh interessante notar aqui eh que é necessário armazenar o iterador em uma variável (aqui usei a "it").
		 * Isso acontece pois se você ficar acessando o iterator pelo método a partir do nó, o estado dele nunca vai mudar, os retornos do "next()", por exemplo, serão sempre
		 * os mesmos e vai gerar um loop infinito. */
		depthPrinter(depth); System.out.printf("%s", x.getValue()); if (isRoot(x)) System.out.printf(" (root)\n"); else System.out.printf("\n");
 		Iterator<GTNode> it = x.getChildsIt();
		while (it.hasNext()) {
			preOrderPrint(it.next(), depth+1);
		}
	}
	
	public GTNode getRoot() {
		return root;
	}
	
	public void addRoot(Object x) {
		root = new GTNode(x);
	}
	
	public void add(GTNode target, Object x) {
		if (root.getValue() == null) root.setValue(x); else {
			target.getChilds().add(new GTNode(x));
		}
	}
	
	public boolean isEmpty() {
		return root==null;
	}
	
	public Integer size(GTNode x) {
		if (x.getValue() == null) return 0;
		Iterator<GTNode> it = x.getChildsIt();
		
		int size = 1;
		while (it.hasNext()) {
			size += size(it.next());
		}
		return size;	
	}
	
	public Integer height(GTNode x) {
		if (x == null) return 0;
		Iterator<GTNode> it = x.getChildsIt();
		int height = 1;
		int childHeight = 0;
		while(it.hasNext()) {
			if ( height(it.next())>childHeight ) childHeight = \
		}
	}
	
	public boolean isRoot(GTNode x) {
		return (root == x);
	}
	
	// métodos auxiliares
	
	public void depthPrinter(int depth) {
		for (int i=depth; i!=0; i--)
			System.out.printf("   ");
	}
	
	public GTNode getNodeByString(GTNode x, String s) {
		if (s == "" || root.getValue() == null) return root;
		
		Iterator<GTNode> it = x.getChildsIt();
		if (x.getValue().equals(s)) return x;
		
		else {
			while ( it.hasNext() ) { //getNodeByString(it.next(), s);
				GTNode actual = it.next();
				GTNode wtf = getNodeByString(actual, s); 
				if (wtf != null) return wtf;
			}
			return null;
			// como q trata exceçao em backtracking? aehaueuheuahuehu
		}
		// o throw de excecao tava sendo ativado sempre. procura no root -> procura em filho do root -> lança o throw abaixo depois de procurar no filho do root. Acho que consegui achar o problema.
		// acho que nao eh bom que ele taque exceçao, se nao cada nó que nao tiver filho com o value igual a string vai tacar exceçao.
		
	}
	
	
}
