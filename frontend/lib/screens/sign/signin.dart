import 'package:flutter/material.dart';
import 'package:flutter_svg/svg.dart';
import 'package:recipe_recommender_frontend/api/session.dart';
import 'package:recipe_recommender_frontend/api/sign_api.dart';
import 'package:recipe_recommender_frontend/constants.dart';
import 'package:recipe_recommender_frontend/screens/sign/forgetPassword.dart';
import 'package:recipe_recommender_frontend/screens/sign/signup.dart';
import 'package:recipe_recommender_frontend/screens/sign/widgets/custom_button.dart';
import 'package:recipe_recommender_frontend/screens/sign/widgets/text_field.dart';

import '../page_view_controller.dart';

class SignInPage extends StatefulWidget {
  static String routeName = "/signin";
  final String initResp;

  const SignInPage({Key? key, required this.initResp}) : super(key: key);

  @override
  State<SignInPage> createState() => _SignInPageState();
}

class _SignInPageState extends State<SignInPage> {
  var usernameController = TextEditingController();
  var passwordController = TextEditingController();

  String resp = "";

  Future<void> _signin() async {
    String? status = await SignAPI.signin(
        usernameController.text.trim(), passwordController.text.trim());
    debugPrint(status);
    if (status == "wrong credentials") {
      setState(() {
        resp = "Wrong credentials";
      });
    } else if (status == "right credentials") {
      Session.login = true;
      // ignore: use_build_context_synchronously
      Navigator.of(context).pushAndRemoveUntil(
          MaterialPageRoute(
              builder: (BuildContext context) => const PageViewController()),
              (route) => false);
    }
  }

  @override
  void initState() {
    resp = widget.initResp;
    super.initState();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        resizeToAvoidBottomInset: false,
        body: Stack(
          children: [
            Positioned(
              top: MediaQuery.of(context).size.height * 0.8,
              left: MediaQuery.of(context).size.width * 0.06,
              child: SvgPicture.asset(
                  "assets/images/bottom.svg",
                color: Colors.orange,
              ),
            ),
            Center(
                child: SingleChildScrollView(
                  child: Padding(
                    padding: const EdgeInsetsDirectional.fromSTEB(20, 0, 20, 0),
                    child: Column(
                      crossAxisAlignment: CrossAxisAlignment.center,
                      mainAxisAlignment: MainAxisAlignment.center,
                      mainAxisSize: MainAxisSize.max,
                      children: <Widget>[
                        Container(
                            width: MediaQuery
                                .of(context)
                                .size
                                .width / 2,
                            padding: const EdgeInsets.fromLTRB(20, 20, 20, 40),
                            child: const Image(
                                image: AssetImage("assets/images/Logo.png"),
                                fit: BoxFit.fill)),
                        CustomTextField(
                          hintText: "Enter your username here..",
                          labelText: "Username",
                          bottomMargin: 20,
                          controller: usernameController,
                          obscureText: false,
                        ),
                        CustomTextField(
                          hintText: "Enter your password here..",
                          labelText: "Password",
                          bottomMargin: 15,
                          controller: passwordController,
                          obscureText: true,
                        ),
                        Row(
                            mainAxisAlignment: MainAxisAlignment.spaceBetween,
                            children: [
                              TextButton(
                                onPressed: () {
                                  setState(() {
                                    resp = "";
                                  });
                                  Navigator.push(
                                      context,
                                      MaterialPageRoute(
                                          builder: (context) =>
                                          const ForgetPasswordPage()));
                                },
                                child: const Padding(
                                  padding: EdgeInsetsDirectional.fromSTEB(
                                      10, 0, 10, 0),
                                  child: Text(
                                    'Forgot Password?',
                                    style: TextStyle(
                                      fontSize: 16,
                                      fontWeight: FontWeight.bold,
                                      fontFamily: "Roboto",
                                      color: Colors.black87,
                                    ),
                                  ),
                                ),
                              ),
                              CustomButton(onPressFn: _signin, text: "Sign in")
                            ]),
                        Row(
                          mainAxisSize: MainAxisSize.max,
                          mainAxisAlignment: MainAxisAlignment.center,
                          children: [
                            Padding(
                              padding: const EdgeInsetsDirectional.fromSTEB(
                                  20, 0, 0, 0),
                              child: Text(
                                "Don't have an account?",
                                style: TextStyle(
                                  fontSize: 14,
                                  fontWeight: FontWeight.bold,
                                  fontFamily: "Roboto",
                                  color: Colors.grey.shade800,
                                ),
                              ),
                            ),
                            Padding(
                              padding: const EdgeInsetsDirectional.fromSTEB(
                                  0, 0, 20, 0),
                              child: TextButton(
                                onPressed: () {
                                  Navigator.push(
                                      context,
                                      MaterialPageRoute(
                                          builder: (context) =>
                                          const SignUpPage()));
                                },
                                child: const Text(
                                  'Create Account',
                                  style: TextStyle(
                                      fontSize: 16,
                                      fontWeight: FontWeight.bold,
                                      color: Constants.primaryColor),
                                ),
                              ),
                            ),
                          ],
                        ),
                        Text(
                          resp,
                          style: const TextStyle(
                              color: Colors.red, fontSize: 15),
                        )
                      ],
                    ),
                  ),
                )),
          ],
        ));
  }
}
