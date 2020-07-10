package com.itcr.datos.cooktimeserver.data_structures;

public class BinarySearchTree<T extends Comparable<T>>{
    private NodeTree<T> root = null;

    /**
     * Adds a node to the tree
     * @param data the object contained in the node
     * @param key a value representing the value of the node
     */
    public void add(T data, int key){
        if (this.isEmpty()) {
            root = new NodeTree<T>(data, key);
        }else{
            NodeTree<T> tmp = root;
            while (tmp != null){
                if (key > tmp.getKey()){
                    if (tmp.getRight() == null){
                        tmp.setRight(new NodeTree<T>(data, key));
                        return;
                    }else{
                        tmp = tmp.getRight();
                    }
                }else{
                    if (tmp.getLeft() == null){
                        tmp.setLeft(new NodeTree<>(data, key)); return;
                    }
                    else{
                        tmp = tmp.getLeft();
                    }
                }
            }
        }
    }

    /**
     * Method that verifies if the key is contained in the BST
     * @param key variable that is verified
     * @return returns true if the key is contained or false if it´s not
     */
    public boolean contains (int key) {
        if (root == null) {
            return false;
        }
        NodeTree<T> tmp = root;
        while (tmp != null) {
            if (tmp.getKey() == key) {
                return true;
            }
            else if (tmp.getKey() > key) {
                tmp = tmp.getLeft();
            }
            else {tmp = tmp.getRight();
            }
        }
        return false;
    }

    /**
     * Method that gets the lowest key in the BST
     * @return returns -1 if the node is not found or if the tree is empty
     */
    public int getMin(){
        if (!isEmpty()){
            NodeTree<T> tmp = root;
            while (tmp.getLeft() != null) {
                tmp = tmp.getLeft();
            }
            return tmp.getKey();
        }
        else{
            return -1;
        }
    }
    /**
     * Method that gets the highest key in the BST
     * @return returns -1 if the node is not found or if the tree is empty
     */
    public int getMax(){
        if (!isEmpty()){
            NodeTree<T> tmp = root;
            while (tmp.getRight() != null) {tmp = tmp.getRight();}
            return tmp.getKey();
        }
        else{
            return -1;
        }
    }

    /**
     * Deletes the node in the BST
     * @param key key about to be deleted
     * @throws Exception throws exception if the node is not found
     */
    public void delete(int key) throws Exception {
        this.root = deleteAux(this.root, key);
    }

    /**
     * Auxiliar method that gets called in delete.
     * @param root the root of the BST
     * @param key key about to be deleted
     * @return returns the root
     * @throws Exception throws exception if the node is not found
     */
    private NodeTree<T> deleteAux(NodeTree<T> root, int key) throws Exception {
        if (root == null){
            throw new Exception("The node was not found");
        }
        else if(key < root.getKey()){
            NodeTree<T> left = deleteAux(root.getLeft(), key);
            root.setLeft(left);
        }
        else if(key > root.getKey()){
            NodeTree<T> right = deleteAux(root.getRight(), key);
            root.setRight(right);
        }
        else{
            NodeTree<T> copy = root;
            if (copy.getRight() == null){
                root = copy.getLeft();
            }
            else if(copy.getLeft() == null){
                root = copy.getRight();
            }
            else{
                copy = change(copy);
            }
            copy = null;
        }
        return root;
    }

    /**
     *
     * @param root
     * @return
     */
    private NodeTree<T> change(NodeTree<T> root){
        NodeTree<T> copy = root;
        NodeTree<T> maxLeft = root.getLeft();

        while (maxLeft.getRight() != null){
            copy = maxLeft;
            maxLeft = maxLeft.getRight();
        }
        root.setData(maxLeft.getData());
        if(copy == root){
            copy.setLeft(maxLeft.getRight());
        }
        else{
            copy.setRight(maxLeft.getRight());
        }
        return maxLeft;
    }
    public boolean isEmpty (){
        return this.root == null;
    }
    public NodeTree<T> getRoot(){
        return this.root;
    }

    public String toString(BinarySearchTree<T> tree) {
        return this.toString(new StringBuilder(), true, new StringBuilder(),tree.getRoot()).toString();
    }

    @SuppressWarnings("DuplicatedCode")
    public StringBuilder toString(StringBuilder prefix, boolean isTail, StringBuilder sb, NodeTree<T> head) {
        if(head.getRight()!=null) {
            sb.append(toString(new StringBuilder().append(prefix).append(isTail ? "│   " : "    "), false, new StringBuilder(), head.getRight()));
        }
        sb.append(prefix).append(isTail ? "└──" : "┌──").append("[").append(head.getData()).append("]").append("\n");
        if(head.getLeft()!=null) {
            sb.append(toString(new StringBuilder().append(prefix).append(isTail ? "    " : "│   "), true, new StringBuilder(), head.getLeft()));
        }
        return sb;
    }
}
