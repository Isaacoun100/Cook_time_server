package com.itcr.datos.cooktimeserver.host;

import com.itcr.datos.cooktimeserver.object.Recipe;
import com.itcr.datos.cooktimeserver.restfull.RecipeTree;
import com.itcr.datos.cooktimeserver.data_structures.AlphNodeTree;
import com.itcr.datos.cooktimeserver.restfull.TreeManagement;
import com.itcr.datos.cooktimeserver.restfull.TypeConversion;
import com.itcr.datos.cooktimeserver.restfull.UserTree;
import com.itcr.datos.cooktimeserver.object.User;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.*;
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
                "Add new users using the link http://localhost:6969/newUser/ using a POST request "
                + System.lineSeparator() +
                "Access a specific user by typing the link http://localhost:6969/email/getUser/[USER EMAIL]"
                + System.lineSeparator() +
                "Change a value from a specific user with http://localhost:6969/setUser/[USER EMAIL]/[[KEY TO MODIFY]]"
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
    public User addUser( @RequestBody User newUser){
        if(newUser!=null){
            System.out.println(newUser.toString());
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

    @PostMapping("/newRecipe")
    public Recipe addRecipe(@RequestBody Recipe newRecipe){
        if (newRecipe != null){
            System.out.println(newRecipe.toString());
            RecipeTree.addRecipe(newRecipe);
            return newRecipe;
        }
        else{
            return new Recipe();
        }
    }
}
