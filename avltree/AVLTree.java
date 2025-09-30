package avltree;

import bstree.BSTNode;
import bstree.BSTree;

public class AVLTree extends BSTree {

    public AVLTree() {
        super();
        this.root = new AVLNode(null, null, null, null, 0);
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
            AVLNode target = (AVLNode) this.root;

            while (target.getElement() != null) {
                if ((int) target.getElement() < k)
                    target = (AVLNode) target.getRightChild();
                else if ((int) target.getElement() > k)
                    target = (AVLNode) target.getLeftChild();
                else
                    return;
            }

            target.setElement(k);
            target.setLeftChild(new BSTNode(null, null, null, target));
            target.setRightChild(new BSTNode(null, null, null, target));
        }
    }
}
