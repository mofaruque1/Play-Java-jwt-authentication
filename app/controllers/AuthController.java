package controllers;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;

import models.User;
import play.Logger;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import utilities.JWTUtilities;

public class AuthController extends Controller {
	
	private static final User user1 = new User(1, "omor", "1234");
	
	
	public Result login() {
		
		JsonNode jsonNode = request().body().asJson();
		User user = Json.fromJson(jsonNode,User.class);
		Logger.info("A log message : " + user.toString());
		

		if(user.userName.equals(user1.userName)&& user.userPassword.equals(user1.userPassword)) {
			Map<String, Object> response = new HashMap<>();
			response.put("Status", "SUCCESS");
			response.put("Auth_Token", JWTUtilities.generateJWT(user1.userName));
			return ok(Json.toJson(response));
		}
		return badRequest("Authentication failed");
	}
	
	
	public Result returnToken() {
		String teString = JWTUtilities.generateJWT(user1);
		Logger.info(teString);
		return ok(teString);
	}
	
	public Result validateToken() {
		String token = request().body().asText();
		return ok("Is a valid token: "+JWTUtilities.validateJWT(token));
		
	}
}
