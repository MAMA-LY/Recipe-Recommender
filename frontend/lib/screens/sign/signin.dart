import 'dart:convert';

import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;
import 'package:path_provider/path_provider.dart';
import 'package:recipe_recommender_frontend/api/session.dart';
import 'package:recipe_recommender_frontend/screens/home/home.dart';
import 'package:recipe_recommender_frontend/screens/sign/ResponseEnum.dart';
import 'package:recipe_recommender_frontend/screens/sign/signup.dart';

import '../../main.dart';
import '../nav/bottom_nav_screen.dart';

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

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
        title: 'Flutter Demo',
        debugShowCheckedModeBanner: false,
        theme: ThemeData(
          primarySwatch: Colors.orange,
        ),
        home: Scaffold(
            appBar: AppBar(
              title: const Text('Login Screen'),
            ),
            body: Center(
              child: Column(
                crossAxisAlignment: CrossAxisAlignment.center,
                mainAxisAlignment: MainAxisAlignment.center,
                children: <Widget>[
                  Container(
                    width: MediaQuery.of(context).size.width / 3,
                    padding: const EdgeInsets.fromLTRB(20, 20, 20, 70),
                    child: const Image(image: AssetImage("assets/images/Logo.png"), fit: BoxFit.fill)
                  ),
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
                        child: const Text('Sign in'),
                        onPressed: () async {
                          var url = Uri.http("localhost:8080", "/signin");
                          var creds = {
                            "username": usernameController.text,
                            "password": passwordController.text
                          };
                          var response = await http.post(url, body: creds);
                          var cookie = response.headers['set-cookie'];
                          var responseLocation = response.headers['location'];
                          if(responseLocation == "http://localhost:8080/signin?error") {
                            setState(() {
                              resp = "Wrong Credentials";
                            });
                          }
                          if(responseLocation == "http://localhost:8080/home" && cookie != null) {{
                            session.cookie = cookie;
                            cacheFile = await cacheFile!.writeAsString(session.cookie);
                            var urlHome = Uri.http("localhost:8080", "/home");
                            var responseHome = await http.post(url, headers: {"cookie" : cookie});
                            Navigator.push(
                                context,
                                MaterialPageRoute(
                                    builder: (context) =>
                                        const BottomNavView()));
                          }}
                        
                        },
                      )),
                  TextButton(
                    onPressed: () {
                      Navigator.push(
                          context,
                          MaterialPageRoute(
                              builder: (context) => const BottomNavView()));
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
            )));
  }
}
