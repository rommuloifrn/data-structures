package trees;

import java.util.ArrayList;
import java.util.Iterator;

import nodes.GTNode;

public class GTree {
	private GTNode root;
	
	public GTree() {
		//this.root = new GTNode(null);
	}
	// ha 2 formas de implementar a interface: fazer os backtrackings aqui e manejar os parâmetros de função lá no Main.java ou fazer funções de print preparadas aqui e só usar lá. Lembrar de normalizar depois.
	
	
	
	
	public void printaEssaTree() {
		if (root==null) System.out.println("Está vazia!"); 
		else {
		preOrderPrint(root, 0);
		System.out.printf("\nsize: %d, height: %d\n", size(root), height(root));
		}
	}
	public void preOrderPrint(GTNode x, int depth) { // o que o Iterator.next() faz eh retornar o elemento atual e acessar o próximo.
		/* Uma coisa que eh interessante notar aqui eh que é necessário armazenar o iterador em uma variável (aqui usei a "it").
		 * Isso acontece pois se você ficar acessando o iterator pelo método a partir do nó, o estado dele nunca vai mudar, os retornos do "next()", por exemplo, serão sempre
		 * os mesmos e vai gerar um loop infinito. */
		depthPrinter(depth); System.out.printf("%s", x.getValue()); if (isRoot(x)) System.out.printf(" (root)\n"); else System.out.printf("\n");
 		Iterator<GTNode> it = x.getChildrenIt();
		while (it.hasNext()) {
			preOrderPrint(it.next(), depth+1);
		}
	}
	
	public GTNode root() {
		return root;
	}
	
	public GTNode parent(GTNode x) {
		return parentPreOrder(root, x);
	}
	public GTNode parentPreOrder(GTNode x, GTNode child) {
		if (x == child) return child;
		
		Iterator<GTNode> it = x.getChildrenIt();
		while (it.hasNext()) {
			GTNode actual = it.next();
			if (actual == child) return x;
			GTNode searchDeeper = parentPreOrder(actual, child); 
			if (searchDeeper != null) return searchDeeper;
		}
		return null;
	}
	
	public Iterator<GTNode> children(GTNode x) {
		return x.getChildrenIt();
	}
	
	public Integer size(GTNode x) {
		if (x.getValue() == null) return 0;
		Iterator<GTNode> it = x.getChildrenIt();
		
		int size = 1;
		while (it.hasNext()) {
			size += size(it.next());
		}
		return size;	
	}
	
	public Integer height(GTNode x) {
		if (x == null) return 0;
		Iterator<GTNode> it = x.getChildrenIt(); // a cada execução, retorna 1 ate nao ter mais filho.
		
		if (it.hasNext()) {
			int height = height(it.next());
			
			while (it.hasNext()) {
				int nextHeight = height(it.next());
				if (nextHeight>height) height = nextHeight;
			}
			return 1 + height;
			
		} else return 1;
	}
	
	public boolean isEmpty() {
		return root==null;
	}

	public Iterator<Object> elements() {
		ArrayList<Object> arr = new ArrayList<Object>();
		preOrderElements(root, arr);
		return arr.iterator();
	}
	public void printElements() {
		Iterator<Object> it = elements();
		System.out.printf("[ ");
		while (it.hasNext()) {
			System.out.printf("%s, ", it.next());
		}
		System.out.printf("]\n");
	}
	public void preOrderElements(GTNode x, ArrayList<Object> arr) {
		arr.add(x.getValue());
		Iterator<GTNode> childsIt = x.getChildrenIt();
		while (childsIt.hasNext()) {
			preOrderElements(childsIt.next(), arr);
		}

	}
	// não colocado na interface. Nem testado :/
	public Iterator<GTNode> nodes() {
		ArrayList<GTNode> arr = new ArrayList<GTNode>();
		preOrderNodes(root, arr);
		return arr.iterator();
	}
	public void preOrderNodes(GTNode x, ArrayList<GTNode> arr) {
		arr.add(x);
		Iterator<GTNode> childsIt = x.getChildrenIt();
		while (childsIt.hasNext()) {
			preOrderNodes(childsIt.next(), arr);
		}

	}
	
	public boolean isInternal(GTNode x) {
		return !x.getChilds().isEmpty();
	}
	
	public boolean isExternal(GTNode x) {
		return !isInternal(x);
	}
	
	public boolean isRoot(GTNode x) {
		return (root == x);
	}
	
	public int depth(GTNode x) {
		return depthPreOrder(x, root, 0);
	}
	public Integer depthPreOrder(GTNode target, GTNode x, int depth) {
		if (x == target) return depth;
 		Iterator<GTNode> it = x.getChildrenIt();
 		
		while (it.hasNext()) {
			Integer next = depthPreOrder(target, it.next(), depth+1);
			if (next != null) return next;
		}
		return null;
	}
	
	public Object replace(GTNode target, Object x) {
		Object aux = target.getValue();
		target.setValue(x);
		return aux;
	}
	
	// métodos auxiliares
	
	public void addRoot(Object x) {
		root = new GTNode(x);
	}
	public void add(GTNode target, Object x) {
		if (root.getValue() == null) root.setValue(x); else {
			target.getChilds().add(new GTNode(x));
		}
	}
	
	public void depthPrinter(int depth) {
		for (int i=depth; i!=0; i--)
			System.out.printf("   ");
	}
	
	public GTNode getNodeByString(GTNode x, String s) {
		if (s == "" || root.getValue() == null) return root;
		
		Iterator<GTNode> it = x.getChildrenIt();
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
