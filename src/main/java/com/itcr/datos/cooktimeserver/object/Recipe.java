package com.itcr.datos.cooktimeserver.object;

import com.itcr.datos.cooktimeserver.data_structures.SinglyList;

/**
 * Class for the recipe object
 */
public class Recipe {

    private String title;
    private String description;
    private String author;
    private String type;
    private String duration;
    private String time;
    private String diet;
    private String steps;
    private String image;
    private String date;
    private int price;
    private int servings;
    private int rating;
    private int difficulty;
    private SinglyList<String> comments;

    /**
     * Getter for title
     * @return returns title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Setter for title
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Getter for description
     * @return returns description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Setter for description
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Getter for author
     * @return returns author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Setter for author
     * @param author
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Getter for type
     * @return returns type
     */
    public String getType() {
        return type;
    }

    /**
     * Setter for type
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Getter for duration
     * @return returns duration
     */
    public String getDuration() {
        return duration;
    }

    /**
     * Setter for duration
     * @param duration
     */
    public void setDuration(String duration) {
        this.duration = duration;
    }

    /**
     * Getter for time
     * @return returns time
     */
    public String getTime() {
        return time;
    }

    /**
     * Setter for time
     * @param time
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * Getter for diet
     * @return returns diet
     */
    public String getDiet() {
        return diet;
    }

    /**
     * Setter for diet
     * @param diet
     */
    public void setDiet(String diet) {
        this.diet = diet;
    }

    /**
     * Getter for steps
     * @return returns steps
     */
    public String getSteps() {
        return steps;
    }

    /**
     * Setter for steps
     * @param steps
     */
    public void setSteps(String steps) {
        this.steps = steps;
    }

    /**
     * Getter for images
     * @return returns image
     */
    public String getImage() {
        return image;
    }

    /**
     * Setter for image
     * @param image
     */
    public void setImage(String image) {
        this.image = image;
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
     * Getter for price
     * @return returns price
     */
    public int getPrice() {
        return price;
    }

    /**
     * Setter for price
     * @param price
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * Getter for servings
     * @return
     */
    public int getServings() {
        return servings;
    }

    /**
     * Setter for servings
     * @param servings
     */
    public void setServings(int servings) {
        this.servings = servings;
    }

    /**
     * Getter for rating
     * @return returns rating
     */
    public int getRating() {
        return rating;
    }

    /**
     * Setter for rating
     * @param rating
     */
    public void setRating(int rating) {
        this.rating = rating;
    }

    /**
     * Getter for difficulty
     * @return returns difficulty
     */
    public int getDifficulty() {
        return difficulty;
    }

    /**
     * Setter for difficulty
     * @param difficulty
     */
    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    /**
     * Getter for comments
     * @return returns comments
     */
    public SinglyList<String> getComments() {
        return comments;
    }

    /**
     * Adds the comment object
     * @param author
     * @param comment
     */
    public void addComment(String comment){
        this.comments.add(comment);
    }

    /**
     * Setter for comments
     * @param comments
     */
    public void setComments(SinglyList<String> comments) {
        this.comments = comments;
    }
    /**
     * This method is just for testing purposes, is used when a new User it's being added, then it transforms it into
     * a string to print it in the console
     * @return a string of the user
     */
    @Override
    public String toString() {
        return "Recipe{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", author='" + author + '\'' +
                ", type='" + type + '\'' +
                ", duration='" + duration + '\'' +
                ", time='" + time + '\'' +
                ", diet='" + diet + '\'' +
                ", steps='" + steps + '\'' +
                ", image='" + image + '\'' +
                ", date=" + date +
                ", price=" + price +
                ", servings=" + servings +
                ", rating=" + rating +
                ", difficulty=" + difficulty +
                ", comments=" + comments.toString() +
                '}';
    }

}
