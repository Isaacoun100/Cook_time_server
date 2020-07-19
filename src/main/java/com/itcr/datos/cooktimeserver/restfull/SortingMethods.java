package com.itcr.datos.cooktimeserver.restfull;

import com.itcr.datos.cooktimeserver.data_structures.AlphNodeAVL;
import com.itcr.datos.cooktimeserver.data_structures.SinglyList;
import com.itcr.datos.cooktimeserver.data_structures.SinglyNode;
import com.itcr.datos.cooktimeserver.object.DateSort;
import com.itcr.datos.cooktimeserver.object.DifficultySort;
import com.itcr.datos.cooktimeserver.object.RatingSort;
import com.itcr.datos.cooktimeserver.object.Recipe;
import com.itcr.datos.cooktimeserver.sorting.SortingAlgorithms;

/**
 * Class for doing the sorting methods
 */
public class SortingMethods {
    /**
     *
     * @return returns the recursive function
     */
    private static SinglyList<DateSort> BinarySearchDate(){
        return BinarySearchDate(RecipeTree.getAvlRecipeTree().getRoot(), new SinglyList<>());
    }

    /**
     * Recursive function for the binary search of the ratings
     * @param reference the tree´s root
     * @param date the list
     * @return returns the list
     */
    private static SinglyList<DateSort> BinarySearchDate(AlphNodeAVL<Recipe> reference, SinglyList<DateSort> date){

        date.add(new DateSort(reference.getData().getTitle(),reference.getData().getDate()));
        if (reference.getRight() != null){ BinarySearchDate(reference.getRight(), date);}
        if (reference.getLeft() != null){ BinarySearchDate(reference.getLeft(), date);}
        return date;
    }

    /**
     * Function that sorts the ratings with bubble sort
     * @return returns the list sorted
     */
    public static SinglyList<DateSort> DateSort(){
        SinglyList<DateSort> datesort_list;

        SinglyList<Integer> days = new SinglyList<>();
        SinglyList<Integer> months = new SinglyList<>();
        SinglyList<Integer> years = new SinglyList<>();

        datesort_list = BinarySearchDate();

        for (int i = 0; i < datesort_list.getLength(); i++){
            String date = datesort_list.get(i).getData().getDate();

            days.add(Integer.parseInt(String.valueOf(date.charAt(0)) + date.charAt(1)));

            months.add(Integer.parseInt(String.valueOf(date.charAt(3)) + date.charAt(4)));

            years.add(Integer.parseInt(String.valueOf(date.charAt(6)) + date.charAt(7) + date.charAt(8) + date.charAt(9)));


        }
        SortingAlgorithms.bubble_sort(days);
        SortingAlgorithms.bubble_sort(months);
        SortingAlgorithms.bubble_sort(years);
        for (int i = 0; i < datesort_list.getLength(); i++){
            String dayString = Integer.toString(days.get(i).getData());
            String monthString = Integer.toString(months.get(i).getData());
            String yearString = Integer.toString(years.get(i).getData());

            datesort_list.get(i).getData().setDate(dayString + "/" + monthString + "/" + yearString);
        }
        datesort_list = datesort_list.Inverter(datesort_list);
        datesort_list.print_list();
        return datesort_list;
    }

    /**
     * Function for doing a binary search of the ratings with its titles
     * @return returns the recursive function
     */
    private static SinglyList<RatingSort> BinarySearchRating(){
        return BinarySearchRating(RecipeTree.getAvlRecipeTree().getRoot(), new SinglyList<>());
    }

    /**
     * Recursive function for the binary search of the ratings
     * @param reference the tree´s root
     * @param ratings the list
     * @return returns the list
     */
    private static SinglyList<RatingSort> BinarySearchRating(AlphNodeAVL<Recipe> reference, SinglyList<RatingSort> ratings){

        ratings.add(new RatingSort(reference.getData().getTitle(),reference.getData().getRating()));
        if (reference.getRight() != null){ BinarySearchRating(reference.getRight(), ratings);}
        if (reference.getLeft() != null){ BinarySearchRating(reference.getLeft(), ratings);}
        return ratings;
    }

    /**
     * Function that sorts the ratings with bubble sort
     * @return returns the list sorted
     */
    public static SinglyList<RatingSort> RatingSort(){
        SinglyList<RatingSort> list;
        list = BinarySearchRating();
        SortingAlgorithms.quick_sort_ratings(list);
        list.print_list();

        return list;
    }
    /**
     * Function for doing a binary search of the ratings with its titles
     * @return returns the recursive function
     */
    private static SinglyList<DifficultySort> BinarySearchDifficulty(){
        return BinarySearchDifficulty(RecipeTree.getAvlRecipeTree().getRoot(), new SinglyList<>());
    }

    /**
     * Recursive function for the binary search of the ratings
     * @param reference the tree´s root
     * @param difficulty the list
     * @return returns the list
     */
    private static SinglyList<DifficultySort> BinarySearchDifficulty(AlphNodeAVL<Recipe> reference, SinglyList<DifficultySort> difficulty){

        difficulty.add(new DifficultySort(reference.getData().getTitle(),reference.getData().getDifficulty()));
        if (reference.getRight() != null){ BinarySearchDifficulty(reference.getRight(), difficulty);}
        if (reference.getLeft() != null){ BinarySearchDifficulty(reference.getLeft(), difficulty);}
        return difficulty;
    }

    /**
     * Function that sorts the difficulty of the recipes
     * @return the singly list
     */
    public static SinglyList<DifficultySort> DifficultySort(){
        SinglyList<DifficultySort> list;
        list = BinarySearchDifficulty();
        SortingAlgorithms.radix_sort_difficulty(list);
        list.print_list();

        return list;
    }
}
