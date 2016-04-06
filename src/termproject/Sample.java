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
public class Sample extends JFrame implements ActionListener
{
	HotelDB hdb;
	/*public static void main(String[]args)
	{ 
	    setSample();
    }*/
        JFrame frame= new JFrame("Administrator Login");
        JLabel labTitle = new JLabel("Group-6 Project");
        JLabel labuser = new JLabel("Username:");
	JLabel labpass = new JLabel("Password:");
	JTextField txtuser = new JTextField();
	JPasswordField txtpass = new JPasswordField();
        String Access = "C:\\Users\\USER\\Documents\\NetBeansProjects\\TermProject\\Pic"; // <- เปลี่ยน access ที่เก็บ Pic ไว้
	JButton bLogin = new JButton(new ImageIcon(Access + "\\ok.jpeg"));
	JButton bClose = new JButton(new ImageIcon(Access + "\\eks.jpeg"));
        JButton bRegis = new JButton(new ImageIcon(Access + "\\Edit.png"));
	public String loginname="";
   	public String loginpass="";
	Connection cn;
	Statement st;
	ResultSet rs;
	PreparedStatement ps;
	public String user="";
	public String pass="";
	public int cnt;
	int dialogtype = JOptionPane.PLAIN_MESSAGE;
   	String dialogmessage;
   	String dialogs;
   	
    public  void setSample()
    {
           /* Sample p1= new Sample();
	    p1.setSize(350,190);
	    p1.setLocation(300,300);
	    p1.setVisible(true);
	    p1.setResizable(false);*/
	    setSize(350,190);
	    setLocation(300,300);
	    setVisible(true);
	    setResizable(false);
	}

    public Sample() 
    {
    	super("Administrator Login");
    	JPanel pane= new JPanel();
    	pane.setLayout(null);
    	
    	
    	labuser.setForeground(Color.red);
    	labpass.setForeground(Color.blue);
    	
        pane.add(labTitle);
        labTitle.setBounds(175, 5, 100, 20);
        
    	pane.add(labuser);
    	labuser.setBounds(15,35,100,20);
    	pane.add(txtuser);
    	txtuser.setBounds(120,35,190,20);
    
    	pane.add(labpass);
    	labpass.setBounds(15,60,100,20);
    	pane.add(txtpass);
    	txtpass.setBounds(120,60,190,20);
    
        pane.add(bLogin);
    	bLogin.setBounds(200,105,40,35);
    	bLogin.addActionListener(this);
    	
    	pane.add(bClose);
    	bClose.setBounds(245,105,40,35);
    	bClose.addActionListener(this);
    	
        pane.add(bRegis);
        bRegis.setBounds(155, 105, 40, 35);
        bRegis.addActionListener(this);
        
	bLogin.setToolTipText("Log-in");
        bClose.setToolTipText("Exit");
        bRegis.setToolTipText("Sign-in");
        
    	setContentPane(pane);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	pane.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), ""));
    	/*
    	try
    	{
			Class.forName("com.mysql.jdbc.Driver");

			connect = DriverManager.getConnection(""
					+ "jdbc:mysql://localhost/mydatabase"
					+ "?user=root&password=root");

			s = connect.createStatement();
        }catch(ClassNotFoundException e){
 			JOptionPane.showMessageDialog(null,"unable to load driver");
 			System.exit(0);
 	}catch(SQLException e){
 			JOptionPane.showMessageDialog(null,"unable to connect");
 			System.exit(0);
	}
        */
    }
    public void actionPerformed(ActionEvent e)
    {
    	 Object source=e.getSource();
    	 if(source==bRegis)
         {
                Register sign = new Register();
                sign.setRegis();
                sign.setDB(hdb);
                dispose();
         }
         if(source==bLogin)
         {
    			String str1=txtuser.getText();
			String str2= new String(txtpass.getPassword());
    			if((str1.length()==0 || str2.length()==0))
    			{
    					JOptionPane.showMessageDialog(null,"Some Fields are empty","WARNING",JOptionPane.WARNING_MESSAGE);
    			}
    			else
    			{
    				if(hdb.logIn(txtuser.getText() , new String(txtpass.getPassword())))
    				{	
    			        TheMain main = new TheMain();
                  	    main.setMain();	
                  	    main.setDB(hdb);
                        dialogmessage = "Welcome: "+txtuser.getText();
                	    dialogtype = JOptionPane.INFORMATION_MESSAGE;
                        JOptionPane.showMessageDialog((Component)null, dialogmessage, dialogs, dialogtype);
                    	txtuser.setText("");
                    	txtpass.setText("");
            		    dispose();
    				}
                    else 
                	{
                    	JOptionPane.showMessageDialog(null, "INVALID ID OR PASSWORD!","WARNING!!",JOptionPane.WARNING_MESSAGE);
                    	cnt=cnt+1;
                   		txtuser.setText("");
                    	txtpass.setText("");
                	}		
    			
    				if(cnt==3)
    				{
    				   dispose();
    				}
    			}
    		    //dispose();
    		} 	
                
         
    	if(source==bClose)
    	{
    		//System.exit(0);
    		dispose();
    	}
    }
    
    public void setDB(HotelDB hdb)
    {
    	this.hdb = hdb;
    }
}
