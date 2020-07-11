package com.itcr.datos.cooktimeserver.object;

public class Comment {

    private String author;
    private String comment;

    /**
     * Getter for the author
     * @return the author of the recipe
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Setter for the author
     * @param author that is going to comment
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Getter for the comment
     * @return the recipe comment
     */
    public String getComment() {
        return comment;
    }

    /**
     * Setter for the comment
     * @param comment that is going to be added
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

}
