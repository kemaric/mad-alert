package com.example.demodomparser;

import java.util.Random;

import android.text.format.Time;

public class Alert {
	private String description;
	private Time eventTime;
	private AlertType alertType;
	private Location location;

	public Alert(String desciption, Time evenTime, AlertType alertType,
			Location location) {
		this.description = desciption;
		this.eventTime = eventTime;		
		this.alertType = alertType;
		this.location = location;
	}
	
	
	
	

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Time getEventTime() {
		return eventTime;
	}

	public void setEventTime(Time eventTime) {
		this.eventTime = eventTime;
	}

	public AlertType getAlertType() {
		return alertType;
	}

	public void setAlertType(AlertType alertType) {
		this.alertType = alertType;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}
	

	public int createId() {
		Random r = new Random();
		return (eventTime.month + eventTime.monthDay + eventTime.weekDay
				+ eventTime.hour + eventTime.minute + eventTime.second)
				* r.nextInt(100);
	}
}
