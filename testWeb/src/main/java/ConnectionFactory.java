
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
		   	//通过加载器来加载属性文件
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
	   //加载数据库驱动获得链接
	   public Connection getConnection() throws ClassNotFoundException, SQLException 
	   {
		   System.out.println(url);
		   //加载数据库驱动类获得链接
		   Class.forName(driver);
			con = DriverManager.getConnection(url, username, password);
		       
		   return con;
	   }
	   
	   
	  
}

