package org.btm.batchDemo;

import java.sql.*;
import java.sql.SQLException;

public class batchStmtDemo {

	public static void main(String[] args) {
		Connection con=null;
		Statement stmt=null;
		String iqry="insert into btm.student values(5,'Prince',90.0)";
		String uqry="update btm.student set sperc=91.05 where sperc<=90.0";
		String dqry="delete from btm.student where sid=4";
		
		try {
			//Class.forName("org.jdbc.cj.mysql.Driver");
			System.out.println("Class Loaded and Register");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=1234");
			System.out.println("Connection Estalished");
			stmt=con.createStatement();
			System.out.println("Platform Created");
			stmt.addBatch(iqry);
			stmt.addBatch(uqry);
			stmt.addBatch(dqry);
			System.out.println("All DML quries added Batch Successfully");
			int output[]=stmt.executeBatch();
			System.out.println("Batch Excecuted Successfully");
			for (int i : output) {
				System.out.println(i);
			}
		} catch (SQLException e) {
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
