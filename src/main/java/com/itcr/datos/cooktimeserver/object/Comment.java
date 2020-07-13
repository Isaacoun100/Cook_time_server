package com.itcr.datos.cooktimeserver.object;

public class Comment {

    private final String author;
    private final String comment;

    public Comment(String author, String comment) {
        this.author = author;
        this.comment = comment;
    }

    /**
     * Getter for the author
     * @return the author of the recipe
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Getter for the comment
     * @return the recipe comment
     */
    public String getComment() {
        return comment;
    }

}
