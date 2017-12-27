package com.test.jsp.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.test.jsp.dto.DepartInfo;


public interface DepartDAO {
															//여기다 쓰는이유 뭐라고?
	public ArrayList<DepartInfo> selectDepartList(String search,String searchStr) throws SQLException;

	public DepartInfo selectDepart(int diNo)throws SQLException ;
	public int updateDepart(DepartInfo di)throws SQLException;
	public int deleteDepart(DepartInfo di) throws SQLException;
	public int insertDepart(DepartInfo di) throws SQLException;
	
	
}
