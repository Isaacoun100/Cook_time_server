package com.itcr.datos.cooktimeserver.restfull;

import com.itcr.datos.cooktimeserver.data_structures.AlphNodeAVL;
import com.itcr.datos.cooktimeserver.data_structures.AlphNodeSplay;
import com.itcr.datos.cooktimeserver.data_structures.AlphNodeTree;
import com.itcr.datos.cooktimeserver.object.Company;
import com.itcr.datos.cooktimeserver.object.Recipe;
import com.itcr.datos.cooktimeserver.object.User;

/**
 * Class for functions used for the tree
 */
public class TreeManagement {
    /**
     * Function used for calling BinarySearch recursively
     * @param data the data string
     * @return returns the recursive function
     */
    public static AlphNodeTree<User> BinarySearch(String data){
        return BinarySearch(UserTree.getUserTree().getRoot(),data);
    }

    /**
     * Recursive function used for the binary search
     * @param reference the tree´s node
     * @param data the string data
     * @return returns the node searched
     */
    private static AlphNodeTree<User> BinarySearch(AlphNodeTree<User> reference, String data){
        if(reference.getKey().equals(data)){
            return reference;
        }
        switch(greater(reference.getKey(),data)){
            case "key":
                if(reference.getRight()!=null){ return BinarySearch(reference.getRight(),data);}
                else{ return null;}
            case "leaf":
                if(reference.getLeft()!=null){return BinarySearch(reference.getLeft(),data);}
                else{ return null;}
        }
        return null;
    }

    /**
     * Function used for calling BinarySearchAvl recursively
     * @param data the data string
     * @return returns the recursive function
     */
    public static AlphNodeAVL<Recipe> BinarySearchAvl(String data){
        System.out.println("EOOOOOOOOO ENTRE PUTO");
        return BinarySearchAvl(RecipeTree.getAvlRecipeTree().getRoot(), data);
    }

    /**
     * Recursive function used for the binary search in the avl
     * @param reference the tree´s root
     * @param data the string data
     * @return returns the node searched
     */
    private static AlphNodeAVL<Recipe> BinarySearchAvl(AlphNodeAVL<Recipe> reference, String data){
        if(reference.getKey().equals(data)){
            return reference;
        }
        switch(greater(reference.getKey(),data)){
            case "key":
                if(reference.getRight()!=null){ return BinarySearchAvl(reference.getRight(),data);}
                else{ return null;}
            case "leaf":
                if(reference.getLeft()!=null){return BinarySearchAvl(reference.getLeft(),data);}
                else{ return null;}
        }
        return null;

    }

    /**
     * Function used for calling binary search splay recursively
     * @param data the string data
     * @return returns the recursive function
     */
    public static AlphNodeSplay<Company> BinarySearchSplay(String data){
        return BinarySearchSplay(CompanyTree.getUserTree().getRoot(),data);
    }

    /**
     * Recursive function used for the binary search in the splay tree
     * @param reference the tree´s root
     * @param data the string data
     * @return returns the node searched
     */
    private static AlphNodeSplay<Company> BinarySearchSplay(AlphNodeSplay<Company> reference, String data){
        if(reference.getKey().equals(data)){
            return reference;
        }
        switch(greater(reference.getKey(),data)){
            case "key":
                if(reference.getRight()!=null){ return BinarySearchSplay(reference.getRight(),data);}
                else{ return null;}
            case "leaf":
                if(reference.getLeft()!=null){return BinarySearchSplay(reference.getLeft(),data);}
                else{ return null;}
        }
        return null;
    }

    /**
     * Function that identifies which string is greater than the other
     * @param leaf first string
     * @param key second string
     * @return return ´leaf´ if the first string is greater, ´key´ if the second string is greater, or ´equals´ if they are the same
     */
    private static String greater(String leaf, String key){
        int size,count=0;
        size = Math.min(leaf.length(), key.length())-1;
        while(count<=size){
            if(key.charAt(count)>leaf.charAt(count)){ return "key";}
            else if(key.charAt(count)<leaf.charAt(count)){ return "leaf";}
            else{ count++;}
        }
        if(key.length() > leaf.length()){ return "key";}
        else{ return "leaf";}
    }

}
