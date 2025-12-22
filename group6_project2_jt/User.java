package group6_project2_jt;

public class User{

	private String name;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public void setUser(String name) {
		System.out.println("Please enter username:");
		setName(name);
	}

	
}