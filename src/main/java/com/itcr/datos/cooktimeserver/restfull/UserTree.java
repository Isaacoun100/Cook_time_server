package com.itcr.datos.cooktimeserver.restfull;

import com.itcr.datos.cooktimeserver.data_structures.AlphBinaryTree;
import com.itcr.datos.cooktimeserver.data_structures.AlphNodeTree;
import com.itcr.datos.cooktimeserver.object.User;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONObject;
import java.io.IOException;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * This class will be called whenever we need to modify, clear, add or access the list of users
 */
public class UserTree {
    private static AlphBinaryTree<User> binaryUserTree;

    /**
     * This method initializes the user list and adds all of the users from the Users.json json file
     */
    public static void initUserList(){
        binaryUserTree = new AlphBinaryTree<User>();
        updateUserList();
    }

    /**
     * This method will access to the Users.json and load all of the users in the UsersList
     */
    public static void updateUserList(){
        binaryUserTree.clear();

        JSONParser userParser = new JSONParser();
        try {
            JSONObject usersJSON = (JSONObject) userParser.parse(new FileReader("res/data/Users.json"));
            getBranch(usersJSON);
        }
        catch (Exception e) {e.printStackTrace();}
        System.out.println(binaryUserTree.toString());
    }

    private static void getBranch(JSONObject jsonObject){
        User newUser = new User();
        newUser.setName(jsonObject.get("name").toString());
        newUser.setEmail(jsonObject.get("email").toString());
        newUser.setAge(Integer.parseInt(jsonObject.get("age").toString()));
        newUser.setPassword(jsonObject.get("password").toString());

        binaryUserTree.add(newUser, newUser.getName());

        if(jsonObject.get("right")!=null){
            getBranch((JSONObject) jsonObject.get("right"));
        }
        if(jsonObject.get("left")!=null){
            getBranch((JSONObject) jsonObject.get("left"));
        }

    }

    /**
     * This method will convert the given JSONObject into a User
     * @param newObject
     * @return the JSONObject converted into a User
     */
    public static User makeUser(JSONObject newObject){

        User newUser = new User();

        if(!newObject.isEmpty()){

            try{
                String name = newObject.get("name").toString();
                newUser.setName(name);
            }
            catch (NullPointerException e){
                System.out.println("The name was not provided correcly please check");
                e.printStackTrace();
                System.out.println("For more information");
                newUser.setName("Not provided correcly");
            }

            try{
                int age = Integer.parseInt(newObject.get("age").toString());
                newUser.setAge(age);
            }
            catch (NullPointerException e){
                System.out.println("The name age not provided correcly please check");
                e.printStackTrace();
                System.out.println("For more information");
                newUser.setAge(0);
            }

            try{
                String email = newObject.get("email").toString();
                newUser.setEmail(email);
            }
            catch (NullPointerException e){
                System.out.println("The email was not provided correcly please check");
                e.printStackTrace();
                System.out.println("For more information");
                newUser.setEmail("Not provided correcly");
            }

            try{
                String password = newObject.get("password").toString();
                newUser.setPassword(password);
            }
            catch (NullPointerException e) {
                System.out.println("The password was not provided correcly please check");
                e.printStackTrace();
                System.out.println("For more information");
                newUser.setPassword("Not provided correcly");}
        }
        else{
            newUser.setName("Not provided");
            newUser.setEmail("Not provided");
            newUser.setPassword("Not provided");
            newUser.setAge(0);
        }

        return newUser;
    }

    /**
     * This method will convert the given User into a JSONObject
     * @param newUser
     * @return the User converted into a JSONObject
     */
    @SuppressWarnings("unchecked")
    public static JSONObject makeObject(User newUser){

        JSONObject incomingUser = new JSONObject();

        incomingUser.put("name",newUser.getName());
        incomingUser.put("age",newUser.getAge());
        incomingUser.put("email",newUser.getEmail());
        incomingUser.put("password",newUser.getPassword());

        return incomingUser;

    }

    /**
     * This method is a getter for the UserList
     * @return UserList
     */
    public static AlphBinaryTree<User> getUserTree(){
        return binaryUserTree;
    }

    /**
     * This method receives a User and it adds it to the UserList
     * @param newUser
     */
    public static void addUser(User newUser){
        if(newUser!=null){
            binaryUserTree.add(newUser, newUser.getName());
            saveUser();
            updateUserList();
        }
        else{
            System.out.println("Something went wrong while adding the user, the user was empty");
        }
    }
    /**
     * This method will write the users into the Users.json
     */
    public static void saveUser(){
        try(FileWriter file = new FileWriter("res/data/Users.json")){
            file.write(binaryTravel(binaryUserTree.getRoot(), new JSONObject()).toString());
            file.flush();

        }
        catch (IOException e) { e.printStackTrace();}
    }

    @SuppressWarnings("unchecked")
    public static JSONObject binaryTravel(AlphNodeTree<User> user, JSONObject jsonObject){
        jsonObject.put("name",user.getData().getName());
        jsonObject.put("password",user.getData().getPassword());
        jsonObject.put("email",user.getData().getEmail());
        jsonObject.put("age",user.getData().getAge());
        jsonObject.put("left", null);
        jsonObject.put("right",null);
        if(user.getLeft()!=null){
            jsonObject.replace("left", binaryTravel(user.getLeft(), new JSONObject()));
        }
        if(user.getRight()!=null){
            jsonObject.replace("right", binaryTravel(user.getRight(), new JSONObject()));
        }
        return jsonObject;
    }

}
