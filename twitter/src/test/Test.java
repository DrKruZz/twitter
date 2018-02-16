package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import bd.Database;

public class Test {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			try {
				Connection c = Database.getMySQLConnection();
				
				//insertion ligne dans bd
				/*
				String query = "INSERT INTO users VALUES(1, \"albert7\", \"pswd\", \"Albert\", \"Camus\")";
				Statement st = c.createStatement();
				st.executeUpdate(query);
				*/
				//lecture ligne
				String query = "SELECT * FROM users ;";
				Statement st = c.createStatement();
				ResultSet rs = st.executeQuery(query);
				
				while(rs.next())
					System.out.println(rs.getString("login"));
					
				
				rs.close();
				st.close();
				c.close();
				
						
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
