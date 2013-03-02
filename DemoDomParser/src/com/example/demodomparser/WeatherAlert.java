package com.example.demodomparser;

import java.util.Date;

import android.text.format.Time;

public class WeatherAlert extends Alert {

	public WeatherAlert(String desciption, Date eventTime, Location location,
			AlertType alertType) {
		super(desciption, eventTime, alertType, location);
		
		
		
	}

	
	
}
