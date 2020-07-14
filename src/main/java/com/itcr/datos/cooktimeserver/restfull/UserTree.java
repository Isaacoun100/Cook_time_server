package com.itcr.datos.cooktimeserver.restfull;

import com.itcr.datos.cooktimeserver.data_structures.AlphBinaryTree;
import com.itcr.datos.cooktimeserver.data_structures.AlphNodeTree;
import com.itcr.datos.cooktimeserver.data_structures.SinglyList;
import com.itcr.datos.cooktimeserver.object.Recipe;
import com.itcr.datos.cooktimeserver.object.User;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
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
        catch (Exception e) {
            e.printStackTrace();
            getBranch(new JSONObject());
        }
        System.out.println(binaryUserTree.toString());
    }

    private static void getBranch(JSONObject jsonObject){
        User newUser = new User();

        try{newUser.setName(jsonObject.get("name").toString());}
        catch (NullPointerException e){newUser.setName(null);}

        try{newUser.setEmail(jsonObject.get("email").toString());}
        catch (NullPointerException e){newUser.setEmail(null);}

        try{newUser.setAge(Integer.parseInt(jsonObject.get("age").toString()));}
        catch (NullPointerException e){newUser.setAge(0);}

        try{newUser.setPassword(jsonObject.get("password").toString());}
        catch (NullPointerException e){newUser.setPassword(null);}

        try{newUser.setRecipe(TypeConversion.toSinglyList((JSONArray) jsonObject.get("recipe"),new SinglyList<Recipe>()));}
        catch (NullPointerException e){ newUser.setRecipe(new SinglyList<Recipe>());}

        try{newUser.setHasCompany((Boolean) jsonObject.get("hasCompany"));}
        catch (NullPointerException e){newUser.setHasCompany(false);}

        try{newUser.setFollowers(TypeConversion.makeStringList((JSONArray)jsonObject.get("followers"), new SinglyList<String>()));}
        catch (NullPointerException e){newUser.setFollowers(new SinglyList<String>());}

        try{newUser.setFollowing(TypeConversion.makeStringList((JSONArray) jsonObject.get("following"), new SinglyList<String>()));}
        catch (NullPointerException e){newUser.setFollowing(new SinglyList<String>());}

        binaryUserTree.add(newUser, newUser.getEmail());

        if(jsonObject.get("right")!=null){
            getBranch((JSONObject) jsonObject.get("right"));
        }
        if(jsonObject.get("left")!=null){
            getBranch((JSONObject) jsonObject.get("left"));
        }
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
            binaryUserTree.add(newUser, newUser.getEmail());
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

        try{jsonObject.put("name",user.getData().getName());}
        catch (NullPointerException e){jsonObject.put("name",null);}

        try{ jsonObject.put("password",user.getData().getPassword());}
        catch (NullPointerException e){jsonObject.put("password",null);}

        try{jsonObject.put("email",user.getData().getEmail());}
        catch (NullPointerException e){jsonObject.put("email",null);}

        try{jsonObject.put("age",user.getData().getAge());}
        catch (NullPointerException e){jsonObject.put("age",0);}

        try{jsonObject.put("image",user.getData().getImage());}
        catch (NullPointerException e){jsonObject.put("image",null);}

        try{jsonObject.put("recipe",TypeConversion.makeRecipeArray(user.getData().getRecipe(),new JSONArray()));}
        catch (NullPointerException e){jsonObject.put("recipe",null);}

        try{jsonObject.put("followers",TypeConversion.makeStringArray(user.getData().getFollowers(), new JSONArray()));}
        catch (NullPointerException e){jsonObject.put("followers",null);}

        try{jsonObject.put("following",TypeConversion.makeStringArray(user.getData().getFollowing(), new JSONArray()));}
        catch (NullPointerException e){jsonObject.put("following",null);}

        try{jsonObject.put("hasCompany",user.getData().isHasCompany());}
        catch (NullPointerException e){jsonObject.put("hasCompany",false);}

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
