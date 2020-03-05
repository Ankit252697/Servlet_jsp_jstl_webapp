<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JSP List Users Record</title>
</head>
<body bgcolor=white>

	<sql:setDataSource var="myDS" driver="com.mysql.jdbc.Driver"
		url="jdbc:mysql://localhost:3306/fbdata" user="root"
		password="adm@123" />

	<sql:query var="listUsers" dataSource="${myDS}">
	SELECT * FROM registration;
	</sql:query>
	<div align="center">
		<table border="1" cellpadding="5" bgcolor="gray">
			<caption>
				<h2>List Of Users</h2>
			</caption>
			<tr>
				<th>User Id</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Password</th>
				<th>Address</th>
			</tr>
			<c:forEach var="user" items="${listUsers.rows}">
				<tr>
					<td><font color="brown"><c:out value="${user.user_id}" /></font></td>
					<td><font color="blue"><c:out value="${user.first_name}" /></font></td>
					<td><font color="green"><c:out value="${user.last_name}" /></font></td>
					<td><font color="green"><c:out value="${user.password}" /></font></td>
					<td><font color="green"><c:out value="${user.address}" /></font></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>