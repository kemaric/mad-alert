package com.example.madalerts;


import java.util.ArrayList;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
	private final int LOAD_SAVED_ALERTS = 0;
	private final int LOAD_NEW_ALERTS = 1;
	private int feedValue = 0; // this is how will will keep track of which button the user pressed

	private boolean resumeHasRun = false;
	private AsyncTask<Void, Integer, Void> task = null;

	private Button btn;
	
	Context context;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		context = this;
		
		Updater br = new Updater();
	
		br.setAlarm(context);
		

	}

	public void onPause() {
		super.onPause();  // Always call the superclass method first
//
//		if (task != null){//terminate the AsyncTask if it is still running
//			task.cancel(true);
//		}
	}

	@Override
	protected void onResume() {
		super.onResume();
		if (!resumeHasRun) {
			resumeHasRun = true;
			return;
		}
		//making the buttons Clickable again BC/ they might be Un-Clickable  
		btn = (Button) findViewById(R.id.newAlerts);
		btn.setClickable(true);
		btn = (Button) findViewById(R.id.savedAlerts);
		btn.setClickable(true);
		

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	// this method creates and launches the list activity
	public void startList() {

		Intent startList = new Intent(MainActivity.this, EventsList.class);

		startActivity(startList);
		return;
	}


	/*button listener for emergency contact button
	 * should start a new intent with UMD emergency contact info
	 */
	public void ContactInfo(View v) {
		Intent startContactInfo = new Intent(MainActivity.this, ContactInfoActivity.class);
		
		startActivity(startContactInfo);
		return;
	}

	/*button listener for Saved Alerts button
	 *should use the AsyncTask to load a list of alerts from the 
	 * phone DB 
	 */
	public void LoadSavedAlerts(View v) {
		feedValue = LOAD_SAVED_ALERTS;

	}

	/*button listener for Saved Alerts button
	 *should use the AsyncTask to load a list of alerts from the 
	 * RSS feed 
	 */
	public void LoadNewAlerts(View v) {
		// lock the buttons so the user can't click the buttons multiple times and create multiple threads
		btn = (Button) findViewById(R.id.newAlerts);
		btn.setClickable(false);
		btn = (Button) findViewById(R.id.savedAlerts);
		btn.setClickable(false);
		
		feedValue = LOAD_NEW_ALERTS; //used in the AsyncTask to see what button was clicked
		task = new CreateAlerts().execute();//run the AsyncTask

	}

	// creates a new thread so the UI thread is free
	private class CreateAlerts extends AsyncTask<Void, Integer, Void> {

	   
		@Override
		//
		protected Void doInBackground(Void... params) {

			if (feedValue == LOAD_NEW_ALERTS) {//
				Driver.loadFeed(getString(R.string.alert_Url));
				
				ArrayList <Alert> newList = new ArrayList<Alert>();
				
				for (Alert alert : Driver.Alertlist){
					alert = Analyzer.determineType(alert, context);
					newList.add(alert);
				}
				Log.i("Alert", "Array size after parsing"+Driver.Alertlist.size());
				Driver.Alertlist = newList;
				Log.i("Alert", "Array size after analizing"+Driver.Alertlist.size());
				// creates the list of alerts and stores it in a static ArrayList
				Driver.LAST_LOAD = Driver.LOAD_FROM_RSS;

			} else if (feedValue == LOAD_SAVED_ALERTS) {
				// set up database and load Driver.Alertlist with alerts in
				// BD
			}


			return null;

		}

		// protected void onProgressUpdate(Integer... progress) {
		// setProgressPercent(progress[0]);
		// }

		//after the tread is finished executing  
		protected void onPostExecute(Void v) {
			startList();

			return;

		}
	}
}
