package com.itcr.datos.cooktimeserver.data_structures;

public class AlphNodeSplay<T> {

    private T data;

    private String key;
    private AlphNodeSplay<T> father;
    private AlphNodeSplay<T> left;
    private AlphNodeSplay<T> right;

    /**
     * The class constructor
     * @param data the data that get´s inserted in the node
     * @param key string that identifies each node
     */
    public AlphNodeSplay(T data, String key) {
        this.data = data;
        this.key = key;

    }

    public AlphNodeSplay<T> getFather() {
        return father;
    }

    public void setFather(AlphNodeSplay<T> father) {
        this.father = father;
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
     * @return returns the left node
     */
    public AlphNodeSplay<T> getLeft() {
        return left;
    }

    /**
     * Sets the left node
     * @param left the new left node
     */
    public void setLeft(AlphNodeSplay<T> left) {
        this.left = left;
    }

    /**
     *
     * @return returns the right node
     */
    public AlphNodeSplay<T> getRight() {
        return right;
    }

    /**
     * Sets the right node
     * @param right the new right node
     */
    public void setRight(AlphNodeSplay<T> right) {
        this.right = right;
    }
}

