package com.itcr.datos.cooktimeserver.host;

import com.itcr.datos.cooktimeserver.data_structures.AlphNodeAVL;
import com.itcr.datos.cooktimeserver.data_structures.AlphNodeTree;
import com.itcr.datos.cooktimeserver.data_structures.SinglyList;
import com.itcr.datos.cooktimeserver.object.*;
import com.itcr.datos.cooktimeserver.restfull.*;
import org.json.simple.JSONArray;
import org.springframework.web.bind.annotation.*;
import org.json.simple.JSONObject;

/**
 * This class manages all of the paths for the client to access from the local host http://localhost:6969/
 */
@RestController
public class WebHost {

    /**
     * This method will act as a login page to have a better control of the methods we have and the method we don't, to
     * avoid confusions and reference
     * @return The login String
     */
    @GetMapping("/")
    public String login(){

        String Welcome= "Welcome to the Cook Time server "
                + System.lineSeparator() +
                "You can"
                + System.lineSeparator() +
                "Access the users in the following link http://localhost:6969/user "
                + System.lineSeparator() +
                "Add new users using the link http://localhost:6969/newUser using a POST request "
                + System.lineSeparator() +
                "Access a specific user by typing the link http://localhost:6969/email/getUser/[USER EMAIL]"
                + System.lineSeparator() +
                "Change a value from a specific user with http://localhost:6969/setUser/[USER EMAIL]/[[KEY TO MODIFY]]"
                + System.lineSeparator() +
                "Verify the user is in the server http://localhost:6969/login/[USER EMAIL]/[[PASSWORD]]"
                + System.lineSeparator() +
                "Add a recipe to a user with http://localhost:6969/newRecipe using a post method"
                + System.lineSeparator() +
                "Get an specific recipe with http://localhost:6969/getRecipe/title/[RECIPE TITLE] using the title"
                + System.lineSeparator() +
                "Or access to all of the recipes of a user http://localhost:6969/getRecipe/user/[USER NAME] using the user name, this returns a list"
                + System.lineSeparator() +
                "Add a new company with the link http://localhost:6969/newCompany using a post method"
                + System.lineSeparator() +
                "Add a follower to a user and assing the following http://localhost:6969/user/[FOLLOWED_EMAIL]/addFollower/[FOLLOWING_EMAIL]"
                + System.lineSeparator() +
                "the first parameter FOLLOWED is the user that FOLLOWING is following, this will set the list for both FOLLOWED and FOLLOWING"
                + System.lineSeparator() +
                "Access the the dates sorted in the following link http://localhost:6969/sorting/getDates"
                + System.lineSeparator() +
                "Access the the dates sorted in the following link http://localhost:6969/sorting/getRatings"
                + System.lineSeparator() +
                "Access the the dates sorted in the following link http://localhost:6969/sorting/getDifficulties"
                + System.lineSeparator() +


                "Read more about HTTP Methods here: https://restfulapi.net/http-methods/ ";

        System.out.println(Welcome);
        return Welcome;
    }

    /**
     * This method will be executed with the link http://localhost:6969/user and will return a list of the users
     * @return a list of users in json format
     */
    @GetMapping("/user")
    public String getTree(){
        UserTree.updateUserList();
        return UserTree.getUserTree().toString();
    }

    /**
     * This method is a post method that receives a user in json format and converts it into a User type
     * @param newUser
     * @return the user that was just created
     */
    @PostMapping("/newUser")
    public User addUser(@RequestBody User newUser){
        if(newUser!=null){
            System.out.println(newUser);
            UserTree.addUser(newUser);
            return newUser;
        }
        else{
            return new User();
        }
    }

    /**
     * This will
     * @param userKey
     * @return
     */
    @GetMapping("/getUser/{userKey}")
    public String getUser(@PathVariable String userKey){
        JSONObject jsonObject = TypeConversion.userToJSON(TreeManagement.BinarySearch(userKey));
        return jsonObject.toString();
    }

    @GetMapping("/login/{userKey}/{password}")
    public JSONObject LoginMethod(@PathVariable String userKey, @PathVariable String password){
        JSONObject jsonObject;
        if(TreeManagement.BinarySearch(userKey)!=null){
            jsonObject = TypeConversion.userToJSON(TreeManagement.BinarySearch(userKey));
        }
        else{ return TypeConversion.userToJSON(new AlphNodeTree<User>(null,null)); }
        if(jsonObject.get("password").equals(password)){ return jsonObject; }
        else{ return TypeConversion.userToJSON(new AlphNodeTree<User>(null,null)); }
    }

    /**
     * This method will modify an specific value of a given user.
     * @param userKey the user email
     * @param userData the data type to be modified
     * @param request The response from the client
     * @return
     */
    @PostMapping("/setUser/{userKey}/{userData}")
    public String setUser(@PathVariable String userKey, @PathVariable String userData, @RequestBody String request){
        AlphNodeTree<User> user = TreeManagement.BinarySearch(userKey);
        if(user==null){
            return "user not found";
        }
        else{
            switch(userData){
                case "name":
                    user.getData().setName(request);
                    return user.getData().getName();
                case "email":
                    user.getData().setEmail(request);
                    return user.getData().getEmail();
                case "image":
                    user.getData().setImage(request);
                    return user.getData().getImage();
                case "password":
                    user.getData().setPassword(request);
                    return user.getData().getPassword();
                case "hasCompany":
                    if(request.equals("true")){ user.getData().setHasCompany(true); }
                    else if(request.equals("false")){ user.getData().setHasCompany(false); }
                    else{ return "bad request, please check the info"; }
                    return String.valueOf(user.getData().isHasCompany());
                case "age":
                    try{
                        user.getData().setAge(Integer.parseInt(request));
                    }
                    catch (NumberFormatException e){
                        e.printStackTrace();
                    }
                    return String.valueOf(user.getData().getAge());
                default:
                    return "This request can't be processed";
            }
        }

    }
    @GetMapping("/recipe")
    public String getRecipeTree(){
        RecipeTree.updateRecipeList();
        return RecipeTree.getAvlRecipeTree().toString();
    }

