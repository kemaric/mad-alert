package com.example.madalerts;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
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
		loc.setText("location not implemended Yet");
		
		type=(TextView)findViewById(R.id.alert_type);
		type.setText("type not implemended Yet");
		
		webV= (WebView)findViewById(R.id.webView1);
		
		//webV.setVisibility(WebView.INVISIBLE);
	
	}
	
	
	private void SaveAlert(View v){
		
		
	
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