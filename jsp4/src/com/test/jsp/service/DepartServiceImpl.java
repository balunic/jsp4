
package com.test.jsp.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.test.jsp.common.DBcon;
import com.test.jsp.dao.DepartDAO;

import com.test.jsp.dao.DepartDAOImpl;

import com.test.jsp.dto.DepartInfo;

public class DepartServiceImpl implements DepartService {

	@Override

	public ArrayList<DepartInfo> selectDepartList() {

		ArrayList<DepartInfo> departList = new ArrayList<DepartInfo>();

		DBcon dbCon = new DBcon();

		try {

			DepartDAO ddao = new DepartDAOImpl(dbCon.getConnection());

			departList = ddao.selectDepartList();

		}

		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		catch (SQLException e) {
			e.printStackTrace();
		}

		return departList;

	}

	@Override

	public HashMap<String, Object> selectDepart() {

		HashMap<String, Object> hm = new HashMap<String, Object>();
		hm.put("dino", 1);
		hm.put("diname", 1 + "번째 부서");
		hm.put("didesc", 1 + "번째 부서 설명");
		return hm;
		

	}

	@Override

	public void updateDepart(HttpServletRequest req) {

	}

	@Override

	public void insertDepart(HttpServletRequest req) {

	}

}
