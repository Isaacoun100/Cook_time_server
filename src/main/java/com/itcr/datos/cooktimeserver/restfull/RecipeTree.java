package com.itcr.datos.cooktimeserver.restfull;

import com.itcr.datos.cooktimeserver.data_structures.AlphAvlTree;
import com.itcr.datos.cooktimeserver.data_structures.AlphNodeAVL;
import com.itcr.datos.cooktimeserver.object.Recipe;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

public class RecipeTree {
    private static AlphAvlTree<Recipe> avlRecipeTree;

    public static void saveUser(){
        try (FileWriter file = new FileWriter("res/data/Recipes.json")){
            file.write(avlTravel(avlRecipeTree.getRoot(), new JSONObject()).toString());
            file.flush();
        }catch (IOException e ){
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public static JSONObject avlTravel(AlphNodeAVL<Recipe> recipe, JSONObject jsonObject){
        jsonObject.put("title", recipe.getData().getTitle());
        jsonObject.put("description", recipe.getData().getDescription());
        jsonObject.put("author", recipe.getData().getAuthor());
        jsonObject.put("type", recipe.getData().getType());
        jsonObject.put("duration", recipe.getData().getDuration());
        jsonObject.put("time", recipe.getData().getTime());
        jsonObject.put("diet", recipe.getData().getDiet());
        jsonObject.put("steps", recipe.getData().getSteps());
        jsonObject.put("image", recipe.getData().getImage());
        jsonObject.put("date", recipe.getData().getDate());
        jsonObject.put("price", recipe.getData().getPrice());
        jsonObject.put("servings", recipe.getData().getServings());
        jsonObject.put("rating", recipe.getData().getRating());
        jsonObject.put("difficulty", recipe.getData().getDifficulty());
        if(recipe.getLeft()!=null){
            jsonObject.replace("left", avlTravel(recipe.getLeft(), new JSONObject()));
        }
        if(recipe.getRight()!=null){
            jsonObject.replace("right", avlTravel(recipe.getRight(), new JSONObject()));
        }
        return jsonObject;
    }
}
