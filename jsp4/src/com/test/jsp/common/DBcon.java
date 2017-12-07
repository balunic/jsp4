package com.test.jsp.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class DBcon {
	Connection con = null;

	public Connection getConnection() throws ClassNotFoundException, SQLException {
		if (con != null) {
			return con;
		}

		String url = "jdbc:mysql://localhost:3306/jsp4"; // 해당 db의 전화번호
		String id = "root";
		String pwd = "tmxkqhd1";

		Class.forName("org.mariadb.jdbc.Driver"); // Driver 클래스
		con = DriverManager.getConnection(url, id, pwd);
		return con;
	}

	public void closeCon() throws SQLException {
		if (con != null) {
			con.close();
			con = null;
		}

	}

	public static void main(String[] arsg) {
		DBcon dbcon = new DBcon();
		try {

			Connection con = dbcon.getConnection();

			String sql = "select*from user_info";
			PreparedStatement ps = con.prepareStatement(sql); // 쿼리 쓸수 있음

			ResultSet rs = ps.executeQuery(); // 쿼리에 있는 모든 데이터를 받음

			ArrayList<HashMap<String, String>> al = new ArrayList<HashMap<String, String>>();

			HashMap<String, String> hm = new HashMap<String, String>();

												// next는 데이터가 있는지 없는지 체크 없어도 메타데이터는 간다 (액샐의 맨위칸)
			while (rs.next()) { 				// next를 하면 데이터가 있으면 true값 출력.
				hm = new HashMap<String, String>();
				hm.put("userno", rs.getString("userno"));
				hm.put("username", rs.getString("username"));
				hm.put("userid", rs.getString("userid"));
				hm.put("userpwd", rs.getString("userpwd"));
				hm.put("userage", rs.getString("userage"));
				hm.put("dino", rs.getString("dino"));
				hm.put("useraddress", rs.getString("useraddress"));
				al.add(hm);									 // 이때 al에 해당 데이터가 들어감
			}
			for (HashMap<String, String> h : al) {
				System.out.println(h);

			}

		} catch (Exception e) {
			System.out.println(e);
		} finally {
				try {
					dbcon.closeCon();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
				
	}
}
