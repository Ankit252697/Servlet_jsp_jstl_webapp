package JavaConn;

import java.beans.Statement;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import javax.swing.text.Document;

import Connection.CreateConnection;

public class Login1 extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		java.sql.Statement stmt=null;
		Connection con = null;
		String id=null;
		String pass=null;
		int flage=0;
		id=request.getParameter("id");
		pass=request.getParameter("pass");
		try{
			CreateConnection cc=new CreateConnection();
			con=cc.connection1();
			stmt=(java.sql.Statement)con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from login");
			while(rs.next())
			{
				if(rs.getString(1).equals(id)&&rs.getString(2).equals(pass))
				{
					flage=1;
				}
			}
			if(flage==1)
			{
				RequestDispatcher rd=request.getRequestDispatcher("Success.jsp");
				rd.forward(request, response);
			}
			else
			{
				//Document.getElementById("page").innerHTLM="Not Valide Input";
				//JOptionPane.showMessageDialog(null, "Id or Pass is Wrong", "Login, java", JOptionPane.PLAIN_MESSAGE);
				RequestDispatcher rd=request.getRequestDispatcher("login.html");
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
