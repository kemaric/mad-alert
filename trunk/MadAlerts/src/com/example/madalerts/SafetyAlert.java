package com.example.madalerts;

public class SafetyAlert extends Alert {
	
	private Double latitude;
	private Double longitude;
	private Boolean hasLocation;
	
	
	public SafetyAlert(String title, String link, String description,
			String eventTime) {
		
		super(title, link, description, eventTime);
		latitude = null;
		longitude = null;
		hasLocation = false;
	}

	public SafetyAlert(Alert alert){
		super(alert.getTitle(), alert.getLink(), 
				alert.getDescription(), alert.getEventTime());
		latitude = null;
		longitude = null;
		hasLocation = false;
	}

	public Double getLatitude() {
		return latitude;
	}


	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}


	public Double getLongitude() {
		return longitude;
	}


	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}


	public Boolean getHasLocation() {
		return hasLocation;
	}


	public void setHasLocation(Boolean hasLocation) {
		this.hasLocation = hasLocation;
	}
	
	
	
}
