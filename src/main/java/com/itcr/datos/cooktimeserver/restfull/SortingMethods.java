package com.itcr.datos.cooktimeserver.restfull;

import com.itcr.datos.cooktimeserver.data_structures.AlphNodeAVL;
import com.itcr.datos.cooktimeserver.data_structures.SinglyList;
import com.itcr.datos.cooktimeserver.object.*;
import com.itcr.datos.cooktimeserver.sorting.SortingAlgorithms;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Class for doing the sorting methods
 */
public class SortingMethods {

    /**
     * Function that sorts the ratings with bubble sort
     * @return returns the list sorted
     */
    public static SinglyList<Recipe> DateSort(SinglyList<Recipe> recipeList){
        SinglyList<Recipe> result = new SinglyList<Recipe>();
        SinglyList<DateSort> dateList = new SinglyList<DateSort>();

        for(int x=0;x<recipeList.getLength();x++){
            Recipe newRecipe = recipeList.get(x).getData();
            Date date = new Date();
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            try { date = format.parse(newRecipe.getDate());}
            catch (ParseException e) { e.printStackTrace();}
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            dateList.add(new DateSort(newRecipe, calendar));
        }

        SortingAlgorithms.bubble_sort(dateList);

        for(int x=0;x<recipeList.getLength();x++){ result.add(dateList.get(x).getData().getRecipe()); }

        return result;

    }

    /**
     * Function that sorts the user´s recipes by date
     * @param user the user´s id
     * @return returns the new singly list sorted
     */
    public static SinglyList<Recipe> DateSortUser(String user){

        SinglyList<String> oldList = TreeManagement.binarySearch(user).getData().getRecipe();
        SinglyList<Recipe> newList = new SinglyList<>();

        for(int x=0;x<oldList.getLength();x++){
            newList.add(TreeManagement.binarySearchAvl(oldList.get(x).getData()).getData());
        }

        return DateSort(newList);
    }

    /**
     * Function that sorts the company´s recipes by date
     * @param company the company´s email
     * @return returns the new singly list sorted
     */
    public static SinglyList<Recipe> DateSortCompany(String company){

        SinglyList<String> oldList = TreeManagement.binarySearchSplay(company).getData().getRecipe();
        SinglyList<Recipe> newList = new SinglyList<>();

        for(int x=0 ; x<oldList.getLength(); x++){
            newList.add(TreeManagement.binarySearchAvl(oldList.get(x).getData()).getData());
        }

        return DateSort(newList);
    }

    /**
     * Function that sorts the ratings with bubble sort and returns the 3 best ratings
     * @return returns the list sorted
     */
    public static SinglyList<Recipe> RatingSort(SinglyList<Recipe> list){

        SortingAlgorithms.quick_sort_ratings(list);
        list = list.Inverter(list);

        return list;
    }

    /**
     * Function that sorts the ratings of the recipes of each user
     * @param user the user id
     * @return returns the new singly list sorted
     */
    public static SinglyList<Recipe> RatingSortUser(String user) {
        SinglyList<String> oldList = TreeManagement.binarySearch(user).getData().getRecipe();

        SinglyList<Recipe> recipeSinglyList = new SinglyList<>();

        for (int i = 0; i < oldList.getLength(); i++) {
            recipeSinglyList.add(TreeManagement.binarySearchAvl(oldList.get(i).getData()).getData());
        }

        return RatingSort(recipeSinglyList);
    }

    /**
     * Function that sorts the ratings of the recipes of each company
     * @param company the company´s email
     * @return return the new singly list sorted
     */
    public static SinglyList<Recipe> RatingSortCompany(String company){
        SinglyList<String> oldList = TreeManagement.binarySearchSplay(company).getData().getRecipe();

        SinglyList<Recipe> recipeSinglyList = new SinglyList<>();

        for(int i = 0; i < oldList.getLength();i++){
            recipeSinglyList.add(TreeManagement.binarySearchAvl(oldList.get(i).getData()).getData());
        }

        return RatingSort(recipeSinglyList);
    }
    /**
     * Function that sorts the difficulty of the recipes
     * @return the singly list
     */
    public static SinglyList<Recipe> DifficultySort(SinglyList<Recipe> list){
        SortingAlgorithms.radix_sort_difficulty(list);
        list = list.Inverter(list);
        list.print_list();

        return list;
    }

    /**
     * Function that sorts the ratings of the recipes of each user
     * @param user the user id
     * @return returns the new singly list sorted
     */
    public static SinglyList<Recipe> DifficultySortUser(String user){
        SinglyList<String> oldList = TreeManagement.binarySearch(user).getData().getRecipe();

        SinglyList<Recipe> recipeSinglyList = new SinglyList<>();

        for(int i = 0; i < oldList.getLength();i++){
            recipeSinglyList.add(TreeManagement.binarySearchAvl(oldList.get(i).getData()).getData());
        }

        return DifficultySort(recipeSinglyList);
    }

    /**
     * Function that sorts the ratings of the recipes of each company
     * @param company the company´s id
     * @return returns the new singly list sorted
     */
    public static SinglyList<Recipe> DifficultySortCompany(String company){
        SinglyList<String> oldList = TreeManagement.binarySearchSplay(company).getData().getRecipe();

        SinglyList<Recipe> recipeSinglyList = new SinglyList<>();

        for(int i = 0; i < oldList.getLength();i++){
            recipeSinglyList.add(TreeManagement.binarySearchAvl(oldList.get(i).getData()).getData());
        }

        return DifficultySort(recipeSinglyList);
    }




}
