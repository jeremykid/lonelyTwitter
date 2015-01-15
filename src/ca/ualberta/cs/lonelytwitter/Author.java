package ca.ualberta.cs.lonelytwitter;

import java.io.IOException;

public class Author extends User implements UserLike { //have method

	public Author(String string) {
		super(string);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setName(String x) throws IOException {
		if (x.length() > 8){
			throw new IOException ("Name too long!");
		}
		this.name = x;
		
	}

	public String getmethod() {
		// TODO Auto-generated method stub
		return null;
	}
}
 