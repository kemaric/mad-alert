package com.example.madalerts;



import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//TextView t = (TextView) findViewById(R.id.textView1) ;
		
		ListView listView = (ListView) findViewById(R.id.listView1);
		String[] values = new String[] { "Android", "iPhone", "WindowsMobile",
		  "Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X",
		  "Linux", "OS/2" };

		// Define a new Adapter
		// First parameter - Context
		// Second parameter - Layout for the row
		// Third parameter - ID of the TextView to which the data is written
		// Forth - the Array of data

		ArrayList<String> list = new ArrayList() ;
		for (Alert a : Driver.loadFeed()){
			list.add(a.getTitle());
		}
		
		//list = Driver.loadFeed();
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
		  android.R.layout.simple_list_item_1, android.R.id.text1, list);


		// Assign adapter to ListView
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(listView.getOnItemClickListener());
		
		
	
//		WebView wV = (WebView) findViewById(R.id.webView1);
//		wV.loadUrl("https://alert.umd.edu/rssfeed.php");
	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
