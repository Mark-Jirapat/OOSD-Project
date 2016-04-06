/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author USER
 */
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Bill extends JFrame implements ActionListener
{
	HotelDB hdb;
    	
        JButton bot1= new JButton ("Main");
	JButton bot2= new JButton ("Clear");
	JButton botP1= new JButton ("Price");
	JButton botP2= new JButton ("Price");
	JButton botTP= new JButton ("Total");
	JButton botC= new JButton ("Change");
	JButton botS= new JButton ("Search");
	JButton botOk= new JButton ("Ok");
	
	JLabel lab1= new JLabel ("Billings/Check-Out");
	JLabel labRN= new JLabel ("Room Number");
	JLabel labFN= new JLabel ("First Name");
	JLabel labMI= new JLabel ("MI");
	JLabel labLN= new JLabel ("Last Name: ");
	JLabel labDI= new JLabel ("Day-In:");
	JLabel labRS= new JLabel ("Room Size");
	JLabel labND= new JLabel ("No. of Days");
	JLabel labTP= new JLabel ("Total Price:");
	JLabel labYM= new JLabel ("Your Money:");
	JLabel labC= new JLabel ("Change:");
	JLabel labDn= new JLabel ("Down");
	
	JTextField txtRN= new JTextField ();
	JTextField txtLN= new JTextField ();
	JTextField txtMI= new JTextField ();
	JTextField txtFN= new JTextField ();	
	JTextField txtM= new JTextField ();
	JTextField txtD= new JTextField ();
	JTextField txtY= new JTextField ();
	JTextField txtRS= new JTextField ();
	JTextField txtND= new JTextField ();
	JTextField txtP1= new JTextField ();
	JTextField txtP2= new JTextField ();
	JTextField txtTP= new JTextField ();
	JTextField txtYM= new JTextField ();
	JTextField txtC= new JTextField ();
	JTextField txtDn= new JTextField ();

	
        String dialogmessage;
        String dialogs;
        int dialogtype = JOptionPane.PLAIN_MESSAGE;
        public static int record;
	static Connection cn;
	static Statement st;
	static PreparedStatement ps;
	static ResultSet rs;
	
	Container con = getContentPane();
	String Access = "C:\\Users\\USER\\Documents\\NetBeansProjects\\TermProject\\Pic"; // <- เปลี่ยน access ที่เก็บ Pic ไว้
	ImageIcon image = new ImageIcon(Access + "\\2.jpeg");
	JLabel back = new JLabel(image,JLabel.CENTER);
	
	Font font = new Font("Times new Roman", Font.BOLD, 20);

    public Bill() 
    {
    	con.setLayout(null);
    	con.add(botOk);
    	botOk.setBounds(100,600,100,30);
    	botOk.addActionListener(this);    	
    	con.add(bot2);
    	bot2.setBounds(210,600,100,30);
    	bot2.addActionListener(this);  
    	con.add(botP1);
    	botP1.setBounds(250,250,80,30);
    	botP1.addActionListener(this);    	
    	con.add(botP2);
    	botP2.setBounds(250,300,80,30);
    	botP2.addActionListener(this);
    	con.add(botTP);
    	botTP.setBounds(250,400,80,30);
    	botTP.addActionListener(this);    	
    	con.add(botC);
    	botC.setBounds(250,450,80,30);
    	botC.addActionListener(this); 
    	con.add(botS);
    	botS.setBounds(250,100,80,30);
    	botS.addActionListener(this);
    	con.add(bot1);
    	bot1.setBounds(320,600,100,30);
    	bot1.addActionListener(this); 
    	
    	con.add(lab1);
    	lab1.setBounds(50,50,300,30);
    	lab1.setFont(font);
    	con.add(labRN);
    	labRN.setBounds(50,100,300,30);
    	con.add(labFN);
    	labFN.setBounds(175,125,300,30);
    	con.add(labMI);
    	labMI.setBounds(325,125,300,30);
    	con.add(labLN);
    	labLN.setBounds(385,125,300,30);
   		con.add(labDI);
    	labDI.setBounds(50,200,150,30);
    	con.add(labRS);
    	labRS.setBounds(50,250,200,30);
   		con.add(labND);
    	labND.setBounds(50,300,150,30);
    	con.add(labDn);
    	labDn.setBounds(50,350,200,30);
    	con.add(labTP);
    	labTP.setBounds(50,400,150,30);
    	con.add(labYM);
    	labYM.setBounds(50,450,200,30);
   		con.add(labC);
    	labC.setBounds(50,500,150,30);
    	
    	con.add(txtRN);
    	txtRN.setBounds(150,100,100,30);
    	con.add(txtFN);
    	txtFN.setBounds(150,150,150,30);
    	txtFN.setEditable(false);
    	con.add(txtMI);
    	txtMI.setBounds(300,150,50,30);
    	txtMI.setEditable(false);
    	con.add(txtLN);
    	txtLN.setBounds(350,150,150,30);
    	txtLN.setEditable(false);
    	con.add(txtM);
    	txtM.setBounds(150,200,50,30);
    	txtM.setEditable(false);
    	con.add(txtD);
    	txtD.setBounds(200,200,50,30);
    	txtD.setEditable(false);
    	con.add(txtY);
    	txtY.setBounds(250,200,50,30);
    	txtY.setEditable(false);
    	con.add(txtRS);
    	txtRS.setBounds(150,250,80,30);
    	txtRS.setEditable(false);
    	con.add(txtND);
    	txtND.setBounds(150,300,50,30);
    	txtND.setEditable(false);
    	con.add(txtP1);
    	txtP1.setBounds(350,250,80,30);
    	txtP1.setEditable(false);
    	con.add(txtP2);
    	txtP2.setBounds(350,300,80,30);
    	txtP2.setEditable(false);
    	con.add(txtDn);
    	txtDn.setBounds(150,350,80,30);
    	txtDn.setEditable(false);
    	con.add(txtTP);
    	txtTP.setBounds(150,400,80,30);
    	txtTP.setEditable(false);
    	con.add(txtYM);
    	txtYM.setBounds(150,450,80,30);
    	con.add(txtC);
    	txtC.setBounds(150,500,80,30);
    	txtC.setEditable(false);
    	
    	con.add(back).setBounds(0,0,700,700);
    }
    public void actionPerformed (ActionEvent e)
    {
    		String Room_No = "";
		String Last_Name = "";
		String Middle_Initial = "";
		String First_Name = "";
		String Contact_No  = "";
		String Address   = ""; 
		String Month = "";
		String Day = "";
		String Year = "";
		String Room_Size = "";
		String No_Days  = "";
		String Down  = "";
			
		double single = 300;
		double duble = 500;
		double family = 1000;
    	Object source = e.getSource();
    	
		if(source == botS)
		{
		Room_No = txtRN.getText().trim();
         if (!Room_No.equals(""))
         {	
        	System.out.println(hdb.db.connect());
      		String query = "SELECT * FROM Hotel_CheckIn WHERE room ='" + Room_No +"'";
      		ArrayList<HashMap> list = hdb.db.queryRows(query);
                 int foundrec = 0;
                 for (HashMap l : list)
                 {
                 	Last_Name = (String)(l.get("lastname"));
 			Middle_Initial = (String)(l.get("middle"));
 			First_Name = (String)(l.get("name"));
 			Contact_No = (String)(l.get("contact"));
                         Address = (String)(l.get("address"));
 			Month = (String)(l.get("month"));
 			Day = (String)(l.get("day"));
 			Year = (String)(l.get("year"));
 			Room_Size = (String)(l.get("room_size"));
 			No_Days = (String)(l.get("no_day"));
 			Down = (String)(l.get("down"));
 		
                 	txtFN.setText(First_Name);               	
                 	txtMI.setText(Middle_Initial);	
                 	txtLN.setText(Last_Name);  
                 	txtC.setText(Contact_No);	           	
                 	txtM.setText(Month);
                 	txtY.setText(Year);               	
                 	txtD.setText(Day);	
                 	txtRS.setText(Room_Size);             	
                 	txtND.setText(No_Days);
                 	txtDn.setText(Down);
                	
                    foundrec = 1;
                    
                } 
     		if (foundrec == 0)
                {
                    dialogmessage = "No Such Room";               
                    dialogtype = JOptionPane.WARNING_MESSAGE;
                    JOptionPane.showMessageDialog((Component)null, dialogmessage, dialogs, dialogtype);
                   	clear();
                }
                
         }
         else
         {
         			dialogmessage = "No Blank Field Allowed";          
                    dialogtype = JOptionPane.WARNING_MESSAGE;
                    JOptionPane.showMessageDialog((Component)null, dialogmessage, dialogs, dialogtype);
                    clear();
                   
         }    
          System.out.println(hdb.db.disconnect());
     		
		}
		if(source == botP1)
		{
			if(txtRS.getText().equals("Single"))
			{
				txtP1.setText(""+single);
			}
			if(txtRS.getText().equals("Double"))
			{
				txtP1.setText(""+duble);
			}
			if(txtRS.getText().equals("Family"))
			{
				txtP1.setText(""+family);
			}
		}
		if(source == botP2)
    	{
    		double total=(Double.parseDouble(txtND.getText()));
    		
    		double totals = total * single;
    		double totald = total * duble;
    		double totalf = total * family;
    		if(txtRS.getText().equals("Single"))
			{
				txtP2.setText(""+totals);
			}
			if(txtRS.getText().equals("Double"))
			{
				txtP2.setText(""+totald);
			}
			if(txtRS.getText().equals("Family"))
			{
				txtP2.setText(""+totalf);
			}	
				
    	}
    	if(source == botTP)
    	{
    		double t2=(Double.parseDouble(txtP2.getText()));
    		double t1=(Double.parseDouble(txtDn.getText()));
    		
    		double total1=t2-t1;
    		txtTP.setText(""+total1);
    			
    	}
    	if(source == botC)
    	{
    		double t1=(Double.parseDouble(txtTP.getText()));
    		double t2=(Double.parseDouble(txtYM.getText()));
    		double total= t2-t1;
    		
    		if(t2<t1)
    		{
                    dialogmessage = "Not Enough Money";          
                    dialogtype = JOptionPane.WARNING_MESSAGE;
                    JOptionPane.showMessageDialog((Component)null, dialogmessage, dialogs, dialogtype);
                    txtC.setText("");
    		}
    		else
    		{
    			txtC.setText(""+total);
    		}		
    	}
    	if(source == botOk)
    	{
    		int DResult = JOptionPane.showConfirmDialog((Component) null,"Are you sure you want to Check Out?");
			if (DResult == JOptionPane.NO_OPTION) 
			{
			clear();
			} 		 
	 		if (DResult == JOptionPane.YES_OPTION)
         	{
            try
              {
            	    System.out.println(hdb.db.connect());  
			    	Room_No = txtRN.getText().trim();	              
                         if ( !Room_No.equals(""))
                         {
                                   	
                        	String sql = "DELETE from Hotel_CheckIn" + " WHERE room = '" + Room_No + "'";
                            	System.out.println(hdb.db.executeQuery(sql));
                            	int result = 1;
                                   if ( result == 1)
                                 	{
                                 	dialogmessage = "Thank You Come Again..!";
                    			dialogtype = JOptionPane.WARNING_MESSAGE;
                    			JOptionPane.showMessageDialog((Component)null, dialogmessage, dialogs, dialogtype);
                    			clear();
                              		}
                        }  
                 System.out.println(hdb.db.disconnect());     
            }

            catch(Exception ex)
           {
               System.out.println("\nUnknown Error" + ex);
               dialogmessage = "ERROR"; 
               dialogtype = JOptionPane.WARNING_MESSAGE;
               JOptionPane.showMessageDialog((Component)null, dialogmessage, dialogs, dialogtype);
           }
          
    	}				
    	}
	   	if(source == bot1)
    	{
    		TheMain main = new TheMain();
           	main.setMain();
           	main.setDB(hdb);
           	dispose();
    		
    	}
    	if(source == bot2)
    	{
			clear();	
    	}
    	
    }
     private void clear()
    {
                txtRN.setText("");
	 	txtLN.setText("");
	 	txtMI.setText("");
	 	txtFN.setText("");	
	 	txtM.setText("");
	 	txtD.setText("");
	 	txtY.setText("");
		txtRS.setText("");
	 	txtND.setText("");
	 	txtP1.setText("");
	 	txtP2.setText(""); 
		txtTP.setText("");
		txtYM.setText("");
	 	txtC.setText("");
	 	txtDn.setText("");
    }
    public  void setBill()
    {
    	setTitle("Hotel Reservation System");
    	setVisible(true);
    	Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
    	setLocation(100,5);
    	setSize((screen.width-1150),screen.height-250);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void setDB(HotelDB hdb)
    {
    	this.hdb = hdb;
    }
    
    
}
