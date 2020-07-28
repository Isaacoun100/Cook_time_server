package com.itcr.datos.cooktimeserver.data_structures;

/**
 * This class will be the object we will use as the Alphabetical Splay Tree
 * @param <T>
 */
public class AlphSplayTree<T> {

    private AlphNodeSplay<T> root = null;
    private int length = 0;

    /**
     * This method will add a node to the AlphSplayTree Tree
     * @param data that is going to be added
     * @param key that will identify the node
     */
    public void add(T data, String key) {
        AlphNodeSplay<T> tmp = root;
        AlphNodeSplay<T> root = null;
        while (tmp != null) {
            root = tmp;
            if (greater(key,root.getKey()).equals("leaf")) {
                tmp = tmp.getRight();
            } else {
                tmp = tmp.getLeft();
            }
        }
        tmp = new AlphNodeSplay<>(data, key);
        tmp.setFather(root);
        if (root == null) {
            root = tmp;
        } else if (greater(key, root.getKey()).equals("leaf")) {
            root.setRight(tmp);
        } else {
            root.setLeft(tmp);
        }
        splay(tmp);
        length++;
    }

    /**
     * This will delete the node which key corresponds to
     * @param key of the node that we want to delete
     */
    public void delete(String key){
        AlphNodeSplay<T> node = getNode(key);
        delete(node);
    }

    /**
     * This is an auxiliary method for delete method, this will delete a given node from the tree and adjust the tree
     * @param node that is going to be deleted
     */
    public void delete(AlphNodeSplay<T> node){
        if (node == null)
            return;
        splay(node);
        if ((node.getLeft() != null) && (node.getRight() != null)) {
            AlphNodeSplay<T> min = node.getLeft();

            while (min.getRight() != null) {
                min = min.getRight();
            }

            min.setRight(node.getRight());
            node.getRight().setFather(min);
            node.getLeft().setFather(null);
            root = node.getLeft();
        }
        else if (node.getRight() != null) {
            node.getRight().setFather(null);
            root = node.getRight();
        }
        else if (node.getLeft() != null) {
            node.getLeft().setFather(null);
            root = node.getLeft();
        } else {
            root = null;
        }
        node.setFather(null);
        node.setLeft(null);
        node.setRight(null);
        node = null;
        length--;
    }

    /**
     * This will adjust the give node in the tree
     * @param node that is going to be adjusted
     */
    private void splay(AlphNodeSplay<T> node){
        while (node.getFather() != null) {
            AlphNodeSplay<T> father = node.getFather();
            AlphNodeSplay<T> grandFather = father.getFather();
            if (grandFather == null) {
                if (node == father.getLeft()) {
                    zag(node, father);
                } else {
                    zig(node, father);
                }
            } else {
                if (node == father.getLeft()) {
                    if (father == grandFather.getLeft()) {
                        zag(father, grandFather);
                        zag(node, father);
                    } else {
                        zag(node, node.getFather());
                        zig(node, node.getFather());
                    }
                } else {
                    if (father == grandFather.getLeft()) {
                        zig(node, node.getFather());
                        zag(node, node.getFather());
                    } else {
                        zig(father, grandFather);
                        zig(node, father);
                    }
                }
            }
        }
        root = node;
    }

    /**
     * Zag rotation for the AlphSplayTree
     * @param node that we're going to start
     * @param father the final line where the zag is going to be applied
     */
    private void zag(AlphNodeSplay<T> node, AlphNodeSplay<T> father) {
        if (father.getFather() != null) {
            if (father == father.getFather().getLeft()) {
                father.getFather().setLeft(node);
            } else {
                father.getFather().setRight(node);
            }
        }
        if (node.getRight() != null) {
            node.getRight().setFather(father);
        }
        node.setFather(father.getFather());
        father.setFather(node);
        father.setLeft(node.getRight());
        node.setRight(father);
    }

    /**
     * Zig rotation for the AlphSplayTree
     * @param node that we're going to start
     * @param father the final line where the zig is going to be applied
     */
    private void zig(AlphNodeSplay<T> node, AlphNodeSplay<T> father) {
        if (father.getFather() != null) {
            if (father == father.getFather().getLeft()) {
                father.getFather().setLeft(node);
            } else {
                father.getFather().setRight(node);
            }
        }
        if (node.getLeft() != null) {
            node.getLeft().setFather(father);
        }
        node.setFather(father.getFather());
        father.setFather(node);
        father.setRight(node.getLeft());
        node.setLeft(father);
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
        size = Math.min(leaf.length(), key.length());

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
     * This method will return the data of the given node
     * @param key that we're going to search
     * @return The AlphNodeSplay we needed
     */
    public AlphNodeSplay<T> getNode(String key){
        AlphNodeSplay<T> prevNode = null;
        AlphNodeSplay<T> tmp = root;
        while (tmp != null){
            prevNode = tmp;
            if (greater(key,tmp.getKey()).equals("leaf")){
                tmp = tmp.getRight();
            }else if (greater(key,tmp.getKey()).equals("key")){
                tmp = tmp.getLeft();
            }else if (greater(key,tmp.getKey()).equals("equals")){
                splay(tmp);
                return tmp;
            }

        }
        if (prevNode != null){
            splay(prevNode);
            return null;
        }
        return null;

    }

    /**
     * @return Returns the root of the tree.
     */
    public AlphNodeSplay<T> getRoot() {
        return this.root;
    }

    /**
     * @return Returns the size of the tree.
     */
    public int getlength() {
        return length;
    }

    /**
     * This will return the length of the given tree
     * @param length of the given tree
     */
    public void setLength(int length) {
        this.length = length;
    }

    /**
     * Utility function that clears the BST
     */
    public void clear(){
        this.root=null;
        setLength(0);
    }

    /**
     * Function that calls recursively the function of printing the tree´s diagram
     * @return returns the recursive function
     */
    public String toString() {
        AlphNodeSplay<T> newRoot = null;
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
    private StringBuilder toString(StringBuilder prefix, boolean isTail, StringBuilder sb,AlphNodeSplay<T> head) {
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
