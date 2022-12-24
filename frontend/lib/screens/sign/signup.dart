import 'package:email_validator/email_validator.dart';
import 'package:flutter/material.dart';
import 'package:flutter_svg/svg.dart';
import 'package:recipe_recommender_frontend/api/sign_api.dart';
import 'package:recipe_recommender_frontend/constants.dart';
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
    bool emailValid = EmailValidator.validate(emailController.text.trim());
    if (emailValid) {
      String? body = await SignAPI.signup(usernameController.text.trim(),
          passwordController.text.trim(), emailController.text.trim());
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
    return Scaffold(
            resizeToAvoidBottomInset: false,
            body: Stack(
              children: [
                Positioned(
                  top: MediaQuery.of(context).size.height * 0.85,
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
                                width: MediaQuery.of(context).size.width / 2,
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
                              hintText: "Enter your email here..",
                              labelText: "Email",
                              bottomMargin: 20,
                              controller: emailController,
                              obscureText: true,
                            ),
                            CustomTextField(
                              hintText: "Enter your password here..",
                              labelText: "Password",
                              bottomMargin: 15,
                              controller: passwordController,
                              obscureText: true,
                            ),
                            Row(
                              mainAxisSize: MainAxisSize.min,
                              mainAxisAlignment: MainAxisAlignment.center,
                              children: [
                                CustomButton(onPressFn: _signup, text: "Sign up"),
                              ],
                            ),
                            Row(
                              mainAxisSize: MainAxisSize.min,
                                mainAxisAlignment: MainAxisAlignment.spaceBetween,
                                children: [
                                  Padding(
                                    padding: const EdgeInsetsDirectional.fromSTEB(20, 0, 0, 0),
                                    child: Text(
                                      "Have an account?",
                                      style: TextStyle(
                                        fontSize: 14,
                                        fontWeight: FontWeight.bold,
                                        fontFamily: "Roboto",
                                        color: Colors.grey.shade800,
                                      ),
                                    ),
                                  ),
                                  TextButton(
                                    onPressed: () {
                                      setState(() {
                                        resp = "";
                                      });
                                      Navigator.pop(context);
                                    },
                                    child: const Text(
                                      'Sign in',
                                      style: TextStyle(
                                        color: Constants.primaryColor,
                                        fontWeight: FontWeight.bold,
                                        fontSize: 16,
                                      ),
                                    ),
                                  ),
                                ]
                            ),
                            Text(resp,
                                style: resp == "Account is Created Successfully"
                                    ? const TextStyle(color: Colors.green, fontSize: 20)
                                    : const TextStyle(color: Colors.red, fontSize: 20))
                          ],
                        ),
                      ),
                    )),
              ],
            ));
  }
}
