package com.example.madalerts;

import java.util.ArrayList;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class Updater extends BroadcastReceiver{

	private static String serviceTag;
	private long duration = 5*1000*60; //5 mins
	
	
	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
//		CharSequence text = "Hello toast!";
//		int duration = Toast.LENGTH_SHORT;
//		Toast toast = Toast.makeText(context, text, duration);
//		toast.show();
		serviceTag= "Alert";
		Log.d(serviceTag, "Service onRecive");
		
		
		Driver.loadFeed(context.getString(R.string.alert_Url));
		
		ArrayList <Alert> newList = new ArrayList<Alert>();
		
		for (Alert alert : Driver.Alertlist){
			alert = Analyzer.determineType(alert, context);
			newList.add(alert);
		}
		Driver.Alertlist = newList;
		// creates the list of alerts and stores it in a static ArrayList
		
		
	}
	
	public void setAlarm(Context context){
		AlarmManager am = (AlarmManager)context.getSystemService(context.ALARM_SERVICE);
		Intent i = new Intent(context, Updater.class);
        PendingIntent pi = PendingIntent.getBroadcast(context, 0, i, 0);
       // duration = 5*1000*60;
        am.setInexactRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP, duration, duration, pi);
	}
	
	public void cancelAlarm(Context context){
		 Intent intent = new Intent(context, Updater.class);
         PendingIntent pi = PendingIntent.getBroadcast(context, 0, intent, 0);
         AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
         alarmManager.cancel(pi);
	}

}
