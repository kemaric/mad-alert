package com.example.madalerts;

import java.util.ArrayList;



import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class SplashScreen extends Activity {

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		/*
		 * The next two lines of code gets rid of the title and makes the app
		 * fullscreen. We want to do it right before we set the content view
		 */
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.splash);
		Thread timer = new Thread() {
			public void run() {
				try {

					sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					Intent mainActivity = new Intent(
							"android.intent.action.MAINACTIVITY");
					startActivity(mainActivity);
				}
			}
		};

		//timer.start();
		
		
		Intent mainActivity = new Intent(this,MainActivity.class);
		startActivity(mainActivity);
	}

	/**
	 * This overriden method ensures that the splash doesn't come back if the
	 * user presses the back button on their phone.
	 */
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();/*
		 * pretty much kills this activity as soon as the 5 seconds is
		 * over
		 */
	}
}
