package com.example.madalerts;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;





import java.io.InputStream;
import java.io.InputStreamReader;

public class Parser  {

	private Parser() {

	}


	public static  Document XMLfromURL(String url ){

		try {

			//			URL url = new URL("ftp://mirror.csclub.uwaterloo.ca/index.html");   
			//			URLConnection urlConnection = url.openConnection();   
			//			InputStream in = new BufferedInputStream(urlConnection.getInputStream());   
			//			try {     readStream(in);     }
			//			
			URL xmlURL = new URL (url);
			URLConnection urlConnection = xmlURL.openConnection();

			InputStream is = new BufferedInputStream(urlConnection.getInputStream());
			is = xmlURL.openStream();
			String xmlString = convertStreamToString(is);
			Document result = XMLfromString(xmlString);
			is.close(); 
			return result;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

		
	}


	public final static Document XMLfromString(String xml){

		Document doc = null;

		DocumentBuilderFactory dbf= null;

		dbf = DocumentBuilderFactory.newInstance();

		try {

			DocumentBuilder db = dbf.newDocumentBuilder();

			InputSource is = new InputSource();
			is.setCharacterStream(new StringReader(xml));
			doc =db.parse(is);

		} catch (ParserConfigurationException e) {
			System.out.println("XML parse error: " + e.getMessage());
			return null;
		} catch (SAXException e) {
			System.out.println("Wrong XML file structure: " + e.getMessage());
			return null;
		} catch (IOException e) {
			System.out.println("I/O exeption: " + e.getMessage());
			return null;
		}

		return doc;
	}

	public static String convertStreamToString(InputStream is) throws IOException {
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

	public static String getValue(Element item, String str) {  
		NodeList n = item.getElementsByTagName(str);  
		return getElementValue(n.item(0));
	}

	public final static String getElementValue( Node elem ) {
		Node kid;
		if( elem != null){
			if (elem.hasChildNodes()){
				for( kid = elem.getFirstChild(); kid != null; kid = kid.getNextSibling() ){
					if( kid.getNodeType() == Node.TEXT_NODE  ){
						return kid.getNodeValue();
					}
				}
			}
		}
		return "";
	}

	public static String[] getTimeAndDescription(Element root, int index){
		String[] ret = new String[2];
		NodeList items = root.getElementsByTagName("item");
		if (items != null){
			Element t = (Element)items.item(index);
			if (t!=null){
				ret[0] = getValue(t, "pubDate");
				ret[1] = getValue(t, "description");
				return ret;
			}
		}
		return null;
	}

	public static Map<String, String> getAlertInfo(Element root, int index){

		Map<String,String> AletInfo = new HashMap<String,String>();

		NodeList items = root.getElementsByTagName("item");
		if (items != null){
			Element t = (Element)items.item(index);
			if (t!=null){

				AletInfo.put("title", getValue(t, "title"));
				AletInfo.put("pubDate", getValue(t, "pubDate"));
				AletInfo.put("link", getValue(t, "link"));
				AletInfo.put("description", getValue(t, "description"));

				return AletInfo;
			}
		}
		return null;
	}

}
