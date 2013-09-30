package com.example.madalerts;

import java.util.ArrayList;



import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class EventsList extends Activity { 

	private ListView listView;
	ArrayList<Alert> Alertlist;
	private ArrayAdapter<String> adapter;
	private ArrayAdapter<Alert> adapter2;
	private ArrayList<String> titleList;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.events_list);
		// TextView t = (TextView) findViewById(R.id.textView1) ;

		listView = (ListView) findViewById(R.id.listView1);

		// Define a new Adapter
		// First parameter - Context
		// Second parameter - Layout for the row
		// Third parameter - ID of the TextView to which the data is written
		// Forth - the Array of data
		
		//get the titles of the alets
		 ArrayList<String> list = new ArrayList<String>();
		for (Alert a : Driver.Alertlist) {
			list.add(a.getTitle());
		}
		titleList= list;
//		adapter = new ArrayAdapter<String>(this,
//				android.R.layout.simple_list_item_1, list);
		
		
		adapter2 = new MyAlertAdapter(this,
		R.layout.rss_feed_item, Driver.Alertlist);
		
		listView.setAdapter(adapter2);
		listView.setOnItemClickListener(listView.getOnItemClickListener());
		
		
		// this is the click listenier for the list imtems
		listView.setOnItemClickListener(new OnItemClickListener() {
	        public void onItemClick(AdapterView<?> parent, View view,
	                int position, long id) {

//	       Object o = listView.getItemAtPosition(position);
//	       String str=(String)o;//As you are using Default String Adapter
//	       Toast.makeText(getBaseContext(),str+position,Toast.LENGTH_SHORT).show();
//	       
	        //We add the index of the item  to a bundle so the next activity can get the data
	       Bundle extras = new Bundle();
			extras.putLong("position", position);
			
			Intent intent = new Intent(EventsList.this,AlertView.class);
			intent.putExtras(extras);
			startActivity(intent);
	        }

		
	    });

	}

	
//	public void onPause() {
//	    super.onPause();  // Always call the superclass method first
//	    finish();
//	}
//	protected void onResume() {
//	    super.onResume();
//		for (Alert a : Driver.Alertlist) {
//			list.add(a.getTitle());
//		}
//	    adapter.notifyDataSetChanged();
//	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
/*
	private class CreateAlerts extends AsyncTask<Void, Void, ArrayList<String>> {

		@Override
		protected ArrayList<String> doInBackground(Void... params) {
			
		
			Driver.loadFeed(getString(R.string.alert_Url));// creates the list of alerts and stores it in a
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
	*/
}