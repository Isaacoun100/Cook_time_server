package com.itcr.datos.cooktimeserver.data_structures;

public class AlphSplayTree<T> {
    private AlphNodeSplay<T> root = null;
    private int lenght = 0;

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
        lenght++;
    }
    public void delete(String key){
        AlphNodeSplay<T> node = getNode(key);
        deleteAux(node);
    }
    public void deleteAux(AlphNodeSplay<T> node){
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
        lenght--;
    }
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
    public boolean isEmpty(){
        return this.root == null;
    }
    /**
     * Function that calls recursively the function of printing the tree´s diagram
     * @return returns the recursive function
     */
    public String toString() {
        return this.toString(new StringBuilder(), true, new StringBuilder(),this.root).toString();
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
    /*
    public static void main(String[] args) {
        AlphSplayTree<Integer> tree = new AlphSplayTree<>();
        tree.add(2, "c");
        tree.add(2, "a");
        tree.add(2, "b");
        tree.add(2, "z");
        tree.add(2, "d");
        System.out.println(tree.toString());

        System.out.println("---------------------new tree---------------------");

        tree.delete("b");
        System.out.println(tree.toString());
    }
    
     */
}
