package com.itcr.datos.cooktimeserver.object;

import com.itcr.datos.cooktimeserver.data_structures.SinglyList;

/**
 * Class for the client object
 */
public abstract class Client {

    /**
     * Getter for the String name
     * @return name
     */
    public abstract String getName();

    /**
     * Setter for the String name
     * @param name
     */
    public abstract void setName(String name);

    /**
     * Getter for the String password
     * @return password
     */
    public abstract String getPassword();

    /**
     * Setter for the String password
     * @param password
     */
    public abstract void setPassword(String password);

    /**
     * Getter for the String email
     * @return email
     */
    public abstract String getEmail();

    /**
     * Setter for the String email
     * @param email
     */
    public abstract void setEmail(String email);

    /**
     * Getter for the integer age
     * @return age
     */
    public abstract int getAge();

    /**
     * Setter for the integer age
     * @param age
     */
    public abstract void setAge(int age);

    /**
     * Getter for the String image
     *
     * @return image
     */
    public abstract String getImage();

    /**
     * Setter for the image url
     *
     * @param image that we're going to use
     */
    public abstract void setImage(String image);

    /**
     * Getter for the Singly List recipe
     *
     * @return recipe
     */
    public abstract SinglyList<String> getRecipe();

    /**
     * Adds a new recipe to the recipe list
     *
     * @param recipe
     */
    public abstract void addRecipe(String recipe);

    /**
     * Adds a new follower to the lis of followers
     *
     * @param name
     */
    public abstract void addFollower(String name);

    /**
     *Returns the list of followers
     * @return follower
     */
    public abstract SinglyList<String> getFollowers();

    /**
     * Getter for the singly list following
     *
     * @return following
     */
    public abstract SinglyList<String> getFollowing();

    /**
     * This will add a new user or chef that the user is following
     * @param name
     */
    public abstract void addFollowing(String name);

    /**
     * Will indicate whether or not the user owns a company
     * @return hasCompany depending if he owns one
     */
    public abstract boolean isHasCompany();

    /**
     * Sets the hasCompany boolean
     * @param hasCompany value if has or not
     */
    public abstract void setHasCompany(boolean hasCompany);

    /**
     * Setter for the recipe Singly list
     *
     * @param recipe that we're going to use
     */
    public abstract void setRecipe(SinglyList<String> recipe);

    /**
     * Setter for the followers Singly list
     *
     * @param followers that we're going to use
     */
    public abstract void setFollowers(SinglyList<String> followers);

    /**
     * Setter for the following Singly list
     *
     * @param following is the singly list that is going to be added
     */
    public abstract void setFollowing(SinglyList<String> following);

}
