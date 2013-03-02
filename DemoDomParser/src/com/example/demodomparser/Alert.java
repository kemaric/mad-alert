package com.example.demodomparser;

import android.text.format.Time;

public class Alert {
	private String description;
	private Time eventTime;
	private Mode AlertType;
	private Location location;
	
	public Alert( String desciption, Time evenTime){
		this.description = desciption;
		this.eventTime = eventTime;
		this.AlertType = AlertType;
		this.location = location;				
	}
	
	
	
	public enum Mode{
		Weather,Violent,NonViolent
	}
	
	public enum Location{
		OffCampus,OnCampus
	}
}