package com.itcr.datos.cooktimeserver.restfull;

import com.itcr.datos.cooktimeserver.data_structures.AlphNodeTree;
import com.itcr.datos.cooktimeserver.object.User;

public class TreeManagement {

    public static AlphNodeTree<User> BinarySearch(String data){
        return BinarySearch(UserTree.getUserTree().getRoot(),data);
    }

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