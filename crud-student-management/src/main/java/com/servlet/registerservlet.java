package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.student;

@WebServlet("/register")
public class registerservlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name=req.getParameter("name");
		String dob =req.getParameter("dob");
		String address = req.getParameter("address");
		String qualification =req.getParameter("qualification");
		String email = req.getParameter("email");
		
		student student =new student(name, dob,address,qualification,email);
		System.out.print(student);
	}
	
	

}
