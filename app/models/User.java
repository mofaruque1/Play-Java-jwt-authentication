package models;

import org.joda.time.DateTime;

public class User {
	
	public String oldUserName;
	public String newUserName;
	public String authStatus;
	public String guid;
	public String authenticationTime;
	public String migrStatus;
	public int reminderDays;
	public String forceMigrDate;
	
	
	public User() {
		this.oldUserName="";
		this.newUserName="";
		this.authStatus="";
		this.guid="c828660d-c59c-4b64-ae78-235689681127";
		this.authenticationTime= new DateTime().toString();
		this.migrStatus="";
		this.reminderDays=0;
		this.forceMigrDate="July 25, 2018";
	}
	

}
