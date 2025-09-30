package bstree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BSTree {
    private BSTNode root;

    public BSTree() {
        this.root = new BSTNode(null, null, null, null);
    }

    public BSTree(Object el) {
        this.root = new BSTNode(
                el,
                new BSTNode(null, null,
                        null, root),
                new BSTNode(null, null, null, root), null);
    }

    public void Show() {
        System.out.println(this.nodesList());
        // TODO
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

    interface DoAt {
        public void operation(BSTNode node);
    }

    void preOrder(BSTNode node, DoAt operator) {
        if (isEmpty())
            return;
        operator.operation(node);

        if (node.getLeftChild().getElement() != null)
            preOrder(node.getLeftChild(), operator);
        if (node.getRightChild().getElement() != null)
            preOrder(node.getRightChild(), operator);
    }

    void inOrder(BSTNode node, DoAt operator) {
        if (isEmpty())
            return;

        if (node.getLeftChild().getElement() != null)
            inOrder(node.getLeftChild(), operator);

        operator.operation(node);

        if (node.getRightChild().getElement() != null)
            preOrder(node.getRightChild(), operator);
    }

    private BSTNode marchelo(BSTNode node) {
        if (isEmpty())
            return null;

        if (node.getLeftChild().getElement() != null)
            return marchelo(node.getLeftChild());

        if (isExternal(node))
            return node;

        if (node.getRightChild().getElement() != null)
            return marchelo(node.getRightChild());

        return null;
    }

    public void insert(Integer k) {
        if (isEmpty()) {
            root.setElement(k);
            root.setLeftChild(
                    new BSTNode(null, null, null, root));
            root.setRightChild(
                    new BSTNode(null, null, null, root));
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
            target.setLeftChild(new BSTNode(null, null, null, target));
            target.setRightChild(new BSTNode(null, null, null, target));
        }
    }

    public BSTNode find(Integer k) {
        if (isEmpty())
            return null;

        BSTNode target = this.root;

        while (target.getElement() != null) {
            if (target.getElement() == k)
                return target;

            // acessa o nó mas nunca seu elemento, portanto nao vai dar erro. O null é
            // tratado pela condição do while
            if ((int) target.getElement() < k)
                target = target.getRightChild();
            else if ((int) target.getElement() > k)
                target = target.getLeftChild();
        }

        return null;
    }

    public BSTNode remove(Integer k) {
        BSTNode node = find(k);
        if (node == null)
            return null;

        if (node == root) {
            BSTNode aux = new BSTNode(root.getElement(), root.getLeftChild(), root.getRightChild(), null);

            if (node.hasLeftChild()) {

            }

            root.setLeftChild(null);
            root.setRightChild(null);
            root.setElement(null);

            return aux;
        }

        BSTNode parent = node.getParent();

        if (node == parent.getLeftChild()) { // caso seja filho esquerdo, desce para o filho direito e faz inOrder pra
                                             // esquerda

            if (node.hasRightChild()) {
                BSTNode sucessor = marchelo(node.getRightChild());

                // pega o elemento do sucessor e coloca no node a ser removido
                node.setElement(sucessor.getElement());

                // limpa o elemento do sucessor e desengata ele dos filhos
                sucessor.setElement(null);
                sucessor.setLeftChild(null);
                sucessor.setRightChild(null);
            } else { // caso excluido nao tenha filho direito
                BSTNode leftChild = node.getLeftChild();
                parent.setLeftChild(leftChild);
                leftChild.setParent(parent);
            }

        } else if (node == parent.getRightChild()) {
            System.out.println("fuck!!!");

            if (node.hasLeftChild()) {
                BSTNode sucessor = marchelo(node.getRightChild());

                // pega o elemento do sucessor e coloca no node a ser removido
                node.setElement(sucessor.getElement());

                // limpa o elemento do sucessor e desengata ele dos filhos
                sucessor.setElement(null);
                sucessor.setLeftChild(null);
                sucessor.setRightChild(null);
            } else { // caso excluido nao tenha filho esquerdo
                BSTNode rightChild = node.getRightChild();
                parent.setRightChild(rightChild);
                rightChild.setParent(parent);
            }
        }

        return node;
    }

    public boolean isInternal(BSTNode node) {
        return node.getLeftChild().getElement() != null || node.getRightChild().getElement() != null;
    }

    public boolean isExternal(BSTNode node) {
        if (node.getElement() == null) return false;

        Object leftElement = node.getLeftChild().getElement();
        Object rightElement = node.getRightChild().getElement();

        return leftElement == null && rightElement == null;
    }

    public BSTNode root() {
        return root;
    }

    public BSTNode parent(BSTNode node) {
        return node.getParent();
    }

    public Iterator<BSTNode> children(BSTNode node) {
        List<BSTNode> list = new ArrayList<BSTNode>();

        list.add(node.getLeftChild());
        list.add(node.getRightChild());

        return list.iterator();
    }

    public boolean isRoot(BSTNode node) {
        return this.root == node;
    }

    public Integer depth(BSTNode node) {
        if (root.getElement() == null) return 0;

        if (node.isRoot())
            return 0;

        return 1 + depth(node.getParent());
    }

    public Integer height(BSTNode node) {
        if (node == null || node.getElement() == null)
            return 0;
        if (isExternal(node)) return 0;

        int leftHeight = height(node.getLeftChild());
        int rightHeight = height(node.getRightChild());

        if (leftHeight > rightHeight){
            return 1 + leftHeight;
        }
            
        return 1 + rightHeight;
    }
}
