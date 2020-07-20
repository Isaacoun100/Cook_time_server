package com.itcr.datos.cooktimeserver.restfull;

import com.itcr.datos.cooktimeserver.data_structures.*;
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
        if(reference.getRight()!=null){return getUserList(reference.getRight(), userList);}
        if(reference.getLeft()!=null){return getUserList(reference.getLeft(), userList);}
        userList.print_list();
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
        if(reference.getRight()!=null){return getRecipeList(reference.getRight(), recipeList);}
        if(reference.getLeft()!=null){return getRecipeList(reference.getLeft(), recipeList);}
        recipeList.print_list();
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
        if(reference.getRight()!=null){return getCompanyList(reference.getRight(), companyList);}
        if(reference.getLeft()!=null){return getCompanyList(reference.getLeft(), companyList);}
        companyList.print_list();
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
