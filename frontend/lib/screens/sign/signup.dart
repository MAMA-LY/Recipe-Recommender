
import 'dart:io';

import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;
import 'package:recipe_recommender_frontend/screens/sign/ResponseEnum.dart';
import 'package:email_validator/email_validator.dart';

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
            appBar: AppBar(
              title: const Text('Sign up Screen'),
            ),
            body: Center(
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
                  Container(
                    padding: const EdgeInsets.fromLTRB(20, 20, 20, 0),
                    child: TextField(
                      controller: usernameController,
                      decoration: InputDecoration(
                        border: OutlineInputBorder(
                          borderRadius: BorderRadius.circular(90.0),
                        ),
                        labelText: 'Username',
                      ),
                    ),
                  ),
                  Container(
                    padding: const EdgeInsets.fromLTRB(20, 20, 20, 0),
                    child: TextField(
                      controller: emailController,
                      decoration: InputDecoration(
                        border: OutlineInputBorder(
                          borderRadius: BorderRadius.circular(90.0),
                        ),
                        labelText: 'Email',
                      ),
                    ),
                  ),
                  Container(
                    padding: const EdgeInsets.fromLTRB(20, 20, 20, 0),
                    child: TextField(
                      controller: passwordController,
                      obscureText: true,
                      decoration: InputDecoration(
                        border: OutlineInputBorder(
                          borderRadius: BorderRadius.circular(90.0),
                        ),
                        labelText: 'Password',
                      ),
                    ),
                  ),
                  Container(
                      height: 80,
                      padding: const EdgeInsets.all(20),
                      child: ElevatedButton(
                        style: ElevatedButton.styleFrom(
                          minimumSize: const Size.fromHeight(50),
                        ),
                        child: const Text('Sign up'),
                        onPressed: () async {
                          bool emailValid =
                              EmailValidator.validate(emailController.text);
                          if (emailValid) {
                            var url = Uri.http(
                                "${const String.fromEnvironment("BrainFoodBackendIP", defaultValue: "localhost")}:8080",
                                "/signup");
                            var creds = {
                              "username": usernameController.text,
                              "password": passwordController.text,
                              "email": emailController.text
                            };
                            var response =
                                await http.post(url, body: creds, headers: {
                              "Access-Control-Allow-Origin": "*",
                              "Access-Control-Allow-Methods":
                                  "POST, OPTIONS, GET",
                              "Access-Control-Allow-Headers":
                                  "Origin,Content-Type,X-Amz-Date,Authorization,X-Api-Key,X-Amz-Security-Token,locale",
                            });
                            setState(() {
                              responseTextController.text = response.body;
                              switch (response.body) {
                                case "EmailAlreadyExists":
                                  resp =
                                      "An account with this email address already exists";
                                  break;
                                case "UsernameAlreadyExists":
                                  resp = "This username is already taken";
                                  break;
                                case "UserCreated":
                                  resp = "Account is Created Successfully";
                                  break;
                              }
                            });
                            debugPrint(response.body);
                          } else {
                            setState(() {
                              resp = "Please enter a valid email address";
                            });
                          }
                        },
                      )),
                  TextButton(
                    onPressed: () {
                      setState(() {
                        resp = "";
                      });
                      Navigator.pop(context);
                    },
                    child: Text(
                      'Sign in',
                      style: TextStyle(color: Colors.grey[600]),
                    ),
                  ),
                  Text(resp,
                      style: resp == "Account is Created Successfully"
                          ? const TextStyle(color: Colors.green, fontSize: 20)
                          : const TextStyle(color: Colors.red, fontSize: 20))
                ],
              ),
            )));
  }
}

