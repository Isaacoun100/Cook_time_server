package com.itcr.datos.cooktimeserver;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.itcr.datos.cooktimeserver.restfull.UserListAdmin;
import org.springframework.boot.SpringApplication;

/**
 * CookTimeServerApplication is the main class, here will be executed only the neccesary for the code to run
 */
@SpringBootApplication
public class CookTimeServerApplication {

    /**
     * This is the main method that will run the server and initialize the list of users.
     * @param args
     */
    public static void main(String[] args) {
        UserListAdmin.initUserList();
        SpringApplication.run(CookTimeServerApplication.class, args);
    }

}
