package ca.ualberta.cs.lonelytwitter;

import java.io.IOException;

public class Viewer extends User {
	public void setName(String name) throws IOException {
		if (name.length() > 8){
			throw new RuntimeException("Too long");//creating a new object call runtime instructor throw == rise in Python
		}
		this.name = name;
	}

}
