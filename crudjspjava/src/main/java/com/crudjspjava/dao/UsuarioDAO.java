package com.crudjspjava.dao;

import java.sql.Connection;
import java.sql.DriverManager;
public class UsuarioDAO {
	
	public static Connection getConnection() {
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/crudjspjava", "root", "");
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return conn;
	}
	

}
