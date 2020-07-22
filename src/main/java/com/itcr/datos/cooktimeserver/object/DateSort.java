package com.itcr.datos.cooktimeserver.object;

import java.util.Calendar;

/**
 * Class for the object DateSort
 */
public class DateSort {
    private final Recipe recipe;
    private final Calendar date;


    /**
     * Constructor for the class DateSort
     * @param title the title
     * @param date the date
     */
    public DateSort(Recipe recipe, Calendar date) {
        this.recipe = recipe;
        this.date = date;
    }

    /**
     * Getter for title
     * @return returns title
     */
    public Recipe getRecipe() {
        return recipe;
    }

    /**
     * Getter for date
     * @return returns date
     */
    public Calendar getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "DateSort{" +
                "recipe=" + recipe +
                ", date=" + date +
                '}';
    }
}
