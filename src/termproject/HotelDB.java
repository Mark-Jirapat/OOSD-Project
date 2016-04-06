import java.util.ArrayList;
import java.util.HashMap;

import edu.sit.cs.db.CSDbDelegate;


public class HotelDB 
{
    //Session session;
    CSDbDelegate db;
    boolean login;
    public HotelDB()
    {
        init();
    }
    public void init()
    {
        db = new CSDbDelegate("csprog-in.sit.kmutt.ac.th","3306","CSC105_G6","csc105_2014","csc105");
        System.out.println(db.connect());
        //login = false;
        //cs14sitkmutt.me
        //CSC105_G6
        //CSC105_G6
    }
    
    public boolean logIn(String user , String password)
    {
    	String sql = "SELECT*FROM Hotel_Login";
        ArrayList<HashMap> list = db.queryRows(sql);
        //boolean delSuccess = db.executeQuery(sql);
        //System.out.println(delSuccess);
        System.out.println(user + " " + password);
        for(HashMap l : list)
        {
            if(l.get("user").equals(user))
            {
                if(l.get("password").equals(password))
                {
                	return true;
                }
                else
                {
                    return false;
                }
            }
        }
        return false;
    }
    
    public void register(String user , String password , String name , String email)
    {
    	String sql = "INSERT INTO Hotel_Login "
				+ "(user,password,name,email) "
				+ "VALUES ('" + user + "','"
				+ password + "','"
				+ name + "'" + ",'"
				+ email + "') ";
    	 boolean delSuccess = db.executeQuery(sql);
         System.out.println(delSuccess);
    	//System.out.println(user + "\n" + password + "\n" + name + "\n" + email);
    }
}
