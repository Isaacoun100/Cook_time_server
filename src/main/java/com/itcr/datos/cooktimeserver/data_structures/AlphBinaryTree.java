package com.itcr.datos.cooktimeserver.data_structures;

import com.itcr.datos.cooktimeserver.object.User;

public class AlphBinaryTree<T> {

    private AlphNodeTree<T> root = null;
    private int length;

    public int getLength(){
        return this.length;
    }

    public void add(T data, String key){
        if(this.root==null) root = new AlphNodeTree<T>(data, key);
        else addNode(data, key, this.root);
        length++;
    }

    private void addNode(T data, String key, AlphNodeTree<T> tmp){

        switch (greater(key,tmp.getKey())){
            case "key":
                if(tmp.getRight()==null) tmp.setRight(new AlphNodeTree<T>(data,key));
                else addNode(data,key,tmp.getRight());
                break;

            case "leaf":
                if(tmp.getLeft() == null) tmp.setLeft(new AlphNodeTree<T>(data,key));
                else addNode(data,key,tmp.getLeft());
                break;

            case "equals":
                break;
        }
    }

    public void clear(){
        this.root=null;
        length=0;
    }

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

    public void delete(String key) throws Exception {
        this.root = deleteAux(this.root, key);
        length--;
    }

    private AlphNodeTree<T> deleteAux(AlphNodeTree <T> root, String key) throws Exception {

        if (root == null) {
            throw new Exception("Node was not found");
        }

        switch (greater(root.getKey(), key)) {
            case "key" -> {
                AlphNodeTree<T> left = deleteAux(root.getLeft(), key);
                root.setRight(left);
            }
            case "leaf" -> {
                AlphNodeTree<T> right = deleteAux(root.getRight(), key);
                root.setRight(right);
            }
            case "equals" -> {
                AlphNodeTree<T> copy = root;
                if (copy.getRight() == null) root = copy.getLeft();
                else if (copy.getLeft() == null) root = copy.getRight();
                else copy = change(copy);
                copy = null;
            }
        }
        return root;
    }

    @SuppressWarnings("DuplicatedCode")
    private AlphNodeTree<T> change(AlphNodeTree<T> root){
        AlphNodeTree<T> nodeTree = root;
        AlphNodeTree<T> maxLeft = root.getLeft();

        //noinspection DuplicatedCode
        while (maxLeft.getRight() != null){
            nodeTree = maxLeft;
            maxLeft = maxLeft.getRight();
        }
        root.setData(maxLeft.getData());
        if(nodeTree == root) nodeTree.setLeft(maxLeft.getRight());
        else nodeTree.setRight(maxLeft.getRight());
        return maxLeft;
    }

    public AlphNodeTree<T> getRoot(){
        return this.root;
    }

    public String toString() {
        return this.toString(new StringBuilder(), true, new StringBuilder(),this.root).toString();
    }

    public StringBuilder toString(StringBuilder prefix, boolean isTail, StringBuilder sb,AlphNodeTree<T> head) {
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
