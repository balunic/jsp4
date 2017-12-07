package com.test.jsp.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.test.jsp.common.DBcon;

public interface UserService { //userServoce는 인터페이스 userServiceip 은 구현한것

	public ArrayList<HashMap<String, String>> getUserList();
}
