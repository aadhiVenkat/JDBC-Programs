package org.btm.jdbcTransactionDemo;

import java.sql.*;
import java.util.Scanner;

public class jdbcTransaction {

	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement pstmt=null,pstmt1=null;
		String iqry1="insert into btm.student1 values(?,?,?)";
		String iqry2="insert into btm.college values(?,?,?,?)";
		Scanner sc=new Scanner(System.in);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Class load and registered");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=1234");
			System.out.println("Connection Established Succesfully");
			con.setAutoCommit(false);
			System.out.println("Auto Commit is Disabled");
			pstmt=con.prepareStatement(iqry1);
			System.out.println("platform created and compiled");
			//set the values into iqry1
			System.out.println("Enter the id");
			int id=sc.nextInt();
			System.out.println("Enter the Name");
			String name=sc.next();
			System.out.println("Enter the Place");
			String place=sc.next();
			pstmt.setInt(1, id);
			pstmt.setString(2,name);
			pstmt.setString(3,place);
			System.out.println("Set the values respective placeholders in student1 iqry1");
			pstmt.executeUpdate();
			System.out.println("iqry1 Executed Successfully");
			
			pstmt1=con.prepareStatement(iqry2);
			System.out.println("platform created and compiled");
			//set the values into iqry2
			System.out.println("Enter the Dept");
			String dept=sc.next();
			System.out.println("Enter the perc");
			double perc=sc.nextDouble();
			
			pstmt1.setInt(1, id);
			pstmt1.setString(2,name);
			pstmt1.setString(3,dept);
			pstmt1.setDouble(4, perc);
			System.out.println("Set the values respective placeholders in college iqry2");
			pstmt1.executeUpdate();
			System.out.println("iqry2 Executed Successfully");
			sc.close();
			con.commit();
			System.out.println("comitted Successfully");
			
		} catch (ClassNotFoundException | SQLException e) {
			try {
				con.rollback();
				System.out.println("Execution Rollbacked Successfully");
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
