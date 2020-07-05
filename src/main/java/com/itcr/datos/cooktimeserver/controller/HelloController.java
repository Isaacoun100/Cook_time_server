package com.itcr.datos.cooktimeserver.controller;

import com.itcr.datos.cooktimeserver.data_structures.SinglyList;
import org.springframework.web.bind.annotation.*;
import com.itcr.datos.cooktimeserver.data.UserRepository;
import com.itcr.datos.cooktimeserver.object.User;

@RestController
public class HelloController {

    public User getUserById(int userID) {
        return UserRepository.getUserList().get(userID).getData();
    }
    @GetMapping("/user")
    public SinglyList<User> getString(){
        UserRepository.updateUserList();
        return UserRepository.getUserList();
    }
    @GetMapping("/user/{id}")
    public User userID( @PathVariable int id ) {
        try{
            return getUserById(id);
        }
        catch(NullPointerException e){
            return new User();
        }
    }
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
