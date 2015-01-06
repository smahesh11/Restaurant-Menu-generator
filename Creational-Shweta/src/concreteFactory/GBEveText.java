package concreteFactory;

import java.util.ArrayList;

import interfaces.CreateMenuFormatter;
import interfaces.CreateMenuGenerator;
import interfaces.CreateReader;
import abstractClass.IMenuFormatter;
import abstractClass.IMenuGenerator;
import abstractClass.IReader;
import concreteClass.MenuFormatter;
import concreteClass.MenuGenerator;
import concreteClass.MenuReader;
import xyz.Xml;

public class GBEveText implements CreateMenuGenerator,CreateMenuFormatter,CreateReader{
	
	IReader reader=new MenuReader();
	IMenuGenerator menugenerator=new MenuGenerator();
	IMenuFormatter menuformatter=new MenuFormatter();
	
	public GBEveText() throws Exception
	{
		@SuppressWarnings("unchecked")
		ArrayList<Xml> data=reader.getReader("GB");
		ArrayList<Xml> newData=menugenerator.getMenu(data,"Evening");
		for(int i=0;i<newData.size();i++)
		{
		//	System.out.println(newData.get(i).toString());
		}
		menuformatter.generateMenu(newData,"Text","GBP");
	}
	
	
}

