package com.example.demodomparser;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class AlertOnClickActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_alert_on_click);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.alert_on_click, menu);
		return true;
	}

}
