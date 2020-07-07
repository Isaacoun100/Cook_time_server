package com.itcr.datos.cooktimeserver.data_structures;

public class AlphBinaryTree<T> {

    private AlphNodeTree<T> root = null;

    public void add(T data, String key){
        if (this.isEmpty()) {
            root = new AlphNodeTree<T>(data, key);
        }else
            {
            AlphNodeTree<T> tmp = root;

        }
    }

    public boolean isEmpty (){
        return this.root == null;
    }

}
