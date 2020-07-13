package com.itcr.datos.cooktimeserver.host;

import com.itcr.datos.cooktimeserver.data_structures.AlphBinaryTree;
import com.itcr.datos.cooktimeserver.restfull.UserTree;
import com.itcr.datos.cooktimeserver.object.User;
import org.springframework.web.bind.annotation.*;
/**
 * This class manages all of the paths for the client to access from the local host http://localhost:6969/
 */
@RestController
public class WebHost {
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
}
