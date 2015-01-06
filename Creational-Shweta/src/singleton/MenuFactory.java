package singleton;

import interfaces.CreateReader;
import concreteFactory.GBAllDayHTML;
import concreteFactory.GBAllDayText;
import concreteFactory.GBAllDayXML;
import concreteFactory.GBDinnerHTML;
import concreteFactory.GBDinnerText;
import concreteFactory.GBDinnerXML;
import concreteFactory.GBEveHTML;
import concreteFactory.GBEveText;
import concreteFactory.GBEveXML;
import concreteFactory.USAllDayHTML;
import concreteFactory.USAllDayText;
import concreteFactory.USAllDayXML;
import concreteFactory.USDinnerHTML;
import concreteFactory.USDinnerText;
import concreteFactory.USDinnerXML;
import concreteFactory.USEveHTML;
import concreteFactory.USEveText;
import concreteFactory.USEveXML;

public class MenuFactory {
	
	private static  MenuFactory object;
	 
    private MenuFactory() {
       //Instantiate the object.
    }

    public static MenuFactory getInstance() {
        if (object == null) {
            object = new MenuFactory(); // Create the object for the first and last time
        }
        return object;
    }
	
	public void menu(String country,String menutype, String format) throws Exception
	{
		CreateReader reader;
		
		if(country.equals("US") && menutype.equals("Dinner") && format.equals("XML"))
		{
			//System.out.println("Us Dinner Xml");
			reader=new USDinnerXML();
			
			
		}
		if(country.equals("US") && menutype.equals("Dinner") && format.equals("Text"))
		{
			//System.out.println("Us Dinner Text");
			reader=new USDinnerText();
			
			
		}
		
		if(country.equals("US") && menutype.equals("Dinner") && format.equals("HTML"))
		{
			reader=new USDinnerHTML();
			
			
		}
		
		if(country.equals("GB") && menutype.equals("Dinner") && format.equals("XML"))
		{
			reader=new GBDinnerXML();
			
			
		}
		if(country.equals("GB") && menutype.equals("Dinner") && format.equals("Text"))
		{
			System.out.println("GB Dinner Text");
			reader=new GBDinnerText();
			
			
		}
		
		if(country.equals("GB") && menutype.equals("Dinner") && format.equals("HTML"))
		{
			reader=new GBDinnerHTML();
			
			
		}
		
		if(country.equals("US") && menutype.equals("Evening") && format.equals("XML"))
		{
			System.out.println("GB Dinner Xml");
			reader=new USEveXML();
			
			
		}
		if(country.equals("US") && menutype.equals("Evening") && format.equals("Text"))
		{
			reader=new USEveText();
			
			System.out.println("Us Eve text");
		}
		
		if(country.equals("US") && menutype.equals("Evening") && format.equals("HTML"))
		{
			reader=new USEveHTML();
			
			
		}
		
		if(country.equals("GB") && menutype.equals("Evening") && format.equals("XML"))
		{
			reader=new GBEveXML();
			
			
		}
		if(country.equals("GB") && menutype.equals("Evening") && format.equals("Text"))
		{
			reader=new GBEveText();
			
			
		}
		
		if(country.equals("GB") && menutype.equals("Evening") && format.equals("HTML"))
		{
			reader=new GBEveHTML();
			
			
		}
		
		if(country.equals("GB") && menutype.equals("AllDay") && format.equals("XML"))
		{
			reader=new GBAllDayXML();
			
			
		}
		if(country.equals("GB") && menutype.equals("AllDay") && format.equals("Text"))
		{
			reader=new GBAllDayText();
			
			
		}
		
		if(country.equals("GB") && menutype.equals("AllDay") && format.equals("HTML"))
		{
			reader=new GBAllDayHTML();
			
			
		}
		if(country.equals("US") && menutype.equals("AllDay") && format.equals("XML"))
		{
			reader=new USAllDayXML();
			
			
		}
		if(country.equals("US") && menutype.equals("AllDay") && format.equals("Text"))
		{
			reader=new USAllDayText();
			
			
		}
		
		if(country.equals("US") && menutype.equals("AllDay") && format.equals("HTML"))
		{
			System.out.println("US AllDay HTML");
			reader=new USAllDayHTML();
			
			
		}
		//System.out.println("menu check");
	}

}
