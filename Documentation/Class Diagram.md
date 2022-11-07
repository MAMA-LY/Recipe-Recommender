![](Aspose.Words.89eaa9b9-8aa6-4324-9838-a0e6b9819e21.001.png)







# **Recipe Recommender**
Description:

Humans face some decisions that they have to make every day, one of which is “What to eat today?”, our Recipe Recommender will ease that decision a lot for everyone, the housewives thinking of lunch ideas and the napless night owls looking for a midnight snack as well

. Our Recipe Recommender will be a mobile application supporting both Android and iOS, and it will have its web UI as well. It has a broad set of functionalities, mainly oriented about recommending recipes given a small set of ingredients to be used, providing the user a wide range of different cuisines both local and international. It provides the user with the ingredients of a numerous set of recipes, how to make them, nutrition facts for each recipe, and even suggests personalized recipes for returning users! It also has a planner so that you can plan what to eat for days ahead, mentioning the calories that you need each day, and the calories of the meals you planned to make.

Authors:

` `Ahmed Adel, Abdelrahman Mosly, Louai Zahran, Mohamed Ibrahim, Mohamed Mamdouh, Yousef Bazina 

Date: 2022-11-06


# **Recipe Recommender (Model)**
![class-diagram](class_diagram.png)

*class-diagram*

*class-diagram - copy*
## **1. BodyInfo (Class)**
*In Recipe Recommender*

