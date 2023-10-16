package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.conn.JDBCconn;
import com.dao.studentdao;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("id"));
		
		studentdao dao= new studentdao(JDBCconn.getconn());
		boolean f= dao.deleteStudent(id);
		
		HttpSession session =req.getSession();
		
		
	     if (f) {
//			System.out.print("student details sucessfully Deleted");
			session.setAttribute("succMsg", "student details submited sucessfully");
			resp.sendRedirect("index.jsp");
		}else {
//			System.out.print("something went wrong");
			session.setAttribute("errMsg", "something went wrong on server");
			resp.sendRedirect("index.jsp");

		}
		
	}

	
	
}
