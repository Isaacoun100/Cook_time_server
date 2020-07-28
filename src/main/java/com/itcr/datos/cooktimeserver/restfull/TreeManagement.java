package com.itcr.datos.cooktimeserver.restfull;

import com.itcr.datos.cooktimeserver.data_structures.*;
import com.itcr.datos.cooktimeserver.object.*;


/**
 * Class for functions used for the tree
 */
public class TreeManagement {
    public static String getSourceCodeLine() {

    // An index of 1 references the calling method
    StackTraceElement ste = new Throwable().getStackTrace()[1];
        return "(" + ste.getFileName() + ":" + ste.getLineNumber() + ")";
    }

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
     * Function used for calling BinarySearch recursively for chefs
     * @param data the data string
     * @return returns the recursive function
     */
    public static AlphNodeTree<Chef> BinarySearchChefs(String data){
        return BinarySearchChefs(ChefTree.getChefTree().getRoot(),data);
    }

    /**
     * Recursive function used for the binary search for chefs
     * @param reference the tree´s node
     * @param data the string data
     * @return returns the node searched
     */
    private static AlphNodeTree<Chef> BinarySearchChefs(AlphNodeTree<Chef> reference, String data){
        if(reference.getKey().equals(data)){
            return reference;
        }
        switch(greater(reference.getKey(),data)){
            case "key":
                if(reference.getRight()!=null){ return BinarySearchChefs(reference.getRight(),data);}
                else{ return null;}
            case "leaf":
                if(reference.getLeft()!=null){return BinarySearchChefs(reference.getLeft(),data);}
                else{ return null;}
        }
        return null;
    }

    /**
     * Function used for calling BinarySearchAvl recursively
     * @param data the data string
     * @return returns the recursive function
     */
    public static AlphNodeAVL<Recipe> binarySearchAvl(String data){
        return binarySearchAvl(RecipeTree.getAvlRecipeTree().getRoot(), data);
    }

    /**
     * Recursive function used for the binary search in the avl
     * @param reference the tree´s root
     * @param data the string data
     * @return returns the node searched
     */
    private static AlphNodeAVL<Recipe> binarySearchAvl(AlphNodeAVL<Recipe> reference, String data){
        if(reference.getKey().equals(data)){
            return reference;
        }
        switch(greater(reference.getKey(),data)){
            case "key":
                if(reference.getRight()!=null){ return binarySearchAvl(reference.getRight(),data);}
                else{ return null;}
            case "leaf":
                if(reference.getLeft()!=null){return binarySearchAvl(reference.getLeft(),data);}
                else{ return null;}
        }
        return null;

    }

    /**
     * Function used for calling binary search splay recursively
     * @param data the string data
     * @return returns the recursive function
     */
    public static AlphNodeSplay<Company> binarySearchSplay(String data){
        return binarySearchSplay(CompanyTree.getSplayCompanyTree().getRoot(),data);
    }

    /**
     * Recursive function used for the binary search in the splay tree
     * @param reference the tree´s root
     * @param data the string data
     * @return returns the node searched
     */
    public static AlphNodeSplay<Company> binarySearchSplay(AlphNodeSplay<Company> reference, String data){
        if(reference.getKey().equals(data)){
            return reference;
        }
        switch(greater(reference.getKey(),data)){
            case "key":
                if(reference.getRight()!=null){ return binarySearchSplay(reference.getRight(),data);}
                else{ return null;}
            case "leaf":
                if(reference.getLeft()!=null){return binarySearchSplay(reference.getLeft(),data);}
                else{ return null;}
        }
        return null;
    }

    /**
     * Function that returns the user singly list
     * @return returns the function getUserList()
     */
    public static SinglyList<User> getUserList(){
        return getUserList(UserTree.getUserTree().getRoot(), new SinglyList<>());
    }

    /**
     * Recursive function that gets the singly user list
     * @param reference the tree´s root
     * @param userList the  new user list
     * @return returns the user list
     */
    private static SinglyList<User> getUserList(AlphNodeTree<User> reference, SinglyList<User> userList){
        if (reference != null){ userList.add(reference.getData());}
        if(reference.getRight()!=null){ getUserList(reference.getRight(), userList);}
        if(reference.getLeft()!=null){ getUserList(reference.getLeft(), userList);}
        return userList;
    }

    /**
     * Function that returns the recipe singly list
     * @return returns the function getRecipeList()
     */
    public static SinglyList<Recipe> getRecipeList(){
        return getRecipeList(RecipeTree.getAvlRecipeTree().getRoot(), new SinglyList<>());
    }

    /**
     * Recursive function that gets the singly recipe list
     * @param reference the tree´s root
     * @param recipeList the  new user list
     * @return returns the recipe list
     */
    private static SinglyList<Recipe> getRecipeList(AlphNodeAVL<Recipe> reference, SinglyList<Recipe> recipeList){
        if (reference != null){ recipeList.add(reference.getData());}
        if(reference.getRight()!=null){ getRecipeList(reference.getRight(), recipeList);}
        if(reference.getLeft()!=null){ getRecipeList(reference.getLeft(), recipeList);}
        return recipeList;
    }

    /**
     * Function that returns the company singly list
     * @return returns the function getCompanyList()
     */
    public static SinglyList<Company> getCompanyList(){
        return getCompanyList(CompanyTree.getSplayCompanyTree().getRoot(), new SinglyList<>());
    }

    /**
     * Recursive function that gets the singly company list
     * @param reference the tree´s root
     * @param companyList the  new user list
     * @return returns the company list
     */
    private static SinglyList<Company> getCompanyList(AlphNodeSplay<Company> reference, SinglyList<Company> companyList){
        if (reference != null){ companyList.add(reference.getData());}
        if(reference.getRight()!=null){ getCompanyList(reference.getRight(), companyList);}
        if(reference.getLeft()!=null){ getCompanyList(reference.getLeft(), companyList);}
        return companyList;
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
