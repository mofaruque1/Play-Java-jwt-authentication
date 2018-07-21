package controllers;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import com.fasterxml.jackson.databind.JsonNode;

import models.MigrUser;
import models.User;
import models.UserDB;
import play.Logger;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import scala.util.parsing.json.JSONObject;
import utilities.JWTUtilities;

public class AuthController extends Controller {

	public static User user;
	public UserDB userDB = new UserDB();

	public Map<String, Object> get_User_respns() {
		Map<String, Object> userResponse = new HashMap<>();
		userResponse.put("status", "SUCCESS");

		Map<String, Object> user1migrData = new HashMap<>();
		user1migrData.put("status", user.migrStatus);

		if (user.migrStatus.equals("VOLUNTARY")) {
			user1migrData.put("reminderDays", user.reminderDays);
			user1migrData.put("forceMigrationDate", user.forceMigrDate);
		} else if (user.migrStatus.equals("INITIATED") || user.migrStatus.equals("INITIATED_EXPIRED")) {
			user1migrData.put("emailAddress", user.newUserName);
		}

		Map<String, Object> user1Data = new HashMap<>();
		user1Data.put("guid", user.guid);
		user1Data.put("authenticationTime", user.authenticationTime);
		user1Data.put("migrationData", user1migrData);

		userResponse.put("data", user1Data);
		return userResponse;
	}

	// post
	public Result authenticate() {

		JsonNode jsonNode = request().body().asJson();
		String name = jsonNode.findPath("username").textValue();
		Logger.info(name);

		user = UserDB.findUser(name);

		Map<String, Object> response;

		if (user != null) {
			Logger.info(user.oldUserName);
			response = get_User_respns();
			return ok(Json.toJson(response));
		}
		return badRequest("Authentication failed");
	}

	// PUT
	public Result setReminerDays() {
		JsonNode jsonNode = request().body().asJson();
		String guid = jsonNode.findPath("guid").textValue();
		Logger.info(guid);
		Map<String, Object> response = new HashMap<String, Object>();
		boolean result = UserDB.setReminderdaysByGuid(guid);
		if (result) {
			response.put("status", "SUCCESS");
		} else {
			response.put("status", "FAILED");
		}
		return ok(Json.toJson(response));
	}

}
