package com.itcr.datos.cooktimeserver.object;

import com.itcr.datos.cooktimeserver.data_structures.SinglyList;

/**
 * This class is will manage all of the data from the users
 */
public class User extends Client {

    private String name;
    private String email;
    private String image;
    private String password;
    private SinglyList<Recipe> recipe;
    private SinglyList<String> followers;
    private SinglyList<String> following;
    private boolean hasCompany;
    private int age;

    /**
     * Getter for the String name
     *
     * @return name
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Setter for the String name
     *
     * @param name
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for the String password
     *
     * @return password
     */
    @Override
    public String getPassword() {
        return password;
    }

    /**
     * Setter for the String password
     *
     * @param password
     */
    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Getter for the String email
     *
     * @return email
     */
    @Override
    public String getEmail() {
        return email;
    }

    /**
     * Setter for the String email
     *
     * @param email
     */
    @Override
    public void setEmail(String email) {
        this.email =  email;
    }

    /**
     * Getter for the integer age
     *
     * @return age
     */
    @Override
    public int getAge() {
        return age;
    }

    /**
     * Setter for the integer age
     *
     * @param age
     */
    @Override
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Getter for the String image
     *
     * @return image
     */
    @Override
    public String getImage() {
        return image;
    }

    /**
     * Setter for the image url
     *
     * @param image that we're going to use
     */
    @Override
    public void setImage(String image) {
        this.image=image;
    }

    /**
     * Getter for the Singly List recipe
     *
     * @return recipe
     */
    @Override
    public SinglyList<Recipe> getRecipe() {
        return recipe;
    }

    /**
     * Adds a new recipe to the recipe list
     *
     * @param recipe that is going to be added
     */
    @Override
    public void addRecipe(Recipe recipe) {
        this.recipe.add(recipe);
    }

    /**
     * Returns the list of followers
     *
     * @return follower
     */
    @Override
    public SinglyList<String> getFollowers() {
        return followers;
    }

    /**
     * Adds a new follower to the lis of followers
     *
     * @param name of the follower that is going to be added
     */
    @Override
    public void addFollower(String name) {
        this.followers.add(name);
    }

    /**
     * Getter for the singly list following
     *
     * @return following
     */
    @Override
    public SinglyList<String> getFollowing() {
        return following;
    }

    /**
     * This will add a new user or chef that the user is following
     *
     * @param name
     */
    @Override
    public void addFollowing(String name) {
        following.add(name);
    }

    /**
     * Will indicate whether or not the user owns a company
     *
     * @return hasCompany depending if he owns one
     */
    @Override
    public boolean isHasCompany() {
        return hasCompany;
    }

    /**
     * Sets the hasCompany boolean
     *
     * @param hasCompany value if has or not
     */
    @Override
    public void setHasCompany(boolean hasCompany) {
        this.hasCompany= hasCompany;
    }

    /**
     * Setter for the recipe Singly list
     *
     * @param recipe that we're going to use
     */
    @Override
    public void setRecipe(SinglyList<Recipe> recipe) {
        this.recipe=recipe;
    }

    /**
     * Setter for the followers Singly list
     *
     * @param followers that we're going to use
     */
    @Override
    public void setFollowers(SinglyList<String> followers) {
        this.followers=followers;
    }

    /**
     * Setter for the following Singly list
     *
     * @param following is the singly list that is going to be added
     */
    @Override
    public void setFollowing(SinglyList<String> following) {
        this.following=following;
    }

    /**
     * This method is just for testing purposes, is used when a new User it's being added, then it transforms it into
     * a string to print it in the console
     * @return a string of the user
     */
    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", password='" + password + '\'' +
                ", image='" + image + '\'' +
                ", recipe=" + recipe +
                ", hasCompany=" + hasCompany +
                ", followers=" + followers +
                ", following=" + following +
                '}';
    }

}