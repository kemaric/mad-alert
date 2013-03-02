package com.example.demodomparser;

import android.text.format.Time;

public class Alert {
	private String description;
	private Time eventTime;
	private Location location;
	private Mode alertType;

	public Alert(String desciption, Time eventTime, Location location, Mode alertType) {
		this.description = desciption;
		this.eventTime = eventTime;
		this.location = location;
		this.alertType = alertType;			
	}

	
	
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	
	
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}


	
	/**
	 * @return the eventTime
	 */
	public Time getEventTime() {
		return eventTime;
	}



	/**
	 * @param eventTime the eventTime to set
	 */
	public void setEventTime(Time eventTime) {
		this.eventTime = eventTime;
	}

	
	
	/**
	 * @return the location
	 */
	public Location getLocation() {
		return location;
	}



	/**
	 * @param location the location to set
	 */
	public void setLocation(Location location) {
		this.location = location;
	}



	/**
	 * @return the alertType
	 */
	public Mode getAlertType() {
		return alertType;
	}



	/**
	 * @param alertType the alertType to set
	 */
	public void setAlertType(Mode alertType) {
		this.alertType = alertType;
	}



	public enum Mode{
		Weather, NonViolent, Violent
	}

	public enum Location{
		OffCampus, OnCampus
	}
}