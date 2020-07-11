package com.itcr.datos.cooktimeserver.data_structures;

public class NodeAVL<T extends Comparable<T>> {
    private T data;
    private int key, height;
    private NodeAVL<T> left;
    private NodeAVL<T> right;

    NodeAVL(T data, int d)
    {
        this.data = data;
        key = d;
        height = 1;
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

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public NodeAVL<T> getLeft() {
        return left;
    }

    public void setLeft(NodeAVL<T> left) {
        this.left = left;
    }

    public NodeAVL<T> getRight() {
        return right;
    }

    public void setRight(NodeAVL<T> right) {
        this.right = right;
    }
}
