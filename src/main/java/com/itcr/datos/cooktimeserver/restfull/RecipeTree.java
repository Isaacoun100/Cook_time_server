package com.itcr.datos.cooktimeserver.restfull;

import com.itcr.datos.cooktimeserver.data_structures.AlphAvlTree;
import com.itcr.datos.cooktimeserver.data_structures.AlphNodeAVL;
import com.itcr.datos.cooktimeserver.data_structures.SinglyList;
import com.itcr.datos.cooktimeserver.object.Comment;
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
        avlRecipeTree = new AlphAvlTree<Recipe>();
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
            System.out.println(avlRecipeTree.toString());
        }
        catch (Exception e){
            System.out.println("Empty recipe JSON, error at line "+(TreeManagement.getSourceCodeLine()));
        }
    }

    /**
     * Function that creates a recipe object and adds the recipe to the tree
     * @param jsonObject
     */
    public static void getBranch(JSONObject jsonObject){
        Recipe newRecipe  = TypeConversion.makeRecipe(jsonObject);
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
            saveRecipe();
            updateRecipeList();
        }
        else{
            System.out.println("Something went wrong while adding the recipe, the recipe was empty");

        }
    }

    /**
     * Function that saves a new recipe
     */
    public static void saveRecipe(){
        try (FileWriter file = new FileWriter("res/data/Recipes.json")){
            file.write(avlTravel(avlRecipeTree.getRoot(), new JSONObject()).toString());
            file.flush();
        }catch (IOException e ){ e.printStackTrace(); }
    }

    /**
     * Function that casts a recipe list to JSON
     * @param recipeSinglyList the recipe singly list
     * @return returns the jsonarray
     */
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

    /**
     * Function that casts recipe to JSON object
     * @param recipe
     * @return
     */
    @SuppressWarnings("unchecked")
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

        try{jsonObject.put("comments", recipe.getComments());}
        catch (NullPointerException e){jsonObject.put("comments",null);}

        return jsonObject;
    }

    /**
     * Function that travels the avl tree in finds the data
     * @param recipe the recioe avl node
     * @param jsonObject the JSON object
     * @return returns the updated JSON object
     */
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

    public static SinglyList<Recipe> getRecipeList(){
        return getRecipeList(RecipeTree.getAvlRecipeTree().getRoot(), new SinglyList<>());
    }
    private static SinglyList<Recipe> getRecipeList(AlphNodeAVL<Recipe> reference, SinglyList<Recipe> recipeList){
       if (reference != null){ recipeList.add(reference.getData());}
        if(reference.getRight()!=null){return getRecipeList(reference.getRight(), recipeList);}
        if(reference.getLeft()!=null){return getRecipeList(reference.getLeft(), recipeList);}
        recipeList.print_list();
        return recipeList;

    }

    public static SinglyList<Recipe> searchRecipe(String data){
        return searchRecipe(data, getAvlRecipeTree().getRoot(), new SinglyList<Recipe>());
    }

    public static SinglyList<Recipe> searchRecipe(String data, AlphNodeAVL<Recipe> root, SinglyList<Recipe> result){
        if(root.getData().getTitle().contains(data)){ result.add(root.getData()); }
        if(root.getRight()!=null){ searchRecipe(data, root.getRight(), result); }
        if(root.getLeft()!=null){ searchRecipe(data, root.getLeft(), result); }
        return result;
    }

}
