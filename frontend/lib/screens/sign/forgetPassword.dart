import 'package:email_validator/email_validator.dart';
import 'package:flutter/material.dart';
import 'package:flutter_svg/svg.dart';
import 'package:recipe_recommender_frontend/api/sign_api.dart';
import 'package:recipe_recommender_frontend/constants.dart';
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
    return Scaffold(
        backgroundColor: Theme.of(context).secondaryHeaderColor,
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
              child: Column(
                crossAxisAlignment: CrossAxisAlignment.center,
                mainAxisAlignment: MainAxisAlignment.center,
                children: <Widget>[
                  Container(
                      width: MediaQuery.of(context).size.width / 2,
                      padding: const EdgeInsets.fromLTRB(20, 20, 20, 70),
                      child: const Image(
                          image: AssetImage("assets/images/Logo.png"),
                          fit: BoxFit.fill)),
                  CustomTextField(
                    hintText: "Enter your email here..",
                    labelText: "Email",
                    bottomMargin: 20,
                    controller: emailController,
                    obscureText: true,
                    icon: Icons.email_outlined,
                  ),
                  Row(
                    mainAxisSize: MainAxisSize.min,
                    mainAxisAlignment: MainAxisAlignment.center,
                    children: [
                      CustomButton(
                          onPressFn: _forgetPassword, text: "Reset Password"),
                    ],
                  ),
                  Row(
                    mainAxisSize: MainAxisSize.min,
                    mainAxisAlignment: MainAxisAlignment.center,
                    children: [
                      Padding(
                        padding:
                            const EdgeInsetsDirectional.fromSTEB(20, 0, 0, 0),
                        child: Text(
                          "Reset?",
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
                            fontWeight: FontWeight.w900,
                            fontSize: 16,
                          ),
                        ),
                      ),
                    ],
                  ),
                  Text(resp,
                      style: resp == "Reset password email is sent"
                          ? const TextStyle(color: Colors.green, fontSize: 20)
                          : const TextStyle(color: Colors.red, fontSize: 20))
                ],
              ),
            )),
          ],
        ));
  }
}
