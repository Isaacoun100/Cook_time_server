package com.itcr.datos.cooktimeserver.data_structures;

public class NodeAVL<T extends Comparable<T>> {
    private T data;
    private int key;
    public int height;
    private NodeAVL<T> left, right;

    /**
     * Constructor that sets the data to the node
     *
     * @param data data of generic type saved on new node
     */
    public NodeAVL(T data, int key) {
        this.data = data;
        this.key = key;
        this.height = 1;
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
    public NodeAVL<T> getRight() {
        return right;
    }

    /**
     * Sets the right node
     *
     * @param right data stored on right node
     */

    public void setRight(NodeAVL<T> right) {
        this.right = right;
    }

    /**
     * Gets the left node
     *
     * @return left node
     */

    public NodeAVL<T> getLeft() {
        return left;
    }

    /**
     * Sets the left node
     *
     * @param left data stored on left node
     */
    public void setLeft(NodeAVL<T> left) {
        this.left = left;
    }
}
