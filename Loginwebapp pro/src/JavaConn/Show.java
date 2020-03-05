package JavaConn;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Connection.CreateConnection;

public class Show extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		java.sql.Statement stmt=null;
		Connection con = null;
		String id=null;
		String pass=null;
		int flage=0;
		id=request.getParameter("id");
		try{
			CreateConnection cc=new CreateConnection();
			con=cc.connection1();
			stmt=(java.sql.Statement)con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from registration");
			while(rs.next())
			{
				if(rs.getString(1).equals(id))
				{
					flage=1;
				}
			}
			if(flage==1)
			{
				RequestDispatcher rd=request.getRequestDispatcher("Show.jsp");
				request.setAttribute("id", id);
				rd.forward(request, response);
			}
			else
			{
				RequestDispatcher rd=request.getRequestDispatcher("Fail.jsp");
				rd.forward(request, response);
				
			}
		}
		catch(Exception e){
			e.printStackTrace();
			
		}
		finally{
			try{
				con.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
	}
}
}
