import 'package:email_validator/email_validator.dart';
import 'package:flutter/material.dart';
import 'package:recipe_recommender_frontend/api/sign_api.dart';
import 'package:recipe_recommender_frontend/screens/sign/widgets/custom_button.dart';
import 'package:recipe_recommender_frontend/screens/sign/widgets/text_field.dart';

class SignUpPage extends StatefulWidget {
  static String routeName = "/signup";

  const SignUpPage({Key? key}) : super(key: key);

  @override
  State<SignUpPage> createState() => _SignUpPageState();
}

class _SignUpPageState extends State<SignUpPage> {
  var usernameController = TextEditingController();
  var passwordController = TextEditingController();
  var emailController = TextEditingController();
  var responseTextController = TextEditingController();
  String resp = "";

  Future<void> _signup() async {
<<<<<<< HEAD
    bool emailValid = EmailValidator.validate(emailController.text);
    if (emailValid) {
      String? body = await SignAPI.signup(usernameController.text,
          passwordController.text, emailController.text);
=======
    bool emailValid = EmailValidator.validate(emailController.text.trim());
    if (emailValid) {
      String? body = await SignAPI.signup(usernameController.text.trim(),
          passwordController.text.trim(), emailController.text.trim());
>>>>>>> main
      setState(() {
        responseTextController.text = body!;
        switch (body) {
          case "EmailAlreadyExists":
            resp = "An account with this email address already exists";
            break;
          case "UsernameAlreadyExists":
            resp = "This username is already taken";
            break;
          case "UserCreated":
            resp = "Account is Created Successfully";
            break;
        }
      });
      debugPrint(body);
    } else {
      setState(() {
        resp = "Please enter a valid email address";
      });
    }
  }

  @override
  Widget build(BuildContext context) {
    responseTextController.text = "";
    return MaterialApp(
        title: 'Flutter Demo',
        debugShowCheckedModeBanner: false,
        theme: ThemeData(
          primarySwatch: Colors.orange,
        ),
        home: Scaffold(
            body: Center(
                child: SingleChildScrollView(
          child: Column(
            crossAxisAlignment: CrossAxisAlignment.center,
            mainAxisAlignment: MainAxisAlignment.center,
            children: <Widget>[
              Container(
                  width: MediaQuery.of(context).size.width / 3,
                  padding: const EdgeInsets.fromLTRB(20, 20, 20, 70),
                  child: const Image(
                      image: AssetImage("assets/images/Logo.png"),
                      fit: BoxFit.fill)),
              CustomTextField(
                promptText: "Username",
                bottomPadding: 25,
                controller: usernameController,
                obscureText: false,
              ),
              CustomTextField(
                promptText: "Email",
                bottomPadding: 25,
                controller: emailController,
                obscureText: false,
              ),
              CustomTextField(
                promptText: "Password",
                bottomPadding: 20,
                controller: passwordController,
                obscureText: false,
              ),
              CustomButton(onPressFn: _signup, text: "Sign up"),
              TextButton(
                onPressed: () {
                  setState(() {
                    resp = "";
                  });
                  Navigator.pop(context);
                },
                child: Text(
                  'Sign in',
                  style: TextStyle(
                    color: Colors.grey[600],
                    fontWeight: FontWeight.bold,
                    fontSize: 16,
                  ),
                ),
              ),
              Text(resp,
                  style: resp == "Account is Created Successfully"
                      ? const TextStyle(color: Colors.green, fontSize: 20)
                      : const TextStyle(color: Colors.red, fontSize: 20))
            ],
          ),
        ))));
  }
}
