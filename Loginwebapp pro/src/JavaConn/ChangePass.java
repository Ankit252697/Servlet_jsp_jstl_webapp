
package JavaConn;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.PreparedStatement;

import Connection.CreateConnection;

/**
 * Servlet implementation class ChangePass
 */
@WebServlet("/ChangePass")
public class ChangePass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePass() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		java.sql.Statement stmt=null;
		System.out.println("Date in the database is as below");
		Connection con = null;
		java.sql.PreparedStatement pstmt = null,pstmt1=null;
		String userid=null;
		String oldpass=null;
		String pass=null;
		String pass1=null;
		int flage=0;
		userid=request.getParameter("userid");
		oldpass=request.getParameter("oldpass");
		pass=request.getParameter("pass");
		pass1=request.getParameter("pass1");
		if(pass.equals(pass1))
		{
		try{
			CreateConnection cc=new CreateConnection();
			con=cc.connection1();
			stmt=(java.sql.Statement)con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from login");
			while(rs.next())
			{
				if(rs.getString(1).equals(userid)&&rs.getString(2).equals(oldpass))
				{
					flage=1;
					 pstmt = con.prepareStatement("UPDATE login SET password=? WHERE id = ?");
					 pstmt.setString(1, pass);
					 pstmt.setString(2, userid);
					 
					 pstmt1 = con.prepareStatement("UPDATE registration SET password=? WHERE user_id = ?");
					 pstmt1.setString(1, pass);
					 pstmt1.setString(2, userid);
					 
					 pstmt.executeUpdate();
					 pstmt1.executeUpdate();
					 break;
				}
			}
			if(flage==1)
			{
				RequestDispatcher rd=request.getRequestDispatcher("Success.jsp");
				rd.forward(request, response);
			}
			else
			{
				RequestDispatcher rd=request.getRequestDispatcher("Change_Pass.html");
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
		else
		{
			RequestDispatcher rd=request.getRequestDispatcher("Change_Pass.html");
			rd.forward(request, response);
		}
}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
