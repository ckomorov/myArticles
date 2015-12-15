package tritpo;

import java.sql.*;

import javax.swing.*;

import java.sql.Connection;
import java.awt.*;

public class sqlConnection {//TODO: -> ConnectionFactory
	
	public static Connection conn;//TODO: why it is public
	public static Statement statmt;//TODO: make private
	
	public static Connection dbConnector()//TODO:->GetConnection
	{
		try{
			Class.forName("org.sqlite.JDBC");
			Connection conn=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Сергей\\workspace\\MyArticles.s3db");			
			//JOptionPane.showMessageDialog(null, "Connection Done!");
			return conn;
		}catch(Exception e)//TODO: remove.
		{
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
	}
	

}
