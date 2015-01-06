package concreteClass;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Iterator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import abstractClass.IReader;
import xyz.Xml;

import org.apache.commons.io.*;



public class MenuReader extends IReader {

	ArrayList<Xml> read = new ArrayList<Xml>();

	@Override
	public ArrayList<Xml> getReader(String country) throws Exception {

		if(country.equals("GB"))
		{
			readXML(country);
			if(read.size()==0)
			{readJson(country);}
			}
		if(country.equals("US"))
		{
			readJson(country);
			if(read.size()==0)
			{readXML(country);}
		}
		return read;
	}

	public void readXML(String country) {
		try {

			File XmlFile = new File("InputFiles/FoodItemData.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(XmlFile);
			doc.getDocumentElement().normalize();

			

			NodeList nList = doc.getElementsByTagName("FoodItem");
			System.out.println("-----------------------");

			for (int temp = 0; temp < nList.getLength(); temp++) {
			
				Node nNode = nList.item(temp);
				if (nNode.getNodeType() == Node.ELEMENT_NODE
						&& (nNode.getAttributes().getNamedItem("country")
								.getNodeValue()).equals(country)) {

					Element eElement = (Element) nNode;
					

					read.add(new Xml(getTagValue("id", eElement),
							getTagValue("name", eElement), getTagValue("description", eElement), getTagValue("category", eElement), getTagValue("price",
									eElement)));
					
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static String getTagValue(String sTag, Element eElement) {
		NodeList nlList = eElement.getElementsByTagName(sTag).item(0).getChildNodes();

		Node nValue = nlList.item(0);

		return nValue.getNodeValue();
	}

	public void readJson(String Country) throws IOException {

	FileReader fReader = new FileReader("InputFiles/FoodItemData.json");
	BufferedReader bReader = new BufferedReader(fReader);
	
		String content = IOUtils.toString(bReader);
		JSONObject json = (JSONObject) JSONSerializer.toJSON(content);
		JSONArray arr = json.getJSONArray("FoodItemData");
		@SuppressWarnings("rawtypes")
		Iterator iter = arr.iterator();
		while (iter.hasNext()) {
			JSONObject object = (JSONObject) iter.next();
			if (object.getString("-country").equals(Country)) {
				Xml f = new Xml(object.getString("id"),
						object.getString("name"),
						object.getString("description"),
						object.getString("category"), 
						object.getString("price"));

				read.add(f);
				bReader.close();
				fReader.close();
			}
		}
		
	}

	
}
