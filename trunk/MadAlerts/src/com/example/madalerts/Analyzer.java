package com.example.madalerts;

import android.annotation.SuppressLint;
import java.util.ArrayList;
import java.util.Date;

import com.example.demodomparser.AlertType;
import com.example.demodomparser.Location;


public static class Analyzer {

	/*Should this be an object or just a library of methods?*/
	
	
	/*Until we can get the standardized info from the police, there's not 
	 * much this module can do, just because the info from the xml isn't as detailed as 
	 * we need it to be. For example, many of the descriptions don't indicate the 
	 * incident time.
	 */
	
	
	
	/*How is this getting the info from the DOM parser?
	 * Work with Ely on communication between the modules*/
	
	
	/*Takes the string from <pubdate> that the DOM parser (should) output
	 * and turns it into a Date object.
	 * 
	 * Dates/from the XML are in the format
	 * (day of the week), (date) (month) (year) (time in GMT)
	 * 
	 * */ 
	public Date parseDate(String d) {
		String[] splits = d.split("( |,)");
		String dateNum = splits[1];
		String month = splits[2];
		String year = splits[3];
		String time = splits[4];
		String timeSplits[] = time.split(":");
		int dateInt = Integer.parseInt(dateNum);
		int yearInt = Integer.parseInt(year);
		int hourInt = Integer.parseInt(timeSplits[0]);
		int minuteInt = Integer.parseInt(timeSplits[1]);
		int secInt = Integer.parseInt(timeSplits[2]);
		
		int monthInt = getMonthInt(month); 
		@SuppressWarnings("deprecation")
		Date retDate = new Date(yearInt, monthInt, dateInt, hourInt, minuteInt, secInt);
		
		return retDate;
		
		
		
		
		
		
	}

	/*Takes the description string and returns which type of error it is.
	 * If none of the error words ocurred in the description, returns null*/
	@SuppressLint("DefaultLocale")
	public AlertType parseMode(String description) {
		String w[] = getResources().getStringArray(R.array.weatherKeywords_array);
		for (int i = 0; i < arr.length; i++) {
		       if (description.contains(w[i])) {
		    	   return AlertType.WEATHER;
		       }
		}
		String n[] = getResources().getStringArray(R.array.nonViolentKeywords_array);
		for (int i = 0; i < arr.length; i++) {
		       if (description.contains(n[i])) {
		    	   return AlertType.NONVIOLENT;
		       }
		}
		String v[] = getResources().getStringArray(R.array.violentKeywords_array);
		for (int i = 0; i < arr.length; i++) {
		       if (description.contains(w[i])) {
		    	   return AlertType.VIOLENT;
		       }
		}
		return AlertType.OTHER;
	}
	
	private int getMonthInt(String month) {
		int monthInt = 0;
		if (month.equals("Jan")) {
			monthInt = 1;
		}
		if (month.equals("Feb")) {
			monthInt = 2;
		}
		if (month.equals("Mar")) {
			monthInt = 3;
		}
		if (month.equals("Apr")) {
			monthInt = 4;
		}
		if (month.equals("May")) {
			monthInt = 5;
		}
		if (month.equals("Jun")) {
			monthInt = 6;
		}
		if (month.equals("Jul")) {
			monthInt = 7;
		}
		if (month.equals("Aug")) {
			monthInt = 8;
		}
		if (month.equals("Sep")) {
			monthInt = 9;
		}
		if (month.equals("Oct")) {
			monthInt = 10;
		}
		if (month.equals("Nov")) {
			monthInt = 11;
		}
		if (month.equals("Dec")) {
			monthInt = 12;
		}
		return monthInt;
	}
	
	/*Tries to determine whether or not the incident occurred on or off campus.
	 * Returns an Location enum if it can, null otherwise.*/
	public Location getLocation(String description) {
		if (description.contains("on-campus")) {
			return Location.ONCAMPUS;
		}
		if (description.contains("off-campus") || description.contains("off campus")) {
			return Location.OFFCAMPUS;
		}
		return null;
	}
}
