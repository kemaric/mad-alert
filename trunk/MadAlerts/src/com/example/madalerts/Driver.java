package com.example.madalerts;


import java.util.ArrayList;
import java.util.HashMap;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;





public class Driver {

	static ArrayList<Alert> Alertlist;

	public static ArrayList<Alert> loadFeed(){

		Document dom = Parser.XMLfromURL("https://alert.umd.edu/rssfeed.php");
		Element root = dom.getDocumentElement();
		NodeList alertList = root.getElementsByTagName("item");

		ArrayList<String> list = new ArrayList<String>();
		 Alertlist = new ArrayList<Alert>();
		
		HashMap<String,String> AlertInfo;
		for (int i=0  ; i< alertList.getLength() ;i++){
			String[] d = Parser.getTimeAndDescription(root, i);
			AlertInfo = (HashMap<String,String>) Parser.getAlertInfo(root, i);
			Alertlist.add(CreateAlertObject(AlertInfo));
			
			list.add(chop(d[1]));
			
			//			NamedNodeMap  pList = alertList.item(i).getAttributes();
			//			list.add(pList.getNamedItem("description").getNodeValue());
		}

		return Alertlist;
	}


	public static Alert CreateAlertObject(HashMap<String,String> AlertInfo){
		String title = AlertInfo.get("title");
		String pubDate = AlertInfo.get("pubDate");
		String discription = AlertInfo.get("description");
		discription=chop(discription);
		String link = discription = AlertInfo.get("link");

		return	new Alert(title,link ,discription, pubDate);

	}

	private static String chop(String s){

		return	s.split("UMD Alerts is powered by Cooper Notification RSAN$")[0].trim();

	}
}
