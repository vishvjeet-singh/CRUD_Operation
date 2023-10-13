package com.conn;

import java.sql.Connection;
import java.sql.DriverManager;

import org.apache.taglibs.standard.tag.rt.fmt.FormatNumberTag;

public class JDBCconn {

	private static Connection conn = null;

	public static Connection getconn() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studen_crud","root","Kuku@123");

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return conn;
	}

}
