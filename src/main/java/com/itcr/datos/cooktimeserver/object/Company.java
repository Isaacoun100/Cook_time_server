package com.itcr.datos.cooktimeserver.object;

import com.itcr.datos.cooktimeserver.data_structures.SinglyList;

/**
 * This class manages all the data for company
 */
public class Company {
    private String name;
    private String email;
    private String schedule;
    private String logo;
    private String location;
    private int number;
    private int posts;
    private SinglyList<String> followers;
    private SinglyList<String> following;
    private SinglyList<String> members;

    public void addMember(String member){
        members.add(member);
    }
    /**
     * getter for name
     * @return returns the name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for email
     * @return returns email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Setter for email
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Getter for schedule
     * @return returns schedule
     */
    public String getSchedule() {
        return schedule;
    }

    /**
     * Setter for schadule
     * @param schedule
     */
    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    /**
     * Getter for logo
     * @return returns logo
     */
    public String getLogo() {
        return logo;
    }

    /**
     * Setter for logo
     * @param logo
     */
    public void setLogo(String logo) {
        this.logo = logo;
    }

    /**
     * Getter for locatiom
     * @return returns location
     */
    public String getLocation() {
        return location;
    }

    /**
     * Setter for location
     * @param location
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Getter for number
     * @return returns number
     */
    public int getNumber() {
        return number;
    }

    /**
     * Setter for number
     * @param number
     */
    public void setNumber(int number) {
        this.number = number;
    }

    /**
     * Getter for posts
     * @return returns posts
     */
    public int  getPosts() {
        return posts;
    }

    /**
     * Setter for posts
     * @param posts
     */
    public void setPosts(int posts) {
        this.posts = posts;
    }

    /**
     * Getter for followers
     * @return returns followers
     */
    public SinglyList<String> getFollowers() {
        return followers;
    }

    /**
     * Setter for followers
     * @param followers
     */
    public void setFollowers(SinglyList<String> followers) {
        this.followers = followers;
    }

    public SinglyList<String> getFollowing() {
        return following;
    }

    /**
     * Setter for following
     * @param following
     */
    public void setFollowing(SinglyList<String> following) {
        this.following = following;
    }

    /**
     * Getter for members
     * @return returns members
     */
    public SinglyList<String> getMembers() {
        return members;
    }

    /**
     * Setter for members
     * @param members
     */
    public void setMembers(SinglyList<String> members) {
        this.members = members;
    }

    /**
     * This method is just for testing purposes, is used when a new User it's being added, then it transforms it into
     * a string to print it in the console
     * @return a string of the user
     */
    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", schedule='" + schedule + '\'' +
                ", logo='" + logo + '\'' +
                ", location='" + location + '\'' +
                ", number=" + number +
                ", posts=" + posts +
                ", followers=" + followers +
                ", following=" + following +
                ", members=" + members +
                '}';
    }
}
