package com.itcr.datos.cooktimeserver.host;

import com.itcr.datos.cooktimeserver.data_structures.SinglyList;
import org.springframework.web.bind.annotation.*;
import com.itcr.datos.cooktimeserver.restfull.UserListAdmin;
import com.itcr.datos.cooktimeserver.object.User;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

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
                        "Access an specific user in the following link http://localhost:6969/user/ + the user number"
                        + System.lineSeparator() +
                        "Add new users using the link http://localhost:6969/newUser/ using a POST request "
                        + System.lineSeparator() +
                        "Read more about HTTP Methods here: https://restfulapi.net/http-methods/ ";

        System.out.println(Welcome);
        return Welcome;
    }

    /**
     * This method will manage accessing to an specific user in the list by the index
     * @param userID
     * @return the user that matches the given id
     */
    public User getUserById(int userID) {
        return UserListAdmin.getUserList().get(userID).getData();
    }

    /**
     * This method will be executed with the link http://localhost:6969/user and will return a list of the users
     * @return a list of users in json format
     */
    @GetMapping("/user")
    public SinglyList<User> getString(){
        UserListAdmin.updateUserList();
        return UserListAdmin.getUserList();
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

    @PostMapping("/test/post")
    public String addUser( @RequestBody String message){
        System.out.println(message);

        try(FileWriter file = new FileWriter("res/data/test.json")){
            file.write(message);
            file.flush();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return message;
    }

    @GetMapping("/test/get")
    public StringBuilder addUser() throws IOException {
        FileReader fr =new FileReader("res/data/test.json");
        int i;
        StringBuilder message= new StringBuilder();
        while((i=fr.read())!=-1)
            message.append((char) i);
        fr.close();

        return message;
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
            UserListAdmin.addUser(newUser);
            return newUser;
        }
        else{
            return new User();
        }
    }

}
