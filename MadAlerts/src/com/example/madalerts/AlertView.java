package com.example.madalerts;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;

public class AlertView extends Activity {

	private Alert alert;
	private TextView dis;
	private TextView loc;
	private TextView type;
	private WebView webV;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.alert);
		Bundle extras = getIntent().getExtras();
		int position = (int) extras.getLong("position");

		alert = Driver.Alertlist.get(position);

		dis=(TextView)findViewById(R.id.alert_dis);
		dis.setText(alert.getDescription());

		loc=(TextView)findViewById(R.id.alert_loc);
		loc.setText("NO Location Found");

		type=(TextView)findViewById(R.id.alert_type);
		type.setText(alert.getType().name());

		webV= (WebView)findViewById(R.id.webView1);

		if (alert.getType()== AlertType.SAFETY){
			SafetyAlert sAlert = (SafetyAlert) alert;

			if (sAlert.getHasLocation()== true){
				String location = sAlert.getLocation();
				loc.setText("location: "+sAlert.getLocationDescription()+"~("+location+")");		
				String html = 
						"<iframe width=\"300\" height=\"300\" frameborder=\"0\" scrolling=\"yes\" marginheight=\"0\" marginwidth=\"0\" " +
								"src=\"https://maps.google.com/maps?q="+location+"&amp;;z=19\">" +
								"</iframe>";
				String mime = "text/html";
				String encoding = "utf-8";

				webV.getSettings().setJavaScriptEnabled(true);
				webV.loadDataWithBaseURL(null, html, mime, encoding, null);
				
				//webV.setVisibility(WebView.INVISIBLE);
			}
		}
	}


	private void SaveAlert(View v){

		//			Bundle extras = getIntent().getExtras();
		//			ArrayList<String> vals = extras.getStringArrayList("values");
		//			String frat = vals.get(1);
		SQLiteDatabase db;
		db = openOrCreateDatabase( "savedAllerts.db" , SQLiteDatabase.CREATE_IF_NECESSARY , null );
		try {
			/* While testing, you may want to delete your table from the emulator/phone. To do this simply uncomment this line of code 
			 * db.execSQL("DROP TABLE IF EXISTS tbl_Contain");
			 */


			final String CREATE_TABLE_CONTAIN = "CREATE TABLE IF NOT EXISTS tbl_Contain ("
					+ "ID INTEGER primary key,"
					+ "TYPE TEXT,"
					+ "TITLE TEXT,"
					+ "DESCRIPTION TEXT,"
					+ "TIME TEXT,"
					+ "LINK TEXT,"
					+ "LOCATION TEXT,"
					+ ""

			+");";
			db.execSQL(CREATE_TABLE_CONTAIN);
			String sql = "INSERT or replace INTO tbl_Contain (NAME) VALUES()" ;

			db.execSQL(sql);
		}
		catch (Exception e) { 
			e.printStackTrace();
		}
		db.close();

	}

	public static void saveAlertToDB() {
		new AsyncTask<Void, Void, Void>() {


			protected Void doInBackground(Void... unused) { 

				return null;
			}

			protected void onPostExecute(Void unused) { 

			}

		}.execute();  
	}



}