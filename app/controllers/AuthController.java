package controllers;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import com.fasterxml.jackson.databind.JsonNode;

import models.MigrUser;
import models.User;
import play.Logger;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import scala.util.parsing.json.JSONObject;
import utilities.JWTUtilities;

public class AuthController extends Controller {
	
	private static final User user1 = new User(1, "omor", "1234");
	

	//Voluntary
	public Map<String, Object> get_Volun_User_respns() {
		Map<String, Object> user1response = new HashMap<>();
		user1response.put("status", "SUCCESS");
		
		Map<String, Object> user1migrData = new HashMap<>();
		user1migrData.put("status", "VOLUNTARY");
		user1migrData.put("reminderDays", 30);
		user1migrData.put("forceMigrationDate", "December 09, 2018");
		
		Map<String, Object> user1Data = new HashMap<>();
		user1Data.put("guid", "c828660d-c59c-4b64-ae78-235689681127");
		user1Data.put("authenticationTime", "2018-07-13 01:31:07 +0000");
		user1Data.put("migrationData", user1migrData);
		
		user1response.put("data",user1Data);
		return user1response;
	}
	
	//SemiVolunatry
	public Map<String, Object> get_SemiVolun_User_respns() {
		Map<String, Object> user1response = new HashMap<>();
		user1response.put("status", "SUCCESS");
		
		Map<String, Object> user1migrData = new HashMap<>();
		user1migrData.put("status", "VOLUNTARY");
		user1migrData.put("reminderDays", 7);
		user1migrData.put("forceMigrationDate", "December 09, 2018");
		
		Map<String, Object> user1Data = new HashMap<>();
		user1Data.put("guid", "c828660d-c59c-4b64-ae78-235689681127");
		user1Data.put("authenticationTime", "2018-07-13 01:31:07 +0000");
		user1Data.put("migrationData", user1migrData);
		
		user1response.put("data",user1Data);
		return user1response;
	}
	
	
	//Mandatory
	public Map<String, Object> get_Mand_User_respns() {
		Map<String, Object> user1response = new HashMap<>();
		user1response.put("status", "SUCCESS");
		
		Map<String, Object> user1migrData = new HashMap<>();
		user1migrData.put("status", "MANDATORY");
		
		Map<String, Object> user1Data = new HashMap<>();
		user1Data.put("guid", "c828660d-c59c-4b64-ae78-235689681127");
		user1Data.put("authenticationTime", "2018-07-13 01:31:07 +0000");
		user1Data.put("migrationData", user1migrData);
		
		user1response.put("data",user1Data);
		return user1response;
	}
	
	
	//None
	public Map<String, Object> get_None_User_respns() {
		Map<String, Object> user1response = new HashMap<>();
		user1response.put("status", "SUCCESS");
		
		Map<String, Object> user1migrData = new HashMap<>();
		user1migrData.put("status", "NONE");
		
		Map<String, Object> user1Data = new HashMap<>();
		user1Data.put("guid", "c828660d-c59c-4b64-ae78-235689681127");
		user1Data.put("authenticationTime", "2018-07-13 01:31:07 +0000");
		user1Data.put("migrationData", user1migrData);
		
		user1response.put("data",user1Data);
		return user1response;
	}
	
	//Initiated
	public Map<String, Object> get_Initiated_User_respns() {
		Map<String, Object> user1response = new HashMap<>();
		user1response.put("status", "SUCCESS");
		
		Map<String, Object> user1migrData = new HashMap<>();
		user1migrData.put("status", "INITIATED");
		user1migrData.put("emailAddress", "abs@gmail.com");
		
		Map<String, Object> user1Data = new HashMap<>();
		user1Data.put("guid", "c828660d-c59c-4b64-ae78-235689681127");
		user1Data.put("authenticationTime", "2018-07-13 01:31:07 +0000");
		user1Data.put("migrationData", user1migrData);
		
		user1response.put("data",user1Data);
		return user1response;
	}
	
	//Initiated but Expired
		public Map<String, Object> get_Initiated_Expired_User_respns() {
			Map<String, Object> user1response = new HashMap<>();
			user1response.put("status", "SUCCESS");
			
			Map<String, Object> user1migrData = new HashMap<>();
			user1migrData.put("status", "INITIATED_EXPIRED");
			user1migrData.put("emailAddress", "abs@gmail.com");
			
			Map<String, Object> user1Data = new HashMap<>();
			user1Data.put("guid", "c828660d-c59c-4b64-ae78-235689681127");
			user1Data.put("authenticationTime", "2018-07-13 01:31:07 +0000");
			user1Data.put("migrationData", user1migrData);
			
			user1response.put("data",user1Data);
			return user1response;
		}
	
	
	
	
	
		
		
	//post
	public Result authenticate() {
		
        //Logger.info(request().body().asRaw().toString());
		//JsonNode jsonNode = request().body().asJson();
		//String name = jsonNode.findPath("name").textValue();
		//Logger.info(name);
		//MigrUser user = Json.fromJson(jsonNode,MigrUser.class);
		//Logger.info("A log message from post method : " + user.toString());
		
		String user = "user1";
		Map<String, Object> response;
		switch (user) {
		case "user1":
			 response = get_Volun_User_respns();
			return ok(Json.toJson(response));
			
		case "user2":
			response = get_SemiVolun_User_respns();
			return ok(Json.toJson(response));
		
		case "user3":
			response = get_Mand_User_respns();
			return ok(Json.toJson(response));
			
		case "user4":
			response = get_None_User_respns();
			return ok(Json.toJson(response));
			
		default:
			return badRequest("Authentication failed");
		}
 
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	//get
	public Result authenticateGet() {
		
        Random random = new Random();
        int ran_int = random.nextInt(6);
        
        Logger.info("In the authentication method");
        
        Map<String, Object> response;
		switch (1) {
		case 0:
			 response = get_Volun_User_respns();
			return ok(Json.toJson(response));
			
		case 1:
			response = get_SemiVolun_User_respns();
			return ok(Json.toJson(response));
		
		case 2:
			response = get_Mand_User_respns();
			return ok(Json.toJson(response));
			
		case 3:
			response = get_None_User_respns();
			return ok(Json.toJson(response));
			
		case 4:
			response = get_Initiated_User_respns();
			return ok(Json.toJson(response));
			
		case 5:
			response = get_Initiated_Expired_User_respns();
			return ok(Json.toJson(response));
			
		default:
			return badRequest("Authentication failed");
		}
        
		
	}
	
	

	
	
	
	
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
