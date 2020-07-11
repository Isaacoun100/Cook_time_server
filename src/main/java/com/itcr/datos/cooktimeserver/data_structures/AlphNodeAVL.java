package com.itcr.datos.cooktimeserver.data_structures;

/**
 * Class for the creation of the alphabetical AVL tree´s node
 * @param <T> the type of data
 */
public class AlphNodeAVL<T> {

    private T data;

    private String key;
    private int height;
    private AlphNodeAVL<T> left;
    private AlphNodeAVL<T> right;

    /**
     * The class constructor
     * @param data the data that get´s inserted in the node
     * @param key string that identifies each node
     */
    public AlphNodeAVL(T data, String key) {
        this.data = data;
        this.key = key;
        this.height = 1;
    }

    /**
     *
     * @return returns the data
     */
    public T getData() {
        return data;
    }

    /**
     * Sets the new data
     * @param data data parameter
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
     *
     * @return returns the key
     */
    public String getKey() {
        return key;
    }

    /**
     * Sets the new key
     * @param key the new key
     */
    public void setKey(String key) {
        this.key = key;
    }

    /**
     *
     * @return returns the new height
     */
    public int getHeight() {
        return height;
    }

    /**
     * Sets the new height
     * @param height the new height
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     *
     * @return returns the left node
     */
    public AlphNodeAVL<T> getLeft() {
        return left;
    }

    /**
     * Sets the left node
     * @param left the new left node
     */
    public void setLeft(AlphNodeAVL<T> left) {
        this.left = left;
    }

    /**
     *
     * @return returns the right node
     */
    public AlphNodeAVL<T> getRight() {
        return right;
    }

    /**
     * Sets the right node
     * @param right the new right node
     */
    public void setRight(AlphNodeAVL<T> right) {
        this.right = right;
    }
}
