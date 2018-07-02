package controllers;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;

import models.Student;
import play.Logger;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

public class JSONController extends Controller {
	
	public Result usingMap() {
		Map<String, Object> result = new HashMap<>();
		result.put("name", "Omor Faruque");
		result.put("track", "Unique");
		result.put("talk", "Restful services");
		result.put("Schedule", "Moday");
		return ok(Json.toJson(result));
	}
	
	public Result returnObject() {
		
		Student student = new Student(34, "Altaf", "12th");
		
		return ok(Json.toJson(student));
	}
	
	public Result catchObject() {
		JsonNode jsonNode = request().body().asJson();
		Student student = Json.fromJson(jsonNode, Student.class);
		Logger.info("A log message : " + student.toString());
		return ok(Json.toJson(student));
	}

}
