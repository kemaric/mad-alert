package com.example.demodomparser;

import android.annotation.SuppressLint;
import java.util.ArrayList;
import java.util.Date;


public class Analyzer {

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
		
		description = description.toLowerCase();
		ArrayList<String> violentAL = new ArrayList<String>();
		ArrayList<String> nonViolentAL = new ArrayList<String>();	
		ArrayList<String> weatherAL = new ArrayList<String>();
		
		violentAL.add("robbery");
		violentAL.add("armed");
		violentAL.add("murder");
		violentAL.add("shot");
		violentAL.add("shoot");
		violentAL.add("assault");
		violentAL.add("homicide");
		
		nonViolentAL.add("break");
		nonViolentAL.add("stalk");
		nonViolentAL.add("follow");
		nonViolentAL.add("harass");
		nonViolentAL.add("all clear");
		nonViolentAL.add("arrest");
		
		weatherAL.add("tornado");
		weatherAL.add("flood");
		weatherAL.add("wind");
		weatherAL.add("snow");
		weatherAL.add("hurricane");
		weatherAL.add("ice");
		weatherAL.add("icy");
		
		for (String curr: violentAL) {
			if (description.contains(curr)) {
				return AlertType.VIOLENT;
			}
		}
		for (String curr: nonViolentAL) {
			if (description.contains(curr)) {
				return AlertType.NONVIOLENT;
			}
		}
		for (String curr: weatherAL) {
			if (description.contains(curr)) {
				return AlertType.WEATHER;
			}
		}
		return null;
		
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
