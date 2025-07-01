package heaptree;

public class HeapNode {
    private Object element;
    private HeapNode daddy;
    private HeapNode leftChild;
    private HeapNode rightChild;

    
    public HeapNode(Object element, HeapNode daddy, HeapNode leftChild, HeapNode rightChild) {
        this.element = element;
        this.daddy = daddy;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public boolean isLeftChild() {
        return this.daddy.leftChild == this;
    }

    public Object getElement() {
        return element;
    }
    public void setElement(Object element) {
        this.element = element;
    }
    public HeapNode getDaddy() {
        return daddy;
    }
    public void setDaddy(HeapNode daddy) {
        this.daddy = daddy;
    }
    public HeapNode getLeftChild() {
        return leftChild;
    }
    public void setLeftChild(HeapNode leftChild) {
        this.leftChild = leftChild;
    }
    public HeapNode getRightChild() {
        return rightChild;
    }
    public void setRightChild(HeapNode rightChild) {
        this.rightChild = rightChild;
    }

    public boolean hasLeftChild() {
        return leftChild != null;
    }

    public boolean hasRightChild() {
        return rightChild != null;
    }

    public String toString() {
        String stringfiedNode = String.format("%s", getElement());
        if (this.hasLeftChild() || this.hasRightChild()) {
            stringfiedNode += "(";
            if (this.hasLeftChild()) {
                stringfiedNode += String.format("l: %s", this.getLeftChild().getElement());
                if (this.hasRightChild()) stringfiedNode += String.format(", r: %s)", this.getRightChild().getElement());
            }
            else {
                stringfiedNode += String.format("r: %s)", this.getRightChild().getElement());
            }
            
        }
        return stringfiedNode;
    }
}
