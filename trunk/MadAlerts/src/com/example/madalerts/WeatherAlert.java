package com.example.madalerts;

public class WeatherAlert extends Alert{
	
	private Double latitude;
	private Double longitude;
	private boolean hasLocation;
	
	public WeatherAlert(String title, String link, String description,
			String eventTime) {
		
		super(title, link, description, eventTime);
		latitude = null;
		longitude = null;
		hasLocation = false;
	}
	
	public WeatherAlert(Alert alert) {
		super(alert.getTitle(), alert.getLink(), 
				alert.getDescription(), alert.getEventTime());
		super.setType(AlertType.WEATHER);
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
