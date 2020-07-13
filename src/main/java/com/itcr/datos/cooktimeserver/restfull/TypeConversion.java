package com.itcr.datos.cooktimeserver.restfull;

import com.itcr.datos.cooktimeserver.data_structures.SinglyList;
import com.itcr.datos.cooktimeserver.object.Comment;
import com.itcr.datos.cooktimeserver.object.Recipe;
import com.itcr.datos.cooktimeserver.object.User;
import org.json.simple.JSONObject;
import java.util.Calendar;

/**
 * This class will manage the conversion between types JSON and others
 */
public class TypeConversion {

    public static SinglyList<Recipe> toSinglyList(JSONObject recipeJSON, SinglyList<Recipe> recipeSinglyList){
        try{
            if(recipeJSON.get("next")!=null){
                recipeSinglyList=toSinglyList((JSONObject) recipeJSON.get("next"),recipeSinglyList);
            }
            if(recipeJSON.get("data")!=null){
                recipeSinglyList.add(makeRecipe((JSONObject) recipeJSON.get("data")));
            }
        }
        catch (NullPointerException e){
            e.printStackTrace();
        }
        return recipeSinglyList;
    }

    private static Recipe makeRecipe(JSONObject jsonObject){
        try {
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
            recipe.setDate((Calendar) jsonObject.get("date"));
            recipe.setPrice(Integer.parseInt(jsonObject.get("price").toString()));
            recipe.setServings(Integer.parseInt(jsonObject.get("servings").toString()));
            recipe.setRating(Integer.parseInt(jsonObject.get("rating").toString()));
            recipe.setDifficulty(Integer.parseInt(jsonObject.get("difficulty").toString()));
            recipe.setComments(makeCommentList((JSONObject) jsonObject.get("comments"), new SinglyList<Comment>()));
            return recipe;
        }
        catch (Exception e){
            e.printStackTrace();
            return new Recipe();
        }
    }

    private static SinglyList<Comment> makeCommentList(JSONObject jsonObject,SinglyList<Comment> result){
        if(jsonObject.get("next")!=null){
            result=makeCommentList((JSONObject) jsonObject.get("next"), result);
        }
        if(jsonObject.get("data")!=null){
            result.add(makeComment((JSONObject)jsonObject.get("data")));
        }
        return result;
    }

    private static Comment makeComment(JSONObject jsonObject){
        return new Comment(jsonObject.get("author").toString(), jsonObject.get("comment").toString());
    }

    public static SinglyList<String> makeStringList(JSONObject jsonObject, SinglyList<String> singlyList){
        if(jsonObject.get("next")!=null){
            singlyList= makeStringList((JSONObject)jsonObject.get("next"),singlyList);
        }
        if(jsonObject.get("data")!=null){
            singlyList.add(jsonObject.get("data").toString());
        }
        return singlyList;
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
                System.out.println("The name was not provided correctly please check");
                e.printStackTrace();
                System.out.println("For more information");
                newUser.setName("Not provided correctly");
            }

            try{
                int age = Integer.parseInt(newObject.get("age").toString());
                newUser.setAge(age);
            }
            catch (NullPointerException e){
                System.out.println("The name age not provided correctly please check");
                e.printStackTrace();
                System.out.println("For more information");
                newUser.setAge(0);
            }

            try{
                String email = newObject.get("email").toString();
                newUser.setEmail(email);
            }
            catch (NullPointerException e){
                System.out.println("The email was not provided correctly please check");
                e.printStackTrace();
                System.out.println("For more information");
                newUser.setEmail("Not provided correctly");
            }

            try{
                String password = newObject.get("password").toString();
                newUser.setPassword(password);
            }
            catch (NullPointerException e) {
                System.out.println("The password was not provided correctly please check");
                e.printStackTrace();
                System.out.println("For more information");
                newUser.setPassword("Not provided correctly");}
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

}
