package com.itcr.datos.cooktimeserver.data_structures;

public class AlphBinaryTree<T> {

    private AlphNodeTree<T> root = null;

    public void add(T data, String key){
        if(this.root==null) root = new AlphNodeTree<T>(data, key);
        else addNode(data, key,this.root);
    }

    public void addNode(T data, String key, AlphNodeTree<T> tmp){

        if(greater(key,tmp.getKey())){
            if(tmp.getRight()==null) tmp.setRight(new AlphNodeTree<T>(data,key));
            else addNode(data,key,tmp.getRight());
        }
        else{
            if(tmp.getLeft() == null) tmp.setLeft(new AlphNodeTree<T>(data,key));
            else addNode(data,key,tmp.getLeft());
        }
    }

    public boolean greater(String leaf, String key){

        int size,count=0;
        size = Math.max(leaf.length(), key.length());

        while(count<=size){

            if(key.charAt(count)>leaf.charAt(count)){
                return true;
            }
            else if(key.charAt(count)<leaf.charAt(count)){
                return false;
            }
            else{
                count++;
            }

        }

        return leaf.length() <= key.length();

    }

    public boolean isEmpty (){
        return this.root == null;
    }

    public String getMin(){
        if (!isEmpty()){
            AlphNodeTree<T> tmp = root;
            while (tmp.getLeft() != null) {tmp = tmp.getLeft();}
            return tmp.getKey();
        }
        return "null";
    }

    public String getMax(){
        if (!isEmpty()){
            AlphNodeTree<T> tmp = root;
            while (tmp.getRight() != null) {tmp = tmp.getRight();}
            return tmp.getKey();
        }
        return "null";
    }

}
