package com.itcr.datos.cooktimeserver.host;

import com.itcr.datos.cooktimeserver.data_structures.AlphNodeTree;
import com.itcr.datos.cooktimeserver.data_structures.SinglyList;
import com.itcr.datos.cooktimeserver.object.*;
import com.itcr.datos.cooktimeserver.restfull.*;
import org.springframework.web.bind.annotation.*;
import org.json.simple.JSONObject;

/**
 * This class manages all of the paths for the client to access from the local host http://localhost:6969/
 */
@RestController
public class WebHost {

    /**
     * This method will act as a login page to have a better control of the methods we have and the method we don't, to
     * avoid confusions and reference
     * @return The login String
     */
    @GetMapping("/")
    public String login(){

        String Welcome= "Welcome to the Cook Time server "
                + System.lineSeparator() +System.lineSeparator() + System.lineSeparator() +System.lineSeparator() +


                "User management:"


                + System.lineSeparator() +System.lineSeparator() + System.lineSeparator() +System.lineSeparator() +
                "    *Access the users in the following link http://localhost:6969/user "
                + System.lineSeparator() +System.lineSeparator() +
                "    *Add new users using the link http://localhost:6969/newUser using a POST request "
                + System.lineSeparator() +System.lineSeparator() +
                "    *Access a specific user by typing the link http://localhost:6969/email/getUser/[USER EMAIL]"
                + System.lineSeparator() +System.lineSeparator() +
                "    *Change a value from a specific user with http://localhost:6969/setUser/[USER EMAIL]/[[KEY TO MODIFY]]"
                + System.lineSeparator() +System.lineSeparator() +
                "    *Verify the user is in the server http://localhost:6969/login/[USER EMAIL]/[[PASSWORD]]"
                + System.lineSeparator() +System.lineSeparator() +
                "    *Add a follower to a user and assing the following http://localhost:6969/user/[FOLLOWED_EMAIL]/addFollower/[FOLLOWING_EMAIL]"
                + System.lineSeparator() +System.lineSeparator() +
                "    *the first parameter FOLLOWED is the user that FOLLOWING is following, this will set the list for both FOLLOWED and FOLLOWING"
                + System.lineSeparator() +System.lineSeparator() +
                "    *Access the a linked list of all users using http://localhost:6969/getUser/userShuffledList"
                + System.lineSeparator() +System.lineSeparator() +
                "    *Set a users value using http://localhost:6969/setUser/[Email]/[Data] , in this last field you'll be able"
                +System.lineSeparator() +
                "    *Search for a user by typing http://localhost:6969/searchUser/[criteria]"
                +System.lineSeparator() +
                "    *Get the first 3 users of the shuffled user list by typing http://localhost:6969//getUser/userShuffledList"
                +System.lineSeparator() +
                "     to change a value from a specified user using name, email, image, password, hasCompany and age"
                + System.lineSeparator() +System.lineSeparator() + System.lineSeparator() +System.lineSeparator() +


                "Chef management:"


                + System.lineSeparator() +System.lineSeparator() + System.lineSeparator() +System.lineSeparator() +
                "    *You can access the chef tree using http://localhost:6969/chef"
                + System.lineSeparator() +System.lineSeparator() +
                "    *Search for a chef by typing http://localhost:6969/searchChef/[criteria]/"
                +System.lineSeparator() +
                "    *You can add a chef using http://localhost:6969/newChef"
                + System.lineSeparator() +System.lineSeparator() + System.lineSeparator() +System.lineSeparator() +


                "Recipe management:"


                + System.lineSeparator() +System.lineSeparator() + System.lineSeparator() +System.lineSeparator() +
                "You can access the recipe tree using http://localhost:6969/recipe"
                + System.lineSeparator() +System.lineSeparator() +
                "    *Add a recipe to a user with http://localhost:6969/newRecipe using a post method"
                + System.lineSeparator() +System.lineSeparator() +
                "    *Get an specific recipe with http://localhost:6969/getRecipe/title/[RECIPE TITLE] using the title"
                + System.lineSeparator() +System.lineSeparator() +
                "    *Or access to all of the recipes of a user http://localhost:6969/getRecipe/user/[USER NAME] using the user name, this returns a list"
                + System.lineSeparator() +System.lineSeparator() +
                "    *Add a recipe to the feed by using http://localhost:6969/addFeedRecipe/[Recipe_Title]/[User_email]"
                + System.lineSeparator() +System.lineSeparator() +
                "    *Get a recipe list by typing http://localhost:6969/getRecipeList"
                + System.lineSeparator() +System.lineSeparator() +
                "    *Add a comment to a recipe by using the link http://localhost:6969/addComment/[Recipe_Title]/[Email]"
                +System.lineSeparator() +
                "    *Search for a recipe by typing http://localhost:6969/searchRecipe and the JSON with the query form"
                +System.lineSeparator() +
                "     where the email corresponds to the user email, this is a post that will recieve the comment in plain text"
                + System.lineSeparator() +System.lineSeparator() + System.lineSeparator() +System.lineSeparator() +


                "Company management:"


                + System.lineSeparator() +System.lineSeparator() + System.lineSeparator() +System.lineSeparator() +
                "    *Add a new company with the link http://localhost:6969/newCompany/{user} using a post method"
                + System.lineSeparator() +System.lineSeparator() +
                "    *Add a new recipe to the company with the link http://localhost:6969/company/newRecipe using a post method"
                + System.lineSeparator() +System.lineSeparator() +
                "    *Search for a company by typing http://localhost:6969/searchCompany/[criteria]/"
                + System.lineSeparator() +System.lineSeparator() +
                "    *Access the company of an user by typing http://localhost:6969/getCompany/user/[User_email]"
                + System.lineSeparator() +System.lineSeparator() +
                "    *Get the first 3 companies of the shuffled company list by typing http://localhost:6969//getCompany/companyShuffledList"
                + System.lineSeparator() +System.lineSeparator() + System.lineSeparator() +System.lineSeparator() +


                "    *Data management"


                + System.lineSeparator() +System.lineSeparator() + System.lineSeparator() +System.lineSeparator() +
                "    *Access the the dates sorted in the following link http://localhost:6969/sorting/getDates"
                + System.lineSeparator() +System.lineSeparator() +
                "    *Access the the dates sorted in the following link http://localhost:6969/sorting/getRatings"
                + System.lineSeparator() +System.lineSeparator() +
                "    *Access the the dates sorted in the following link http://localhost:6969/sorting/getDifficulties"
                + System.lineSeparator() +System.lineSeparator() + System.lineSeparator() +System.lineSeparator() +
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

    @GetMapping("/getCompany/name/{ID}")
    public Company getCompany(@PathVariable String ID){
        try{ return TreeManagement.binarySearchSplay(ID).getData(); }
        catch (NullPointerException e){ return new Company();}
    }



    /**
     * This method is a post method that receives a user in json format and converts it into a User type
     * @param newUser
     * @return the user that was just created
     */
    @PostMapping("/newUser")
    public User addUser(@RequestBody User newUser){
        if(newUser!=null){
            System.out.println(newUser);
            UserTree.addUser(newUser);
            return newUser;
        }
        else{
            return new User();
        }
    }

    /**
     * This will
     * @param userKey
     * @return
     */
    @GetMapping("/getUser/{userKey}")
    public String getUser(@PathVariable String userKey){
        JSONObject jsonObject = TypeConversion.userToJSON(TreeManagement.binarySearch(userKey));
        return jsonObject.toString();
    }

    /**
     * Getter for the shuffled user singly list
     * @return returns the first 3 users of the shuffled singly list
     */
    @GetMapping("/getUser/userShuffledList")
    public static SinglyList<JSONObject> getShuffledUserList(){
        SinglyList<User> list = UserTree.getUserShuffledList();
        SinglyList<JSONObject> response = new SinglyList<JSONObject>();
        int count=0;
        while(count<list.getLength()){
            response.add(TypeConversion.userToJSON(new AlphNodeTree<User>
                    (list.get(count).getData(),list.get(count).getData().getEmail())));
            count++;
        }
        return response;
        
    }
    /**
     * Getter for the shuffled company singly list
     * @return returns the first 3 companies of the shuffled singly list
     */
    @GetMapping("/getCompany/companyShuffledList")
    public static SinglyList<JSONObject> getShuffledCompanyList(){
        SinglyList<Company> companyList = CompanyTree.getCompanyShuffledList();
        SinglyList<JSONObject> response = new SinglyList<JSONObject>();
        int count=0;
        while(count<companyList.getLength()){
            response.add(TypeConversion.companyToJSON(new AlphNodeSplay<Company>
                    (companyList.get(count).getData(),companyList.get(count).getData().getName())));
            count++;
        }
        return response;
    }

    @GetMapping("/login/{userKey}/{password}")
    public JSONObject LoginMethod(@PathVariable String userKey, @PathVariable String password){
        JSONObject jsonObject;
        if(TreeManagement.binarySearch(userKey)!=null){
            jsonObject = TypeConversion.userToJSON(TreeManagement.binarySearch(userKey));
        }
        else{ return TypeConversion.userToJSON(new AlphNodeTree<User>(null,null)); }
        if(jsonObject.get("password").equals(password)){ return jsonObject; }
        else{ return TypeConversion.userToJSON(new AlphNodeTree<User>(null,null)); }
    }

    /**
     * This method will modify an specific value of a given user.
     * @param userKey the user email
     * @param userData the data type to be modified
     * @param request The response from the client
     * @return
     */
    @PostMapping("/setUser/{userKey}/{userData}")
    public String setUser(@PathVariable String userKey, @PathVariable String userData, @RequestBody String request){
        AlphNodeTree<User> user = TreeManagement.binarySearch(userKey);
        if(user==null){
            return "user not found";
        }
        else{
            switch(userData){
                case "name":
                    user.getData().setName(request);
                    return user.getData().getName();
                case "email":
                    user.getData().setEmail(request);
                    return user.getData().getEmail();
                case "image":
                    user.getData().setImage(request);
                    return user.getData().getImage();
                case "password":
                    user.getData().setPassword(request);
                    return user.getData().getPassword();
                case "hasCompany":
                    if(request.equals("true")){ user.getData().setHasCompany(true); }
                    else if(request.equals("false")){ user.getData().setHasCompany(false); }
                    else{ return "bad request, please check the info"; }
                    return String.valueOf(user.getData().isHasCompany());
                case "age":
                    try{
                        user.getData().setAge(Integer.parseInt(request));
                    }
                    catch (NumberFormatException e){
                        e.printStackTrace();
                    }
                    return String.valueOf(user.getData().getAge());
                default:
                    return "This request can't be processed";
            }
        }

    }

    @GetMapping("/recipe")
    public String getRecipeTree(){
        RecipeTree.updateRecipeList();
        return RecipeTree.getAvlRecipeTree().toString();
    }

    @PostMapping("/newChef")
    public static Chef addChef(@RequestBody Chef newChef){
        if(newChef!=null){
            System.out.println(newChef);
            User newUser = new User();
            newUser.setHasCompany(newChef.isHasCompany());
            newUser.setFollowers(newChef.getFollowers());
            newUser.setFollowing(newChef.getFollowing());
            newUser.setPassword(newChef.getPassword());
            newUser.setRecipe(newChef.getRecipe());
            newUser.setEmail(newChef.getEmail());
            newUser.setImage(newChef.getImage());
            newUser.setName(newChef.getName());
            newUser.setAge(newChef.getAge());
            UserTree.addUser(newUser);
            ChefTree.addChef(newChef);
            return newChef;
        }
        else{
            return new Chef();
        }
    }

    @GetMapping("/addFeedRecipe/{Recipe}/{User}")
    public static String addFeedRecipe(@PathVariable String User, @PathVariable String recipe){
        try{
            User user = TreeManagement.binarySearch(User).getData();
            Recipe newRecipe = TreeManagement.binarySearchAvl(recipe).getData();
            user.addRecipe(recipe);
            return recipe;
        }
        catch (NullPointerException e){ return null; }
    }

    @GetMapping("/user/{email}/addFollower/{incoming}")
    public static String addValue(@PathVariable String email , @PathVariable String incoming){
        User follower, followed = follower = null;
        try{
            followed = TreeManagement.binarySearch(email).getData();
            follower = TreeManagement.binarySearch(incoming).getData();
        }
        catch (NullPointerException e){
            e.printStackTrace();
            return "Something went wrong, please check the data";
        }
        followed.addFollower(follower.getEmail());
        follower.addFollowing(followed.getEmail());
        UserTree.saveUser();
        return incoming +"  now follows  "+ email;
    }

    @PostMapping("/newRecipe")
    public Recipe addRecipe(@RequestBody JSONObject newRecipe){
        try{
            Recipe incomingRecipe = TypeConversion.makeRecipe(newRecipe);
            User user = TreeManagement.binarySearch(incomingRecipe.getAuthor()).getData();
            if (newRecipe != null){
                user.addRecipe(incomingRecipe.getTitle());
                UserTree.saveUser();
                RecipeTree.addRecipe(incomingRecipe);
                return incomingRecipe;
            }
            else{
                return new Recipe();
            }
        }
        catch (NullPointerException e){
            e.printStackTrace();
            return new Recipe();
        }
    }

    @PostMapping("/company/newRecipe")
    public Recipe addCompanyRecipe(@RequestBody JSONObject newRecipe){
        try {
            Recipe incomingRecipe = TypeConversion.makeRecipe(newRecipe);
            Company company = TreeManagement.BinarySearchSplay(incomingRecipe.getAuthor()).getData();
            if (newRecipe != null){
                company.addRecipe(incomingRecipe.getTitle());
                CompanyTree.saveCompany();
                RecipeTree.addRecipe(incomingRecipe);
                return incomingRecipe;
            }
            else{
                return new Recipe();
            }
        }
        catch (NullPointerException e){
            e.printStackTrace();
            return new Recipe();
        }
    }

    /**
     * This method is a post method that receives a company in json format and converts it into a User type
     * @param newCompany
     * @return the company object
     */
    @PostMapping("/newCompany/{user}")
    public Company addCompany(@RequestBody JSONObject newCompany, @PathVariable String user){
        try{
            Company incomingCompany = TypeConversion.makeCompany(newCompany);
            if (newCompany != null){
                User newUser = TreeManagement.binarySearch(user).getData();
                newUser.setCompany(incomingCompany.getName());
                UserTree.saveUser();
                incomingCompany.addMember(user);
                CompanyTree.addCompany(incomingCompany);
                return incomingCompany;
            }
            else{ return new Company(); }
        }
        catch (NullPointerException e){
            e.printStackTrace();
            return new Company();
        }
    }

    @GetMapping("/getCompany/user/{ID}")
    public static JSONObject getUserCompany(@PathVariable String ID){
        User user;
        Company company;
        try{
            user=TreeManagement.binarySearch(ID).getData();
            return CompanyTree.companyToJSON(TreeManagement.binarySearchSplay(user.getCompany()));
        }
        catch (NullPointerException e){return CompanyTree.companyToJSON(null); }
    }

    @GetMapping("/getRecipe/{recipe}/title")
    public static Recipe getRecipe(@PathVariable String recipe){
        return RecipeTree.getAvlRecipeTree().getRoot().getData();
    }

    @GetMapping("/getRecipe/{email}/user")
    public static SinglyList<Recipe> getRecipeID(@PathVariable String email){
        SinglyList<Recipe> recipeSinglyList = new SinglyList<Recipe>();
        User user = new User();

        try{
            user = TreeManagement.binarySearch(email).getData();
        }
        catch (NullPointerException e){ e.printStackTrace();}

        int count, size = count = 0;

        try{
            size = user.getRecipe().getLength();
        }
        catch (NullPointerException e){ e.printStackTrace();}

        while(count<size){
            Recipe recipe = new Recipe();
            try{ recipe = TreeManagement.binarySearchAvl(user.getRecipe().get(count).getData()).getData(); }
            catch (NullPointerException e){ e.printStackTrace();}

            recipeSinglyList.add(recipe);
            count++;
        }
       return recipeSinglyList;
    }

    /**
     * Function that gets the dates sorted
     * @return returns the singly list with the dates sorted
     */
    @GetMapping("/sorting/getDates")
    public static SinglyList<Recipe> getDateSort(){
        return SortingMethods.DateSort(RecipeTree.getRecipeList());
    }

    /**
     * Function that gets the ratings sorted
     * @return returns the singly list with the ratings sorted
     */
    @GetMapping("/sorting/getRatings")
    public static SinglyList<Recipe> getRatingSort(){
        return SortingMethods.RatingSort();
    }

    /**
     * Function that gets the difficulties sorted
     * @return returns the singly list with the difficulties sorted
     */
    @GetMapping("/sorting/getDifficulties")
    public static SinglyList<Recipe> getDifficultySort(){
        return SortingMethods.DifficultySort();
    }

    /**
     * Getter for all the recipes in a singly list
     * @return returns the singly list
     */
    @GetMapping("/getRecipeList")
    public static SinglyList<Recipe> getRecipeList(){
        try{ return TreeManagement.getRecipeList(); }
        catch (NullPointerException e){ return new SinglyList<Recipe>(); }
    }

    @PostMapping("/addComment/{recipe}/{commentator}/")
    public static String addComment(@RequestBody String comment, @PathVariable String recipe, @PathVariable String commentator) {
        try {
            Recipe newRecipe = TreeManagement.binarySearchAvl(recipe).getData();
            newRecipe.addComment(commentator.concat(":").concat(comment));
            RecipeTree.saveRecipe();
            return newRecipe.getComments();
        } catch (NullPointerException e) {
            return null;
        }
    }

    /**
     * Getter for the dates sorted for each user
     * @param id the id of the user
     * @return returns the singly list
     */
    @GetMapping("/sorting/getDates/{id}")
    public static SinglyList<Recipe> getSortedDates(@PathVariable String id){
        return SortingMethods.DateSortUser(id);
    }

    /**
     * Getter for the ratings sorted for each user
     * @param id the id of the user
     * @return returns the singly list
     */
    @GetMapping("/sorting/getRatings/{id}")
    public static SinglyList<Recipe> getSortedRatings(@PathVariable String id){
        return SortingMethods.RatingSortUser(id);
    }

    /**
     * Getter for the difficulties sorted for each user
     * @param id the id of the user
     * @return returns the singly list
     */
    @GetMapping("/sorting/getDifficulties/{id}")
    public static SinglyList<Recipe> getSortedDifficulties(@PathVariable String id){
        return SortingMethods.DifficultySortUser(id);
    }

    @GetMapping("/searchUser/{criteria}/")
    public static SinglyList<User> searchUser(@PathVariable String criteria){
        try{ return UserTree.searchUser(criteria); }
        catch (NullPointerException e){ return new SinglyList<>(); }
    }

    @GetMapping("/searchChef/{criteria}/")
    public static SinglyList<Chef> searchChef(@PathVariable String criteria){
        try{ return ChefTree.searchChef(criteria); }
        catch (NullPointerException e){ return new SinglyList<>(); }
    }

    @PostMapping("/searchRecipe")
    public static SinglyList<Recipe> searchRecipe(@RequestBody JSONObject criteria){
        SinglyList<Recipe> recipeSinglyList, finalSinglyList = recipeSinglyList = new SinglyList<Recipe>();
        try{ recipeSinglyList = RecipeTree.searchRecipe(criteria.get("search").toString()); }
        catch (NullPointerException e){ return new SinglyList<>(); }
        for(int x=0; x<recipeSinglyList.getLength(); x++){
            Recipe recipe = recipeSinglyList.get(x).getData();
            if(criteria.get("type")==null ||
                    recipe.getType().equals(criteria.get("type"))){

                if(criteria.get("duration") == null ||
                        recipe.getDuration().equals(criteria.get("duration"))){

                    if(criteria.get("servings") == null ||
                            recipe.getServings() == Integer.parseInt(criteria.get("servings").toString())){

                        finalSinglyList.add(recipeSinglyList.get(x).getData());
                    }
                }
            }
        }

        return finalSinglyList;
    }

    @GetMapping("/searchCompany/{criteria}/")
    public static SinglyList<Company> searchCompany(@PathVariable String criteria){
        try{ return CompanyTree.searchCompany(criteria); }
        catch (NullPointerException e){ return new SinglyList<>(); }
    }


}