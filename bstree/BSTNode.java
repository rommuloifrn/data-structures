package bstree;

public class BSTNode {
    private Object element;
    private BSTNode daddy;
    private BSTNode leftChild;
    private BSTNode rightChild;

    public BSTNode(Object element, BSTNode leftChild, BSTNode rightChild) {
        this.daddy = null;
        this.element = element;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public BSTNode(Object element, BSTNode leftChild, BSTNode rightChild, BSTNode daddy) {
        this.daddy = daddy;
        this.element = element;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public boolean hasLeftChild() {
        return leftChild != null;
    }

    public boolean hasRightChild() {
        return rightChild != null;
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
}
