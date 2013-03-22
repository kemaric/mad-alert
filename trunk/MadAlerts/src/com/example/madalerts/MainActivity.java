package com.example.madalerts;

import java.util.ArrayList;


import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity {
	private final int LOAD_SAVED_ALERTS = 0;
	private final int LOAD_NEW_ALERTS = 1;
	private int feedValue =0 ; 
	private boolean resumeHasRun = false;
	
	private Button btn;
	private ArrayList<String> list = new ArrayList<String>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);


	}
	

	@Override
	protected void onResume() {
	    super.onResume();
	    if (!resumeHasRun) {
	        resumeHasRun = true;
	        return;
	    }
	    btn = (Button)findViewById(R.id.newAlerts);
		btn.setClickable(true);
	   
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void ContactInfo(View v) {
	
	}

	public void LoadSavedAlerts(View v) {
		feedValue = LOAD_SAVED_ALERTS; 
		
	}

	public void LoadNewAlerts(View v) {
		btn = (Button)findViewById(R.id.newAlerts);
		btn.setClickable(false);
		feedValue = LOAD_NEW_ALERTS; 
		new CreateAlerts().execute();
//		Intent startList = new Intent(MainActivity.this,EventsList.class);
//		/*this sends the arraylist that has the list of soro-
//		 *rities to the sorority class */
//		startActivity(startList);

	}
	
	
	private class CreateAlerts extends AsyncTask<Void, Void, Void> {

		@Override
		protected Void doInBackground(Void... params) {
			
		 if (feedValue==LOAD_NEW_ALERTS ){
			Driver.loadFeed(getString(R.string.alert_Url));// creates the list of alerts and stores it in a
		 }else if (feedValue==LOAD_SAVED_ALERTS){
			 // set up database and load Driver.Alertlist with alerts in BD
		 }

//			// loop through all Alerts and add the alert title to the list that will be appended to the list adapter
//			for (Alert a : Driver.Alertlist) {
//				list.add(a.getTitle());
//			}
			
			
			return null;
		
		}

		protected void onPostExecute(Void v) {
			
			Intent startList = new Intent(MainActivity.this,EventsList.class);
			/*this sends the arraylist that has the list of soro-
			 *rities to the sorority class */
			startActivity(startList);

		}
	}
}
