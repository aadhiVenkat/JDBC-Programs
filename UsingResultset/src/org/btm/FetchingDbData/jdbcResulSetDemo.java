package org.btm.FetchingDbData;

import java.sql.*;

public class jdbcResulSetDemo {

	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String qry="select *from btm.student";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver class loaded and register");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=1234");
			System.out.println("Connection Established");
			pstmt=con.prepareStatement(qry);
			rs=pstmt.executeQuery();
			System.out.println("id"+"	"+"SName"+"		"+"Perc");
			System.out.println("------------------------------------------");
			while(rs.next())
			{
				int id=rs.getInt(1);
				String name=rs.getString(2);
				double perc=rs.getDouble(3);
				System.out.println(id+"	"+name+"		"+perc);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			if(rs!=null)
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if(pstmt!=null)
				try {
					pstmt.close();
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
