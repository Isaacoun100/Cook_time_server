package com.itcr.datos.cooktimeserver.sorting;

import com.itcr.datos.cooktimeserver.data_structures.*;

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

    /**
     * Verifies if the list is sorted.
     * @param list singlylist that gets verified.
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
}
