package com.itcr.datos.cooktimeserver;

import com.itcr.datos.cooktimeserver.data_structures.SinglyList;
import com.itcr.datos.cooktimeserver.object.Comment;
import com.itcr.datos.cooktimeserver.object.Recipe;
import com.itcr.datos.cooktimeserver.object.User;
import com.itcr.datos.cooktimeserver.restfull.RecipeTree;
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

        //UserTree.initUserList();
        RecipeTree.initRecipeList();
        /*
        Recipe recipe = new Recipe();

        recipe.setTitle("Gallo pinto");
        recipe.setDescription("Ez");
        recipe.setAuthor("naheemjohnson@email");
        recipe.setType("Breakfast");
        recipe.setDuration("3 min");
        recipe.setTime("brunch");
        recipe.setDiet("Vegan");
        recipe.setSteps("Pour the rice and then the beans");
        recipe.setImage("https://i.picsum.photos/id/233/200/300.jpg?hmac=aVpewfxURvNso_n34jznb-DOcy5vizCqhqwd-YIcKAM");
        recipe.setDate("12/12/12");
        recipe.setPrice(2000);
        recipe.setServings(3);
        recipe.setRating(4);
        recipe.setDifficulty(40);
        SinglyList<Comment> commentSinglyList = new SinglyList<Comment>();
        Comment comment1 = new Comment("sebas@gmai.com","promete");
        commentSinglyList.add(comment1);
        Comment comment2 = new Comment("johnson@hotmail","Ak7 rasta");
        commentSinglyList.add(comment2);
        recipe.setComments(commentSinglyList);
        RecipeTree.addRecipe(recipe);

         */





//        User newUser = new User();
//
//        newUser.setName("Juan");
//        newUser.setImage("https://i.picsum.photos/id/233/200/300.jpg?hmac=aVpewfxURvNso_n34jznb-DOcy5vizCqhqwd-YIcKAM");
//        newUser.setEmail("juan@email");
//
//        newUser.setAge(21);
//
//        newUser.setPassword("sdf54sd");
//
//        SinglyList<Recipe> recipeSinglyList = new SinglyList<Recipe>();
//        Recipe recipe = new Recipe();
//
//        recipe.setTitle("Pasta");
//        recipe.setDescription("IZI");
//        recipe.setAuthor("juan@email");
//        recipe.setType("lunch");
//        recipe.setDuration("1-3 h");
//        recipe.setTime("brunch");
//        recipe.setDiet("Vegan");
//        recipe.setSteps("first you.... then you");
//        recipe.setImage("https://i.picsum.photos/id/233/200/300.jpg?hmac=aVpewfxURvNso_n34jznb-DOcy5vizCqhqwd-YIcKAM");
//        recipe.setDate("12/12/12");
//        recipe.setPrice(1500);
//        recipe.setServings(2);
//        recipe.setRating(5);
//        recipe.setDifficulty(50);
//
//        SinglyList<Comment> commentSinglyList = new SinglyList<Comment>();
//        Comment comment = new Comment("juanra@gmai.com","Muy rico");
//        commentSinglyList.add(comment);
//        comment = new Comment("isaac@hotmail","Espléndido");
//        commentSinglyList.add(comment);
//        recipe.setComments(commentSinglyList);
//        recipeSinglyList.add(recipe);
//
//
//        newUser.setRecipe(recipeSinglyList);
//
//        newUser.setHasCompany(false);
//
//        SinglyList<String> stringSinglyList = new SinglyList<String>();
//        stringSinglyList.add("parkunhg@hotmail.com");
//
//        newUser.setFollowers(stringSinglyList);
//        newUser.setFollowing(stringSinglyList);
//
//        UserTree.addUser(newUser);
        SpringApplication.run(CookTimeServerApplication.class, args);
    }

}
