package com.example.demodomparser;

import java.util.Date;

import android.text.format.Time;

public class NonViolentAlert extends Alert {

	public NonViolentAlert(String desciption, Date eventTime,
			Location location, AlertType alertType) {
		super(desciption, eventTime, alertType, location);
		
	}
	

	
}
