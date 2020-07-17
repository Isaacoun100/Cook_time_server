package com.itcr.datos.cooktimeserver;

import com.itcr.datos.cooktimeserver.object.User;
import com.itcr.datos.cooktimeserver.restfull.RecipeTree;
import com.itcr.datos.cooktimeserver.restfull.TreeManagement;
import com.itcr.datos.cooktimeserver.restfull.TypeConversion;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.itcr.datos.cooktimeserver.restfull.UserTree;
import org.springframework.boot.SpringApplication;


/**
 * CookTimeServerApplication is the main class, here will be executed only the necessary for the code to run
 */
@SpringBootApplication
public class CookTimeServerApplication {

    /**
     * This is the main method that will run the server and initialize the list of users.
     * @param args
     */
    public static void main(String[] args) {

        UserTree.initUserList();
        RecipeTree.initRecipeList();
        SpringApplication.run(CookTimeServerApplication.class, args);
    }

}
