package com.example.demodomparser;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class LatestNewsActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_latest_news);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.latest_news, menu);
		return true;
	}

}
