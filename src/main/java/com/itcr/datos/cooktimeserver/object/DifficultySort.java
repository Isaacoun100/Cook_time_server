package com.itcr.datos.cooktimeserver.object;

/**
 * Class containing the difficulty sort object
 */
public class DifficultySort {
    private final String title;
    private int difficulty;

    /**
     * Constructor for the class
     * @param title the title of the object
     * @param difficulty the difficulty of the object
     */
    public DifficultySort(String title, int difficulty) {
        this.title = title;
        this.difficulty = difficulty;
    }

    /**
     * Getter for title
     * @return returns title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Getter for difficulty
     * @return returns difficulty
     */
    public int getDifficulty() {
        return difficulty;
    }
    public void setDifficulty(int difficulty){
        this.difficulty = difficulty;
    }


    /**
     *
     * @return Returns the object into a string
     */
    @Override
    public String toString() {
        return "DifficultySort{" +
                "title='" + title + '\'' +
                ", difficulty=" + difficulty +
                '}';
    }
}
