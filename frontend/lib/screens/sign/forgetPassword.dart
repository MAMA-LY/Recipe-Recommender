import 'package:email_validator/email_validator.dart';
import 'package:flutter/material.dart';
import 'package:recipe_recommender_frontend/api/sign_api.dart';
import 'package:recipe_recommender_frontend/screens/sign/widgets/custom_button.dart';
import 'package:recipe_recommender_frontend/screens/sign/widgets/text_field.dart';

class ForgetPasswordPage extends StatefulWidget {
  static String routeName = "/forgetPassword";

  const ForgetPasswordPage({Key? key}) : super(key: key);

  @override
  State<ForgetPasswordPage> createState() => _ForgetPasswordPageState();
}

class _ForgetPasswordPageState extends State<ForgetPasswordPage> {
  var emailController = TextEditingController();
  var responseTextController = TextEditingController();
  String resp = "";

  Future<void> _forgetPassword() async {
    bool emailValid = EmailValidator.validate(emailController.text.trim());
    if (emailValid) {
      String? body = await SignAPI.forgetPassword(emailController.text.trim());
      setState(() {
        responseTextController.text = body!;
        switch (body) {
          case "NoUserFoundByThisEmail":
            resp = "No Account is associated with this email";
            break;
          case "PasswordResetEmailSent":
            resp = "Reset password email is sent";
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
                promptText: "Email",
                bottomPadding: 25,
                controller: emailController,
                obscureText: false,
              ),
              CustomButton(onPressFn: _forgetPassword, text: "Reset Password"),
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
                  style: resp == "Reset password email is sent"
                      ? const TextStyle(color: Colors.green, fontSize: 20)
                      : const TextStyle(color: Colors.red, fontSize: 20))
            ],
          ),
        ))));
  }
}
