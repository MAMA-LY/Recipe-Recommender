class APIConstants {
  static const baseUrl = String.fromEnvironment("BrainFoodBackendIP", defaultValue: "brainfood.azurewebsites.net");
  static String signupEndPoint = "/signup";
  static String signinEndPoint = "/signin";
  static String signoutEndPoint = "/signout";
  static String homeEndPoint = "/home";
  static String recipeEndPoint = "/home/recipe";
  static Map<String, String> headerCORS(String cookie) {
    if (cookie != "") {
      return {
        "cookie": cookie,
        "Access-Control-Allow-Origin": "*",
        "Access-Control-Allow-Methods": "POST, OPTIONS, GET",
        "Access-Control-Allow-Headers":
        "Origin,Content-Type,X-Amz-Date,Authorization,X-Api-Key,X-Amz-Security-Token,locale",
      };
    } else {
      return {
        "Access-Control-Allow-Origin": "*",
        "Access-Control-Allow-Methods": "POST, OPTIONS, GET",
        "Access-Control-Allow-Headers":
        "Origin,Content-Type,X-Amz-Date,Authorization,X-Api-Key,X-Amz-Security-Token,locale",
      };
    }
  }
}