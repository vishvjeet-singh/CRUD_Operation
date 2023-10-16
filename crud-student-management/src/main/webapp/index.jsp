<%@page import="com.entity.student"%>
<%@page import="java.util.List"%>
<%@page import="com.dao.studentdao"%>
<%@page import="com.conn.JDBCconn"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@page isELIgnored="false" %>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@ include file="all-css.jsp"%>

<!-- <meta http-equiv="refresh" content="3"> -->
</head>
<body class="bg-light">
	<%@ include file="navbar.jsp"%>

	<div class="container p-3">
		<div class="card">
			<div class="card-body">


				<p class="text-center fs-1">All student details</p>
				
						<c:if test="${not empty succMsg }">
						<p class="text-center text-success">${succMsg }</p>
						<c:remove var="succMsg"/>
						</c:if>
						
						<c:if test="${not empty errMsg }">
						<p class="text-center text-success">${errMsg }</p>
						<c:remove var="errMsg"/>
						</c:if>
			
				<table class="table">
					<thead>
						<tr>
							<th scope="col">Full name</th>
							<th scope="col">DOB</th>
							<th scope="col">Address</th>
							<th scope="col">Qualification</th>
							<th scope="col">Email</th>
							<th scope="col">Action</th>

						</tr>
					</thead>
					<tbody>

						<% 
						studentdao dao = new studentdao(JDBCconn.getconn());
						List<student> list = dao.getallStudents();
						for (student s : list) {
						%>

						<tr>
							<th scope="row"><%=s.getFullname() %></th>
							<td><%=s.getDob() %></td>
							<td><%=s.getAddress() %></td>
							<td><%=s.getQualification() %></td>
							<td><%=s.getEmail() %></td>
							<td><a href="edit-student.jsp?id=<%=s.getId() %>"
								class="btn btn-sm btn-primary">Edit</a> 
								
								<a href="delete?id=<%=s.getId() %>"
								class="btn btn-sm btn-danger ms-1">Delete</a></td>
						</tr>


						<%
						}
						%>
					

					</tbody>
				</table>
			</div>
		</div>
	</div>

</body>
</html>