

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class day03
 */
@WebServlet("/day03")
public class day03 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public day03() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		response.setContentType("type=text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		String path=request.getParameter("path");
		System.out.println(this.getServletContext().getRealPath(path));
 InputStream in=new FileInputStream(this.getServletContext().getRealPath(path));
	OutputStream output=new FileOutputStream("D:"+File.separator+"test.jpg");	
	byte b[]=new byte[1024];
	while(in.read(b)!=-1)
	{
		output.write(b);
		
	}
	output.close();
	in.close();
	out.print("T");
	}

}
