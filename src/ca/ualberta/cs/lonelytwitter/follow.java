package ca.ualberta.cs.lonelytwitter;

import java.sql.Connection;
import java.util.ArrayList;

public interface follow {
	public Connection follow(String a);
	public ArrayList<User> getFollowers();
	//public ArrayList<follower> getFollow();
}
