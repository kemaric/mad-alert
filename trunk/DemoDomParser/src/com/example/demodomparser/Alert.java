package com.example.demodomparser;

import java.util.Date;
import java.util.Random;


public class Alert {
	private String description;
	private Date eventTime;
	private AlertType alertType;
	private Location location;

	public Alert(String desciption, Date eventTime, AlertType alertType,
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

	public Date getEventTime() {
		return eventTime;
	}

	public void setEventTime(Date eventTime) {
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
	

	@SuppressWarnings("deprecation")
	public int createId() {
		Random r = new Random();
		return (eventTime.getMonth() + eventTime.getDate() + eventTime.getDay()
				+ eventTime.getHours() + eventTime.getHours() + eventTime.getSeconds())
				* r.nextInt(100);
	}
}
