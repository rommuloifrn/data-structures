package avltree;

import bstree.BSTNode;

public class AVLNode extends BSTNode {
    private int fb;

    public AVLNode(Object element, AVLNode leftChild, AVLNode rightChild, AVLNode parent, Integer fb) {
        super(fb, leftChild, rightChild, parent);
        this.fb = fb;
    }

    public int getFb() {
        return fb;
    }

    public void setFb(int fb) {
        this.fb = fb;
    }

}
