package com.itcr.datos.cooktimeserver.restfull;


import com.itcr.datos.cooktimeserver.data_structures.AlphBinaryTree;
import com.itcr.datos.cooktimeserver.data_structures.AlphNodeTree;
import com.itcr.datos.cooktimeserver.data_structures.SinglyList;
import com.itcr.datos.cooktimeserver.object.Chef;
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
public class ChefTree {
    private static AlphBinaryTree<Chef> binaryChefTree;

    /**
     * This method initializes the user list and adds all of the users from the Users.json json file
     */
    public static void initChefList(){
        binaryChefTree = new AlphBinaryTree<Chef>();
        updateChefList();
    }

    /**
     * This method will access to the Chefs.json and load all of the users in the ChefsList
     */
    public static void updateChefList(){
        binaryChefTree.clear();

        JSONParser chefParser = new JSONParser();
        try {
            JSONObject chefsJSON = (JSONObject) chefParser.parse(new FileReader("res/data/Chefs.json"));
            getBranch(chefsJSON);
        }
        catch (Exception e) {
            e.printStackTrace();
            getBranch(new JSONObject());
        }
        System.out.println(binaryChefTree.toString());
    }

    /**
     * Function that creates a chef object and adds the chef to the tree
     * @param jsonObject
     */
    private static void getBranch(JSONObject jsonObject){
        Chef newChef = new Chef();

        try{newChef.setName(jsonObject.get("name").toString());}
        catch (NullPointerException e){newChef.setName(null);}

        try{newChef.setEmail(jsonObject.get("email").toString());}
        catch (NullPointerException e){newChef.setEmail(null);}

        try{newChef.setAge(Integer.parseInt(jsonObject.get("age").toString()));}
        catch (NullPointerException e){newChef.setAge(0);}

        try{newChef.setPassword(jsonObject.get("password").toString());}
        catch (NullPointerException e){newChef.setPassword(null);}

        try{newChef.setRecipe(TypeConversion.makeStringList((JSONArray) jsonObject.get("recipe"),new SinglyList<String>()));}
        catch (NullPointerException e){ newChef.setRecipe(new SinglyList<String>());}

        try{newChef.setHasCompany((Boolean) jsonObject.get("hasCompany"));}
        catch (NullPointerException e){newChef.setHasCompany(false);}

        try{newChef.setVerify((Boolean) jsonObject.get("verify"));}
        catch (NullPointerException e){newChef.setHasCompany(false);}

        try{newChef.setFollowers(TypeConversion.makeStringList((JSONArray)jsonObject.get("followers"), new SinglyList<String>()));}
        catch (NullPointerException e){newChef.setFollowers(new SinglyList<String>());}

        try{newChef.setFollowing(TypeConversion.makeStringList((JSONArray) jsonObject.get("following"), new SinglyList<String>()));}
        catch (NullPointerException e){newChef.setFollowing(new SinglyList<String>());}

        binaryChefTree.add(newChef, newChef.getEmail());

        if(jsonObject.get("right")!=null){
            getBranch((JSONObject) jsonObject.get("right"));
        }
        if(jsonObject.get("left")!=null){
            getBranch((JSONObject) jsonObject.get("left"));
        }
    }

    /**
     * This method is a getter for the ChefsList
     * @return ChefList
     */
    public static AlphBinaryTree<Chef> getChefTree(){
        return binaryChefTree;
    }

    /**
     * This method receives a User and it adds it to the ChefsList
     * @param newChef
     */
    public static void addChef(Chef newChef){
        if(newChef!=null){
            binaryChefTree.add(newChef, newChef.getEmail());
            saveChef();
            updateChefList();
        }
        else{
            System.out.println("Something went wrong while adding the chef, the chef was empty");
        }
    }
    /**
     * This method will write the users into the Chefs.json
     */
    public static void saveChef(){
        try(FileWriter file = new FileWriter("res/data/Chefs.json")){
            file.write(binaryTravel(binaryChefTree.getRoot(), new JSONObject()).toString());
            file.flush();

        }
        catch (IOException e) { e.printStackTrace();}
    }

    /**
     * Function that adds the data to Chefs.json
     * @param chef
     * @param jsonObject
     * @return returns jsonobject
     */
    @SuppressWarnings("unchecked")
    public static JSONObject binaryTravel(AlphNodeTree<Chef> chef, JSONObject jsonObject){
        jsonObject=TypeConversion.chefToJSON(chef);
        jsonObject.put("left", null);
        jsonObject.put("right",null);

        if(chef.getLeft()!=null){
            jsonObject.replace("left", binaryTravel(chef.getLeft(), new JSONObject()));
        }
        if(chef.getRight()!=null){
            jsonObject.replace("right", binaryTravel(chef.getRight(), new JSONObject()));
        }
        return jsonObject;
    }

}
