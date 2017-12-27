package com.test.jsp.service;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.test.jsp.dto.DepartInfo;

public interface DepartService {
	public ArrayList<DepartInfo> selectDepartList(String search,String serchStr);
	public DepartInfo selectDepart();
	public DepartInfo selectDepart(int diNo);	
	public int updateDepart(DepartInfo req);
	public int insertDepart(DepartInfo di);
	public int deleteDepart(DepartInfo di);

	
}
