package com.itcr.datos.cooktimeserver.object;

import com.itcr.datos.cooktimeserver.data_structures.SinglyList;

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
    private SinglyList<Comment> comments;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDiet() {
        return diet;
    }

    public void setDiet(String diet) {
        this.diet = diet;
    }

    public String getSteps() {
        return steps;
    }

    public void setSteps(String steps) {
        this.steps = steps;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getServings() {
        return servings;
    }

    public void setServings(int servings) {
        this.servings = servings;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public SinglyList<Comment> getComments() {
        return comments;
    }

    public void addComment(String author, String comment){
        this.comments.add(new Comment(author, comment));
    }

    public void setComments(SinglyList<Comment> comments) {
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
                ", comments=" + comments +
                '}';
    }

}
