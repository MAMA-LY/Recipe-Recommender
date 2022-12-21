import 'package:flutter/material.dart';
import 'package:recipe_recommender_frontend/api/sign_api.dart';
import 'package:recipe_recommender_frontend/screens/sign/signup.dart';
import 'package:recipe_recommender_frontend/screens/sign/widgets/custom_button.dart';
import 'package:recipe_recommender_frontend/screens/sign/widgets/text_field.dart';

import '../page_view_controller.dart';

class SignInPage extends StatefulWidget {
  static String routeName = "/signin";

  const SignInPage({Key? key}) : super(key: key);

  @override
  State<SignInPage> createState() => _SignInPageState();
}

class _SignInPageState extends State<SignInPage> {
  var usernameController = TextEditingController();
  var passwordController = TextEditingController();

  String resp = "";

  Future<void> _signin() async {
    String? status =
        await SignAPI.signin(usernameController.text, passwordController.text);
    debugPrint(status);
    if (status == "wrong credentials") {
      setState(() {
        resp = "Wrong credentials";
      });
    } else if (status == "right credentials") {
      // ignore: use_build_context_synchronously
      Navigator.of(context).pushAndRemoveUntil(
          MaterialPageRoute(
              builder: (BuildContext context) => const PageViewController()),
          (route) => false);
    }
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
        debugShowCheckedModeBanner: false,
        theme: ThemeData(
          primarySwatch: Colors.orange,
        ),
        home: Scaffold(
            resizeToAvoidBottomInset: false,
            body: Center(
                child: SingleChildScrollView(
              child: Column(
                crossAxisAlignment: CrossAxisAlignment.center,
                mainAxisAlignment: MainAxisAlignment.center,
                children: <Widget>[
                  Container(
                      width: MediaQuery.of(context).size.width / 2,
                      padding: const EdgeInsets.fromLTRB(20, 20, 20, 40),
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
                    promptText: "Password",
                    bottomPadding: 20,
                    controller: passwordController,
                    obscureText: true,
                  ),
                  CustomButton(onPressFn: _signin, text: "Sign in"),
                  TextButton(
                    onPressed: () {
                      setState(() {
                        resp = "";
                      });
                      Navigator.push(
                          context,
                          MaterialPageRoute(
                              builder: (context) =>
                                  const PageViewController()));
                    },
                    child: Text(
                      'Forgot Password?',
                      style: TextStyle(color: Colors.grey[600]),
                    ),
                  ),
                  TextButton(
                    onPressed: () {
                      Navigator.push(
                          context,
                          MaterialPageRoute(
                              builder: (context) => const SignUpPage()));
                    },
                    child: Text(
                      'Don\'t have an account?',
                      style: TextStyle(color: Colors.grey[600]),
                    ),
                  ),
                  Text(
                    resp,
                    style: const TextStyle(color: Colors.red, fontSize: 15),
                  )
                ],
              ),
            ))));
  }
}
