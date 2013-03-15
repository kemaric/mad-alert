package com.example.madalerts;

import java.util.ArrayList;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {

	public final String DEFAULT_RSS_URL= "https://alert.umd.edu/rssfeed.php";
	private ListView listView;
	private ArrayAdapter<String> adapter;
	private ArrayList<String> list = new ArrayList<String>();
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// TextView t = (TextView) findViewById(R.id.textView1) ;

		listView = (ListView) findViewById(R.id.listView1);

		// Define a new Adapter
		// First parameter - Context
		// Second parameter - Layout for the row
		// Third parameter - ID of the TextView to which the data is written
		// Forth - the Array of data

		// this creates a new AsyncTask to do the "heavy lifting" so our main ui
		// thread does not slow down
		new CreateAlerts().execute();

		adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, android.R.id.text1, list);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	private class CreateAlerts extends AsyncTask<Void, Void, ArrayList<String>> {

		@Override
		protected ArrayList<String> doInBackground(Void... params) {
			
		
			Driver.loadFeed(DEFAULT_RSS_URL);// creates the list of alerts and stores it in a
								// static Array list

			// loop through all Alerts and add the alert title to the list that will be appended to the list adapter
			for (Alert a : Driver.Alertlist) {
				list.add(a.getTitle());
			}
			return list;
		}

		protected void onPostExecute(ArrayList<String> list) {

			// Assign adapter to ListView
			listView.setAdapter(adapter);
			listView.setOnItemClickListener(listView.getOnItemClickListener());

		}
	}
}
