


import javax.swing.JFrame;

public class RunHere {
	public static void main(String[] args) 
	{
		
		// TODO Auto-generated method stub
		try
		{
			//System.out.print("Hello");
			Gui g1=new Gui();
			g1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			g1.setVisible(true);
			g1.setSize(600,500);
			g1.setTitle("\tRestaurant Menu Generator");
		}
		
		catch (Exception e)
		{
			e.printStackTrace();// TODO Auto-generated method stub
		}
	}

}

