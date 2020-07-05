package com.itcr.datos.cooktimeserver.controller;

import com.itcr.datos.cooktimeserver.data_structures.SinglyList;
import org.springframework.web.bind.annotation.*;
import com.itcr.datos.cooktimeserver.data.UserRepository;
import com.itcr.datos.cooktimeserver.object.User;

@RestController

/**
 * This class manages all of the paths for the client to access from the local host http://localhost:6969/
 */
public class HelloController {

    /**
     * This method will manage accessing to an specific user in the list by the index
     * @param userID
     * @return the user that matches the given id
     */
    public User getUserById(int userID) {
        return UserRepository.getUserList().get(userID).getData();
    }

    /**
     * This method will be executed with the link http://localhost:6969/user and will return a list of the users
     * @return a list of users in json format
     */
    @GetMapping("/user")
    public SinglyList<User> getString(){
        UserRepository.updateUserList();
        return UserRepository.getUserList();
    }

    /**
     * This method recieves an id from the clients and retrieves the user that corresponds to that ID
     * @param id
     * @return the user that was requested by the client
     */
    @GetMapping("/user/{id}")
    public User userID( @PathVariable int id ) {
        try{
            return getUserById(id);
        }
        catch(NullPointerException e){
            return new User();
        }
    }

    /**
     * This method is a post method that receives a user in json format and converts it into a User type
     * @param newUser
     * @return the user that was just created
     */
    @PostMapping("newUser")
    public User addUser( @RequestBody User newUser){
        if(newUser!=null){
            System.out.println(newUser.toString());
            UserRepository.addUser(newUser);
            return newUser;
        }
        else{
            return new User();
        }
    }

}
