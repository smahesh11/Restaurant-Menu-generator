package concreteClass;

import java.util.ArrayList;

import xyz.Xml;

import abstractClass.IMenuGenerator;


public class MenuGenerator extends IMenuGenerator {

	

	@Override
	public ArrayList<Xml> getMenu(ArrayList<Xml> data, String menuformat) {
		// TODO Auto-generated method stub
		ArrayList<Xml> newData=new ArrayList<Xml>();
		
	if(menuformat.equals("Dinner"))
	{
				
		for(int i=0;i<data.size();i++)
		{
			Xml element=data.get(i);
			if(element.category.equals("Breakfast"))
			{
				//System.out.println("Breakfast");
				newData.add(element);
			}
		}
		for(int i=0;i<data.size();i++)
		{
			Xml element=data.get(i);
			if(element.category.equals("Snack"))
			{
				//System.out.println("Snack");
				newData.add(element);
			}
		}
		
		for(int i=0;i<data.size();i++)
		{
			Xml element=data.get(i);
			if(element.category.equals("Appetizer"))
			{
			//	System.out.println("Appetizer");
				newData.add(element);
			}
		}
		
		
		for(int i=0;i<data.size();i++)
		{
			Xml element=data.get(i);
			if(element.category.equals("Lunch"))
			{
			//	System.out.println("Lunch");
				newData.add(element);
			}
		}
		
		
		for(int i=0;i<data.size();i++)
		{
			Xml element=data.get(i);
			if(element.category.equals("Dessert"))
			{
				newData.add(element);
			}
		}
	}
		

	
	else if(menuformat.equals("Evening"))
	{
				
		
		for(int i=0;i<data.size();i++)
		{
			Xml element=data.get(i);
			if(element.category.equals("Appetizer"))
			{
			//	System.out.println("Appetizer");
				newData.add(element);
			}
		}
		
		
		for(int i=0;i<data.size();i++)
		{
			Xml element=data.get(i);
			if(element.category.equals("Dinner"))
			{
			//	System.out.println("Dinner");
				newData.add(element);
			}
		}
		
		
		
		for(int i=0;i<data.size();i++)
		{
			Xml element=data.get(i);
			if(element.category.equals("Dessert"))
			{
				newData.add(element);
			}
		}

		for(int i=0;i<data.size();i++)
		{
			Xml element=data.get(i);
			if(element.category.equals("Side Dish"))
			{
				newData.add(element);
			}
		}

	}
	else if(menuformat.equals("AllDay"))
	{
				
		for(int i=0;i<data.size();i++)
		{
			Xml element=data.get(i);
			if(element.category.equals("Breakfast"))
			{
				//System.out.println("Breakfast");
				newData.add(element);
			}
		}
		for(int i=0;i<data.size();i++)
		{
			Xml element=data.get(i);
			if(element.category.equals("Snack"))
			{
				//System.out.println("Snack");
				newData.add(element);
			}
		}
		
		for(int i=0;i<data.size();i++)
		{
			Xml element=data.get(i);
			if(element.category.equals("Appetizer"))
			{
			//	System.out.println("Appetizer");
				newData.add(element);
			}
		}
		
		
		for(int i=0;i<data.size();i++)
		{
			Xml element=data.get(i);
			if(element.category.equals("Lunch"))
			{
			//	System.out.println("Lunch");
				newData.add(element);
			}
		}
		
		
		
		for(int i=0;i<data.size();i++)
		{
			Xml element=data.get(i);
			if(element.category.equals("Dinner"))
			{
			//	System.out.println("Dinner");
				newData.add(element);
			}
		}
		
			
		for(int i=0;i<data.size();i++)
		{
			Xml element=data.get(i);
			if(element.category.equals("Dessert"))
			{
				newData.add(element);
			}
		}

		for(int i=0;i<data.size();i++)
		{
			Xml element=data.get(i);
			if(element.category.equals("Side Dish"))
			{
				newData.add(element);
			}
		}

	}
		
		return newData;
		
	}


}
