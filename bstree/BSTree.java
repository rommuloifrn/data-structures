package bstree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BSTree {
    private BSTNode root;

    public BSTree() {
        this.root = new BSTNode(null, null, null);
    }

    public BSTree(Object el) {
        this.root = new BSTNode(
                el,
                new BSTNode(null, null,
                        null),
                new BSTNode(null, null, null));
    }

    public void Show() {
        System.out.println(this.nodesList());
    }

    public boolean isEmpty() {
        return root.getElement() == null;
    }

    public Iterator<BSTNode> nodesIterator() {
        List<BSTNode> list = new ArrayList<BSTNode>();

        preOrder(root, (n) -> {
            list.add(n);
        });

        return list.iterator();
    }

    public List<BSTNode> nodesList() {
        List<BSTNode> list = new ArrayList<BSTNode>();

        preOrder(root, (n) -> {
            list.add(n);
        });

        return list;
    }

    interface DoAtPreOrder {
        public void operation(BSTNode node);
    }

    void preOrder(BSTNode node, DoAtPreOrder operator) {
        if (isEmpty())
            return;
        operator.operation(node);

        if (node.getLeftChild().getElement() != null)
            preOrder(node.getLeftChild(), operator);
        if (node.getRightChild().getElement() != null)
            preOrder(node.getRightChild(), operator);
    }

    public void insert(Integer k) {
        if (isEmpty()) {
            root.setElement(k);
            root.setLeftChild(
                    new BSTNode(null, null, null));
            root.setRightChild(
                    new BSTNode(null, null, null));
        }

        else {
            BSTNode target = this.root;

            while (target.getElement() != null) {
                if ((int) target.getElement() < k)
                    target = target.getRightChild();
                else if ((int) target.getElement() > k)
                    target = target.getLeftChild();
                else
                    return;
            }

            target.setElement(k);
            target.setLeftChild(new BSTNode(null, null, null));
            target.setRightChild(new BSTNode(null, null, null));
        }
    }
}
