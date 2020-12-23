package org.btm.jdbcTransactionDemo;

import java.sql.*;
import java.util.Scanner;

public class JdbcWithSavePoint 
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		String iqry1="insert into btm.student1 values(?,?,?)";
		String iqry2="insert into btm.college values(?,?,?,?)";
		Connection con=null;
		PreparedStatement pstmt=null;
		Savepoint sp=null;
		PreparedStatement pstmt1=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=1234");
			con.setAutoCommit(false);
			System.out.println("Auto Commit is Disabled");
			pstmt=con.prepareStatement(iqry1);
			//SET THE DATA FOR PLACE HOLDER//
			System.out.println("Enter the id");
			int id=sc.nextInt();
			System.out.println("Enter the Name");
			String name=sc.next();
			System.out.println("Enter the Place");
			String place=sc.next();
			System.out.println("Enter the Dept");
			String dept=sc.next();
			System.out.println("Enter the perc");
			double perc=sc.nextDouble();
			sc.close();
			
			pstmt.setInt(1, id);
			pstmt.setString(2,name);
			pstmt.setString(3,place);
			System.out.println("Set the values respective placeholders in student1 iqry1");
			pstmt.executeUpdate();
			//declared savepoint
			sp=con.setSavepoint();
			pstmt1=con.prepareStatement(iqry2);
			System.out.println("platform created and compiled");
			//set the values into iqry2
			pstmt1.setInt(1, id);
			pstmt1.setString(2,name);
			pstmt1.setString(3,dept);
			pstmt1.setDouble(4, perc);
			System.out.println("Set the values respective placeholders in college iqry2");
			pstmt1.executeUpdate();
			con.commit();
			System.out.println("data's are sucessfully saved");
		} catch (ClassNotFoundException | SQLException e) 
		{
			try {
				con.rollback(sp);
				con.commit();
				System.out.println("transaction rolled out");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		finally
		{
			if(pstmt1!=null)
			{
				try {
					pstmt1.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt!=null)
			{
				try {
					pstmt.close();
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
