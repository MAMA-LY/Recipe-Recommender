import 'package:flutter/material.dart';
import 'package:flutter_svg/svg.dart';
import 'package:recipe_recommender_frontend/api/sign_api.dart';
import 'package:recipe_recommender_frontend/screens/sign/signin.dart';
import 'package:recipe_recommender_frontend/screens/sign/widgets/custom_button.dart';
import 'package:recipe_recommender_frontend/screens/sign/widgets/text_field.dart';

import '../../constants.dart';

class ChangePasswordPage extends StatefulWidget {
  static String routeName = "/forgetPassword";
  final String tk;

  const ChangePasswordPage({Key? key, required this.tk}) : super(key: key);

  @override
  State<ChangePasswordPage> createState() => _ResetPasswordPageState();
}

class _ResetPasswordPageState extends State<ChangePasswordPage> {
  var passwordController = TextEditingController();
  var confirmPasswordController = TextEditingController();

  bool loading = false;

  var responseTextController = TextEditingController();
  String resp = "";

  Future<void> _changePassword() async {
    setState(() {
      loading = true;
    });
    String ps1 = passwordController.text;
    String ps2 = confirmPasswordController.text;
    if (ps1 == ps2) {
      String? body = await SignAPI.changePassword(ps1, widget.tk)
          .whenComplete(() => setState(() {
                loading = false;
              }));
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
    if (!loading) {
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
                      hintText: "Enter your password here..",
                      labelText: "Password",
                      bottomMargin: 20,
                      controller: passwordController,
                      obscureText: true,
                      icon: Icons.password,
                    ),
                    CustomTextField(
                      hintText: "Enter your password here..",
                      labelText: "Confirm Password",
                      bottomMargin: 15,
                      controller: confirmPasswordController,
                      obscureText: true,
                      icon: Icons.password,
                    ),
                    Row(
                      mainAxisSize: MainAxisSize.min,
                      mainAxisAlignment: MainAxisAlignment.center,
                      children: [
                        CustomButton(
                            onPressFn: _changePassword,
                            text: "Change password"),
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
                                color: Colors.grey.shade800,
                              ),
                            ),
                          ),
                          TextButton(
                            onPressed: () {
                              setState(() {
                                resp = "";
                              });
                              Navigator.of(context, rootNavigator: true)
                                  .pushReplacement(MaterialPageRoute(
                                      builder: (context) => const SignInPage(
                                            initResp: "",
                                          )));
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
                        style: resp == "Password Changed Successfully"
                            ? const TextStyle(color: Colors.green, fontSize: 20)
                            : const TextStyle(color: Colors.red, fontSize: 20))
                  ],
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
