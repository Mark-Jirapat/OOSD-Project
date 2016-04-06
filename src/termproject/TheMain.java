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

public class TheMain extends JFrame implements ActionListener
{
	HotelDB hdb;
   	JDesktopPane desktop = new JDesktopPane();
	JLabel lab1= new JLabel ("Welcome");
	JLabel lab2= new JLabel ("To");
	JLabel lab3= new JLabel ("Group 6 - Hotel System");
	JLabel lab4 = new JLabel ("Log-out");
	String Access = "C:\\Users\\USER\\Documents\\NetBeansProjects\\TermProject\\Pic";
	JButton bcheck = new JButton("Check-in");
	JButton breserve = new JButton("Reservation");
	JButton bbill = new JButton("Billings");
	JButton out = new JButton(new ImageIcon(Access + "\\logout.png"));
	
	Container con = getContentPane();
	Font font1 = new Font("Castellar", Font.BOLD,50);
	Font font2 = new Font("Edwardian Script ITC", Font.BOLD, 30);
	Font font3 = new Font("Castellar", Font.BOLD,20);
	ImageIcon image = new ImageIcon(Access + "\\main.jpg");
	JLabel back = new JLabel(image,JLabel.CENTER);
        

    public TheMain() 
    {
    	con.setLayout(null);
    	
    	con.add(lab1);
    	lab1.setBounds(100,5,300,150);
    	lab1.setFont(font1);
    	con.add(lab2);
    	lab2.setBounds(220,100,50,50);
        lab2.setFont(font3);
    	con.add(lab3);
    	lab3.setBounds(100,150,1000,50);
    	lab3.setFont(font2);
    	con.add(lab4);
    	lab4.setBounds(50,400,300,30);
    	
    	con.add(bcheck);
    	bcheck.setBounds(90,300,100,30);
    	bcheck.addActionListener(this);
        
    	con.add(breserve);
    	breserve.setBounds(200,300,130,30);
    	breserve.addActionListener(this);
        
    	con.add(bbill);
    	bbill.setBounds(340,300,100,30);
    	bbill.addActionListener(this);
    	
        con.add(out);
    	out.setBounds(100,400,30,30);
    	out.addActionListener(this);
    	
    	con.add(back).setBounds(0,0,900,900);
    	
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
     public void actionPerformed (ActionEvent e)
    {
    	Sample log= new Sample();
    	CheckIn in= new CheckIn();
    	Reserve rev = new Reserve();
    	Bill bill = new Bill();
    	Object source = e.getSource();
    	if(source == bcheck)
    	{
    		in.setCheckIn();
    		in.setDB(hdb);
    		dispose();
    		
    	}
    	if(source == breserve)
    	{
    		rev.setReserve();
    		rev.setDB(hdb);
    		dispose();
    	}
    	if(source == bbill)
    	{
    		bill.setBill();
    		bill.setDB(hdb);
    		dispose();
    	}
    	if(source == out)
	{
		log.setSample();
		log.setDB(hdb);
		dispose();
	}
    }
       
     public  void setMain ()
    {
    	setTitle("Hotel Reservation System");
        setVisible(true);
    	Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
    	setLocation(100,5);
    	setSize((screen.width-1370),screen.height-500);
    }
     
     public void setDB(HotelDB hdb)
     {
     	this.hdb = hdb;
     }
    
    
}
