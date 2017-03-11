package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import www.bean.User;


public class daoimpl implements dao{
	
	private Statement st;
	private ResultSet rs;
	
	public List<User> selectUser(Connection con, String sql) throws Exception {
		// 
		List<User> li=new ArrayList<User>();
	    st=con.createStatement();
	    rs=st.executeQuery(sql);
	    while(rs.next())
	    {
	    	User u=new User();
	      u.setUserid( rs.getString(1));
	      u.setUsername(rs.getString(2));
	     u.setPassword(rs.getString(3));
	     
	      System.out.println(u);
	      li.add(u);
	    }
	    return li;
	}

	public void updateUser(Connection con, String sql) throws Exception {
		
	    st=con.createStatement();
	   st.executeQuery(sql);
	}
	
	     
			
	}

