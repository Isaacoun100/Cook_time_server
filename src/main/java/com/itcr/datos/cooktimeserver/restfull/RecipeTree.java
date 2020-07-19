package com.itcr.datos.cooktimeserver.restfull;

import com.itcr.datos.cooktimeserver.data_structures.AlphAvlTree;
import com.itcr.datos.cooktimeserver.data_structures.AlphNodeAVL;
import com.itcr.datos.cooktimeserver.data_structures.SinglyList;
import com.itcr.datos.cooktimeserver.data_structures.SinglyNode;
import com.itcr.datos.cooktimeserver.object.Recipe;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Class for the recipe tree
 */
public class RecipeTree {
    private static AlphAvlTree<Recipe> avlRecipeTree;

    /**
     * Function that initializes the recipe avl tree
     */
    public static void initRecipeList(){
        avlRecipeTree = new AlphAvlTree<>();
        updateRecipeList();

    }

    /**
     * This method will access to the Recipes.json and load all of the recipes in the RecipesList
     */
    public static void updateRecipeList(){
        avlRecipeTree.clear();

        JSONParser recipeParser = new JSONParser();
        try{
            JSONObject recipeJSON =  (JSONObject) recipeParser.parse(new FileReader("res/data/Recipes.json"));
            getBranch(recipeJSON);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(avlRecipeTree.toString());
    }

    /**
     * Function that creates a recipe object and adds the recipe to the tree
     * @param jsonObject
     */
    public static void getBranch(JSONObject jsonObject){
        Recipe newRecipe = new Recipe();

        newRecipe = TypeConversion.makeRecipe(jsonObject);

        avlRecipeTree.add(newRecipe, newRecipe.getTitle());

        if(jsonObject.get("right") != null){
            getBranch((JSONObject) jsonObject.get("right"));
        }
        if (jsonObject.get("left") != null){
            getBranch((JSONObject) jsonObject.get("left"));
        }
    }

    /**
     * Getter for the avl tree
     * @return returns the avl tree
     */
    public static AlphAvlTree<Recipe> getAvlRecipeTree(){
        return avlRecipeTree;
    }

    /**
     * Function that adds the recipe
     * @param newRecipe
     */
    public static void addRecipe(Recipe newRecipe){
        if(newRecipe != null){
            avlRecipeTree.add(newRecipe, newRecipe.getTitle());
            saveUser();
            updateRecipeList();
        }
        else{
            System.out.println("Something went wrong while adding the recipe, the recipe was empty");

        }
    }

    public static void saveUser(){
        try (FileWriter file = new FileWriter("res/data/Recipes.json")){
            file.write(avlTravel(avlRecipeTree.getRoot(), new JSONObject()).toString());
            file.flush();
        }catch (IOException e ){ e.printStackTrace(); }
    }

    public static JSONArray recipeListToJSON(SinglyList<Recipe> recipeSinglyList){
        int count, size = count = 0;
        JSONArray jsonArray = new JSONArray();
        try{ size=recipeSinglyList.getLength(); }
        catch (NullPointerException e){ e.printStackTrace();}

        while(count<size){
            jsonArray.add(recipeToJSONObject(recipeSinglyList.get(count).getData()));
            count++;
        }
        return jsonArray;
    }

    public static JSONObject recipeToJSONObject(Recipe recipe){
        JSONObject jsonObject = new JSONObject();

        try{jsonObject.put("title", recipe.getTitle());}
        catch (NullPointerException e){jsonObject.put("title",null);}

        try{jsonObject.put("description", recipe.getDescription());}
        catch (NullPointerException e){jsonObject.put("description",null);}

        try{jsonObject.put("author", recipe.getAuthor());}
        catch (NullPointerException e){jsonObject.put("author",null);}

        try{jsonObject.put("type", recipe.getType());}
        catch (NullPointerException e){jsonObject.put("type",null);}

        try{jsonObject.put("duration", recipe.getDuration());}
        catch (NullPointerException e){jsonObject.put("duration",null);}

        try{jsonObject.put("time", recipe.getTime());}
        catch (NullPointerException e){jsonObject.put("time",null);}

        try{jsonObject.put("diet", recipe.getDiet());}
        catch (NullPointerException e){jsonObject.put("diet",null);}

        try{jsonObject.put("steps", recipe.getSteps());}
        catch (NullPointerException e){jsonObject.put("steps",null);}

        try{jsonObject.put("image", recipe.getImage());}
        catch (NullPointerException e){jsonObject.put("image",null);}

        try{jsonObject.put("date", recipe.getDate());}
        catch (NullPointerException e){jsonObject.put("date",null);}

        try{jsonObject.put("price", recipe.getPrice());}
        catch (NullPointerException e){jsonObject.put("price",null);}

        try{jsonObject.put("servings", recipe.getServings());}
        catch (NullPointerException e){jsonObject.put("servings",null);}

        try{jsonObject.put("rating", recipe.getRating());}
        catch (NullPointerException e){jsonObject.put("rating",null);}

        try{jsonObject.put("difficulty", recipe.getDifficulty());}
        catch (NullPointerException e){jsonObject.put("difficulty",null);}

        try{jsonObject.put("comments", TypeConversion.makeCommentArray(recipe.getComments(), new JSONArray()));}
        catch (NullPointerException e){jsonObject.put("difficulty",null);}

        return jsonObject;
    }

    @SuppressWarnings("unchecked")
    public static JSONObject avlTravel(AlphNodeAVL<Recipe> recipe, JSONObject jsonObject){
        jsonObject=recipeToJSONObject(recipe.getData());
        jsonObject.put("left", null);
        jsonObject.put("right", null);

        if(recipe.getLeft()!=null){
            jsonObject.replace("left", avlTravel(recipe.getLeft(), new JSONObject()));
        }
        if(recipe.getRight()!=null){
            jsonObject.replace("right", avlTravel(recipe.getRight(), new JSONObject()));
        }
        return jsonObject;
    }
}
