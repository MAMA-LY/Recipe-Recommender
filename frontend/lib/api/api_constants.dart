class ApiConstants {
  static const baseUrl = String.fromEnvironment("BrainFoodBackendIP", defaultValue: "brainfood.azurewebsites.net");
  static String signupEndPoint = "/signup";
  static String signinEndPoint = "/signin";
  static String homeEndPoint = "/home";
}