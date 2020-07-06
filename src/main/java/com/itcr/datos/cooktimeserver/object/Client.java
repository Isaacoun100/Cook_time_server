package com.itcr.datos.cooktimeserver.object;

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

}
