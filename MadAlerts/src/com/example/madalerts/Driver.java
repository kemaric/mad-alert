package com.example.madalerts;

import java.util.ArrayList;
import java.util.HashMap;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;

public final class Driver {
	static final int NEVER_LOADED = -1;
	static final int LOAD_FROM_RSS = 1;
	static final int LOAD_FROM_DATABASE = 2;

	public static ArrayList<Alert>Alertlist = new ArrayList<Alert>();
	public static ArrayList <Alert>rawList = new ArrayList<Alert>();

	static int LAST_LOAD = NEVER_LOADED;

	private Driver() {

	}

	public static ArrayList<Alert>  loadFeed(String urlString) {

		Document dom =  Parser.XMLfromURL(urlString);
		if (dom !=null){
			Element root = dom.getDocumentElement();
			NodeList alertList = root.getElementsByTagName("item");

			// ArrayList<String> list = new ArrayList<String>();
			//ArrayList<Alert>Alertlist = new ArrayList<Alert>();
			Alertlist.clear();
			HashMap<String, String> AlertInfo;
			for (int i = 0; i < alertList.getLength(); i++) {
				// String[] d = Parser.getTimeAndDescription(root, i);
				AlertInfo = (HashMap<String, String>) Parser.getAlertInfo(root, i);
				Alert alert = CreateAlertObject(AlertInfo);
				Alertlist.add(alert);

				// list.add(chop(d[1]));

				// NamedNodeMap pList = alertList.item(i).getAttributes();
				// list.add(pList.getNamedItem("description").getNodeValue());
			}
		}
		return Alertlist ;

	}

	public static Alert CreateAlertObject(HashMap<String, String> AlertInfo) {
		String title = AlertInfo.get("title");
		String pubDate = AlertInfo.get("pubDate");
		String discription = AlertInfo.get("description");
		discription = chop(discription);
		String link = AlertInfo.get("link");

		return new Alert(title, link, discription, pubDate);

	}

	private static String chop(String s) {

		return s.split("UMD Alerts is powered by Cooper Notification RSAN$")[0]
				.trim();

	}
}
