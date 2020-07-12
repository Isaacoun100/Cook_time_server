package com.itcr.datos.cooktimeserver.data_structures;


import com.itcr.datos.cooktimeserver.object.User;

/**
 * Class for the implementation of the alphabetical BST
 * @param <T> the type of data
 */
public class AlphBinaryTree<T> {


    private AlphNodeTree<T> root = null;
    private int length;

    public int getLength(){
        return this.length;
    }

    /**
     * Adds a node to the tree
     * @param data the object contained in the node
     * @param key a value representing the value of the node
     */
    public void add(T data, String key){
        if (this.isEmpty()) {
            root = new AlphNodeTree<T>(data, key);
            length=1;
        }else{
            AlphNodeTree<T> tmp = root;
            while (tmp != null){
                if (greater(key, tmp.getKey()).equals("leaf")){
                    if (tmp.getRight() == null){
                        tmp.setRight(new AlphNodeTree<T>(data, key));
                        return;
                    }else{
                        tmp = tmp.getRight();
                    }
                }  if (greater(key, tmp.getKey()).equals("key")) {
                    if (tmp.getLeft() == null) {
                        tmp.setLeft(new AlphNodeTree<T>(data, key));
                        return;
                    } else {
                        tmp = tmp.getLeft();
                    }
                }else{
                   return;
                }
            }
        }
        length++;
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

    /**
     *
     * @return returns true if the node is empty
     */
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

    /**
     * Deletes the node in the BST
     * @param key key about to be deleted
     * @throws Exception throws exception if the node is not found
     */

    public void delete(String key) throws Exception {
        this.root = deleteAux(this.root, key);
        length--;
    }

    /**
     * Auxiliar method that gets called in delete.
     * @param root the root of the BST
     * @param key key about to be deleted
     * @return returns the root
     * @throws Exception throws exception if the node is not found
     */

    private AlphNodeTree<T> deleteAux(AlphNodeTree<T> root, String key) throws Exception {
        if (root == null){
            throw new Exception("The node was not found");
        }
        else if(greater(key, root.getKey()).equals("key")){
            AlphNodeTree<T> left = deleteAux(root.getLeft(), key);
            root.setLeft(left);
        }
        else if(greater(key, root.getKey()).equals("leaf")){
            AlphNodeTree<T> right = deleteAux(root.getRight(), key);
            root.setRight(right);
        }
        else{
            AlphNodeTree<T> copy = root;
            if (copy.getRight() == null){
                root = copy.getLeft();
            }
            else if(copy.getLeft() == null){
                root = copy.getRight();
            }
            else{
                copy = change(copy);
            }
            copy = null;
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
    /**
     * Function that returns the root of the tree
     * @return returns the root
     */
    public AlphNodeTree<T> getRoot(){
        return this.root;
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
    private StringBuilder toString(StringBuilder prefix, boolean isTail, StringBuilder sb,AlphNodeTree<T> head) {
        if(head.getRight()!=null) {
            sb.append(toString(new StringBuilder().append(prefix).append(isTail ? "│   " : "    "), false, new StringBuilder(), head.getRight()));
        }
        sb.append(prefix).append(isTail ? "└──" : "┌──").append("[").append(head.getKey()).append("]").append("\n");
        if(head.getLeft()!=null) {
            sb.append(toString(new StringBuilder().append(prefix).append(isTail ? "    " : "│   "), true, new StringBuilder(), head.getLeft()));
        }
        return sb;
    }

    public static void main(String[] args) {

        AlphBinaryTree<User> alf = new AlphBinaryTree<User>();

        alf.add(new User(), "mauricio");
        alf.add(new User(), "zenobrio");
        alf.add(new User(), "zzzz");
        alf.add(new User(), "alejandro");
        alf.add(new User(), "ab");
        alf.add(new User(), "ad");


        System.out.println(alf.toString());

        try{
            alf.delete("alejandro");
        }
        catch (Exception e){
            e.printStackTrace();
        }

        System.out.println("---------------------New Tree---------------------");


        System.out.println(alf.toString());

    }
}
