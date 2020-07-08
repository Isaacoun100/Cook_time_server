package com.itcr.datos.cooktimeserver.sorting;

import com.itcr.datos.cooktimeserver.data_structures.*;

public class SortingAlgorithms {
    /**
     * Ordena una lista doblemente enlazada de enteros y la ordena de menor a mayor usando BubbleSort.
     * @param lista la lista a ordenar.
     */
    public static void bubble_sort(SinglyList<Integer> lista){
        int i = 0;
        while (i < lista.getLength() - 1){
            int frst = lista.get(i).getData();
            int scnd = lista.get(i+1).getData();
            if (frst > scnd){
                lista.swap(i, i+1);
                i = 0;
            }else{
                i++;
            }
        }
    }

}
