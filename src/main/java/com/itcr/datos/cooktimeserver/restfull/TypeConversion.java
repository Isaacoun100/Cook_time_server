package com.itcr.datos.cooktimeserver.restfull;

import com.itcr.datos.cooktimeserver.data_structures.AlphNodeSplay;
import com.itcr.datos.cooktimeserver.data_structures.AlphNodeTree;
import com.itcr.datos.cooktimeserver.data_structures.SinglyList;
import com.itcr.datos.cooktimeserver.object.*;
import org.apache.commons.lang3.RandomStringUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

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

    public static Recipe makeRecipe(JSONObject jsonObject) {
        Recipe recipe = new Recipe();
        Random random = new Random();
        try{ recipe.setTitle(jsonObject.get("title").toString());}
        catch (NullPointerException e){ recipe.setTitle(null);}

        try{ recipe.setDescription(jsonObject.get("description").toString());}
        catch (NullPointerException e){ recipe.setDescription(null); }

        try{ recipe.setAuthor(jsonObject.get("author").toString()); }
        catch (NullPointerException e) { recipe.setAuthor(RandomStringUtils.randomAlphabetic(random.nextInt(20))); }

        try{ recipe.setType(jsonObject.get("type").toString()); }
        catch (NullPointerException e) { recipe.setType(null); }

        try{ recipe.setDuration(jsonObject.get("duration").toString());}
        catch (NullPointerException e){ recipe.setDuration(null); }

        try{ recipe.setDate(jsonObject.get("date").toString());}
        catch (NullPointerException e){
            String randDate = String.valueOf(random.nextInt(28))
                    .concat("/").concat(String.valueOf(random.nextInt(12))).
                            concat("/").concat(String.valueOf(random.nextInt(2020)));
            recipe.setDate(randDate);
        }

        try{ recipe.setDiet(jsonObject.get("diet").toString());}
        catch (NullPointerException e){ recipe.setDiet(null); }

        try{ recipe.setSteps(jsonObject.get("steps").toString());}
        catch (NullPointerException e){ recipe.setSteps(null); }

        try{ recipe.setImage(jsonObject.get("image").toString());}
        catch (NullPointerException e){ recipe.setImage(null); }

        try{ recipe.setTime(jsonObject.get("time").toString()); }
        catch (NullPointerException e){ recipe.setTime(null); }

        try{ recipe.setPrice(Integer.parseInt(jsonObject.get("price").toString())); }
        catch (NullPointerException e){ recipe.setPrice(0); }

        try{ recipe.setServings(Integer.parseInt(jsonObject.get("servings").toString())); }
        catch (NullPointerException e){ recipe.setServings(1); }

        try{ recipe.setRating(Float.parseFloat(jsonObject.get("rating").toString())); }
        catch (NullPointerException e){ recipe.setRating(0);}

        try{ recipe.setDifficulty(Integer.parseInt(jsonObject.get("difficulty").toString())); }
        catch (NullPointerException e){ recipe.setDifficulty(0); }

        try{ recipe.setComments(jsonObject.get("comments").toString());}
        catch (NullPointerException e){ recipe.setComments(null);}

        try{recipe.setTotalRating(Integer.parseInt(jsonObject.get("totalRating").toString()));}
        catch (NullPointerException e){ recipe.setTotalRating(0); }

        try{recipe.setNumRating(Integer.parseInt(jsonObject.get("numRating").toString()));}
        catch (NullPointerException e){ recipe.setNumRating(0); }

        return recipe;
    }

    public static ArrayList<Object> objectArray(Object object){
        return (ArrayList<Object>) object;
    }

    public static JSONArray objectToJSONArray(Object object){
        JSONArray jsonArray = new JSONArray();
        ArrayList<Object> arrayList = objectArray(object);
        int count, size = count = 0;

        try{ size=arrayList.size(); }
        catch (NullPointerException e){ e.printStackTrace(); }

        while (count<size){
            jsonArray.add(arrayList.get(count));
            count++;
        }
        return jsonArray;
    }

    private static SinglyList<Comment> toCommentList(ArrayList<Object> arrayList){
        SinglyList<Comment> commentSinglyList = new SinglyList<Comment>();
        int size, count=size=0;

        try{size=arrayList.size();}
        catch (NullPointerException e){ e.printStackTrace();}

        while(count<size){
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = null;
            try {
                jsonObject = (JSONObject) jsonParser.parse(JSONObject.toJSONString((Map) arrayList.get(count)));
                commentSinglyList.add(new Comment(jsonObject.get("author").toString(), jsonObject.get("comment").toString()));
            }
            catch (ParseException | NullPointerException e) {
                e.printStackTrace();
                count=size;
            }
            count++;
        }
        return  commentSinglyList;
    }

    public static Company makeCompany(JSONObject jsonObject){
        Company newCompany = new Company();

        try{newCompany.setName(jsonObject.get("name").toString());}
        catch (NullPointerException e){newCompany.setName(null);}

        try{newCompany.setEmail(jsonObject.get("email").toString());}
        catch (NullPointerException e){newCompany.setEmail(null);}

        try{newCompany.setSchedule(jsonObject.get("schedule").toString());}
        catch (NullPointerException e){newCompany.setSchedule(null);}

        try{newCompany.setLogo(jsonObject.get("logo").toString());}
        catch (NullPointerException e){newCompany.setLogo(null);}

        try{newCompany.setLocation(jsonObject.get("location").toString());}
        catch (NullPointerException e){ newCompany.setLocation(null);}

        try{newCompany.setNumber(Integer.parseInt(jsonObject.get("number").toString()));}
        catch (NullPointerException e){newCompany.setNumber(0);}

        try{newCompany.setPosts(Integer.parseInt(jsonObject.get("posts").toString()));}
        catch (NullPointerException e){newCompany.setPosts(0);}

        try{newCompany.setFollowers(TypeConversion.makeStringList(objectToJSONArray(jsonObject.get("followers")), new SinglyList<String>()));}
        catch (NullPointerException e){newCompany.setFollowers(new SinglyList<String>());}

        try{newCompany.setFollowing(TypeConversion.makeStringList(objectToJSONArray(jsonObject.get("following")), new SinglyList<String>()));}
        catch (NullPointerException e){newCompany.setFollowing(new SinglyList<String>());}

        try{newCompany.setMembers(TypeConversion.makeStringList(objectToJSONArray(jsonObject.get("members")), new SinglyList<String>()));}
        catch (NullPointerException e){newCompany.setFollowing(new SinglyList<String>());}

        try{newCompany.setRecipe(TypeConversion.makeStringList(objectToJSONArray(jsonObject.get("recipe")), new SinglyList<String>()));}
        catch (NullPointerException e){newCompany.setFollowing(new SinglyList<String>());}

        return newCompany;
    }

    public static SinglyList<String> makeStringList(JSONArray jsonArray, SinglyList<String> singlyList){
        int count,size=count=0;

        try{size=jsonArray.size();}
        catch (NullPointerException e){size=0;}

        while(count<size){

            singlyList.add((String) jsonArray.get(count));
            count++;
        }
        return singlyList;
    }


    @SuppressWarnings("unchecked")
    public static JSONArray makeCommentArray(SinglyList<Comment> commentSinglyList, JSONArray jsonArray){
        int count, size  = count = 0;
        try{size=commentSinglyList.getLength();}
        catch (NullPointerException e){ e.printStackTrace();}
        while(count < size){
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
        Random random= new Random();

        try{jsonObject.put("name",user.getData().getName());}
        catch (NullPointerException e){ jsonObject.put("name",null);}

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

        try{jsonObject.put("company",user.getData().getCompany());}
        catch (NullPointerException e){ jsonObject.put("company", null);}
        return jsonObject;
    }
    @SuppressWarnings("unchecked")
    public static JSONObject chefToJSON(AlphNodeTree<Chef> chef){
        JSONObject jsonObject = new JSONObject();

        try{jsonObject.put("name",chef.getData().getName());}
        catch (NullPointerException e){jsonObject.put("name",null);}

        try{ jsonObject.put("password",chef.getData().getPassword());}
        catch (NullPointerException e){jsonObject.put("password",null);}

        try{jsonObject.put("email",chef.getData().getEmail());}
        catch (NullPointerException e){jsonObject.put("email",null);}

        try{jsonObject.put("age",chef.getData().getAge());}
        catch (NullPointerException e){jsonObject.put("age",0);}

        try{jsonObject.put("image",chef.getData().getImage());}
        catch (NullPointerException e){jsonObject.put("image",null);}

        try{jsonObject.put("recipe",TypeConversion.makeStringArray(chef.getData().getRecipe(),new JSONArray()));}
        catch (NullPointerException e){jsonObject.put("recipe",null);}

        try{jsonObject.put("followers",TypeConversion.makeStringArray(chef.getData().getFollowers(), new JSONArray()));}
        catch (NullPointerException e){jsonObject.put("followers",null);}

        try{jsonObject.put("following",TypeConversion.makeStringArray(chef.getData().getFollowing(), new JSONArray()));}
        catch (NullPointerException e){jsonObject.put("following",null);}

        try{jsonObject.put("hasCompany",chef.getData().isHasCompany());}
        catch (NullPointerException e){jsonObject.put("hasCompany",false);}

        try{jsonObject.put("verify",chef.getData().isVerify());}
        catch (NullPointerException e){jsonObject.put("hasCompany",false);}

        return jsonObject;
    }
    @SuppressWarnings("unchecked")
    public static JSONObject companyToJSON(AlphNodeSplay<Company> company){
        JSONObject jsonObject = new JSONObject();

        try{jsonObject.put("name",company.getData().getName());}
        catch (NullPointerException e){jsonObject.put("name",null);}

        try{jsonObject.put("email",company.getData().getEmail());}
        catch (NullPointerException e){jsonObject.put("email",null);}

        try{ jsonObject.put("schedule",company.getData().getSchedule());}
        catch (NullPointerException e){jsonObject.put("schedule",null);}

        try{jsonObject.put("logo",company.getData().getLogo());}
        catch (NullPointerException e){jsonObject.put("logo",0);}

        try{jsonObject.put("location",company.getData().getLocation());}
        catch (NullPointerException e){jsonObject.put("location",null);}

        try{jsonObject.put("number",company.getData().getNumber());}
        catch (NullPointerException e){jsonObject.put("number",null);}

        try{jsonObject.put("posts",company.getData().getPosts());}
        catch (NullPointerException e){jsonObject.put("posts",null);}


        try{jsonObject.put("followers",TypeConversion.makeStringArray(company.getData().getFollowers(), new JSONArray()));}
        catch (NullPointerException e){jsonObject.put("followers",null);}

        try{jsonObject.put("following",TypeConversion.makeStringArray(company.getData().getFollowing(), new JSONArray()));}
        catch (NullPointerException e){jsonObject.put("following",null);}

        try{jsonObject.put("members",TypeConversion.makeStringArray(company.getData().getMembers(), new JSONArray()));}
        catch (NullPointerException e){jsonObject.put("following",null);}

        try{jsonObject.put("recipe",TypeConversion.makeStringArray(company.getData().getRecipe(),new JSONArray()));}
        catch (NullPointerException e){jsonObject.put("recipe",null);}
        return jsonObject;
    }




}
