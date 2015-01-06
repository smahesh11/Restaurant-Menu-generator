package xyz;

public class Xml {
	
	public String id;
	public String name;
	public String description;
	public String category;
	public String price;
	

	public Xml(String itemId,String name,String description, String category, String price)
	{
		this.id=id;
		this.name=name;
		this.description=description;
		this.category=category;
		this.price=price;
	}
	
	@Override
	public String toString()
	{
		
		return "\nid: "+id+"\nname: "+name+"\ndescription: "+description+"\ncategory: "+category+"\nprice: "+price;
		
	}
}
