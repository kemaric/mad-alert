package com.example.demodomparser;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		final Button latestNewsButton = (Button) findViewById(R.id.latestNewsButton);
		latestNewsButton.setOnClickListener(this);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.latest_news, menu);
		return true;
	}

	public void onClick(View v) {
		Intent changeIntentToLatestNews = new Intent(MainActivity.this,LatestNewsActivity.class);
		startActivity(changeIntentToLatestNews);
	}
	
}
