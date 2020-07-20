package com.itcr.datos.cooktimeserver.restfull;

import com.itcr.datos.cooktimeserver.data_structures.AlphNodeSplay;
import com.itcr.datos.cooktimeserver.data_structures.AlphNodeTree;
import com.itcr.datos.cooktimeserver.data_structures.AlphSplayTree;
import com.itcr.datos.cooktimeserver.data_structures.SinglyList;
import com.itcr.datos.cooktimeserver.object.Company;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * This class will be called whenever we need to modify, clear, add or access the list of companies.
 */
public class CompanyTree {
    private static AlphSplayTree<Company> splayCompanyTree;

    /**
     * This method initializes the user list and adds all of the users from the Recipe.json json file
     */
    public static void initCompanyList(){
        splayCompanyTree = new AlphSplayTree<Company>();
        updateCompanyList();
    }
    /**
     * This method will access to the Companies.json and load all of the users in the CompanyList
     */
    public static void updateCompanyList(){
        splayCompanyTree.clear();

        JSONParser companyParser = new JSONParser();

        try{
            JSONObject companyJSON = (JSONObject) companyParser.parse(new FileReader("res/data/Companies.json"));
            getBranch(companyJSON);
        }
        catch (IOException | ParseException e){
            e.printStackTrace();
        }
        System.out.println(splayCompanyTree.toString());
    }

    /**
     * Function that creates a company object and
     * @param jsonObject
     */
    private static void getBranch(JSONObject jsonObject){
        Company newCompany = new Company();

       newCompany = TypeConversion.makeCompany(jsonObject);

        splayCompanyTree.add(newCompany, newCompany.getName());

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
    public static AlphSplayTree<Company> getUserTree(){
        return splayCompanyTree;
    }
    /**
     * This method receives a User and it adds it to the UserList
     * @param newCompany
     */
    public static void addCompany(Company newCompany){
        if(newCompany!=null){
            splayCompanyTree.add(newCompany, newCompany.getName());
            saveCompany();
            updateCompanyList();
        }
        else{
            System.out.println("Something went wrong while adding the company, the company was empty");
        }
    }
    /**
     * This method will write the users into the Recipe.json
     */
    public static void saveCompany(){
        try(FileWriter file = new FileWriter("res/data/Companies.json")){
            file.write(splayTravel(splayCompanyTree.getRoot(), new JSONObject()).toString());
            file.flush();

        }
        catch (IOException e) { e.printStackTrace();}
    }

    /**
     * Recursive function that stores the data into the json
     * @param company the node
     * @param jsonObject the json object
     * @return returns the jsonObject
     */
    @SuppressWarnings("unchecked")
    public static JSONObject splayTravel(AlphNodeSplay<Company> company, JSONObject jsonObject){
        jsonObject= companyToJSON(company);

        jsonObject.put("left", null);
        jsonObject.put("right",null);

        if(company.getLeft()!=null){
            jsonObject.replace("left", splayTravel(company.getLeft(), new JSONObject()));
        }
        if(company.getRight()!=null){
            jsonObject.replace("right", splayTravel(company.getRight(), new JSONObject()));
        }
        return jsonObject;
    }

    public static JSONObject companyToJSON(AlphNodeSplay<Company> company){
        JSONObject jsonObject =  new JSONObject();

        try{jsonObject.put("name", company.getData().getName());}
        catch (NullPointerException e){jsonObject.put("name",null);}

        try{jsonObject.put("email", company.getData().getEmail());}
        catch (NullPointerException e){jsonObject.put("email",null);}

        try{jsonObject.put("schedule", company.getData().getSchedule());}
        catch (NullPointerException e){jsonObject.put("schedule",null);}

        try{jsonObject.put("logo", company.getData().getLogo());}
        catch (NullPointerException e){jsonObject.put("logo",null);}

        try{jsonObject.put("location", company.getData().getLocation());}
        catch (NullPointerException e){jsonObject.put("location",null);}

        try{jsonObject.put("number", company.getData().getNumber());}
        catch (NullPointerException e){jsonObject.put("number",null);}

        try{jsonObject.put("posts", company.getData().getPosts());}
        catch (NullPointerException e){jsonObject.put("posts",null);}

        try{jsonObject.put("followers",TypeConversion.makeStringArray(company.getData().getFollowers(), new JSONArray()));}
        catch (NullPointerException e){jsonObject.put("followers",null);}

        try{jsonObject.put("following",TypeConversion.makeStringArray(company.getData().getFollowing(), new JSONArray()));}
        catch (NullPointerException e){jsonObject.put("following",null);}

        try{jsonObject.put("members", TypeConversion.makeStringArray(company.getData().getMembers(),new JSONArray()));}
        catch (NullPointerException e){jsonObject.put("members",null);}

        return jsonObject;
    }

}
