package ca.ualberta.cs.lonelytwitter;

import java.io.IOException;

public abstract class User extends Object{
	protected String name;//private cannot be used in two class

	public String getName() {
		return name;
	}

	public abstract void setName(String name) throws IOException ;

	public User(String n) {
		super();
		name = n;
	}
	
	/*public User(String name) {
		super();
		this.name = name;
	}*/
	
	public User(){
		super();
		name = "anywous";
		
	}
	

}
