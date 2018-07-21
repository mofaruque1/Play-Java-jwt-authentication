package models;

import java.util.ArrayList;
import java.util.List;

public class UserDB {
	
	public static List<User> userList;
	
	public UserDB() {
		initiateDB();
	}
	
	public void initiateDB() {
		userList = new ArrayList<>();
		User user1 = new User();
		user1.oldUserName="User1";
		user1.reminderDays=30;
		user1.migrStatus="VOLUNTARY";
		
		User user2 = new User();
		user2.oldUserName="User2";
		user2.reminderDays=7;
		user2.migrStatus="VOLUNTARY";
		
		
		User user3 = new User();
		user3.oldUserName="User3";
		user3.reminderDays=0;
		user3.migrStatus="MANDATORY";
		
		User user4 = new User();
		user4.oldUserName="User4";
		user4.reminderDays=0;
		user4.migrStatus="NONE";
		
		
		User user5 = new User();
		user5.oldUserName="User5";
		user5.reminderDays=0;
		user5.migrStatus="INITIATED";
		user5.newUserName="abc@gmail.com";
		
		User user6 = new User();
		user6.oldUserName="User6";
		user6.reminderDays=0;
		user6.migrStatus="INITIATED_EXPIRED";
		user6.newUserName="abc@gmail.com";
		
		userList.add(user1);
		userList.add(user2);
		userList.add(user3);
		userList.add(user4);
		userList.add(user5);
		userList.add(user6);
	}
	
	

	
	public static List<User> getUsers() {
		return userList;
	}
	
	
//	public static boolean setReminderdays(String userName, int reminderDays) {
//	
//		User temp = findUser(userName);
//		if(temp!=null) {
//			temp.migrStatus="NONE";
//			temp.reminderDays = 30;
//			return true;
//		}
//		return false;
//	}
	
	
	
	
	//helper method
	public static User findUser(String userName) {
		List<User> userList = getUsers();
		for (User user : userList) {
			if(user.oldUserName.equals(userName)) {
				return user;
			}
		}
		return null;
	}
	
	
	//helper method
	public static boolean setReminderdaysByGuid(String guid) {
			
			for (User user : userList) {
				if(user.guid.equals(guid)) {
					user.reminderDays=0;
					user.migrStatus="NONE";
					return true;
				}
			}
			return false;
		}
	
	
	
	
	

}
