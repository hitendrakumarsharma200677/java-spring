package com.robert.book;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DbUtil {
	
	public static void main(String[] args) {
		System.out.println("this is main");
		PrintWriter out = null;
	    Connection connection = null;
	    Statement statement;
	    ResultSet rs;
	    
	    try{
		Class.forName("com.mysql.jdbc.Driver");

		//conn =DriverManager.getConnection("jdbc:mysql://localhost/test?" + "user=monty&password=greatsqldb");
	      connection = DriverManager
	          .getConnection("jdbc:mysql://localhost/mob?" + "user=test&password=test");
	      statement = connection.createStatement();

	      rs = statement.executeQuery("SELECT id, detail_url, detail FROM books");

	      while (rs.next()) {
	    	  System.out.println(rs.getString("id") + " " + rs.getString("detail_url") + "\n");
	      }

	    } catch (Exception e) {
	     System.out.println( e.getMessage());
	    }
	}
	
	
	

}
