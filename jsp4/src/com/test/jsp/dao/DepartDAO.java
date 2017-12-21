package com.test.jsp.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.test.jsp.dto.DepartInfo;


public interface DepartDAO {
															//여기다 쓰는이유 뭐라고?
	public ArrayList<DepartInfo> selectDepartList() throws SQLException;
	
	public DepartInfo selectDepart();
		
	public void updateDepart();
	
	public void insertDepart();
	
	
}
