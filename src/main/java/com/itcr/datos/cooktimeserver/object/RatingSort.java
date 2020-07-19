package com.itcr.datos.cooktimeserver.object;

/**
 * Class for the object used in the sorting of the rates of recipe
 */
public class RatingSort {
    private final String title;
    private final int rating;

    /**
     * Constructor for rating sort
     * @param title the title
     * @param rating the rating
     */
    public RatingSort(String title, int rating) {
        this.title = title;
        this.rating = rating;
    }

    /**
     * Getter for title
     * @return returns title
     */
    public String getTitle() {
        return title;
    }



    /**
     * Getter for rating
     * @return returns rating
     */
    public int getRating() {
        return rating;
    }

    /**
     *
     * @return Returns the string of the object
     */
    @Override
    public String toString() {
        return "RatingSort{" +
                "title='" + title + '\'' +
                ", rating=" + rating +
                '}';
    }
}
