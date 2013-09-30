package com.example.madalerts;

public class SafetyAlert extends Alert {
	
	private Double latitude;
	private Double longitude;
	private String location;
	private String locationDescription;
	private boolean hasLocation;
	
	
	public SafetyAlert(String title, String link, String description,
			String eventTime) {
		
		super(title, link, description, eventTime);
		latitude = null;
		longitude = null;
		location = null;
		locationDescription = null;
		hasLocation = false;
	}

	public SafetyAlert(Alert alert){
		super(alert.getTitle(), alert.getLink(), 
				alert.getDescription(), alert.getEventTime());
		super.setType(AlertType.SAFETY);
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


	public boolean getHasLocation() {
		return hasLocation;
	}


	public void setHasLocation(Boolean hasLocation) {
		this.hasLocation = hasLocation;
	}

	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * @return the locationDescription
	 */
	public String getLocationDescription() {
		return locationDescription;
	}

	/**
	 * @param locationDescription the locationDescription to set
	 */
	public void setLocationDescription(String locationDescription) {
		this.locationDescription = locationDescription;
	}
	
	
	
}
