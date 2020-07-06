package com.itcr.datos.cooktimeserver.object;

/**
 * This class is inherited from Client, this because User and Chef both are clients from the server with the only
 * difference that the chef needs a boolean to check if is or not verified
 */
public class Chef extends Client{

    private String name;
    private String email;
    private String password;
    private int age;
    private boolean verify;

    /**
     *  This method verifies if the chef is a verified chef or not
     * @return
     */
    public boolean isVerify() {
        return verify;
    }

    /**
     *  This class modifies the value of the verify value
     * @param verify is true if the user has been verified
     */
    public void setVerify(boolean verify) {
        this.verify = verify;
    }


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
     * This method is just for testing purposes, is used when a new User it's being added, then it transforms it into
     * a string to print it in the console
     * @return
     */
    @Override
    public String toString() {
        return "User [name=" + name + ", password=" + password + ", email=" + email + ", age=" + age + "]";
    }
}
