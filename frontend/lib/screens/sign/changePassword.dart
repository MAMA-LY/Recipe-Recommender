import 'package:email_validator/email_validator.dart';
import 'package:flutter/material.dart';
import 'package:recipe_recommender_frontend/api/sign_api.dart';
import 'package:recipe_recommender_frontend/screens/sign/signin.dart';
import 'package:recipe_recommender_frontend/screens/sign/widgets/custom_button.dart';
import 'package:recipe_recommender_frontend/screens/sign/widgets/text_field.dart';

class changePasswordPage extends StatefulWidget {
  static String routeName = "/forgetPassword";
  final String tk;
  const changePasswordPage({Key? key, required this.tk}) : super(key: key);

  @override
  State<changePasswordPage> createState() => _ResetPasswordPageState();
}

class _ResetPasswordPageState extends State<changePasswordPage> {
  var passwordController = TextEditingController();
  var confirmPasswordController = TextEditingController();

  var responseTextController = TextEditingController();
  String resp = "";

  Future<void> _changePassword() async {
    String ps1 = passwordController.text;
    String ps2 = confirmPasswordController.text;
    if (ps1 == ps2) {
      String? body = await SignAPI.changePassword(ps1, widget.tk);
      setState(() {
        responseTextController.text = body!;
        switch (body) {
          case "PasswordChanged":
            resp = "Password Changed Successfully";
            break;
        }
      });
      debugPrint(body);
    } else {
      setState(() {
        resp = "Those passwords don't match. Try again";
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
                promptText: "Password",
                bottomPadding: 25,
                controller: passwordController,
                obscureText: true,
              ),
              CustomTextField(
                promptText: "Confirm Password",
                bottomPadding: 25,
                controller: confirmPasswordController,
                obscureText: true,
              ),
              CustomButton(onPressFn: _changePassword, text: "Change password"),
              TextButton(
                onPressed: () {
                  setState(() {
                    resp = "";
                  });
                  Navigator.of(context, rootNavigator: true).pushReplacement(
                      MaterialPageRoute(
                          builder: (context) => const SignInPage(initResp: "",)));
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
                  style: resp == "Password Changed Successfully"
                      ? const TextStyle(color: Colors.green, fontSize: 20)
                      : const TextStyle(color: Colors.red, fontSize: 20))
            ],
          ),
        ))));
  }
}
