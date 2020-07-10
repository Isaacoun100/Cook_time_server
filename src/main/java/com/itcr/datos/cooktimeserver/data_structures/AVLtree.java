package com.itcr.datos.cooktimeserver.data_structures;



public class AVLtree<T extends Comparable<T>>
{
    NodeAVL<T> root;
    static final int COUNT = 10;

    // A utility function to get height of the tree
    public int height(NodeAVL<T> N)
    {
        if (N == null)
            return 0;
        return N.getHeight();
    }

    // A utility function to get maximum of two integers
    public int max(int a, int b)
    {
        return Math.max(a, b);
    }

    // A utility function to right rotate subtree rooted with y
    // See the diagram given above.
    public NodeAVL<T> rightRotate(NodeAVL<T> y)
    {
        NodeAVL<T> x = y.getLeft();
        NodeAVL<T> T2 = x.getRight();

        // Perform rotation
        x.setRight(y);
        y.setLeft(T2);

        // Update heights
        y.setHeight( max(height(y.getLeft()), height(y.getRight())) + 1);
        x.setHeight(max(height(x.getLeft()), height(x.getRight())) + 1);

        // Return new root
        return x;
    }

    // A utility function to left rotate subtree rooted with x
    // See the diagram given above.
    public NodeAVL<T> leftRotate(NodeAVL<T> x)
    {
        NodeAVL<T> y = x.getRight();
        NodeAVL<T> T2 = y.getLeft();

        // Perform rotation
        y.setLeft(x);
        x.setRight(T2);

        // Update heights
        x.setHeight(max(height(x.getLeft()), height(x.getRight())) + 1);
        y.setHeight(max(height(y.getLeft()), height(y.getRight())) + 1);

        // Return new root
        return y;
    }

    // Get Balance factor of node N
    public int getBalance(NodeAVL<T> N)
    {
        if (N == null)
            return 0;
        return height(N.getLeft()) - height(N.getRight());
    }
    public void add(T data, int key){
        this.root = add_aux(this.root, data, key);
    }
    public NodeAVL<T> add_aux(NodeAVL<T> node, T data, int key)
    {
        /* 1. Perform the normal BST rotation */
        if (node == null)
            return (new NodeAVL<T>(data, key));

        if (key < node.getKey())
            node.setLeft(add_aux(node.getLeft(), data, key));
        else if (key > node.getKey())
            node.setRight(add_aux(node.getRight(), data, key));
        else // Equal keys not allowed
            return node;

        /* 2. Update height of this ancestor node */
        node.setHeight(1 + max(height(node.getLeft()), height(node.getRight())));

		/* 3. Get the balance factor of this ancestor
		node to check whether this node became
		unbalanced */
        int balance = getBalance(node);

        // If this node becomes unbalanced, then
        // there are 4 cases Left Left Case
        if (balance > 1 && key < node.getLeft().getKey())
            return rightRotate(node);

        // Right Right Case
        if (balance < -1 && key > node.getRight().getKey())
            return leftRotate(node);

        // Left Right Case
        if (balance > 1 && key > node.getLeft().getKey())
        {
            node.setLeft(leftRotate(node.getLeft()));
            return rightRotate(node);
        }

        // Right Left Case
        if (balance < -1 && key < node.getRight().getKey())
        {
            node.setRight(rightRotate(node.getRight()));
            return leftRotate(node);
        }

        /* return the (unchanged) node pointer */
        return node;
    }

    /* Given a non-empty binary search tree, return the
    node with minimum key value found in that tree.
    Note that the entire tree does not need to be
    searched. */
    public NodeAVL<T> minValueNode(NodeAVL<T> node)
    {
        NodeAVL<T> current = node;

        /* loop down to find the leftmost leaf */
        while (current.getLeft() != null)
            current = current.getLeft();

        return current;
    }
    public void deleteNode(int key){
        this.root = deleteNode_aux(this.root, key);
    }
    public NodeAVL<T> deleteNode_aux(NodeAVL<T> root, int key)
    {
        // STEP 1: PERFORM STANDARD BST DELETE
        if (root == null)
            return root;

        // If the key to be deleted is smaller than
        // the root's key, then it lies in left subtree
        if (key < root.getKey())
            root.setLeft(deleteNode_aux(root.getLeft(), key));

            // If the key to be deleted is greater than the
            // root's key, then it lies in right subtree
        else if (key > root.getKey())
            root.setRight(deleteNode_aux(root.getRight(), key));

            // if key is same as root's key, then this is the node
            // to be deleted
        else
        {

            // node with only one child or no child
            if ((root.getLeft() == null) || (root.getRight() == null))
            {
                NodeAVL<T> temp = null;
                if (temp == root.getLeft())
                    temp = root.getRight();
                else
                    temp = root.getLeft();

                // No child case
                if (temp == null)
                {
                    temp = root;
                    root = null;
                }
                else // One child case
                    root = temp; // Copy the contents of
                // the non-empty child
            }
            else
            {

                // node with two children: Get the inorder
                // successor (smallest in the right subtree)
                NodeAVL<T> temp = minValueNode(root.getRight());

                // Copy the inorder successor's data to this node
                root.setKey(temp.getKey());

                // Delete the inorder successor
                root.setRight(deleteNode_aux(root.getRight(), temp.getKey()));
            }
        }

        // If the tree had only one node then return
        if (root == null)
            return root;

        // STEP 2: UPDATE HEIGHT OF THE CURRENT NODE
        root.setHeight(max(height(root.getLeft()), height(root.getRight())) + 1);

        // STEP 3: GET THE BALANCE FACTOR OF THIS NODE (to check whether
        // this node became unbalanced)
        int balance = getBalance(root);

        // If this node becomes unbalanced, then there are 4 cases
        // Left Left Case
        if (balance > 1 && getBalance(root.getLeft()) >= 0)
            return rightRotate(root);

        // Left Right Case
        if (balance > 1 && getBalance(root.getLeft()) < 0)
        {
            root.setLeft(leftRotate(root.getLeft()));
            return rightRotate(root);
        }

        // Right Right Case
        if (balance < -1 && getBalance(root.getRight()) <= 0)
            return leftRotate(root);

        // Right Left Case
        if (balance < -1 && getBalance(root.getRight()) > 0)
        {
            root.setRight(rightRotate(root.getRight()));
            return leftRotate(root);
        }

        return root;
    }


    public void printAVL(NodeAVL<T> node){
        print_aux(node, 0);
    }
    public void print_aux(NodeAVL<T> root, int space){
        // Base case
        if (root == null)
            return;

        // Increase distance between levels
        space += COUNT;

        // Process right child first
        print_aux(root.getRight(), space);

        // Print current node after space
        // count
        System.out.print("\n");
        for (int i = COUNT; i < space; i++)
            System.out.print(" ");
        System.out.print(root.getKey() + "\n");

        // Process left child
        print_aux(root.getLeft(), space);

    }
    
}



