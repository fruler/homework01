package dao;

import java.sql.Connection;
import java.util.List;

import www.bean.User;

public interface dao {
	
     public List<User> selectUser(Connection con,String sql)throws Exception;
     public void updateUser(Connection con,String sql)throws Exception;
}