|**Attributes**|
| :-: |
|height : *float [1]*|
|weight : *float [1]*|
|age : *Integer [1]*|
|**Associations**|
|BodyInfo\_Profile -  : Profile [1] - see [definition](#14-profile-class)|
## **2. Calendar (Class)**
*In Recipe Recommender*

|**Attributes**|
| :-: |
|Ingredients : *List<Ingredient> [1]*|
|recipes : *List<Recipe> [1]*|
|**Associations**|
|Calendar\_Profile - profile : Profile [0..1] - see [definition](#14-profile-class)|
## **3. CaloriesWatcher (Class)**
*In Recipe Recommender*

|**Operations**|
| :-: |
|eat : *Recipe* <br>- parameter: *Recipe[1]*<br>- parameter2: *Profile[1]*|
|unboxRecipeCalories : *Integer* <br>- parameter: *Recipe[1]*|
|unboxIngredientCalories : *Integer* <br>- parameter: *Ingredient[1]*|
## **4. DAO (Class)**
*In Recipe Recommender*

|**Attributes**|
| :-: |
|database : *Database [1]*|
|**Operations**|
|DAO : *DAO*|
|loginAuthentication : *Boolean* <br>- parameter: *UserCredentials[1]*|
|addFavRecipe : *void* <br>- parameter: *UserCredentials[1]*<br>- parameter2: *Recipe[1]*|
|getRecipes : *List<Recipe>* <br>- parameter: *List<Ingredient>[1]*|
|getRecipeByID : *Recipe* <br>- parameter: *UserCredentials[1]*|
|deleteFavRecipe : *void* <br>- Email: *UserCredentials[1]*<br>- parameter: *Recipe[1]*|
|getAllIngredients : *List<Ingredient>*|
|pushProfile : *void* <br>- parameter: *Profile[1]*|
|getProfile : *Profile* <br>- parameter: *UserCredentials[1]*|
|**Associations**|
|DAO\_Database - database : Database [0..1] - see [definition](#bookmark=id.3dy6vkm)|
## **5. Database (Class)**
*In Recipe Recommender*

|**Attributes**|
| :-: |
|instance : *Database [1]*|
|**Operations**|
|getInstance : *Database*|
|query : *void* <br>- sqlQuery: *String[1]*|
|Database : *Database*|
|**Associations**|
|DAO\_Database - DAO : DAO [\*] - see [definition](#bookmark=id.tyjcwt)|
## **8. Ingredient (Class)**
*In Recipe Recommender*

|**Attributes**|
| :-: |
|name : *String [1]*|
|ID : *String [1]*|
|icon  : *Image [1]*|
|weight : *Integer [1]*|
|nutritions : *Nutritions [1]*|
|**Associations**|
|Ingredient\_Nutritions - nutritions2 : Nutritions [0..1] - see [definition](#bookmark=id.35nkun2)|
## **12. Model (Class)**
*In Recipe Recommender*

## **13. Nutritions (Class)**
*In Recipe Recommender*

|**Attributes**|
| :-: |
|calories : *Integer [1]*|
|proteins : *Integer [1]*|
|carbs : *Integer [1]*|
|fats : *Integer [1]*|
|**Associations**|
|Recipe\_Nutritions - recipe : Recipe [0..1] - see [definition](#bookmark=id.2jxsxqh)|
|Ingredient\_Nutritions - ingredient : Ingredient [0..1] - see [definition](#bookmark=id.2s8eyo1)|
## **14. Profile (Class)**
*In Recipe Recommender*

|**Attributes**|
| :-: |
|userCredentials  : *UserCredentials [1]*|
|favoriteRecipes : *List<Recipe> [1]*|
|photo  : *Image [1]*|
|name : *String [1]*|
|dailyCalories : *Integer [1]*|
|caloriesDate : *Integer [1]*|
|bodyInfo : *BodyInfo [1]*|
|calendar : *Calendar [1]*|
|**Operations**|
|calculateCalories : *void*|
|addCalendar : *void* <br>- parameter: *List<Ingredient>[1]*|
|**Associations**|
|ProfileBuilder\_Profile - profileBuilder : ProfileBuilder [0..1] - see [definition](#bookmark=id.44sinio)|
|BodyInfo\_Profile -  : BodyInfo [1] - see [definition](#bookmark=id.1fob9te)|
|UserCredentials\_Profile - userCredentials : UserCredentials [0..1] - see [definition](#bookmark=id.4i7ojhp)|
|Calendar\_Profile - calendar : Calendar [0..1] - see [definition](#bookmark=id.3znysh7)|
## **15. ProfileBuilder (Class)**
*In Recipe Recommender*

|**Attributes**|
| :-: |
|recipe : *Recipe [1]*|
|profile : *Profile [1]*|
|ProfileBuilder : *invalid [1]*|
|**Operations**|
|withUserCredentials : *void* <br>- userCredentials: *UserCredentials[1]*|
|withFavoritRecipes : *void* <br>- favoriteRecipes: *List<Recipe>[1]*|
|withFavoriteRecipe : *void* <br>- favoriteRecipe: *Recipe[1]*|
|withBodyInfo : *void* <br>- bodyInfo: *float[1]*<br>- parameter: *float[1]*<br>- parameter2: *Integer[1]*|
|withName : *void* <br>- name: *String[1]*|
|withPhoto : *void* <br>- photo: *Image[1]*|
|**Associations**|
|ProfileBuilder\_Profile - profile : Profile [\*] - see [definition](#14-profile-class)|
## **16. Recipe (Class)**
*In Recipe Recommender*

|**Attributes**|
| :-: |
|ID : *String [1]*|
|Tags : *List<String> [1]*|
|Cuisine  : *String [1]*|
|name : *String [1]*|
|ingredients : *List<Ingredient> [1]*|
|photo : *Image [1]*|
|nutritions : *Nutritions [1]*|
|**Associations**|
|Recipe\_Nutritions - nutritions2 : Nutritions [0..1] - see [definition](#bookmark=id.35nkun2)|
|RecipeBuilder\_Recipe - recipeBuilder : RecipeBuilder [0..1] - see [definition](#bookmark=id.z337ya)|
## **17. RecipeBuilder (Class)**
*In Recipe Recommender*

|**Attributes**|
| :-: |
|recipe : *Recipe [1]*|
|recipe : *Recipe [1]*|
|RecipeBuilder : *RecipeBuilder [1]*|
|**Operations**|
|withID : *void* <br>- ID: *String[1]*|
|withListTags : *void* <br>- tags: *List<String>[1]*|
|withTag  <br>- tag: *String[1]*|
|withCuisine : *void* <br>- Cuisine: *String[1]*|
|withName : *void* <br>- name: *String[1]*|
|withPhoto : *void* <br>- photo: *Image[1]*|
|withIngredients : *void* <br>- ingredients: *Ingredient[1]*|
|withNutritions : *void* <br>- parameter: *Nutritions[1]*|
|reset : *void*|
|**Associations**|
|RecipeBuilder\_Recipe - recipe : Recipe [\*] - see [definition](#bookmark=id.2jxsxqh)|
## **18. RecipeRecommender (Class)**
*In Recipe Recommender*

|**Attributes**|
| :-: |
|model : *Model [1]*|
|**Operations**|
|recommend : *List<Recipe>* <br>- parameter: *List<Recipe>[1]*<br>- parameter2: *List<Ingredient>[1]*|
## **19. RestfulAPI (Class)**
*In Recipe Recommender*

|**Operations**|
| :-: |
|SearchRecipes : *List<Recipe>* <br>- parameter: *List<Ingredient>[1]*|
|authenticate : *Boolean* <br>- parameter: *String[1]*|
|getAllIngredients : *List<Ingredient>*|
|eatRecipe : *void* <br>- parameter: *Profile[1]*<br>- parameter2: *Recipe[1]*|
|createProfile : *void* <br>- parameter: *List<String>[1]*|
|getProfile : *Profile* <br>- parameter: *UserCredentials[1]*|
|addCalender : *void* <br>- parameter: *List<Ingredient>[1]*|
|addFavRecipe : *void* <br>- parameter: *Profile[1]*<br>- parameter2: *Recipe[1]*|
|deleteFavRecipe : *void* <br>- parameter: *Profile[1]*<br>- parameter2: *Recipe[1]*|
## **20. UserCredentials (Class)**
*In Recipe Recommender*

|**Attributes**|
| :-: |
|ID : *String [1]*|
|email : *String [1]*|
|password : *String [1]*|
|**Associations**|
|UserCredentials\_Profile - profile : Profile [0..1] - see [definition](#14-profile-class)|



|Power by [GenMyModel](https://www.genmymodel.com/)||
| :- | -: |

