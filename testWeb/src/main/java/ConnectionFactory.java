
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import dao.dao;

public class ConnectionFactory {
	private static String url;
	   private  static String driver;
	   private  static String username;
	   private  static String password;
	   private static final ConnectionFactory cf=new ConnectionFactory();
	   private Connection con;
	   static{
		   Properties  prop=new Properties();
		   //	InputStream in= ConnectionFactory.class.getClassLoader().getSystemResourceAsStream("fjdbc.properties");
		   	//ͨ�������������������ļ�
		   	try {
		   		prop.load(new FileReader(ConnectionFactory.class.getClassLoader().getResource("fjdbc.properties").getPath()));
		   		//prop.load(in);
		   		System.out.println(prop.getProperty("driver"));
		   	} catch (IOException e) {
		   		// TODO Auto-generated catch block
		   		e.printStackTrace();
		   	}
		     
		   	url=prop.getProperty("url");
		   	driver=prop.getProperty("driver");
		   	username=prop.getProperty("username");
		   	password=prop.getProperty("password");
		      }
	   public static ConnectionFactory getinstance()
	   {
		   return cf;
	   }
	   //�������ݿ������������
	   public Connection getConnection() throws ClassNotFoundException, SQLException 
	   {
		   System.out.println(url);
		   //�������ݿ�������������
		   Class.forName(driver);
			con = DriverManager.getConnection(url, username, password);
		       
		   return con;
	   }
	   
	   
	  
}

