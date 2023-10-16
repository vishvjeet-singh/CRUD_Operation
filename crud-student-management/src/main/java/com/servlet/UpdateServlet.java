package com.servlet;

import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.conn.JDBCconn;
import com.dao.studentdao;
import com.entity.student;


@WebServlet("/update")
public class UpdateServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name=req.getParameter("name");
		String dob =req.getParameter("dob");
		String address = req.getParameter("address");
		String qualification =req.getParameter("qualification");
		String email = req.getParameter("email");
		int id = Integer.parseInt(req.getParameter("id"));
		
		student student =new student(id,name, dob,address,qualification,email);

	studentdao dao=new studentdao(JDBCconn.getconn());
	
	HttpSession session =req.getSession();
	
	 boolean f= dao.updatetudent(student);
     if (f) {
//		System.out.print("student details sucessfully submited");
		session.setAttribute("succMsg", "student details Updated sucessfully");
		resp.sendRedirect("index.jsp");
	}else {
//		System.out.print("something went wrong");
		session.setAttribute("errMsg", "something went wrong on server");
		resp.sendRedirect("index.jsp");

	}
	}
	
	

}