    @PostMapping("/newChef")
    public static Chef addChef(@RequestBody Chef newChef){
        if(newChef!=null){
            System.out.println(newChef);
            User newUser = new User();
            newUser.setHasCompany(newChef.isHasCompany());
            newUser.setFollowers(newChef.getFollowers());
            newUser.setFollowing(newChef.getFollowing());
            newUser.setPassword(newChef.getPassword());
            newUser.setRecipe(newChef.getRecipe());
            newUser.setEmail(newChef.getEmail());
            newUser.setImage(newChef.getImage());
            newUser.setName(newChef.getName());
            newUser.setAge(newChef.getAge());
            UserTree.addUser(newUser);
            ChefTree.addChef(newChef);
            return newChef;
        }
        else{
            return new Chef();
        }
    }

    @GetMapping("/user/{email}/addFollower/{incoming}")
    public static String addValue(@PathVariable String email , @PathVariable String incoming){
        User follower, followed = follower = null;
        try{
            followed = TreeManagement.BinarySearch(email).getData();
            follower = TreeManagement.BinarySearch(incoming).getData();
        }
        catch (NullPointerException e){
            e.printStackTrace();
            return "Something went wrong, please check the data";
        }
        followed.addFollower(follower.getEmail());
        follower.addFollowing(followed.getEmail());
        UserTree.saveUser();
        return incoming +"  now follows  "+ email;
    }

    @PostMapping("/newRecipe")
    public JSONObject addRecipe(@RequestBody JSONObject newRecipe){
        try{
            Recipe incomingRecipe = TypeConversion.makeRecipe(newRecipe);
            User user = TreeManagement.BinarySearch(incomingRecipe.getAuthor()).getData();
            if (newRecipe != null){
                user.addRecipe(incomingRecipe.getTitle());
                UserTree.saveUser();
                RecipeTree.addRecipe(incomingRecipe);
                return RecipeTree.recipeToJSONObject(incomingRecipe);
            }
            else{
                return RecipeTree.recipeToJSONObject(new Recipe());
            }
        }
        catch (NullPointerException e){
            e.printStackTrace();
            return RecipeTree.recipeToJSONObject(new Recipe());
        }
    }

    /**
     * This method is a post method that receives a company in json format and converts it into a User type
     * @param newCompany
     * @return the company object
     */
    @PostMapping("/newCompany")
    public Company addCompany(@RequestBody JSONObject newCompany){
        try{
            Company incomingCompany = TypeConversion.makeCompany(newCompany);
            if (newCompany != null){
                CompanyTree.addCompany(incomingCompany);
                return incomingCompany;
            }
            else{
                return new Company();
            }
        }
        catch (NullPointerException e){
            e.printStackTrace();
            return new Company();
        }
    }

    @GetMapping("/getRecipe/title/{recipe}")
    public static Recipe getRecipe(@PathVariable String recipe){
        return RecipeTree.getAvlRecipeTree().getRoot().getData();
    }

    @GetMapping("/getRecipe/user/{email}")
    public static SinglyList<Recipe> getRecipeID(@PathVariable String email){
        SinglyList<Recipe> recipeSinglyList = new SinglyList<Recipe>();
        User user = new User();

        try{
            user = TreeManagement.BinarySearch(email).getData();
        }
        catch (NullPointerException e){ e.printStackTrace();}

        int count, size = count = 0;

        try{
            size = user.getRecipe().getLength();
        }
        catch (NullPointerException e){ e.printStackTrace();}

        while(count<size){
            Recipe recipe = new Recipe();
            try{ recipe = TreeManagement.BinarySearchAvl(user.getRecipe().get(count).getData()).getData(); }
            catch (NullPointerException e){ e.printStackTrace();}

            recipeSinglyList.add(recipe);
            count++;
        }
       return recipeSinglyList;
    }

    /**
     * Function that gets the dates sorted
     * @return returns the singly list with the dates sorted
     */
    @GetMapping("/sorting/getDates")
    public static SinglyList<DateSort> getDateSort(){
        return SortingMethods.DateSort();
    }

    /**
     * Function that gets the ratings sorted
     * @return returns the singly list with the ratings sorted
     */
    @GetMapping("/sorting/getRatings")
    public static SinglyList<RatingSort> getRatingSort(){
        return SortingMethods.RatingSort();
    }

    /**
     * Function that gets the difficulties sorted
     * @return returns the singly list with the difficulties sorted
     */
    @GetMapping("/sorting/getDifficulties")
    public static SinglyList<DifficultySort> getDifficultySort(){
        return SortingMethods.DifficultySort();
    }


}
