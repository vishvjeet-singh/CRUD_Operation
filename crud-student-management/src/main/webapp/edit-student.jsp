<%@page import="com.entity.student"%>
<%@page import="com.conn.JDBCconn"%>
<%@page import="com.dao.studentdao"%>
<%@page import="com.servlet.registerservlet"%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@ include file="navbar.jsp"%>
</head>
<body class="bg-light">
	<%@ include file="all-css.jsp"%>
	<div class="container p-4">
		<div class="row">
			<div class="col-md-6 offset-md-3">

				<div class="card">
					<div class="card-body">
						<p class="fs-3 text-center">Edit Student</p>

						<%
						int id = Integer.parseInt(request.getParameter("id"));
						studentdao dao = new studentdao(JDBCconn.getconn());
						//student s= dao.getstudentById(id);
						student s = dao.getstudentById(id);
						%>

						<form action="update" method="post">
							<div class="mb-3">
								<label class="form-label">Full Name</label> <input type="text"
									value="<%=s.getFullname()%>" name="name" class="form-control">
							</div>
							<div class="mb-3">
								<label class="form-label">DOB</label> <input type="date"
									value="<%=s.getDob()%>" name="dob" class="form-control">
							</div>
							<div class="mb-3">
								<label class="form-label">Address</label> <input type="text"
									value="<%=s.getAddress()%>" name="address"
									class="form-control">
							</div>
							<div class="mb-3">
								<label class="form-label">Qualification</label> <input
									type="text" value="<%=s.getQualification()%>"
									name="qualification" class="form-control">
							</div>
							<div class="mb-3">
								<label class="form-label">Email</label> <input type="email"
									name="email" value="<%=s.getEmail()%>>" class="form-control">
							</div>

							<input type="hidden" name="id" value="<%= s.getId()%>">

							<button type="submit" class="btn btn-primary col-md-12">Update</button>
						</form>

					</div>
				</div>

			</div>
		</div>

	</div>


</body>
</html>