package com.itcr.datos.cooktimeserver.data_structures;

public class NodeTree<T extends Comparable <T>>{
    private T data;
    private int key, height;
    private NodeTree<T> left;
    private NodeTree<T> right;

    public int idata;
    public int depth = 0;
    public int level = 0;
    public int drawPos = 0;

    /**
     * Constructor that sets the data to the node
     *
     * @param data data of generic type saved on new node
     */
    public NodeTree(T data, int key) {
        this.data = data;
        this.key = key;
    }
    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    /**
     * Gets the right node
     *
     * @return right node
     */
    public NodeTree<T> getRight() {
        return right;
    }

    /**
     * Sets the right node
     *
     * @param right data stored on right node
     */

    public void setRight(NodeTree<T> right) {
        this.right = right;
    }

    /**
     * Gets the left node
     *
     * @return left node
     */

    public NodeTree<T> getLeft() {
        return left;
    }

    /**
     * Sets the left node
     *
     * @param left data stored on left node
     */
    public void setLeft(NodeTree<T> left) {
        this.left = left;
    }
}
