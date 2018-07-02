package models;

public class Student {
	
	public int id;
	public String name;
	public String grade;
	
	public Student() {
		
	}
	public Student(int id, String name, String grade) {
	
		this.id = id;
		this.name = name;
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", grade=" + grade + "]";
	}
	

}
