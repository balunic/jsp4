package com.test.jsp.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.test.jsp.common.DBcon;
import com.test.jsp.dto.UserInfo;

public class UserServiceImpl implements UserService {   // userService는 인터페이스 userServiceip 은 구현한것
	
	public UserInfo getUser(String id,String pwd) throws ClassNotFoundException, SQLException{
		HashMap <String,String> hm = new HashMap<String,String>();
		DBcon dbcon = new DBcon();
		Connection con = dbcon.getConnection();
		

			String sql = "select*from user_info ui," + " depart_info di" + " where ui.dino =di.dino";
			sql += " and ui.userid=? and ui.userpwd=?";
			
			PreparedStatement ps = con.prepareStatement(sql); // 쿼리 쓸수 있음
			ps.setString(1, id);
			ps.setString(2, pwd);
			ResultSet rs = ps.executeQuery(); // 쿼리에 있는 모든 데이터를 받음
			UserInfo ui = null;
			
			

			// next는 데이터가 있는지 없는지 체크 없어도 메타데이터는 간다 (액샐의 맨위칸)
			while (rs.next()) { // next를 하면 데이터가 있으면 true값 출력.
				ui= new UserInfo();
				
				ui.setUserNo(rs.getInt("userno"));
				ui.setUserName(rs.getString("username"));
				ui.setUserId(rs.getString("userid"));
				ui.setUserPwd(rs.getString("userpwd"));
				ui.setUserAge(rs.getInt("userAge"));
				ui.setUserAddress(rs.getString("userAddress"));
				ui.setDino(rs.getInt("dino"));
				
			}
			return ui;

		
	}
	public ArrayList<UserInfo> getUserList() {

		ArrayList<UserInfo> al = new ArrayList<UserInfo>();

		DBcon dbcon = new DBcon();
		
		try {

			Connection con = dbcon.getConnection();

			String sql = "select*from user_info ui," + " depart_info di" + " where ui.dino =di.dino";
			
			PreparedStatement ps = con.prepareStatement(sql); // 쿼리 쓸수 있음

			ResultSet rs = ps.executeQuery(); // 쿼리에 있는 모든 데이터를 받음

			HashMap<String, String> hm = new HashMap<String, String>();

			// next는 데이터가 있는지 없는지 체크 없어도 메타데이터는 간다 (액샐의 맨위칸)
			while (rs.next()) { // next를 하면 데이터가 있으면 true값 출력.
				UserInfo ui = new UserInfo();
				ui.setUserNo(rs.getInt("userno"));
				ui.setUserName(rs.getString("username"));
				ui.setUserId(rs.getString("userid"));
				ui.setUserPwd(rs.getString("userpwd"));
				ui.setUserAddress(rs.getString("useraddress"));
				ui.setUserAge(rs.getInt("userage"));
				al.add(ui);
				
	
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
		return al;
	}
	public int insertUser(HashMap hm) {
		int result = 0;
		DBcon dbcon = new DBcon();
		
		try {
			Connection con = dbcon.getConnection();
			String sql = "insert into user_info(username,userid,";
			sql += "userpwd,userage,useraddress)";
			sql += "values(?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, (String)hm.get("name"));
			ps.setString(2, (String)hm.get("id"));
			ps.setString(3, (String)hm.get("pwd"));
			ps.setString(4, (String)hm.get("age"));
			ps.setString(5, (String)hm.get("address"));
			result = ps.executeUpdate();	
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
		return result;
	}
	
	public int insertUser(UserInfo ui) {
		int result = 0;
		DBcon dbcon = new DBcon();
		
		try {
			Connection con = dbcon.getConnection();
			String sql = "insert into user_info(username,userid,";
			sql += "userpwd,userage,useraddress)";
			sql += "values(?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, ui.getUserName());
			ps.setString(2, ui.getUserId());
			ps.setString(3, ui.getUserPwd());
			ps.setInt(4, ui.getUserAge());
			ps.setString(5, ui.getUserAddress());
			result = ps.executeUpdate();	
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				dbcon.closeCon();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	
}
