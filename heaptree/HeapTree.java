package heaptree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HeapTree {
    private HeapNode root;
    private HeapNode lastInserted;

    public void Show() {
        System.out.println(this.nodesList());
    }

    public void insert(Object o) {
        HeapNode node = new HeapNode(o, null, null, null);
        // acha o proximo lugar

        if (isEmpty()) {
            root = node;
            lastInserted = node;
        }

        HeapNode actual = lastInserted;

        while (actual != root && !actual.isLeftChild()){
            actual = actual.getDaddy();
        }

        if (lastInserted == root) {
            root.setLeftChild(node);
            node.setDaddy(root);
            lastInserted = node;
        } else if (actual.isLeftChild()) {
            actual.getDaddy().setRightChild(node);
        }
    }

    public HeapNode pop() throws Exception {
        throw new Exception("Nao implementado");
    }

    public boolean isEmpty() {
        return root == null;
    }

    public Iterator<HeapNode> nodesIterator() {
        List<HeapNode> list = new ArrayList<HeapNode>();

        preOrder(root, (n) -> {
            list.add(n);
        });

        return list.iterator();
    }

    public List<HeapNode> nodesList() {
        List<HeapNode> list = new ArrayList<HeapNode>();

        preOrder(root, (n) -> {
            list.add(n);
        });

        return list;
    }

    interface DoAtPreOrder {
        public void operation(HeapNode node);
    }

    void preOrder(HeapNode node, DoAtPreOrder operator) {
        if (isEmpty())
            return;
        operator.operation(node);

        if (node.hasLeftChild())
            preOrder(node.getLeftChild(), operator);
        if (node.hasRightChild())
            preOrder(node.getRightChild(), operator);
    }
}
