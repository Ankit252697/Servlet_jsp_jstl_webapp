package JavaConn;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Connection.CreateConnection;

public class Registration extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		java.sql.Statement stmt=null;
		System.out.println("Date in the database is as below");
		Connection con = null;
		java.sql.PreparedStatement pstmt = null,pstmt1=null;
		String userid=null;
		String fname=null;
		String lname=null;
		String pass=null;
		String pass1=null;
		String add=null;
		userid=request.getParameter("userid");
		fname=request.getParameter("fname");
		lname=request.getParameter("lname");
		pass=request.getParameter("pass");
		pass1=request.getParameter("pass1");
		add=request.getParameter("add");
		if(pass.equals(pass1))
		{
		try{
			CreateConnection cc=new CreateConnection();
			con=cc.connection1();
			pstmt=con.prepareStatement("insert into registration values(?,?,?,?,?)");
			pstmt1=con.prepareStatement("insert into login values(?,?)");
			pstmt.setString(1,userid);
			pstmt.setString(2,fname);
			pstmt.setString(3,lname);
			pstmt.setString(4,pass);
			pstmt.setString(5,add);
			
			pstmt1.setString(1,userid);
			pstmt1.setString(2,pass);
			
			pstmt.executeUpdate();
			pstmt1.executeUpdate();
			System.out.println("Date in the database is as below");
		}
		catch(Exception e){
			e.printStackTrace();
			
		}
		finally{
			try{
				pstmt.close();
				pstmt1.close();
				con.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		RequestDispatcher rd=request.getRequestDispatcher("login.html");
		rd.forward(request, response);
	}
		else
		{
			RequestDispatcher rd=request.getRequestDispatcher("Registration.html");
			rd.forward(request, response);
		}
	}
}
