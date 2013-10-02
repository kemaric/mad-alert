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
	private AlertType type = AlertType.BASIC;
	private Integer alertId;
	

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
		 
		setAlertId(new Integer(link.split("#")[1])); //split link on '#' and create integer with trailing numbers
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



	public AlertType getType() {
		return type;
	}



	public void setType(AlertType type) {
		this.type = type;
	}



	public int getAlertId() {
		return alertId;
	}



	public void setAlertId(int alertId) {
		this.alertId = alertId;
	}

	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alertId == null) ? 0 : alertId.hashCode());
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result
				+ ((eventTime == null) ? 0 : eventTime.hashCode());
		result = prime * result + ((link == null) ? 0 : link.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Alert)) {
			return false;
		}
		Alert other = (Alert) obj;
		if (alertId == null) {
			if (other.alertId != null) {
				return false;
			}
		} else if (!alertId.equals(other.alertId)) {
			return false;
		}
		if (description == null) {
			if (other.description != null) {
				return false;
			}
		} else if (!description.equals(other.description)) {
			return false;
		}
		if (eventTime == null) {
			if (other.eventTime != null) {
				return false;
			}
		} else if (!eventTime.equals(other.eventTime)) {
			return false;
		}
		if (link == null) {
			if (other.link != null) {
				return false;
			}
		} else if (!link.equals(other.link)) {
			return false;
		}
		if (title == null) {
			if (other.title != null) {
				return false;
			}
		} else if (!title.equals(other.title)) {
			return false;
		}
		if (type != other.type) {
			return false;
		}
		return true;
	}


}
