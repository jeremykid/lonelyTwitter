package ca.ualberta.cs.lonelytwitter;

import java.io.IOException;

public abstract class User extends Object implements UserLike {
	protected String name;//private cannot be used in two class
							//public means can used anywhere in the program
	public String getName() {
		return name;
	}

	public abstract void setName(String name) throws IOException ; //throw exception

	public User(String n) {
		super();
		name = n;
	}
	
	/*public setUsername(String name){
	  	
	  	}
	*/
	
	/*public User(String name) {
		super();
		this.name = name; // copy the reference of string
	}*/
	
	public User(){
		super();
		name = "anonymous";
		
	}


	
	
}
