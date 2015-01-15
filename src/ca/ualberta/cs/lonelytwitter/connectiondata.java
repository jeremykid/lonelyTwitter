package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;

import android.R.bool;

public abstract class connectiondata {
	ArrayList<User> followers;
	ArrayList<User> follows;

	public ArrayList<User> getFollows()
	{
		return follows;
	}

	public void setFollowers(ArrayList<User> followers){
		this.followers = followers;
	}
	
	public ArrayList<User> getFollowing()
	{
		return follows;
	
	}
		
	public void setFollowing (ArrayList<User> follows){
		this.follows = follows;
	}
	
	public abstract bool followerUser(User u);
	public abstract bool unfollowerUser(User u);
}