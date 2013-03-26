package com.example.madalerts;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class ContactInfoActivity extends Activity {
	
	private TextView auxNumber;
	private TextView nightRideNumber;
	private TextView policeNumber;	
	private TextView crimeReportNumber;
	private TextView escortNumber;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_contact_info);
		
		auxNumber = (TextView) findViewById(R.string.aux_Number);
		nightRideNumber = (TextView) findViewById(R.string.night_ride_number);
		policeNumber = (TextView) findViewById(R.string.police_number);
		crimeReportNumber = (TextView) findViewById(R.string.crime_report);
		escortNumber = (TextView) findViewById(R.string.escort_number);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_contact_info, menu);
		return true;
	}

}
