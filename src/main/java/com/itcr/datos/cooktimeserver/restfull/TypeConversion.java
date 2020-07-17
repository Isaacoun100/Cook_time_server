package com.itcr.datos.cooktimeserver.restfull;

import com.itcr.datos.cooktimeserver.data_structures.AlphNodeTree;
import com.itcr.datos.cooktimeserver.data_structures.SinglyList;
import com.itcr.datos.cooktimeserver.object.Comment;
import com.itcr.datos.cooktimeserver.object.Recipe;
import com.itcr.datos.cooktimeserver.object.User;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * This class will manage the conversion between types JSON and others
 */
public class TypeConversion {

    public static SinglyList<Recipe> toSinglyList(JSONArray recipeJSON, SinglyList<Recipe> recipeSinglyList){
        int count,size = count = 0;
        try{ size = recipeJSON.size(); }
        catch (NullPointerException e){ e.printStackTrace(); }

        while(count<size){
            recipeSinglyList.add(makeRecipe((JSONObject) recipeJSON.get(count)));
            count++;
        }
        return  recipeSinglyList;
    }

    public static Recipe makeRecipe(JSONObject jsonObject){
        Recipe recipe = new Recipe();
        recipe.setTitle(jsonObject.get("title").toString());
        recipe.setDescription(jsonObject.get("description").toString());
        recipe.setAuthor(jsonObject.get("author").toString());
        recipe.setType(jsonObject.get("type").toString());
        recipe.setDuration(jsonObject.get("duration").toString());
        recipe.setTime(jsonObject.get("time").toString());
        recipe.setDiet(jsonObject.get("diet").toString());
        recipe.setSteps(jsonObject.get("steps").toString());
        recipe.setImage(jsonObject.get("image").toString());
        recipe.setDate(jsonObject.get("date").toString());
        recipe.setPrice(Integer.parseInt(jsonObject.get("price").toString()));
        recipe.setServings(Integer.parseInt(jsonObject.get("servings").toString()));
        recipe.setRating(Integer.parseInt(jsonObject.get("rating").toString()));
        recipe.setDifficulty(Integer.parseInt(jsonObject.get("difficulty").toString()));
        recipe.setComments(makeCommentList((JSONArray) jsonObject.get("comments"), new SinglyList<>()));
        return recipe;
    }

    private static SinglyList<Comment> makeCommentList(JSONArray jsonArray,SinglyList<Comment> result){
        int count,size=count=0;
        try{size=jsonArray.size();}
        catch (NullPointerException e){e.printStackTrace();}

        while(count<size){
            JSONObject jsonObject = (JSONObject) jsonArray.get(count);
            result.add(makeComment(jsonObject));
            count++;
        }

        return result;

    }

    private static Comment makeComment(JSONObject jsonObject){
        return new Comment(jsonObject.get("author").toString(), jsonObject.get("comment").toString());
    }

    public static SinglyList<String> makeStringList(JSONArray jsonArray, SinglyList<String> singlyList){
        int count,size=count=0;

        try{size=jsonArray.size();}
        catch (NullPointerException e){e.printStackTrace();}

        while(count<size){

            singlyList.add((String) jsonArray.get(count));
            count++;
        }
        return singlyList;
    }

    @SuppressWarnings("unchecked")
    public static JSONArray makeRecipeArray(SinglyList<Recipe> recipeSinglyList, JSONArray jsonArray){

        int count=0;

        while(count<recipeSinglyList.getLength()){
            JSONObject jsonObject = new JSONObject();

            jsonObject.put("title", recipeSinglyList.get(count).getData().getTitle());
            jsonObject.put("description", recipeSinglyList.get(count).getData().getDescription());
            jsonObject.put("author", recipeSinglyList.get(count).getData().getAuthor());
            jsonObject.put("type", recipeSinglyList.get(count).getData().getType());
            jsonObject.put("duration", recipeSinglyList.get(count).getData().getDuration());
            jsonObject.put("time", recipeSinglyList.get(count).getData().getTime());
            jsonObject.put("diet", recipeSinglyList.get(count).getData().getDiet());
            jsonObject.put("price",recipeSinglyList.get(count).getData().getPrice());
            jsonObject.put("rating",recipeSinglyList.get(count).getData().getRating());
            jsonObject.put("steps", recipeSinglyList.get(count).getData().getSteps());
            jsonObject.put("image", recipeSinglyList.get(count).getData().getImage());
            jsonObject.put("date", recipeSinglyList.get(count).getData().getDate());
            jsonObject.put("servings", recipeSinglyList.get(count).getData().getServings());
            jsonObject.put("difficulty", recipeSinglyList.get(count).getData().getDifficulty());

            SinglyList<Comment> commentSinglyList = recipeSinglyList.get(count).getData().getComments();
            JSONArray newJSONArray = new JSONArray();
            int value=0;
            while(value<commentSinglyList.getLength()){
                JSONObject newJSONObject = new JSONObject();
                newJSONObject.put("author", commentSinglyList.get(value).getData().getAuthor());
                newJSONObject.put("comment", commentSinglyList.get(value).getData().getComment());
                newJSONArray.add(newJSONObject);
                value++;
            }

            jsonObject.put("comments",newJSONArray);
            jsonArray.add(jsonObject);
            count++;
        }

        return jsonArray;
    }

    @SuppressWarnings("unchecked")
    public static JSONArray makeCommentArray(SinglyList<Comment> commentSinglyList, JSONArray jsonArray){
        int count = 0;
        while(count < commentSinglyList.getLength()){
            JSONObject newJSONObject = new JSONObject();
            newJSONObject.put("author", commentSinglyList.get(count).getData().getAuthor());
            newJSONObject.put("comment", commentSinglyList.get(count).getData().getComment());
            jsonArray.add(newJSONObject);
            count++;
        }
        return jsonArray;

    }

    @SuppressWarnings("unchecked")
    public static JSONArray makeStringArray(SinglyList<String> stringSinglyList, JSONArray jsonArray){
        int count=0;

        while(count<stringSinglyList.getLength()){
            jsonArray.add(stringSinglyList.get(count).getData());
            count++;
        }

        return jsonArray;
    }

    @SuppressWarnings("unchecked")
    public static JSONObject userToJSON(AlphNodeTree<User> user){
        JSONObject jsonObject = new JSONObject();

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

        try{jsonObject.put("recipe",TypeConversion.makeStringArray(user.getData().getRecipe(),new JSONArray()));}
        catch (NullPointerException e){jsonObject.put("recipe",null);}

        try{jsonObject.put("followers",TypeConversion.makeStringArray(user.getData().getFollowers(), new JSONArray()));}
        catch (NullPointerException e){jsonObject.put("followers",null);}

        try{jsonObject.put("following",TypeConversion.makeStringArray(user.getData().getFollowing(), new JSONArray()));}
        catch (NullPointerException e){jsonObject.put("following",null);}

        try{jsonObject.put("hasCompany",user.getData().isHasCompany());}
        catch (NullPointerException e){jsonObject.put("hasCompany",false);}

        return jsonObject;
    }
}
