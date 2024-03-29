package com.itcr.datos.cooktimeserver.data_structures;

/**
 *This class will be the object we will use as the Alphabetical Node Tree
 * @param <T>
 */
public class AlphNodeTree<T> {

    private T data;

    private String key;
    private AlphNodeTree<T> left;
    private AlphNodeTree<T> right;

    /**
     * Constructor for the AlphNodeTree
     * @param data that we're going to store
     * @param key that will be used to sort
     */
    public AlphNodeTree(T data, String key) {
        this.data = data;
        this.key = key;
    }

    /**
     * Gets the data
     *
     * @return the data in the node
     */
    public T getData() {
        return data;
    }

    /**
     * Sets the data
     *
     * @param data that is going to be set
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
     * Gets the key value
     *
     * @return the key value
     */
    public String getKey() {
        return key;
    }

    /**
     * Sets the key value
     *
     * @param key that is going to be set
     */
    public void setKey(String key) {
        this.key = key;
    }

    /**
     * Gets the left node
     *
     * @return left node
     */
    public AlphNodeTree<T> getLeft() {
        return left;
    }

    /**
     * Sets the left node
     * @param left that is going to be set
     */
    public void setLeft(AlphNodeTree<T> left) {
        this.left = left;
    }

    /**
     * Gets the right node
     *
     * @return right node
     */
    public AlphNodeTree<T> getRight() {
        return right;
    }

    /**
     * Sets the left node
     * @param right that is going to be set
     */
    public void setRight(AlphNodeTree<T> right) {
        this.right = right;
    }
}
