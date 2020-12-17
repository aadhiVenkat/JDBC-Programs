package org.btm.examplePStatement;

import java.sql.*;

public class JdbcPreapareDemo {

	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement ps=null;
		String sql="insert into btm.student values(?,?,?)";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("driver Class Loaded and Register");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=1234");
			System.out.println("Connection Established");
			ps=con.prepareStatement(sql);//Compile once
			System.out.println("Platform Created");
			ps.setInt(1, 2);
			ps.setString(2, "Adi");
			ps.setDouble(3, 90.0);
			ps.execute();
			
			ps.setInt(1, 3);
			ps.setString(2, "Venkat");
			ps.setDouble(3, 99.0);
			ps.execute();
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}

}
