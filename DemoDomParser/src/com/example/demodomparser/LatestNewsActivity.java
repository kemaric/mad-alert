package com.example.demodomparser;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import org.w3c.dom.*;

public class LatestNewsActivity extends Activity implements OnClickListener {

	Alert[] alerts = new Alert[3];
	Button alertOne;
	Button alertTwo;
	Button alertThree;
	ViewGroup linearLayout;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		LinearLayout myView= (LinearLayout)findViewById(R.layout.activity_latest_news);
		setContentView(R.layout.activity_latest_news);

		Bundle gotBasket = getIntent().getExtras();
		// get the Alerts data from the MainActivity
		alerts=(Alert[]) gotBasket.getSerializable("alerts");		
		linearLayout = (ViewGroup) findViewById(R.id.rlLatestNews);		
		addButtons();		
		
		
		final ScrollView list = (ScrollView) findViewById(R.id.scrollView1);
	}

	private void addButtons() {
		// TODO Auto-generated method stub
		alertOne=new Button(this);
		alertOne.setText(alerts[0].getDescription());
		alertOne.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT));
		linearLayout.addView(alertOne);
		
		alertTwo=new Button(this);
		alertTwo.setText(alerts[1].getDescription());
		alertTwo.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT));
		linearLayout.addView(alertTwo);
		
		alertThree=new Button(this);
		alertThree.setText(alerts[2].getDescription());
		alertThree.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT));
		linearLayout.addView(alertThree);	
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.latest_news, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}

}
