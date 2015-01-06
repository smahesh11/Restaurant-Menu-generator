package concreteClass;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import abstractClass.IMenuFormatter;
import xyz.Xml;

public class MenuFormatter extends IMenuFormatter {

		
	@Override
	public void generateMenu(ArrayList<Xml> newData, String format,String country) throws Exception {
		// TODO Auto-generated method stub
		
		 if(format.equals("XML"))
		 { 
			 System.out.println("XML file created");
			 
		  try {
	 
			  //System.out.println("try");
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
	 
			// root elements
			Document doc = docBuilder.newDocument();
			Element rootElement = doc.createElement("MenuItems");
			doc.appendChild(rootElement);	
	 
			// staff elements
			
			Element staff = null;
			// set attribute to staff element
			String category="";
		for(int i=0;i<newData.size();i++)
		{
			//System.out.println("for loop");
			
			Xml e=newData.get(i);
			if(!e.category.equals(category))
			{
				//System.out.println("category xml");
				
				category=e.category;
				staff = doc.createElement("MenuCategory");
				rootElement.appendChild(staff);
				Attr attr = doc.createAttribute("category");
				attr.setValue(category.toUpperCase());
				staff.setAttributeNode(attr);
			}
			
			Element menuitem=doc.createElement("MenuItem");
			staff.appendChild(menuitem);
			Element firstname = doc.createElement("Name");
			firstname.appendChild(doc.createTextNode(e.name));
			menuitem.appendChild(firstname);
	 
			// lastname elements
			Element price=doc.createElement("Price");
			menuitem.appendChild(price);
			
			Element lastname = doc.createElement("CurrencyCode");
			lastname.appendChild(doc.createTextNode(country));
			price.appendChild(lastname);
	 
			Element lastname1 = doc.createElement("Amount");
			lastname1.appendChild(doc.createTextNode(e.price));
			price.appendChild(lastname1);
			// nickname elements
			Element nickname = doc.createElement("Description");
			nickname.appendChild(doc.createTextNode(e.description));
			menuitem.appendChild(nickname);
		}
			
			
	 
			
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File("MenuXML.xml"));
	 
			// Output to console for testing
			// StreamResult result = new StreamResult(System.out);
	 
			transformer.transform(source, result);
	 
			System.out.println("Find your file at: ");
	 
		  } catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		  } catch (TransformerException tfe) {
			tfe.printStackTrace();
		  }
		}
		 if(format.equals("Text"))
		 {
			 System.out.println("Text file created"); 
			 
			 Writer output = null;
			  File file = new File("MenuText.txt");
			  output = new BufferedWriter(new FileWriter(file));
			  String category="";
			  output.write("Menu\n\n\n");
			  for(int i=0;i<newData.size();i++)
				{
					Xml e=newData.get(i);
					if(!e.category.equals(category))
					{
						category=e.category;
						output.write(category.toUpperCase());
						output.write("\n\n");
					}
					output.write(e.name);
					output.write("\t \t \t \t ");
					
					if(country == "GBP")
					{output.write(country+e.price);}
					else
					{output.write("$"+e.price);}
					output.write("\n");
					output.write(e.description);
					output.write("\n\n");
					
				}	
				
				output.close();
			
			System.out.println("Find your file at: "); 
		 }
		 
		 if(format.equals("HTML"))
		 {
			 
			 System.out.println("HTML file created");
			  Writer output = null;
			  File file = new File("MenuHTML.html");
			  output = new BufferedWriter(new FileWriter(file));
			  output.write("<HTML><HEAD>	<TITLE>Menu</TITLE></HEAD><BODY>	<CENTER>Menu</CENTER>");
			  String category="";
			  for(int i=0;i<newData.size();i++)
				{
					Xml e=newData.get(i);
					if(!e.category.equals(category))
					{
						if(i!=0)
							output.write("</UL>");
						category=e.category;
						output.write("<H1>");
						output.write(category.toUpperCase());
						output.write("</H1> <UL>");
						output.write("&nbsp&nbsp&nbsp");
					}
					output.write("<LI><br>");
					output.write(e.name);
					output.write("<br><br>");
					output.write("&nbsp&nbsp&nbsp");
					output.write("<I>");
					output.write(e.description);
					output.write("</I><br><br>");
					output.write("&nbsp&nbsp&nbsp");
					output.write(country+e.price);
					output.write("</li><br>");
					output.write("<br>");
				}	
			  output.write("</UL></BODY></HTML>");
				output.close();
			
			 System.out.println("Find your file at: "); 
		 }
		
	}

	
	
}
