package Connection;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.*;
import java.sql.*;

public class CreateConnection{
	public Connection connection1()
	{
		Connection con=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/fbdata","root","adm@123");
			}
		catch(Exception e){
			e.printStackTrace();
			
		}
		return con;
	}

}
