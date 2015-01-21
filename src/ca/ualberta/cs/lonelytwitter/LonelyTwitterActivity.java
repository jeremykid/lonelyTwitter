package ca.ualberta.cs.lonelytwitter;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Date;

import com.google.gson.Gson; 
import com.google.gson.reflect.TypeToken;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.renderscript.Type;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class LonelyTwitterActivity extends Activity { //activity is scream in android

	private static final String FILENAME = "file.sav";//static means shared by all classes. final means cannot change
	private EditText bodyText;
	private ListView oldTweetsList;
	private ArrayAdapter<String> adapter; 
	private ArrayList<String> tweets;
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main); //create the main.xml in the layout

		bodyText = (EditText) findViewById(R.id.body);
		Button saveButton = (Button) findViewById(R.id.save);
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);

		saveButton.setOnClickListener(new View.OnClickListener() { // class

			public void onClick(View v) {// a class
				setResult(RESULT_OK);
				String text = bodyText.getText().toString();
				tweets.add(text);
				saveInFile(text, new Date(System.currentTimeMillis()));
				//finish();
				
				adapter.notifyDataSetChanged();

			}
		});
	}

	@Override
	protected void onStart() { // throws IOException
		
		User u = new Author("Joe"); //with abstract we cannot use user we must use author
		//u.setName("Joe"); // without abstract
		//
		
		u.getName();
		
		try{
			u.setName("Othername");
		} catch (Exception e) {
			
		}
		
		ArrayList<User> users = new ArrayList<User>(); // == template in C++ 
		ArrayList<Object> objects;
		
	
		
		// TODO Auto-generated method stub
		super.onStart();
		tweets = loadFromFile();
		adapter = new ArrayAdapter<String>(this,
				R.layout.list_item, tweets);
		oldTweetsList.setAdapter(adapter);
	}

	private ArrayList<String> loadFromFile() {
		Gson gson =new Gson ();
		
		ArrayList<String> tweets = new ArrayList<String>();
		try {
			FileInputStream fis = openFileInput(FILENAME);
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));
			
			//taken from http://google-gson.googlecode.com/svn/trunk/gson/docs/javadocs/index.html
			java.lang.reflect.Type typeOfT = new TypeToken<ArrayList<String>>(){}.getType();
			//TypeToken<ArrayList<String>> typeOfT = new TypeToken<ArrayList<String>>() {}.getType();
			tweets = gson.fromJson(in, typeOfT);
			
			/*String line = in.readLine();
			while (line != null) {
				tweets.add(line);
				line = in.readLine();
			}*/
			fis.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//return tweets.toArray(new String[tweets.size()]);
		return tweets;
	}
	
	private void saveInFile(String text, Date date) {
		//to use Gson
		Gson gson = new Gson();
		
		
		
		try {
			FileOutputStream fos = openFileOutput(FILENAME, 0);//opening write will over write
			//method of activity class
					//Context.MODE_APPEND);  
			//fos.write(new String(date.toString() + " | " + text)					.getBytes());
			
			OutputStreamWriter osw = new OutputStreamWriter(fos); //pass the fos to osw then we use gson
			gson.toJson(tweets, osw);
			osw.flush();
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}