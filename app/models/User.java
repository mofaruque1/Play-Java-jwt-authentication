package models;

public class User {
	public int id;
	public String userName;
	public String userPassword;
	
	public User() {}

	public User(int id, String userName, String userPassword) {
		this.id = id;
		this.userName = userName;
		this.userPassword = userPassword;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", userPassword=" + userPassword + "]";
	}
	

}
