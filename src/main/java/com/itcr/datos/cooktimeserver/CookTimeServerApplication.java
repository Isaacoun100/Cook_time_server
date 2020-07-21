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

        Calendar calendar1 = Calendar.getInstance();
        calendar1.set(2000, Calendar.DECEMBER,12);

        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(2020, Calendar.AUGUST,21);

        if(calendar1.compareTo(calendar2)>0){
            System.out.println("calendar1 es menor que calendar2");
        }
        else if(calendar2.compareTo(calendar1)>0){
            System.out.println("calendar2 es menor que calendar1");
        }
        else {
            System.out.println("Equals");
        }

        SpringApplication.run(CookTimeServerApplication.class, args);

    }

}
