package com.example.demodomparser;

import java.io.IOException;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;


public class XMLfunctions {

	public final static Document XMLfromString(String xml){

		Document doc = null;

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try {

			DocumentBuilder db = dbf.newDocumentBuilder();

			InputSource is = new InputSource();
			is.setCharacterStream(new StringReader(xml));
			doc = db.parse(is);

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

	/** Returns element value
	 * @param elem element (it is XML tag)
	 * @return Element value otherwise empty String
	 */
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


	public static int numResults(Document doc){  
		Node results = doc.getDocumentElement();
		int res = -1;

		try{
			res = Integer.valueOf(results.getAttributes().getNamedItem("count").getNodeValue());
		}catch(Exception e ){
			res = -1;
		}

		return res;
	}

	public static String[] getTimeAndDescription(Element root, int index){
		String[] ret = new String[2];
		NodeList items = root.getElementsByTagName("item");
		if (items != null){
			Element t = (Element)items.item(index);
			if (t!=null){
				ret[0] = XMLfunctions.getValue(t, "pubDate");
				ret[1] = XMLfunctions.getValue(t, "description");
				return ret;
			}
		}
		return null;
	}

	public static String getValue(Element item, String str) {  
		NodeList n = item.getElementsByTagName(str);  
		return XMLfunctions.getElementValue(n.item(0));
	}
}