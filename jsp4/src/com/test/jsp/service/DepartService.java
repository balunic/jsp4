package com.test.jsp.service;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.test.jsp.dto.DepartInfo;

public interface DepartService {
	public ArrayList<DepartInfo> selectDepartList();
	
	public DepartInfo selectDepart(int diNo);
		
	public void updateDepart();
	
	public void insertDepart();

	
}
