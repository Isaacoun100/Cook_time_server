package com.itcr.datos.cooktimeserver.data;

import com.itcr.datos.cooktimeserver.data_structures.SinglyList;
import com.itcr.datos.cooktimeserver.object.User;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import java.io.IOException;
import java.io.FileReader;
import java.io.FileWriter;
public class UserRepository {
    private static SinglyList<User> UserList;

    public static void initUserList(){
        UserList = new SinglyList<User>();
        updateUserList();
    }
    public static void updateUserList() {
        JSONParser userparser = new JSONParser();
        UserList.clear();

        try {
            JSONArray jsonArray = (JSONArray) userparser.parse(new FileReader("res/data/Users.json"));
            int count = 0;

            while(count<=jsonArray.size()-1) {
                UserList.add(makeUser( (JSONObject) jsonArray.get(count)));
                count++;
            }

        }
        catch (Exception e) {e.printStackTrace();}
    }

    public static User makeUser(JSONObject newObject){

        User newUser = new User();

        if(!newObject.isEmpty()){

            try{
                String name = newObject.get("name").toString();
                newUser.setName(name);
            }
            catch (NullPointerException e){
                System.out.println("The name was not provided correcly please check");
                e.printStackTrace();
                System.out.println("For more information");
                newUser.setName("Not provided correcly");
            }

            try{
                int age = Integer.parseInt(newObject.get("age").toString());
                newUser.setAge(age);
            }
            catch (NullPointerException e){
                System.out.println("The name age not provided correcly please check");
                e.printStackTrace();
                System.out.println("For more information");
                newUser.setAge(0);
            }

            try{
                String email = newObject.get("email").toString();
                newUser.setEmail(email);
            }
            catch (NullPointerException e){
                System.out.println("The email was not provided correcly please check");
                e.printStackTrace();
                System.out.println("For more information");
                newUser.setEmail("Not provided correcly");
            }

            try{
                String password = newObject.get("password").toString();
                newUser.setPassword(password);
            }
            catch (NullPointerException e) {
                System.out.println("The password was not provided correcly please check");
                e.printStackTrace();
                System.out.println("For more information");
                newUser.setPassword("Not provided correcly");}
        }
        else{
            newUser.setName("Not provided");
            newUser.setEmail("Not provided");
            newUser.setPassword("Not provided");
            newUser.setAge(0);
        }

        return newUser;
    }

    @SuppressWarnings("unchecked")
    public static JSONObject makeObject(User newUser){

        JSONObject incomingUser = new JSONObject();

        incomingUser.put("name",newUser.getName());
        incomingUser.put("age",newUser.getAge());
        incomingUser.put("email",newUser.getEmail());
        incomingUser.put("password",newUser.getPassword());

        return incomingUser;

    }
    public static SinglyList<User> getUserList(){
        return UserList;
    }

    public static void addUser(User newUser){
        if(newUser!=null){
            UserList.add(newUser);
            saveUser();
            updateUserList();
        }
        else{
            System.out.println("Something went wrong while adding the user, the user was empty");
        }
    }

    @SuppressWarnings("unchecked")
    public static void saveUser(){

        int client = UserList.getLength();
        if(client!=0){
            client-=1;
            try(FileWriter file = new FileWriter("res/data/Users.json")){
                JSONArray users = new JSONArray();

                while(client>=0){

                    JSONObject memory = new JSONObject();

                    memory.put("name",UserList.get(client).getData().getName());
                    memory.put("password",UserList.get(client).getData().getPassword());
                    memory.put("email",UserList.get(client).getData().getEmail());
                    memory.put("age",UserList.get(client).getData().getAge());

                    users.add(memory);
                    client--;
                }

                file.write(users.toString());
                file.flush();

            }
            catch (IOException e) { e.printStackTrace();}
        }
    }
}
