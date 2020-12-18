package org.btm.loginApp;

import java.sql.*;
import java.util.*;

public class loginApp {

	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String qry="select username from btm.user where name=? and password=?";
		
		try (Scanner sc=new Scanner(System.in)){
			//Class.forName("org.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=1234");
			pstmt=con.prepareStatement(qry);
			System.out.println("Enter the Name:");
			String name=sc.nextLine();
			System.out.println("Enter the Password:");
			String password=sc.nextLine();
			pstmt.setString(1, name);
			pstmt.setString(2, password);
			rs=pstmt.executeQuery();
			if(rs.next())
			{
				System.out.println("!!!!Welcome!!!!"+rs.getString("username"));
			}
			else
			{
				System.out.println("No UserName Contains for this "+name+" and "+password);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally
		{
			if(rs!=null)
			{
				try {
					rs.close();
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
