package com.itcr.datos.cooktimeserver.restfull;

import com.itcr.datos.cooktimeserver.data_structures.AlphNodeAVL;
import com.itcr.datos.cooktimeserver.data_structures.AlphNodeTree;
import com.itcr.datos.cooktimeserver.data_structures.SinglyList;
import com.itcr.datos.cooktimeserver.data_structures.SinglyNode;
import com.itcr.datos.cooktimeserver.object.*;
import com.itcr.datos.cooktimeserver.sorting.SortingAlgorithms;

/**
 * Class for doing the sorting methods
 */
public class SortingMethods {

    /**
     * Function that sorts the ratings with bubble sort
     * @return returns the list sorted
     */
    public static SinglyList<Recipe> DateSort(){
        SinglyList<Recipe> recipeList = TreeManagement.getRecipeList();

        SinglyList<DateSort> dateSortSinglyList = new SinglyList<>();
        SinglyList<Integer> days = new SinglyList<>();
        SinglyList<Integer> months = new SinglyList<>();
        SinglyList<Integer> years = new SinglyList<>();


        for (int i = 0; i < recipeList.getLength(); i++){
            String date = recipeList.get(i).getData().getDate();

            days.add(Integer.parseInt(String.valueOf(date.charAt(0)) + date.charAt(1)));

            months.add(Integer.parseInt(String.valueOf(date.charAt(3)) + date.charAt(4)));

            years.add(Integer.parseInt(String.valueOf(date.charAt(6)) + date.charAt(7) + date.charAt(8) + date.charAt(9)));


        }
        SortingAlgorithms.bubble_sort(days);
        SortingAlgorithms.bubble_sort(months);
        SortingAlgorithms.bubble_sort(years);
        for (int i = 0; i < recipeList.getLength(); i++){
            String dayString = Integer.toString(days.get(i).getData());
            String monthString = Integer.toString(months.get(i).getData());
            String yearString = Integer.toString(years.get(i).getData());

            recipeList.get(i).getData().setDate(dayString + "/" + monthString + "/" + yearString);
        }
        recipeList = recipeList.Inverter(recipeList);
        recipeList.print_list();

        return recipeList;
    }

    public static SinglyList<Recipe> DateSortUser(String user){
        AlphNodeAVL<Recipe> recipeAlphNodeAVL = TreeManagement.BinarySearchAvl(user);

        SinglyList<Recipe> recipeSinglyList = new SinglyList<>();

        recipeSinglyList.add(recipeAlphNodeAVL.getData());

        SinglyList<Integer> days = new SinglyList<>();
        SinglyList<Integer> months = new SinglyList<>();
        SinglyList<Integer> years = new SinglyList<>();

        for (int i = 0; i < recipeSinglyList.getLength(); i++){
            String date = recipeSinglyList.get(i).getData().getDate();

            days.add(Integer.parseInt(String.valueOf(date.charAt(0)) + date.charAt(1)));

            months.add(Integer.parseInt(String.valueOf(date.charAt(3)) + date.charAt(4)));

            years.add(Integer.parseInt(String.valueOf(date.charAt(6)) + date.charAt(7) + date.charAt(8) + date.charAt(9)));

        }
        SortingAlgorithms.bubble_sort(days);
        SortingAlgorithms.bubble_sort(months);
        SortingAlgorithms.bubble_sort(years);
        for (int i = 0; i < recipeSinglyList.getLength(); i++){
            String dayString = Integer.toString(days.get(i).getData());
            String monthString = Integer.toString(months.get(i).getData());
            String yearString = Integer.toString(years.get(i).getData());

            recipeSinglyList.get(i).getData().setDate(dayString + "/" + monthString + "/" + yearString);
        }
        recipeSinglyList = recipeSinglyList.Inverter(recipeSinglyList);
        recipeSinglyList.print_list();

        return recipeSinglyList;

    }

    /**
     * Function that sorts the ratings with bubble sort
     * @return returns the list sorted
     */
    public static SinglyList<Recipe> RatingSort(){
        SinglyList<Recipe> list = TreeManagement.getRecipeList();

        SortingAlgorithms.quick_sort_ratings(list);
        list = list.Inverter(list);
        list.print_list();

        return list;
    }

    /**
     * Function that sorts the ratings of the recipes of each user
     * @param user the user id
     * @return returns the new singly list sorted
     */
    public static SinglyList<Recipe> RatingSortUser(String user){
        SinglyList<Recipe> recipeSinglyList = new SinglyList<>();

        AlphNodeAVL<Recipe> recipeAlphNodeAVL = TreeManagement.BinarySearchAvl(user);

        recipeSinglyList.add(recipeAlphNodeAVL.getData());
        SortingAlgorithms.quick_sort_ratings(recipeSinglyList);

        recipeSinglyList = recipeSinglyList.Inverter(recipeSinglyList);

        return recipeSinglyList;
    }
    /**
     * Function that sorts the difficulty of the recipes
     * @return the singly list
     */
    public static SinglyList<Recipe> DifficultySort(){
        SinglyList<Recipe> list = TreeManagement.getRecipeList();

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
        SinglyList<Recipe> recipeSinglyList = new SinglyList<>();

        AlphNodeAVL<Recipe> recipeAlphNodeAVL = TreeManagement.BinarySearchAvl(user);
        recipeSinglyList.add(recipeAlphNodeAVL.getData());

        SortingAlgorithms.radix_sort_difficulty(recipeSinglyList);
        recipeSinglyList = recipeSinglyList.Inverter(recipeSinglyList);
        return recipeSinglyList;
    }


}
