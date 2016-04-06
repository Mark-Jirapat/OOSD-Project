/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author march
 */
import java.awt.*;
import java.sql.*;

import javax.swing.*;

import java.awt.event.*;

public class Register extends JFrame
{
	HotelDB hdb;
	
    //JFrame frame= new JFrame("Sign-in");
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	private JPasswordField txtConfirmPassword;
	private JTextField txtName;
	private JTextField txtEmail;
        String Access = "C:\\Users\\USER\\Documents\\NetBeansProjects\\TermProject\\Pic";
	ImageIcon image = new ImageIcon(Access + "\\1.jpeg");
	public Register() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 454, 343);
		setTitle("Sign-in Member");
		getContentPane().setLayout(null);

		// Header Title
		JLabel hRegister = new JLabel("Register Data");
		hRegister.setFont(new Font("Tahoma", Font.BOLD, 13));
		hRegister.setHorizontalAlignment(SwingConstants.CENTER);
		hRegister.setBounds(121, 11, 132, 20);
		getContentPane().add(hRegister);

		// *** Header ***//
		JLabel hUsername = new JLabel("Username :");
		hUsername.setBounds(78, 52, 89, 14);
		getContentPane().add(hUsername);
		
		JLabel hPassword = new JLabel("Password :");
		hPassword.setBounds(78, 84, 89, 14);
		getContentPane().add(hPassword);
		
		JLabel hConfirmPassword = new JLabel("Confirm Password :");
		hConfirmPassword.setBounds(77, 113, 130, 14);
		getContentPane().add(hConfirmPassword);
		
		JLabel hName = new JLabel("Name :");
		hName.setBounds(78, 148, 89, 14);
		getContentPane().add(hName);

		JLabel hEmail = new JLabel("Email :");
		hEmail.setBounds(80, 176, 89, 14);
		getContentPane().add(hEmail);
                
                
		// CustomerID
		txtUsername = new JTextField("");
		txtUsername.setBounds(217, 47, 99, 20);
		getContentPane().add(txtUsername);
		
		// Password
		txtPassword = new JPasswordField();
		txtPassword.setBounds(217, 77, 102, 20);
		getContentPane().add(txtPassword);
		
		// Confirm Password
		txtConfirmPassword = new JPasswordField();
		txtConfirmPassword.setBounds(217, 112, 102, 20);
		getContentPane().add(txtConfirmPassword);

		// Name
		txtName = new JTextField("");
		txtName.setBounds(217, 140, 176, 20);
		getContentPane().add(txtName);

		// Email
		txtEmail = new JTextField("");
		txtEmail.setBounds(217, 172, 176, 20);
		getContentPane().add(txtEmail);

		// Save Button
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(RegisterData()) {
					hdb.register(txtUsername.getText(),new String(txtPassword.getPassword()),txtName.getText(),txtEmail.getText());
					JOptionPane.showMessageDialog(null,
							"Register Data Successfully");
					Sample ourhotel = new Sample();
					ourhotel.setDB(hdb);
					ourhotel.setSample();
					dispose();
				}
			}
		});
		btnSave.setBounds(161, 227, 89, 23);
		getContentPane().add(btnSave);		
                
                JLabel back = new JLabel(image,JLabel.CENTER);
                getContentPane().add(back).setBounds(0, 0, 454, 343);
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private Boolean RegisterData()
	{
		
		String strUsername = txtUsername.getText();
		String strPassword = new String(txtPassword.getPassword());
		String strConfirmPassword = new String(txtConfirmPassword.getPassword());
		String strName = txtName.getText();
		String strEmail = txtEmail.getText();
		
		if(strUsername.equals("")) // Username
		{
			JOptionPane.showMessageDialog(null,
					"Please Input (Username)");
			txtUsername.requestFocusInWindow(); 
			return false;
		}
		if(strPassword.equals("")) // Password
		{
			JOptionPane.showMessageDialog(null,
					"Please Input (Password)");
			txtPassword.requestFocusInWindow(); 
			return false;
		}
		
		if(strConfirmPassword.equals("")) // Confirm Password
		{
			JOptionPane.showMessageDialog(null,
					"Please Input (Confirm Password)");
			txtConfirmPassword.requestFocusInWindow(); 
			return false;
		}
		if(!strPassword.equals(strConfirmPassword)) // Password math
		{
			JOptionPane.showMessageDialog(null,
					"Please Input (Password Not Match!)");
			txtPassword.requestFocusInWindow(); 
			return false;
		}		
		if(strName.equals("")) // Name
		{
			JOptionPane.showMessageDialog(null,
					"Please Input (Name)");
			txtName.requestFocusInWindow(); 
			return false;
		}	
		
		if(strEmail.equals("")) // Email
		{
			JOptionPane.showMessageDialog(null,
					"Please Input (Email)");
			txtEmail.requestFocusInWindow(); 
			return false;
		}	
		
		Connection cn = null;
		Statement st = null;
		Boolean status = false;
                /*        
		try {
			Class.forName("com.mysql.jdbc.Driver");

			cn = DriverManager.getConnection(""
					+ "jdbc:mysql://localhost/mydatabase"
					+ "?user=root&password=root");

			st = cn.createStatement();
			
			// SQL Insert
			String sql = "INSERT INTO member "
					+ "(Username,Password,Email,Name) "
					+ "VALUES ('" + strUsername + "','"
					+ strPassword + "','"
					+ strEmail + "'" + ",'"
					+ strName + "') ";
			st.execute(sql);
		
			
			// Reset Text Fields
			txtUsername.setText("");
			txtPassword.setText("");
			txtConfirmPassword.setText("");
			txtName.setText("");
			txtEmail.setText("");
				
			status  = true;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
		}

		try {
			if (st != null) {
				st.close();
				cn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		return status;
                        */
                return true;
	}
    public  void setRegis(){
    	setTitle("Hotel Reservation System");
        setVisible(true);
    	Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
    	setLocation(100,5);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
    public void setDB(HotelDB hdb)
    {
    	this.hdb = hdb;
    }
}