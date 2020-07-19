package com.itcr.datos.cooktimeserver.data_structures;

/**
 * Class for the implementation of the alphabetical AVL tree
 * @param <T>
 */
public class AlphAvlTree<T> {

    AlphNodeAVL<T> root = null;
    private int length;

    /**
     *Calls the recursive function for adding nodes
     * @param data data that gets inserted
     * @param key string that identifies each node
     */
    public void add(T data, String key){
        this.root = addNode(data, key, this.root);
    }

    /**
     * Recursive function for adding nodes
     * @param data data that gets inserted in the node
     * @param key string that identifies each node
     * @param node root node that changes recursively
     * @return the node
     */
    public AlphNodeAVL<T> addNode(T data, String key, AlphNodeAVL<T> node){
        if (node == null) {
            length = 1;
            return (new AlphNodeAVL<T>(data, key));
        }
        if (greater(key, node.getKey()).equals("key"))
            node.setLeft(addNode(data, key, node.getLeft()));
        else if (greater(key, node.getKey()).equals("leaf"))
            node.setRight(addNode(data, key, node.getRight()));
        else // Equal keys not allowed
            return node;

        length++;
        /* 2. Update height of this ancestor node */
        node.setHeight(1 + max(height(node.getLeft()), height(node.getRight())));

		/* 3. Get the balance factor of this ancestor
		node to check whether this node became
		unbalanced */
        int balance = getBalance(node);

        // If this node becomes unbalanced, then
        // there are 4 cases Left Left Case
        if (balance > 1 && greater(key, node.getLeft().getKey()).equals("key"))
            return rightRotate(node);

        // Right Right Case
        if (balance < -1 && greater(key, node.getRight().getKey()).equals("leaf"))
            return leftRotate(node);

        // Left Right Case
        if (balance > 1 && greater(key,node.getLeft().getKey()).equals("leaf")) {
            node.setLeft(leftRotate(node.getLeft()));
            return rightRotate(node);
        }

        // Right Left Case
        if (balance < -1 && greater(key, node.getRight().getKey()).equals("key"))
        {
            node.setRight(rightRotate(node.getRight()));
            return leftRotate(node);
        }


        /* return the (unchanged) node pointer */
        return node;



    }

    /**
     * Function that identifies which string is greater than the other
     * @param leaf first string
     * @param key second string
     * @return return ´leaf´ if the first string is greater, ´key´ if the second string is greater, or ´equals´ if they are the same
     */
    public String greater(String leaf, String key){

        if(leaf.equals(key)){
            return "equals";
        }

        int size,count=0;
        size = Math.max(leaf.length(), key.length());

        while(count<=size){

            if(key.charAt(count)>leaf.charAt(count)){
                return "key";
            }
            else if(key.charAt(count)<leaf.charAt(count)){
                return "leaf";
            }
            else{
                count++;
            }
        }

        if(key.length() > leaf.length()){
            return "key";
        }
        else{
            return "leaf";
        }
    }

    /**
     * Method that calls the recursive function for deleting nodes
     * @param key the string that identifies each node
     */
    public void deleteNode(String key){
        this.root = deleteNode_aux(this.root, key);
    }

