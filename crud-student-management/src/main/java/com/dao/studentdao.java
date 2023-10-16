package com.dao;
import java.util.*;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.student;
import com.mysql.cj.protocol.Resultset;

public class studentdao {

	private Connection conn;

	public studentdao(Connection conn) {
		super();
		this.conn = conn;
	}
	
	
	public boolean addstudent(student students) {
		
		boolean f=false;
		
		try {
			String sql="insert into student(Name,DOB,address,qualification,email) VALUES(?,?,?,?,?)";
			
			PreparedStatement ps= conn.prepareStatement(sql);
			
			ps.setString(1, students.getFullname());
			ps.setString(2, students.getDob());
			ps.setString(3, students.getAddress());
			ps.setString(4, students.getQualification());
			ps.setString(5, students.getEmail());
			
			
			int i= ps.executeUpdate();
			if (i==1) {
				f=true;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return f;
	}
	
	public List<student> getallStudents()
	{
		List<student> list =new ArrayList<student>();
		student s =null;
		
		try {
		String sql=	"SELECT * FROM student";
		PreparedStatement ps =conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			s=new student();
			s.setId(rs.getInt(1));
			s.setFullname(rs.getString(2));
			s.setDob(rs.getString(3));
			s.setAddress(rs.getString(4));
			s.setQualification(rs.getString(5));
			s.setEmail(rs.getString(6));
			list.add(s);
		}
		
		
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return list;
		
	}
	
	public student getstudentById(int id) {
		student s =null;
		
		try {
		String sql=	"SELECT * FROM student where id=?";
		PreparedStatement ps =conn.prepareStatement(sql);
		ps.setInt(1, id);
		
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			s=new student();
			s.setId(rs.getInt(1));
			s.setFullname(rs.getString(2));
			s.setDob(rs.getString(3));
			s.setAddress(rs.getString(4));
			s.setQualification(rs.getString(5));
			s.setEmail(rs.getString(6));
		}
		
		
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		
		
		return s;
	}
	
          public boolean updatetudent(student students) {
		
		boolean f=false;
		
		try {
			String sql="update student set name=?,DOB=?,address=?,qualification=?,email=? where id=?";
			
			PreparedStatement ps= conn.prepareStatement(sql);
			
			ps.setString(1, students.getFullname());
			ps.setString(2, students.getDob());
			ps.setString(3, students.getAddress());
			ps.setString(4, students.getQualification());
			ps.setString(5, students.getEmail());
			ps.setInt(6, students.getId());
			
			
			int i= ps.executeUpdate();
			if (i==1) {
				f=true;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return f;
	}
          public boolean deleteStudent(int id) {
        	  
        	  boolean f= false;
        	  
        	  try {
				
        		  String sql ="delete from student where id=?";
        		  PreparedStatement ps= conn.prepareStatement(sql);
        		  ps.setInt(1, id);
        		  
        		  int i= ps.executeUpdate();
      			  if (i==1) {
      				f=true;
      			}
        		  
        		  
			} catch (Exception e) {

			e.printStackTrace();
			}
        	  
        	  
        	  return f;
        	  
          }
          
}
