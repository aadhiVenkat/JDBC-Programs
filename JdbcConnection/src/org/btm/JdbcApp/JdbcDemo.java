package org.btm.JdbcApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class JdbcDemo 
{
	public static void main(String[] args) {
		Connection con = null; 
		Statement stmt = null;
		//String qry = "insert into btm.Student values(2, 'srinivas' , 75.57)";
		//String qry="delete from btm.student where sid=2";
		String qry="update btm.student set sperc=90.05 where sid=1";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("driver class loaded and registered");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=1234");
			System.out.println("connection established sucessfully");
			stmt = con.createStatement();
			System.out.println("platform created");
			stmt.execute(qry);
			//System.out.println("record saved sucessfully");
			//System.out.println("record deleted sucessfully");
			System.out.println("record updated sucessfully");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally
		{
			if(stmt!=null)
			{
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(con!=null)
			{
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

}