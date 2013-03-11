package com.example.madalerts;

import java.util.Date;
import java.util.Random;

import android.location.Location;


public class Alert {
//	private String description;
//	private Date eventTime;
//	private AlertType alertType;
//	private Location location;
	
	/** **/
	
	private String link; //This is from the XML that 
	private String description;
	private String eventTime;
	private String title;

	

//	public Alert(String desciption, Date eventTime, AlertType alertType,
//			Location location) {
//		this.description = desciption;
//		this.eventTime = eventTime;		
//		this.alertType = alertType;
//		this.location = location;
//		//this.link = link;
//	}


	public Alert(String title, String link,String desciption, String eventTime) {
		this.description = desciption;
		this.eventTime = eventTime;		
		this.title= title;
		this.link = link;
		//this.link = link;
	}



	public String getLink() {
		return link;
	}



	public String getDescription() {
		return description;
	}



	public String getEventTime() {
		return eventTime;
	}



	public String getTitle() {
		return title;
	}

}
