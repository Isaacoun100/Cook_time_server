package com.itcr.datos.cooktimeserver.object;

/**
 * Class for the object DateSort
 */
public class DateSort {
    private final String title;
    private String date;

    /**
     * Constructor for the class DateSort
     * @param title the title
     * @param date the date
     */
    public DateSort(String title, String date) {
        this.title = title;
        this.date = date;
    }

    /**
     * Getter for title
     * @return returns title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Getter for date
     * @return returns date
     */
    public String getDate() {
        return date;
    }

    /**
     * Setter for date
     * @param date
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * Function that casts the object into a string
     *
     * @return returns the string version of the class
     */
    @Override
    public String toString() {
        return "DateSort{" +
                "title='" + title + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
