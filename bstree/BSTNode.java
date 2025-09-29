package bstree;

public class BSTNode {
    private Object element;
    private BSTNode parent;
    private BSTNode leftChild;
    private BSTNode rightChild;

    public BSTNode(Object element, BSTNode leftChild, BSTNode rightChild, BSTNode parent) {
        this.parent = parent;
        this.element = element;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public boolean isRoot() {
        return this.parent == null;
    }

    public BSTNode getParent() {
        return this.parent;
    }

    public boolean hasLeftChild() {
        return leftChild.getElement() != null;
    }

    public boolean hasRightChild() {
        return rightChild.getElement() != null;
    }

    public BSTNode getLeftChild() {
        return this.leftChild;
    }

    public BSTNode getRightChild() {
        return this.rightChild;
    }

    public void setLeftChild(BSTNode leftChild) {
        this.leftChild = leftChild;
    }

    public void setRightChild(BSTNode rightChild) {
        this.rightChild = rightChild;
    }

    public Object getElement() {
        return element;
    }

    public void setElement(Object o) {
        this.element = o;
    }

    public String toString() {
        return String.format("%s (l: %s, r: %s)", getElement(), getLeftChild().getElement(), getRightChild().getElement());
    }

    public void setParent(BSTNode parent) {
        this.parent = parent;
    }
}
