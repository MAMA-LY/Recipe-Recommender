# CRC Card
- [RestfulAPI](#restfulapi)
- [Profile](#profile)
- [Profile Builder](#profilebuilder)
- [Recipe](#recipe)
- [RecipeBuilder](#recipebuilder)
- [DAO](#dao)
- [Database](#database)
- [Calories Watcher](#calorieswatcher)
- [Recipe Recommender](#reciperecommender)
- [Ingredient](#ingredient)
- [Nutritions](#nutritions)
- [User Credentials](#usercredentials)
- [Body Info](#bodyinfo)
- [Calendar](#calendar)

## RestfulAPI

|- Creates an account.</p><p>- Gets a profile data.</p><p>- Authenticates a user.</p><p>- Get all ingredients in the database.</p><p>- Search for recipes with a given list of ingredients.</p><p>- Modifes the meal plan for a user.</p><p>- Modifes the user's consumed daily calories by eating a meal.</p><p>- Adds favorite recipes to the user's profile.</p><p>- Removes favorite recipes from the user's profile.</p>|<p>- DAO</p><p>- RecipeRecommender</p><p>- CaloriesWatcher</p>|
|---|---|

## Profile
|<p> Encapsulates user's data such as his name, credentials, favorite recipes, daily calories, meal plan, and body information.</p><p> Calculates the amount of calories the user should consume daily based on his body information.</p><p> Modifes the meal plan by adding recipes to the user calendar.</p>|<p> ProfileBuilder</p><p>- BodyInfo</p><p>- UserCredentials</p><p> Calendar</p>|
|---|---|

## ProfileBuilder

|<p> Builds the profile for a new user during the creation of his account.</p><p> Sets initial attributes like the user's name, credentials, photo, and body information.</p>| profile|
|---|---|

## Recipe


| Represents all information about a recipe, including its name, ingredients, nutritions, photo, cuisines, and tags.|<p> RecipeBuilder</p><p>- DAO</p><p>- CaloriesWatcher</p><p> Nutrition</p>|
|---|---|

## RecipeBuilder


|<p> Builds the contents of a recipe during its creation.</p><p>- Sets initial attributes like the recipe's name, ingredients, photo, nutrition, cuisines, and tags.</p><p>- Cancel the recipe's building if its creation is aborted by the user.</p>| Recipe|
|---|---|

## DAO


|<p>- Communicates with the database for the following purposes:</p><p>- Add a new profile</p><p>- Get a profile</p><p>- Get a recipe by its ingredients</p><p>- Get a recipe by its ID</p><p>- Get all ingredients</p><p>- Add a favorite recipe to a user's profile</p><p>- Delete a favorite recipe from a user's profile</p><p>- Get authentication credentials</p>|<p> Database</p><p>- Profile</p><p>- Ingredient</p><p>- RecipeRecommender</p><p>- RestfulAPI</p>|
|---|---|

## Database


|<p>Maintaining a singleton representing the database.</p><p> Sending queries to the database server and receiving its response.</p>| DAO|
|---|---|

## CaloriesWatcher


|<p> Calculates the number of calories in a certain ingredient.</p><p>- Calculates the number of calories in a certain recipe.</p><p>- Modifes the user's consumed daily calories by eating a meal.</p>|<p> RestfulAPI</p><p> Recipe</p>|
|---|---|
## RecipeRecommender


| Recommends recipes for a user given its past activities and preferences.| DAO|
|---|---|

## Ingredient


| Encapsulates ingredient's data such as its name, id, weight, icon, and nutrition.|<p> DAO</p><p> Nutritions</p>|
|---|---|

## Nutritions


 Encapsulates recipe or ingredient's nutrition data such as number of calories, amount of protein, carbohydrates, and fats.|<p>Recipe</p><p> Ingredient</p>|
|---|---|

## UserCredentials


| Encapsulates user's credential data such as his email, hashed password, and account's id.| Profile|
|---|---|
## BodyInfo


| Encapsulates user's data such as his height, weight, and age.|! Profile|
|---|---|

## Calendar


| Encapsulates user's meal plan data such as his planned recipes for each day.| Profile|
|---|---|