    /**
     * Recursive function for deleting nodes
     * @param root that root that changes recursively
     * @param key the string that identifies each node
     * @return returns the node
     */
    public AlphNodeAVL<T> deleteNode_aux(AlphNodeAVL<T> root, String key)
    {
        // STEP 1: PERFORM STANDARD BST DELETE
        if (root == null)
            return root;

        // If the key to be deleted is smaller than
        // the root's key, then it lies in left subtree
        if (greater(key, root.getKey()).equals("key"))
            root.setLeft(deleteNode_aux(root.getLeft(), key));

            // If the key to be deleted is greater than the
            // root's key, then it lies in right subtree
        else if (greater(key, root.getKey()).equals("leaf"))
            root.setRight(deleteNode_aux(root.getRight(), key));

            // if key is same as root's key, then this is the node
            // to be deleted
        else
        {

            // node with only one child or no child
            if ((root.getLeft() == null) || (root.getRight() == null))
            {
                AlphNodeAVL<T> temp = null;
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
                AlphNodeAVL<T> temp = minValueNode(root.getRight());

                // Copy the inorder successor's data to this node
                root.setKey(temp.getKey());

                // Delete the inorder successor
                root.setRight(deleteNode_aux(root.getRight(), temp.getKey()));
            }
            length--;
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

    /**
     * Function that tells the minimum value leaf in the tree
     * @param node the node for finding the leftmost leaf
     * @return returns the leftmost leaf
     */
    public AlphNodeAVL<T> minValueNode(AlphNodeAVL<T> node)
    {
        AlphNodeAVL<T> current = node;

        /* loop down to find the leftmost leaf */
        while (current.getLeft() != null)
            current = current.getLeft();

        return current;
    }

    /**
     * Function for getting the balance of the nodes
     * @param N the node
     * @return returns the balance of the node by using the heights
     */
    public int getBalance(AlphNodeAVL<T> N)
    {
        if (N == null)
            return 0;
        return height(N.getLeft()) - height(N.getRight());
    }

    /**
     * Function that gets the height of the node
     * @param N the node
     * @return returns the height of the node
     */
    public int height(AlphNodeAVL<T> N)
    {
        if (N == null)
            return 0;
        return N.getHeight();
    }

    /**
     * A utility function to get maximum of two integers
     * @param a the first integer
     * @param b the second integer
     * @return returns the maximun value integer
     */
    public int max(int a, int b)
    {
        return Math.max(a, b);
    }

    /**
     * Function that returns the root of the tree
     * @return returns the root
     */
    public AlphNodeAVL<T> getRoot(){
        return this.root;
    }


    public int getLength(){
        return this.length;
    }

    /**
     *  A utility function to right rotate subtree rooted with y
     * @param y the node
     * @return returns the new root
     */
    public AlphNodeAVL<T> rightRotate(AlphNodeAVL<T> y)
    {
        AlphNodeAVL<T> x = y.getLeft();
        AlphNodeAVL<T> T2 = x.getRight();

        // Perform rotation
        x.setRight(y);
        y.setLeft(T2);

        // Update heights
        y.setHeight( max(height(y.getLeft()), height(y.getRight())) + 1);
        x.setHeight(max(height(x.getLeft()), height(x.getRight())) + 1);

        return x;
    }

    /**
     * A utility function to left rotate subtree rooted with x
     * @param x the node
     * @return returns the new root
     */
    public AlphNodeAVL<T> leftRotate(AlphNodeAVL<T> x) {
        AlphNodeAVL<T> y = x.getRight();
        AlphNodeAVL<T> T2 = y.getLeft();

        // Perform rotation
        y.setLeft(x);
        x.setRight(T2);

        // Update heights
        x.setHeight(max(height(x.getLeft()), height(x.getRight())) + 1);
        y.setHeight(max(height(y.getLeft()), height(y.getRight())) + 1);

        // Return new root
        return y;
    }

    /**
     * Utility function that clears the BST
     */
    public void clear(){
        this.root=null;
        length=0;
    }
    /**
     * Function that calls recursively the function of printing the tree´s diagram
     * @return returns the recursive function
     */
    public String toString() {
        AlphNodeAVL<T> newRoot = null;
        try {
            newRoot = this.root;
            return this.toString(new StringBuilder(), true, new StringBuilder(), newRoot).toString();
        }
        catch (NullPointerException e){
            e.printStackTrace();
            return null;
        }
    }
    /**
     * Recursive function used for printing de AVL tree´s diagram
     * @param prefix StringBuilder instance
     * @param isTail a boolean
     * @param sb StringBuilder instance
     * @param head the root
     * @return returns the tree´s diagram
     */
    private StringBuilder toString(StringBuilder prefix, boolean isTail, StringBuilder sb,AlphNodeAVL<T> head) {
        if(head.getRight()!=null) {
            sb.append(toString(new StringBuilder().append(prefix).append(isTail ? "│   " : "    "), false, new StringBuilder(), head.getRight()));
        }
        sb.append(prefix).append(isTail ? "└──" : "┌──").append("[").append(head.getKey()).append("]").append("\n");
        if(head.getLeft()!=null) {
            sb.append(toString(new StringBuilder().append(prefix).append(isTail ? "    " : "│   "), true, new StringBuilder(), head.getLeft()));
        }
        return sb;
    }
}
