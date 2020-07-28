package com.itcr.datos.cooktimeserver.host;

import com.itcr.datos.cooktimeserver.data_structures.*;
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
                "    * Access the users in the following link http://localhost:6969/user "
                + System.lineSeparator() +System.lineSeparator() +
                "    * Add new users using the link http://localhost:6969/newUser using a POST request "
                + System.lineSeparator() +System.lineSeparator() +
                "    * Access a specific user by typing the link http://localhost:6969/email/getUser/[USER EMAIL]"
                + System.lineSeparator() +System.lineSeparator() +
                "    * Change a value from a specific user with http://localhost:6969/setUser/[USER EMAIL]/[[KEY TO MODIFY]]"
                + System.lineSeparator() +System.lineSeparator() +
                "    * Verify the user is in the server http://localhost:6969/login/[USER EMAIL]/[[PASSWORD]]"
                + System.lineSeparator() +System.lineSeparator() +
                "    * Add a follower to a user and assign the following http://localhost:6969/user/[FOLLOWED_EMAIL]/addFollower/[FOLLOWING_EMAIL]"
                + System.lineSeparator() +System.lineSeparator() +
                "      the first parameter FOLLOWED is the user that FOLLOWING is following, this will set the list for both FOLLOWED and FOLLOWING"
                + System.lineSeparator() +System.lineSeparator() +
                "    * Access the a linked list of all users using http://localhost:6969/getUser/userShuffledList"
                + System.lineSeparator() +System.lineSeparator() +
                "    * Set a users value using http://localhost:6969/setUser/[Email]/[Data] , in this last field you'll be able"
                +System.lineSeparator() +System.lineSeparator() +
                "    * Search for a user by typing http://localhost:6969/searchUser/[criteria]"
                +System.lineSeparator() +System.lineSeparator() +
                "    * Get the first 3 users of the shuffled user list by typing http://localhost:6969//getUser/userShuffledList"
                +System.lineSeparator() +System.lineSeparator() +
                "    * Follow a company by typing http://localhost:6969/user/[userEmail]/addMember/[companyEmail]"
                +System.lineSeparator() +
                "      to change a value from a specified user using name, email, image, password, hasCompany and age"
                + System.lineSeparator() +System.lineSeparator() + System.lineSeparator() +System.lineSeparator() +


                "Chef management:"


                + System.lineSeparator() +System.lineSeparator() + System.lineSeparator() +System.lineSeparator() +
                "    * You can access the chef tree using http://localhost:6969/chef"
                + System.lineSeparator() +System.lineSeparator() +
                "    * Search for a chef by typing http://localhost:6969/searchChef/[criteria]/"
                +System.lineSeparator() +
                "    * You can add a chef using http://localhost:6969/newChef"
                + System.lineSeparator() +System.lineSeparator() + System.lineSeparator() +System.lineSeparator() +


                "Recipe management:"


                + System.lineSeparator() +System.lineSeparator() + System.lineSeparator() +System.lineSeparator() +
                "    * You can access the recipe tree using http://localhost:6969/recipe"
                + System.lineSeparator() +System.lineSeparator() +
                "    * Add a recipe to a user with http://localhost:6969/newRecipe using a post method"
                + System.lineSeparator() +System.lineSeparator() +
                "    * Get an specific recipe with http://localhost:6969/getRecipe/title/[RECIPE TITLE] using the title"
                + System.lineSeparator() +System.lineSeparator() +
                "    * Or access to all of the recipes of a user http://localhost:6969/getRecipe/user/[USER NAME] using the user name, this returns a list"
                + System.lineSeparator() +System.lineSeparator() +
                "    * Add a recipe to the feed by using http://localhost:6969/addFeedRecipe/[Recipe_Title]/[User_email]"
                + System.lineSeparator() +System.lineSeparator() +
                "    * Get a recipe list by typing http://localhost:6969/getRecipeList"
                + System.lineSeparator() +System.lineSeparator() +
                "    * Add a comment to a recipe by using the link http://localhost:6969/addComment/[Recipe_Title]/[Email]"
                +System.lineSeparator() +System.lineSeparator() +
                "    * Search for a recipe by typing http://localhost:6969/searchRecipe and the JSON with the query form or can be searched using the"
                +System.lineSeparator() +
                "    * Non query form using http://localhost:6969/searchRecipe/[query]"
                +System.lineSeparator() +
                "      where the email corresponds to the user email, this is a post that will recieve the comment in plain text"
                +System.lineSeparator() +System.lineSeparator() +
                "    * Recipes can be deleted both from user by using http://localhost:6969/deleteRecipe/user/[Recipe title]/ or from a company"
                +System.lineSeparator() +
                "      by typing http://localhost:6969/deleteRecipe/company/[Recipe title]/"
                +System.lineSeparator() +System.lineSeparator() +
                "    * Add a new rating by typing http://localhost:6969/newRating/{recipeTitle}/{rating}/ , this will automatically add the rating to the total"
                +System.lineSeparator() +
                "      will add the recipe to the overall and it will calculate the average, it will return true if everything went fine, false if not"
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
                "    *Access the recipes of a company by typing http://localhost:6969/company/getRecipe/{email}/"
                + System.lineSeparator() +System.lineSeparator() +
                "    *Get the first 3 companies of the shuffled company list by typing http://localhost:6969//getCompany/companyShuffledList"
                + System.lineSeparator() +System.lineSeparator() +
                "    *Access all of the members of a company by typing http://localhost:6969/[companyEmail]/memberList"
                + System.lineSeparator() +System.lineSeparator() + System.lineSeparator() +System.lineSeparator() +


                "    *Data management"


                + System.lineSeparator() +System.lineSeparator() + System.lineSeparator() +System.lineSeparator() +
                "    *Access the the dates sorted of each user in the following link http://localhost:6969/sorting/getDates/[id]"
                + System.lineSeparator() +System.lineSeparator() +
                "    *Access the the ratings sorted of each user in the following link http://localhost:6969/sorting/getRatings/[id]"
                + System.lineSeparator() +System.lineSeparator() +
                "    *Access the the difficulties sorted of each user in the following link http://localhost:6969/sorting/getDifficulties/[id]"
                + System.lineSeparator() +System.lineSeparator() +
                "    *Access the the dates sorted of each company in the following link http://localhost:6969/sorting/getDatesCompany/[id]"
                + System.lineSeparator() +System.lineSeparator() +
                "    *Access the the ratings sorted of each company in the following link http://localhost:6969/sorting/getRatingsCompany/[id]"
                + System.lineSeparator() +System.lineSeparator() +
                "    *Access the the difficulties sorted of each company in the following link http://localhost:6969/sorting/getDifficultiesCompany/[id]"
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

    /**
     * Function that gets a company`s name
     * @param ID
     * @return returns the company object
     */
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
        JSONObject jsonObject = TypeConversion.userToJSON(TreeManagement.BinarySearch(userKey));
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
            response.add(TypeConversion.companyToJSON(new AlphNodeSplay<Company>(companyList.get(count).getData(),companyList.get(count).getData().getName())));
            count++;
        }
        return response;
    }

    @GetMapping("/login/{userKey}/{password}")
    public JSONObject LoginMethod(@PathVariable String userKey, @PathVariable String password){
        JSONObject jsonObject;
        if(TreeManagement.BinarySearch(userKey)!=null){
            jsonObject = TypeConversion.userToJSON(TreeManagement.BinarySearch(userKey));
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
        AlphNodeTree<User> user = TreeManagement.BinarySearch(userKey);
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

    /**
     * This method will modify an specific value of a given company.
     * @param companyKey the company´s email
     * @param companyData the data type to be modified
     * @param request The response from the client
     * @return
     */
    @PostMapping("/setCompany/{companyKey}/{companyData}")
    public String setCompany(@PathVariable String companyKey, @PathVariable String companyData, @RequestBody String request){
        AlphNodeSplay<Company> company = TreeManagement.binarySearchSplay(companyKey);
        if(company==null){
            return "company not found";
        }
        else{
            switch(companyData){
                case "name":
                    company.getData().setName(request);
                    return company.getData().getName();
                case "email":
                    company.getData().setEmail(request);
                    return company.getData().getEmail();
                case "logo":
                    company.getData().setLogo(request);
                    return company.getData().getLogo();
                case "schedule":
                    company.getData().setSchedule(request);
                    return company.getData().getLogo();
                case "location":
                    company.getData().setLocation(request);
                    return company.getData().getLocation();
                case "number":
                    try{
                        company.getData().setNumber(Integer.parseInt(request));
                    }
                    catch (NumberFormatException e){
                        e.printStackTrace();
                    }
                    return String.valueOf(company.getData().getNumber());
                case "posts":
                    try{
                        company.getData().setPosts(Integer.parseInt(request));
                    }
                    catch (NumberFormatException e){
                        e.printStackTrace();
                    }
                    return String.valueOf(company.getData().getPosts());
                default:
                    return "This request can't be processed";
            }
        }
    }

    /**
     * Function that gets the recipe tree
     * @return a string
     */
    @GetMapping("/recipe")
    public String getRecipeTree(){
        RecipeTree.updateRecipeList();
        return RecipeTree.getAvlRecipeTree().toString();
    }

    /**
     * Function that adds a new chef
     * @param newChef
     * @return returns the chef method
     */
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

    /**
     * Function that adds a feed of recipes
     * @param User
     * @param recipe
     * @return returns a string
     */
    @GetMapping("/addFeedRecipe/{Recipe}/{User}")
    public static String addFeedRecipe(@PathVariable String User, @PathVariable String recipe){
        try{
            User user = TreeManagement.BinarySearch(User).getData();
            Recipe newRecipe = TreeManagement.binarySearchAvl(recipe).getData();
            user.addRecipe(recipe);
            return recipe;
        }
        catch (NullPointerException e){ return null; }
    }

    /**
     * Function that adds a follower
     * @param email
     * @param incoming
     * @return returns a string
     */
    @GetMapping("/user/{email}/addFollower/{incoming}")
    public static String addValue(@PathVariable String email , @PathVariable String incoming){
        User follower, followed = follower = null;
        try{
            followed = TreeManagement.BinarySearch(email).getData();
            follower = TreeManagement.BinarySearch(incoming).getData();
            followed.setHasNotification(true);
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

    /**
     * Get method that turns the requested
     * @param email the email of the user
     * @return returns the boolean of the user
     */
    @GetMapping("/setUser/{email}/boolean")
    public boolean setFalse(@PathVariable String email){
        try{
            TreeManagement.BinarySearch(email).getData().setHasNotification(false);
            UserTree.saveUser();
        }
        catch (NullPointerException e){ e.printStackTrace(); }
        return TreeManagement.BinarySearch(email).getData().isHasNotification();
    }

    /**
     * Function that adds a  new recipe
     * @param newRecipe
     * @return returns the recipe object
     */
    @PostMapping("/newRecipe")
    public Recipe addRecipe(@RequestBody JSONObject newRecipe){
        try{
            Recipe incomingRecipe = TypeConversion.makeRecipe(newRecipe);
            User user = TreeManagement.BinarySearch(incomingRecipe.getAuthor()).getData();
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

    /**
     * Function that adds a new recipe toa  company
     * @param newRecipe
     * @return returns a recipe object
     */
    @PostMapping("/company/newRecipe")
    public Recipe addCompanyRecipe(@RequestBody JSONObject newRecipe){
        try {
            Recipe incomingRecipe = TypeConversion.makeRecipe(newRecipe);
            Company company = TreeManagement.binarySearchSplay(incomingRecipe.getAuthor()).getData();
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
                User newUser = TreeManagement.BinarySearch(user).getData();
                newUser.setCompany(incomingCompany.getEmail());
                newUser.setHasCompany(true);
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

    /**
     * Function that gets the user`s compant
     * @param ID
     * @return returns a jsonobject
     */
    @GetMapping("/getCompany/user/{ID}")
    public static JSONObject getUserCompany(@PathVariable String ID){
        try{
            User user = TreeManagement.BinarySearch(ID).getData();
            return CompanyTree.companyToJSON(TreeManagement.binarySearchSplay(user.getCompany()));
        }
        catch (NullPointerException e){return CompanyTree.companyToJSON(null); }
    }

    /**
     * Function that gets a recipe`s title
     * @param recipe
     * @return returns a recipe object
     */
    @GetMapping("/getRecipe/{recipe}/title")
    public static Recipe getRecipe(@PathVariable String recipe){
        return RecipeTree.getAvlRecipeTree().getRoot().getData();
    }

    /**
     * Function that gets a recipe of a user by its email
     * @param email
     * @return returns a singly list of recipes
     */
    @GetMapping("/getRecipe/{email}/user")
    public static SinglyList<Recipe> getRecipeID(@PathVariable String email){
        SinglyList<Recipe> recipeSinglyList = new SinglyList<Recipe>();
        User user = new User();

        try{
            user = TreeManagement.BinarySearch(email).getData();
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
        SinglyList<Recipe> list = SortingMethods.RatingSort(RecipeTree.getRecipeList());
        if (list.getLength() >= 3){
            SinglyList<Recipe> newRecipeList = new SinglyList<>();
            for (int i = 0; i < 3; i++){
                newRecipeList.add(list.get(i).getData());
            }
            newRecipeList.print_list();
            return  newRecipeList;
        }
        else {
            return list;
        }
    }

    @GetMapping("/newRating/{recipeTitle}/{rating}/")
    public static boolean newRating(@PathVariable String recipeTitle, @PathVariable int rating){
        try{
            Recipe recipe = TreeManagement.binarySearchAvl(recipeTitle).getData();
            recipe.addNumRating();
            recipe.addTotalRating(rating);
            recipe.setRating( (float)recipe.getTotalRating()/recipe.getNumRating() );
            TreeManagement.BinarySearch(recipe.getAuthor()).getData().setHasNotification(true);
            UserTree.saveUser();
            RecipeTree.saveRecipe();
            return true;
        }
        catch (NullPointerException e){ return false;}
    }

    /**
     * Function that gets the difficulties sorted
     * @return returns the singly list with the difficulties sorted
     */
    @GetMapping("/sorting/getDifficulties")
    public static SinglyList<Recipe> getDifficultySort(){
        return SortingMethods.DifficultySort(RecipeTree.getRecipeList());
    }

    /**
     * Getter for all the recipes in a singly list
     * @return returns the singly list
     */
    @GetMapping("/getRecipeList")
    public static SinglyList<Recipe> getRecipeList(){
        try{
            SinglyList<Recipe> listTree = TreeManagement.getRecipeList();
            listTree = listTree.Inverter(listTree);
            return listTree;
        }
        catch (NullPointerException e){ return new SinglyList<Recipe>(); }
    }

    /**
     * Post function that adds a comment to a certain recipe
     * @param comment
     * @param recipe
     * @param commentator
     * @return returns a string
     */
    @PostMapping("/addComment/{recipe}/{commentator}/")
    public static String addComment(@RequestBody String comment, @PathVariable String recipe, @PathVariable String commentator) {
        try {
            Recipe newRecipe = TreeManagement.binarySearchAvl(recipe).getData();
            newRecipe.addComment(commentator.concat(":").concat(comment));
            AlphNodeTree<User> authorNewRecipe = TreeManagement.BinarySearch(newRecipe.getAuthor());
            authorNewRecipe.getData().setHasNotification(true);
            UserTree.saveUser();
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

    /**
     * Getter for the dates sorted for each company
     * @param id the id of the company (email)
     * @return returns the singly list
     */
    @GetMapping("/sorting/getDatesCompany/{id}")
    public static SinglyList<Recipe> getSortedDatesCompany(@PathVariable String id){
        return SortingMethods.DateSortCompany(id);
    }

    /**
     * Getter for the ratings sorted for each company
     * @param id the id of the company (email)
     * @return returns the singly list
     */
    @GetMapping("/sorting/getRatingsCompany/{id}")
    public static SinglyList<Recipe> getSortedRatingsCompany(@PathVariable String id){
        return SortingMethods.RatingSortCompany(id);
    }

    /**
     * Getter for the difficulties sorted for each company
     * @param id the id of the company (email)
     * @return returns the singly list
     */
    @GetMapping("/sorting/getDifficultiesCompany/{id}")
    public static SinglyList<Recipe> getSortedDifficultiesCompany(@PathVariable String id){
        return SortingMethods.DifficultySortCompany(id);
    }

    /**
     * Function that searhes for a user
     * @param criteria
     * @return returns a singly list of objects
     */
    @GetMapping("/searchUser/{criteria}/")
    public static SinglyList<JSONObject> searchUser(@PathVariable String criteria){
        try{
            SinglyList<User> userList = UserTree.searchUser(criteria);
            SinglyList<JSONObject> objectList = new SinglyList<>();
            for(int i=0; i<userList.getLength(); i++){
                objectList.add(TypeConversion.userToJSON(new AlphNodeTree<User>(userList.get(i).getData(),null)));
            }
            return objectList;
        }
        catch (NullPointerException e){ return new SinglyList<>(); }
    }

    /**
     * Function for searching for a chef
     * @param criteria
     * @return returns singly list of chefs
     */
    @GetMapping("/searchChef/{criteria}/")
    public static SinglyList<Chef> searchChef(@PathVariable String criteria){
        try{ return ChefTree.searchChef(criteria); }
        catch (NullPointerException e){ return new SinglyList<>(); }
    }

    /**
     * Post function for searchin for a recipe
     * @param criteria json object
     * @return returns singly list of recipes
     */
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

                    if(Integer.parseInt(criteria.get("servings").toString()) == 0 ||
                            recipe.getServings() == Integer.parseInt(criteria.get("servings").toString())){

                        finalSinglyList.add(recipeSinglyList.get(x).getData());
                    }
                }
            }
        }

        return finalSinglyList;
    }

    /**
     * Function that searhes for a recipe
     * @param criteria
     * @return returns a singly list of recipes
     */
    @GetMapping("/searchRecipe/{criteria}/")
    public static SinglyList<Recipe> searchRecipe(@PathVariable String criteria){
        return RecipeTree.searchRecipe(criteria);
    }

    /**
     * Function that searches for the company`s data
     * @param criteria
     * @return returns a singly list of objects
     */
    @GetMapping("/searchCompany/{criteria}/")
    public static SinglyList<JSONObject> searchCompany(@PathVariable String criteria){
        try{
            SinglyList<Company> companyList=  CompanyTree.searchCompany(criteria);
            SinglyList<JSONObject> newCompany = new SinglyList<JSONObject>();
            for (int i=0; i<companyList.getLength(); i++){
                newCompany.add(TypeConversion.companyToJSON(new AlphNodeSplay<>(companyList.get(i).getData(),null)));
            }

            return  newCompany;

        }
        catch (NullPointerException e){ return new SinglyList<JSONObject>(); }
    }

    /**
     * Function that gets the company`s recipe by searching its email
     * @param email
     * @return returns a singly list
     */
    @GetMapping("/company/getRecipe/{email}/")
    public static SinglyList<Recipe> getCompanyRecipe(@PathVariable String email){
        SinglyList<String> recipeStringList = TreeManagement.binarySearchSplay(email).getData().getRecipe();
        SinglyList<Recipe> recipeSinglyList = new SinglyList<>();
        for(int x=0;x<recipeStringList.getLength();x++){
            try{ recipeSinglyList.add(TreeManagement.binarySearchAvl(recipeStringList.get(x).getData()).getData()); }
            catch (NullPointerException e){ System.out.println("Missing recipe"); }
        }

        return recipeSinglyList;

    }

    /**
     * Function for following a company
     * @param companyEmail
     * @param userEmail
     * @return returns string
     */
    @GetMapping("/user/{userEmail}/follow/{companyEmail}")
    public static String followCompany(@PathVariable String companyEmail, @PathVariable String userEmail){

        try {
            User user = TreeManagement.BinarySearch(userEmail).getData();
            Company company = TreeManagement.binarySearchSplay(companyEmail).getData();
            user.addFollowing(company.getEmail());
            company.addFollower(user.getEmail());
            UserTree.saveUser();
            CompanyTree.saveCompany();
            return userEmail+" now follows "+companyEmail;
        }
        catch (NullPointerException e){ return "Please check your info"; }

    }

    /**
     * Function that adds a member to the company
     * @param companyEmail
     * @param userEmail
     * @return returns string with the member
     */
    @GetMapping("/user/{userEmail}/addMember/{companyEmail}")
    public static String memberCompany(@PathVariable String companyEmail, @PathVariable String userEmail){

        try {
            User user = TreeManagement.BinarySearch(userEmail).getData();
            Company company = TreeManagement.binarySearchSplay(companyEmail).getData();

            if(user.getCompany()!=null){
                Company oldCompany = TreeManagement.binarySearchSplay(user.getCompany()).getData();
                SinglyList<String> members = oldCompany.getMembers();
                for(int i=0; i<members.getLength(); i++){
                    if(members.get(i).getData().equals(user.getEmail())){
                        members.remove(i);
                    }
                }
                oldCompany.setMembers(members);
            }

            user.setCompany(company.getEmail());
            user.setHasCompany(true);
            company.addMember(user.getEmail());
            UserTree.saveUser();
            CompanyTree.saveCompany();
            return userEmail+" is now a member of "+companyEmail;
        }
        catch (NullPointerException e){ return "Please check your info"; }

    }

    /**
     * Fcuntion that deletes the user`s email
     * @param email
     */
    @GetMapping("/deleteUser/{email}/")
    public static void deleteUser(@PathVariable String email){
        UserTree.getUserTree().delete(email);
        UserTree.saveUser();
    }

    /**
     * Function that deletes the chef`s email
     * @param email
     */
    @GetMapping("/deleteChef/{email}/")
    public static void deleteChef(@PathVariable String email){
        UserTree.getUserTree().delete(email);
        ChefTree.getChefTree().delete(email);
        UserTree.saveUser();
        ChefTree.saveChef();
    }

    /**
     * Function that deletes the company`s email
     * @param email
     */
    @GetMapping("/deleteCompany/{email}/")
    public static void deleteCompany(@PathVariable String email){

        Company company = TreeManagement.binarySearchSplay(email).getData();

        for(int x=0; x<company.getMembers().getLength(); x++){
            User user = TreeManagement.BinarySearch(company.getMembers().get(x).getData()).getData();
            user.setCompany(null);
            user.setHasCompany(false);
        }
        UserTree.saveUser();
        CompanyTree.getSplayCompanyTree().delete(email);
        CompanyTree.saveCompany();
    }

    /**
     * Function that deletes recipe of the user
     * @param title
     * @return
     */
    @GetMapping("/deleteRecipe/user/{title}/")
    public static String deleteRecipeUser(@PathVariable String title){
        try{
            Recipe recipe = TreeManagement.binarySearchAvl(title).getData();
            User user = TreeManagement.BinarySearch(recipe.getAuthor()).getData();
            user.removeRecipe(title);
            RecipeTree.getAvlRecipeTree().deleteNode(title);
            RecipeTree.saveRecipe();
            UserTree.saveUser();
        }
        catch (NullPointerException e){
            return "Please check your info";
        }

        return title;
    }

    /**
     * Function that deletes recipe of company
     * @param title
     * @return
     */
    @GetMapping("/deleteRecipe/company/{title}/")
    public static String deleteRecipeCompany(@PathVariable String title){
        try{
            Recipe recipe = TreeManagement.binarySearchAvl(title).getData();
            Company company = TreeManagement.binarySearchSplay(recipe.getAuthor()).getData();
            company.removeRecipe(title);
            RecipeTree.getAvlRecipeTree().deleteNode(title);
            RecipeTree.saveRecipe();
            CompanyTree.saveCompany();
        }
        catch (NullPointerException e){
            return "Please check your info";
        }

        return title;
    }

    /**
     * Function that gets the member list
     * @param companyEmail
     * @return returns the singly list of json objects
     */
    @GetMapping("/{companyEmail}/memberList")
    public static SinglyList<JSONObject> memberList(@PathVariable String companyEmail){
        SinglyList<JSONObject> userSinglyList = new SinglyList<>();
        Company company;
        try{ company = TreeManagement.binarySearchSplay(companyEmail).getData(); }
        catch (NullPointerException e){
            System.out.println("No company was found");
            return userSinglyList;
        }
        for(int x=0; x<company.getMembers().getLength(); x++){
            try{
                userSinglyList.add(TypeConversion.userToJSON(TreeManagement.BinarySearch(company.getMembers().get(x).getData())));}
            catch (NullPointerException e){
                System.out.println("There was a problem with the member at : "+x+" position");
                return userSinglyList;
            }
        }
        return userSinglyList;
    }



}