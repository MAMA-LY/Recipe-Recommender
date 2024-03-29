import 'package:email_validator/email_validator.dart';
import 'package:flutter/material.dart';
import 'package:flutter_svg/svg.dart';
import 'package:recipe_recommender_frontend/api/sign_api.dart';
import 'package:recipe_recommender_frontend/constants.dart';
import 'package:recipe_recommender_frontend/screens/sign/widgets/custom_button.dart';
import 'package:recipe_recommender_frontend/screens/sign/widgets/date_field.dart';
import 'package:recipe_recommender_frontend/screens/sign/widgets/text_field.dart';

import 'widgets/gender_field.dart';
import 'widgets/genders.dart';

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
  var dateController = TextEditingController();
  var heightController = TextEditingController();
  var weightController = TextEditingController();
  String gender = Gender.others.toString().split('.').last;
  var responseTextController = TextEditingController();
  String resp = "";
  bool loading = false;

  Future<void> _signup() async {
    setState(() {
      loading = true;
    });
    bool emailValid = EmailValidator.validate(emailController.text.trim());
    if (emailValid &&
        usernameController.text.trim() != "" &&
        passwordController.text.trim() != "" &&
        emailController.text.trim() != "" &&
        heightController.text.trim() != "" &&
        weightController.text.trim() != "" &&
        dateController.text.trim() != "") {
      String? body = await SignAPI.signup(
        usernameController.text.trim(),
        passwordController.text.trim(),
        emailController.text.trim(),
        heightController.text.trim(),
        weightController.text.trim(),
        gender,
        dateController.text.trim(),
      ).whenComplete(() => {
            setState(() {
              loading = false;
            })
          });
      setState(() {
        responseTextController.text = body!;
        switch (body) {
          case "EmailAlreadyExists":
            resp = "An account with this email address already exists";
            break;
          case "UsernameAlreadyExists":
            resp = "This username is already taken";
            break;
          case "MissingInputs":
            resp = "Some input fields were missing";
            break;
          case "UserCreated":
            resp = "Account is Created Successfully";
            break;
        }
      });
      debugPrint(body);
    } else {
      setState(() {
        if (!emailValid) {
          loading = false;
          resp = "Please enter a valid email address";
        } else {
          loading = false;
          resp = "Some input fields were missing";
        }
      });
    }
  }

  @override
  Widget build(BuildContext context) {
    responseTextController.text = "";
    if (!loading) {
      return Scaffold(
          backgroundColor: Theme.of(context).secondaryHeaderColor,
          resizeToAvoidBottomInset: false,
          body: Stack(
            children: [
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
                          padding: const EdgeInsets.fromLTRB(20, 35, 20, 25),
                          child: const Image(
                              image: AssetImage("assets/images/Logo.png"),
                              fit: BoxFit.fill)),
                      const SizedBox(height: 2),
                      CustomTextField(
                        hintText: "Enter your username here..",
                        labelText: "Username",
                        bottomMargin: 20,
                        controller: usernameController,
                        obscureText: false,
                        icon: Icons.person,
                      ),
                      const SizedBox(height: 2),
                      CustomTextField(
                        hintText: "Enter your email here..",
                        labelText: "Email",
                        bottomMargin: 20,
                        controller: emailController,
                        obscureText: false,
                        email: true,
                        icon: Icons.email_outlined,
                      ),
                      const SizedBox(height: 2),
                      CustomTextField(
                        hintText: "Enter your password here..",
                        labelText: "Password",
                        bottomMargin: 15,
                        controller: passwordController,
                        obscureText: true,
                        icon: Icons.password,
                      ),
                      const SizedBox(height: 2),
                      CustomTextField(
                        hintText: "Enter your height here..",
                        labelText: "Height (cm) ",
                        bottomMargin: 15,
                        controller: heightController,
                        obscureText: false,
                        numeric: true,
                        icon: Icons.height,
                      ),
                      const SizedBox(height: 2),
                      CustomTextField(
                        hintText: "Enter your weight here..",
                        labelText: "Weight (kg)",
                        bottomMargin: 15,
                        controller: weightController,
                        obscureText: false,
                        numeric: true,
                        icon: Icons.monitor_weight_outlined,
                      ),
                      const SizedBox(height: 2),
                      CustomDateField(
                        hintText: "Choose your birthdate",
                        labelText: "Birthdate",
                        bottomMargin: 15,
                        controller: dateController,
                      ),
                      Row(
                        children: [
                          Expanded(
                              child: GenderWidget(
                            onclick: () {
                              gender = Gender.male.toString().split('.').last;
                              setState(() {});
                            },
                            isSelected:
                                Gender.male.toString().split('.').last ==
                                    gender,
                            title: 'Male',
                            icon: Icons.man_outlined,
                          )),
                          Expanded(
                              child: GenderWidget(
                            onclick: () {
                              gender = Gender.female.toString().split('.').last;
                              setState(() {});
                            },
                            isSelected:
                                Gender.female.toString().split('.').last ==
                                    gender,
                            title: 'Female',
                            icon: Icons.woman_outlined,
                          )),
                        ],
                      ),
                      const SizedBox(height: 3),
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
                              padding: const EdgeInsetsDirectional.fromSTEB(
                                  20, 0, 0, 0),
                              child: Text(
                                "Have an account?",
                                style: TextStyle(
                                  fontSize: 14,
                                  fontWeight: FontWeight.bold,
                                  fontFamily: "Roboto",
                                  color: Theme.of(context).focusColor,
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
                          ]),
                      Text(resp,
                          style: resp == "Account is Created Successfully"
                              ? const TextStyle(
                                  color: Colors.green, fontSize: 20)
                              : const TextStyle(
                                  color: Colors.red, fontSize: 20)),
                      const SizedBox(height: 10),
                    ],
                  ),
                ),
              )),
            ],
          ));
    } else {
      return const Scaffold(
          body: Center(
              child: CircularProgressIndicator(color: Constants.primaryColor)));
    }
  }
}
