package com.example.demodomparser;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import org.w3c.dom.Element;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.SAXParser;

public class MainActivity extends Activity implements OnClickListener {
	URL rssurl;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		final Button latestNewsButton = (Button) findViewById(R.id.latestNewsButton);
		latestNewsButton.setOnClickListener(this);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.latest_news, menu);
		return true;
	}

	@SuppressLint("UseSparseArrays")
	public void onClick(View v) {
		try{
			Intent changeIntentToLatestNews = new Intent(MainActivity.this,LatestNewsActivity.class);
			Analyzer analyze = new Analyzer();
			rssurl = new URL("http://alert.umd.edu/rssfeed.php");
			Document dom = XMLfunctions.XMLfromString(convertStreamToString(rssurl.openStream()));
			Element root = dom.getDocumentElement();
			Alert[] alerts = new Alert[3];
			for(int i = 0; i < 3; i++){
				String[] time_description = XMLfunctions.getTimeAndDescription(root, i);
				if(time_description != null){
					alerts[i] = new Alert(time_description[1],analyze.parseDate(time_description[0]),analyze.parseMode(time_description[1]), analyze.getLocation(time_description[1]));
				}else{
					alerts[i] = null;
				}	
			}
			changeIntentToLatestNews.putExtra("alerts", alerts);
			
			startActivity(changeIntentToLatestNews);
		}catch(MalformedURLException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public String convertStreamToString(InputStream is) throws IOException {
        /*
         * To convert the InputStream to String we use the BufferedReader.readLine()
         * method. We iterate until the BufferedReader return null which means
         * there's no more data to read. Each line will appended to a StringBuilder
         * and returned as String.
         */
        if (is != null) {
            StringBuilder sb = new StringBuilder();
            String line;

            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                while ((line = reader.readLine()) != null) {
                    sb.append(line).append("\n");
                }
            } finally {
                is.close();
            }
            return sb.toString();
        } else {       
            return "";
        
        }
	}
}
