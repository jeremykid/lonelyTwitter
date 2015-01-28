package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;

public class TwitterListModel {
	
	private ArrayList<LonelyTweetModel> tweets = null;
	
	private int count;
	
	public TwitterListModel() {
		count =0;
		tweets=new ArrayList<LonelyTweetModel>();
	}
	
	public int getListlength(){
		
		return count;
	}
	
	public void addTweet(LonelyTweetModel tweet){
		count = count+1;
		tweets.add(tweet);
	
	}
	
	public ArrayList<LonelyTweetModel> getTweets(){
		
		return tweets;
	}
	
	public boolean hasTweet(){
		if (count == 0){
				return false;
		}
		else{
			return true;
		}
	} 
	
	public void removeTweet(LonelyTweetModel tweet){
		count--;
		tweets.remove(tweet);
	}
	//public LonelyTweetModel getTweet
}
