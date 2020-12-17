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
			ps.setInt(1, 4);
			ps.setString(2, "Mahesh");
			ps.setDouble(3, 80.05);
			ps.execute();
			
			ps.setInt(1, 5);
			ps.setString(2, "Babu");
			ps.setDouble(3, 85.05);
			ps.execute();
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally
		{
			if(ps!=null)
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if(con!=null)
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			System.out.println("!!!!All Costly Resoursec are Closed!!!!");
		}
		
	}

}
