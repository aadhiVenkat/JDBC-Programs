package org.btm.batchDemo1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class batchPrepareDemo {

	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement pstmt=null;
		PreparedStatement pstmt1=null;
		PreparedStatement pstmt2=null;
		String iqry="insert into btm.student values(6,'Prince',90.0)";
		String uqry="update btm.student set sperc=75.05 where sperc>=90.0";
		String dqry="delete from btm.student where sid=2";
		
		try {
			//Class.forName("org.jdbc.cj.mysql.Driver");
			System.out.println("Class Loaded and Register");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=1234");
			System.out.println("Connection Estalished");
			pstmt=con.prepareStatement(iqry);
			pstmt.addBatch();
			System.out.println("Platform Created for Insert");
			pstmt.executeBatch();
			System.out.println("Batch Added Succesfully");
			System.out.println("Insert Batch Excecuted Successfully");
			pstmt1=con.prepareStatement(uqry);
			System.out.println("Platform Created for Update");
			pstmt1.addBatch();
			System.out.println("Batch Added Succesfully");
			pstmt1.executeBatch();
			System.out.println("Update Batch Excecuted Successfully");
			pstmt2=con.prepareStatement(dqry);
			System.out.println("Platform Created for Delete");
			pstmt2.addBatch();
			System.out.println("Batch Added Succesfully");
			pstmt2.executeBatch();
			System.out.println("Delete Batch Excecuted Successfully");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally
		{
			if(pstmt2!=null)
			{
				try {
					pstmt2.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
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
