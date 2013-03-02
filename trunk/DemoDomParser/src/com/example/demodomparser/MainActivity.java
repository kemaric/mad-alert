package com.example.demodomparser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.SAXParser;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends Activity {
TextView t;
StringBuffer b= new StringBuffer();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		t= (TextView) (TextView)findViewById(R.id.insertText);
		 b.append("starting to parse\n");
		parserDom();
	}

	
	   
    private  void parserDom(){
     URL rssurl;
  
  try {
	  b.append("got to parse\n");
 //  rssurl = new URL("http://feeds.bbci.co.uk/news/technology/rss.xml");
   rssurl = new URL( "https://alert.umd.edu/rssfeed.php");
   b.append( rssurl.openStream().read());
   b.append("opened url\n");
   t.setText(b);
      Document dom = XMLfunctions.XMLfromString(convertStreamToString(rssurl.openStream()));
      b.append("opened doc\n");
      t.setText(b);
         Element root = dom.getDocumentElement();
         NodeList items = root.getElementsByTagName("item");
      
         for (int i=0;i<items.getLength();i++){
        	
             Element item = (Element)items.item(i);
       // b.append(XMLfunctions.getValue(item, "title"));
        b.append(XMLfunctions.getValue(item, "description"));
            

         
         }
         b.append("end\n");
         t.setText(b);
  } catch (MalformedURLException e) {
   // TODO Auto-generated catch block
   e.printStackTrace();
  } catch (IOException e) {
	  b.append("IO Exception\n");
      t.setText(b);
   // TODO Auto-generated catch block
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