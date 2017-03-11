

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.dao;
import dao.daoimpl;
import www.bean.User;


/**
 * Servlet implementation class Day02
 */
@WebServlet("/Day02")
public class Day02 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Day02() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		response.setContentType("type=text/html;charset=utf-8");
		HttpSession  session=request.getSession();
		PrintWriter out=response.getWriter();
		boolean flag=true;
		String message="";
		String username=request.getParameter("username");
		System.out.println(username);
		String password=request.getParameter("password");
		System.out.println(password);
		List<User> li=null;
		dao u=new daoimpl();
		ConnectionFactory c=ConnectionFactory.getinstance();
		
		String sql="select * from user";
		try {
			Connection con=c.getConnection();
			li=u.selectUser(con,sql);
			
			con.close();
	}
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		for(User  l:li)
		{
			if(l.getUsername().equals(username)&&l.getPassword().equals(password))
			{
				session.setAttribute("username", l.getUsername());
				message="T";
				flag=false;
				break;
			}
			
		}
		if(flag==true)
		{
			message="f";
			
		}
		
		out.print(message);
		out.flush();
	}
	}
