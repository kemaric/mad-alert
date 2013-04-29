package com.example.madalerts;

public class TrafficAlert extends Alert{
	
	private String street1;
	private String street2;
	private boolean hasLocation;
	
	public TrafficAlert(String title, String link, String description,
			String eventTime) {
		
		super(title, link, description, eventTime);
		street1 = null;
		street2 = null;
		hasLocation = false;
	}
	
	public TrafficAlert(Alert alert) {
		super(alert.getTitle(), alert.getLink(), 
				alert.getDescription(), alert.getEventTime());
		street1 = null;
		street2 = null;
		hasLocation = false;
	}
	
	public String getStreet1() {
		return street1;
	}

	public void setStreet1(String street1) {
		this.street1 = street1;
	}

	public String getStreet2() {
		return street2;
	}

	public void setStreet2(String street2) {
		this.street2 = street2;
	}

	public boolean getHasLocation() {
		return hasLocation;
	}

	public void setHasLocation(Boolean hasLocation) {
		this.hasLocation = hasLocation;
	}

	public TrafficAlert(String title, String link, String description,
			String eventTime, String street1, String street2) {
		super(title, link, description, eventTime);
		this.street1 = street1;
		this.street2 = street2;
		hasLocation = true;
	}
	
}
