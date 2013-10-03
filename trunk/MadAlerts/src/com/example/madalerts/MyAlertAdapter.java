package com.example.madalerts;
import java.util.ArrayList;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Filter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;


public class MyAlertAdapter extends ArrayAdapter<Alert>  {

    private Context context;

    public MyAlertAdapter(Context context, int textViewResourceId, ArrayList<Alert> items) {
        super(context, textViewResourceId, items);
        this.context = context;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.rss_feed_item, null);
        }

        Alert item = getItem(position);
        if (item!= null) {
           
            TextView title = (TextView) view.findViewById(R.id.title);
            ImageView image = (ImageView) view.findViewById(R.id.image);
            Drawable img ;
            if (item != null) {
            	title.setText(item.getTitle());
            
            switch (item.getType()){
            case SAFETY: 
            	title.setBackgroundColor(0xfff00000); // red 
            	// img = context.getResources().getDrawable(R.drawable.safty_alert);
             	image.setImageResource(R.drawable.safty_alert);

            	break;
            	case WEATHER:
            		title.setBackgroundColor(0xfff00000); // red 
                	
                	image.setImageResource(R.drawable.weather_alert);
				break;
			default:
            	image.setImageResource(R.drawable.default_alert);
            	
            	/* This is a comment. */
				break;
            	
            }
            	
                
            	
            }
         }

        return view;
    }
    
    
    
    
}