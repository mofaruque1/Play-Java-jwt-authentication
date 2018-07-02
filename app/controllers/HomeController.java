package controllers;

import play.libs.Json;
import play.mvc.*;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    public Result index() {
        return ok("hello java play app!");
    }
    
    public Result hello(String name) {
    	return ok("Hello "+name);
    }
    
    
    public Result returnStudents() {
    	Clients[] students = new Clients[2];
    	students[0] = new Clients(1, "Omor", "6th");
    	students[1] = new Clients(2, "Uumi", "6th");
    	return ok(Json.toJson(students));
    }
    
    
    
    private class Clients{
    	public int id;
    	public String name;
    	public String grade;
    	
    	public Clients(int id, String name, String grade) {
			// TODO Auto-generated constructor stub
    		this.id = id;
    		this.name = name;
    		this.grade = grade;
		}
    	
    }

}
