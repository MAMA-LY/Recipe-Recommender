import 'dart:io';

import 'package:path_provider/path_provider.dart';
import 'package:recipe_recommender_frontend/api/session.dart';

class SessionManager {
  Session session;

  SessionManager(this.session);

  void saveSessionInCache(String path, File file) {
    file.writeAsString(session.cookie);
  }
  
}
