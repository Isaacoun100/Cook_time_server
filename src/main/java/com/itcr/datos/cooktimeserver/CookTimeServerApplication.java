package com.itcr.datos.cooktimeserver;

import com.itcr.datos.cooktimeserver.restfull.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;

import java.util.Calendar;
import java.util.Date;


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
        ChefTree.initChefList();
        RecipeTree.initRecipeList();
        CompanyTree.initCompanyList();

        SpringApplication.run(CookTimeServerApplication.class, args);

    }

}
