package com.itcr.datos.cooktimeserver.data_structures;

public class AVLtree<T extends Comparable<T>> {
    private NodeAVL<T> root = null;
    static final int COUNT = 10;

    public NodeAVL<T> insert(NodeAVL<T> node,T data,  int key) {

        /* 1.  Perform the normal BST insertion */
        if (node == null)
            return (new NodeAVL<T>(data, key));

        if (key < node.getKey())
            node.setLeft(insert(node.getLeft(), data, key));
        else if (key > node.getKey())
            node.setRight(insert(node.getRight(), data, key));
        else  // Duplicate keys not allowed
            return node;

        /* 2. Update height of this ancestor node */
        node.height = 1 + max(getHeight(node.getLeft()), getHeight(node.getRight()));

        /* 3. Get the balance factor of this ancestor
              node to check whether this node became
              unbalanced */
        int balance = getBalance(node);

        // If this node becomes unbalanced, then there
        // are 4 cases Left Left Case
        if (balance > 1 && key < node.getLeft().getKey())
            return rightRotate(node);

        // Right Right Case
        if (balance < -1 && key > node.getRight().getKey())
            return leftRotate(node);

        // Left Right Case
        if (balance > 1 && key > node.getLeft().getKey()) {
            node.setLeft(leftRotate(node.getLeft()));
            return rightRotate(node);
        }

        // Right Left Case
        if (balance < -1 && key < node.getRight().getKey()) {
            node.setRight(rightRotate(node.getRight()));
            return leftRotate(node);
        }

        /* return the (unchanged) node pointer */
        return node;
    }
    public int max(int a, int b){
        return Math.max(a, b);

    }
    // A utility function to right rotate subtree rooted with y
    public NodeAVL<T> rightRotate(NodeAVL<T> node) {
        NodeAVL<T> n = node.getLeft();
        NodeAVL<T> n1 = n.getRight();

        // Perform rotation
        n.setRight(node);
        node.setLeft(n1);

        // Update heights
        node.height = max(getHeight(node.getLeft()), getHeight(node.getRight())) + 1;
        n.height = max(getHeight(n.getLeft()), getHeight(n.getRight())) + 1;

        // Return new root
        return node;
    }
    // A utility function to left rotate subtree rooted with x
    // See the diagram given above.
    public NodeAVL<T> leftRotate(NodeAVL<T> node) {
        NodeAVL<T> n = node.getRight();
        NodeAVL<T> n1 = n.getLeft();

        // Perform rotation
        n.setLeft(node);
        node.setRight(n1);

        //  Update heights
        node.height = max(getHeight(node.getLeft()), getHeight(node.getRight())) + 1;
        n.height = max(getHeight(n.getLeft()), getHeight(n.getRight())) + 1;

        // Return new root
        return n;
    }
    public int getHeight(NodeAVL<T> n){
        if (n == null)
            return 0;
        return n.height;
    }
    public int getBalance(NodeAVL<T> n){
        if (n == null)
            return 0;
        return getHeight(n.getLeft()) - getHeight(n.getRight());
    }
    public void preOrder(NodeAVL<T> node){
        preorderAux(node, 0);
    }
    public void preorderAux(NodeAVL<T> root, int space){
        // Base case
        if (root == null)
            return;

        // Increase distance between levels
        space += COUNT;

        // Process right child first
        preorderAux(root.getRight(), space);

        // Print current node after space
        // count
        System.out.print("\n");
        for (int i = COUNT; i < space; i++)
            System.out.print(" ");
        System.out.print(root.getKey() + "\n");

        // Process left child
        preorderAux(root.getLeft(), space);

    }

}
