package com.itcr.datos.cooktimeserver.object;

/**
 * This class is will manage all of the data from the users
 */
public class User {

    private String name;
    private String password;
    private String email;
    private int age;

    /**
     * Getter for the String name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for the String name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for the String password
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Setter for the String pasword
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Getter for the String email
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Setter for the String email
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Getter for the integer age
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * Setter for the integer age
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * This method is just for testing purposes, is used when a new User it's being added, then it transforms it into
     * a string to print it in the console
     * @return
     */
    @Override
    public String toString() {
        return "User [name=" + name + ", password=" + password + ", email=" + email + ", age=" + age + "]";
    }
}