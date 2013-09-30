package com.example.madalerts;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class ContactInfoActivity extends Activity {

	private TextView auxNumber;
	private TextView nightRideNumber;
	private TextView policeNumber;	
	private TextView crimeReportNumber;
	private TextView escortNumber;
	private Spinner spinner;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_contact_info);

		spinner = (Spinner) findViewById(R.id.spinner);
		ArrayAdapter adapter = ArrayAdapter.createFromResource(this,
				R.array.contact_names, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adapter);

		auxNumber = (TextView) findViewById(R.string.aux_Number);
		nightRideNumber = (TextView) findViewById(R.string.night_ride_number);
		policeNumber = (TextView) findViewById(R.string.police_number);
		crimeReportNumber = (TextView) findViewById(R.string.crime_report);
		escortNumber = (TextView) findViewById(R.string.escort_number);

	}

	public void OnClickDial(View view) {
		int position = spinner.getSelectedItemPosition();
		Intent intent = null;
		Resources res = getResources();
		String[] numbers = res.getStringArray(R.array.contact_numbers);
		
		intent = new Intent(Intent.ACTION_DIAL,
				Uri.parse("tel:"+numbers[position]));
		startActivity(intent);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_contact_info, menu);
		return true;
	}

}
