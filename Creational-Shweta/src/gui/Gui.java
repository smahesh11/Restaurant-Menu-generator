public package gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.ItemSelectable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import singleton.MenuFactory;


public class Gui extends JFrame implements ActionListener
{
		
	private static final long serialVersionUID = 1L;
	JRadioButton GreatBritain,UnitedStates;
	JRadioButton Dinner,Evening,AllDay;
	JRadioButton Text,XML,HTML;
	ButtonGroup buttonGroup1 = new ButtonGroup();
	ButtonGroup buttonGroup2 = new ButtonGroup();
	ButtonGroup buttonGroup3 = new ButtonGroup();
	JButton Submit;
	JLabel filepath;
	JTextField path;
	
	
public Gui()
{
	
	//System.out.println("GUI");
	
	setLayout(new GridBagLayout());
	GridBagConstraints gbc= new GridBagConstraints();
	gbc.ipadx=6;
	gbc.ipady=11;
	
	JRadioButton GreatBritain = new JRadioButton("Great Britain",true);
	gbc.fill= GridBagConstraints.HORIZONTAL;
    gbc.gridx=1;
    gbc.gridy=1;
    add(GreatBritain,gbc);
    GreatBritain.setActionCommand("GB");
    buttonGroup1.add(GreatBritain);
   
    JRadioButton UnitedStates = new JRadioButton("United States",false);
    gbc.fill= GridBagConstraints.HORIZONTAL;
    gbc.gridx=1;
    gbc.gridy=2;
    add(UnitedStates,gbc);
    UnitedStates.setActionCommand("US");
    buttonGroup1.add(UnitedStates);
   
    JRadioButton  Dinner= new JRadioButton("Dinner",true);
	gbc.fill= GridBagConstraints.HORIZONTAL;
    gbc.gridx=2;
    gbc.gridy=1;
    add(Dinner,gbc);
    Dinner.setActionCommand("Dinner");
    buttonGroup2.add(Dinner);
   
    JRadioButton Evening = new JRadioButton("Evening",false);
    gbc.fill= GridBagConstraints.HORIZONTAL;
    gbc.gridx=2;
    gbc.gridy=2;
    add(Evening,gbc);
    Evening.setActionCommand("Evening");
    buttonGroup2.add(Evening);
    
    JRadioButton AllDay = new JRadioButton("AllDay",false);
    gbc.fill= GridBagConstraints.HORIZONTAL;
    gbc.gridx=2;
    gbc.gridy=3;
    add(AllDay,gbc);
    AllDay.setActionCommand("AllDay");
    buttonGroup2.add(AllDay);

    JRadioButton Text = new JRadioButton("Text",true);
	gbc.fill= GridBagConstraints.HORIZONTAL;
    gbc.gridx=3;
    gbc.gridy=1;
    add(Text,gbc);
    Text.setActionCommand("Text");
    buttonGroup3.add(Text);
   
    JRadioButton XML = new JRadioButton("XML",false);
    gbc.fill= GridBagConstraints.HORIZONTAL;
    gbc.gridx=3;
    gbc.gridy=2;
    add(XML,gbc);
    XML.setActionCommand("XML");
    buttonGroup3.add(XML);
    
    JRadioButton HTML = new JRadioButton("HTML",false);
    gbc.fill= GridBagConstraints.HORIZONTAL;
    gbc.gridx=3;
    gbc.gridy=3;
    add(HTML,gbc);
    HTML.setActionCommand("HTML");
    buttonGroup3.add(HTML);

    Submit= new JButton("Submit");
    gbc.fill= GridBagConstraints.HORIZONTAL;
    gbc.gridx=1;
    gbc.gridy=5;
    gbc.gridwidth=3;
    add(Submit,gbc);
    
    filepath=new JLabel("File Location:");
	gbc.fill= GridBagConstraints.HORIZONTAL;
    gbc.gridx=1;
    gbc.gridy=14;
    add(filepath,gbc);
    
    path= new JTextField(10);
    path.setText("");
	gbc.fill= GridBagConstraints.HORIZONTAL;
    gbc.gridx=2;
    gbc.gridy=14;
    gbc.gridwidth=3;
    add(path,gbc);
    
    Submit.addActionListener(this);
    
}
	@Override
	public void actionPerformed(ActionEvent e)
		{
		//System.out.println("action");
	
   if(e.getActionCommand().equals("Submit"))
   {
	   //System.out.println("Submit");
	  try
	  {
	   ButtonModel choice1 = buttonGroup1.getSelection();
	   ButtonModel choice2 = buttonGroup2.getSelection();
	   ButtonModel choice3 = buttonGroup3.getSelection();
	  
	 // System.out.println("submit try");
	   
	  if (choice1 != null || choice2 != null || choice3 != null ) 
          {
		 // System.out.println("checks the choice");
			String com1,com2,com3;
	         com1=choice1.getActionCommand();
	         com2=choice2.getActionCommand();
	         com3=choice3.getActionCommand();
          System.out.println(choice1.getActionCommand());
          System.out.println(choice2.getActionCommand());
         System.out.println(choice3.getActionCommand());
         		MenuFactory object = MenuFactory.getInstance();
         		object.menu(com1,com2,com3);
         
  		       path();
          }
          else System.out.println("Sorry");
      }
	 
	  catch(Exception ee)
	  {
		  System.out.println("Exception caught here");
	  }

    }

		}
	
	public void path() {
		String filepath = String.format("%s", System.getProperty("user.dir"), this.getName().replace(".", "/"));
	    System.out.println(filepath);
	    path.setText(filepath);
	}
	


}
