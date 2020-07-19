package com.itcr.datos.cooktimeserver.sorting;

import com.itcr.datos.cooktimeserver.data_structures.*;
import com.itcr.datos.cooktimeserver.object.DifficultySort;
import com.itcr.datos.cooktimeserver.object.RatingSort;

import java.util.Arrays;


/**
 * Sorting Algorithms used
 * The code used in the radix sort is based on https://www.geeksforgeeks.org/radix-sort/
 */
public class SortingAlgorithms {
    /**
     * Orders the singly list from lowest to highest using BubbleSort.
     * @param list the singly list that´s gonna be ordered.
     */
    public static void bubble_sort(SinglyList<Integer> list){
        int i = 0;
        while (i < list.getLength() - 1){
            int frst = list.get(i).getData();
            int scnd = list.get(i+1).getData();
            if (frst > scnd){
                list.swap(i, i+1);
                i = 0;
            }else{
                i++;
            }
        }
    }
    /**
     * Orders the singly list from lowest to highest using QuickSort.
     * @param list the singlylist about to be ordered.
     */
    public static void quick_sort(SinglyList<Integer> list){
        if (list.getLength() > 0 && list != null){
            quick_sort_aux(list,0, list.getLength()-1);}
    }

    /**
     * Recursive function used for ordering the list.
     * @param list the singlylist about to be ordered.
     * @param first first element of the sublist.
     * @param last the las element of the sublist.
     */
    private static void quick_sort_aux(SinglyList<Integer> list, int first, int last){
        int pivot = (first + (last - first) / 2);
        int dataPivot = list.get(pivot).getData();
        int i = first;
        int j = last;
        while (i <= j){
            while (list.get(i).getData() < dataPivot){
                i++;
            }
            while (list.get(j).getData() > dataPivot){
                j--;
            }
            if (i <= j){
                list.swap(i, j);
                i++;
                j--;
            }
        }
        if (first < j) {
            quick_sort_aux(list, first, j);}
        if (i < last) {
            quick_sort_aux(list, i, last);}
    }

    public static void quick_sort_ratings(SinglyList<RatingSort> list){
        if (list.getLength() > 0 && list != null){
            quick_sort_ratings(list,0, list.getLength()-1);}
    }
    private static void quick_sort_ratings(SinglyList<RatingSort> list, int first, int last){
        int pivot = (first + (last - first) / 2);
        int dataPivot = list.get(pivot).getData().getRating();
        int i = first;
        int j = last;
        while (i <= j){
            while (list.get(i).getData().getRating() < dataPivot){
                i++;
            }
            while (list.get(j).getData().getRating() > dataPivot){
                j--;
            }
            if (i <= j){
                list.swap(i, j);
                i++;
                j--;
            }
        }
        if (first < j) {
            quick_sort_ratings(list, first, j);}
        if (i < last) {
            quick_sort_ratings(list, i, last);}
    }

    /**
     * Verifies if the list is sorted.
     * @param list singly list that gets verified.
     * @return returns true or false if the list is sorted or not.
     */
    public static boolean is_sorted(SinglyList<Integer> list){
        int i = 0;
        while (i < list.getLength()-1){
            if (list.get(i).getData() <= list.get(i+1).getData()){
                i++;
            }
            else{
                return false;
            }
        }
        return true;
    }

    /**
     * Method that returns the highest value on the list.
     * @param list the singly list that gets verified.
     * @return the highest value on the list.
     */
    public static int get_max_pos(SinglyList<Integer> list){
        int maxPos = 0;
        int i = 1;
        while (i != list.getLength()-1){
            if (list.get(i).getData() > list.get(maxPos).getData()){
                maxPos = i;
            }
            i++;
        }
        return maxPos;
    }

    /**
     * Method that returns the lowest value on the list.
     * @param list the singly list that gets verified.
     * @return the lowest value on the list.
     */
    public static int get_min_pos(SinglyList<Integer> list){
        int minPos = 0;
        int i = 1;
        while (i != list.getLength()){
            if (list.get(i).getData() < list.get(minPos).getData()){
                minPos = i;
            }
            i++;
        }
        return minPos;
    }

    /**
     * The main function that sorts the singly list
     * @param list the integer singly list
     */
    public static void radix_sort(SinglyList<Integer> list){
        int length = list.getLength();

        int max = getMax(list, length);

        for (int exp = 1; max/exp > 0; exp *= 10)
            countSort(list, length, exp);

    }

    /**
     * A utility function to get maximum value in singly list
     * @param list the singly list
     * @param lenght the lenght
     * @return returns the maximum value
     */
    private static int getMax(SinglyList<Integer> list, int lenght){
        int max = list.getHead().getData();
        for (int i = 1; i < lenght; i++)
            if (list.get(i).getData() > max)
                max = list.get(i).getData();
        return max;
    }

    /**
     * A function to do counting sort of SinglyList according to the digit represented by exp
     * @param list the singly list
     * @param lenght the length
     * @param exp the exponent
     */
    private static void countSort(SinglyList<Integer> list, int lenght, int exp){
        int[] output = new int[lenght];
        int i;
        int[] count = new int[10];
        Arrays.fill(count, 0);


        for (i = 0; i < lenght; i++)
            count[ (list.get(i).getData()/exp) % 10 ]++;

        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];

        for (i = lenght - 1; i >= 0; i--)
        {
            output[count[ (list.get(i).getData()/exp)%10 ] - 1] = list.get(i).getData();
            count[ (list.get(i).getData()/exp)%10 ]--;
        }

        for (i = 0; i < lenght; i++)
            list.get(i).setData(output[i]);

    }
    /**
     * The main function that sorts the singly list
     * @param list the integer singly list
     */
    public static void radix_sort_difficulty(SinglyList<DifficultySort> list){
        int length = list.getLength();

        int max = get_max_difficulty(list, length);

        for (int exp = 1; max/exp > 0; exp *= 10)
            count_sort_difficulty(list, length, exp);

    }

    /**
     * A utility function to get maximum value in singly list
     * @param list the singly list
     * @param lenght the lenght
     * @return returns the maximum value
     */
    private static int get_max_difficulty(SinglyList<DifficultySort> list, int lenght){
        int max = list.getHead().getData().getDifficulty();
        for (int i = 1; i < lenght; i++)
            if (list.get(i).getData().getDifficulty() > max)
                max = list.get(i).getData().getDifficulty();
        return max;
    }
    /**
     * A function to do counting sort of SinglyList according to the digit represented by exp
     * @param list the singly list
     * @param lenght the length
     * @param exp the exponent
     */
    private static void count_sort_difficulty(SinglyList<DifficultySort> list, int lenght, int exp){
        int[] output = new int[lenght];
        int i;
        int[] count = new int[10];
        Arrays.fill(count, 0);


        for (i = 0; i < lenght; i++)
            count[ (list.get(i).getData().getDifficulty()/exp) % 10 ]++;

        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];

        for (i = lenght - 1; i >= 0; i--)
        {
            output[count[ (list.get(i).getData().getDifficulty()/exp)%10 ] - 1] = list.get(i).getData().getDifficulty();
            count[ (list.get(i).getData().getDifficulty()/exp)%10 ]--;
        }

        for (i = 0; i < lenght; i++)
            list.get(i).getData().setDifficulty(output[i]);
    }

}
