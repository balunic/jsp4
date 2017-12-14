package com.test.jsp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.test.jsp.dto.UserInfo;
import com.test.jsp.service.UserService;
import com.test.jsp.service.UserServiceImpl;

public class UserServlet extends HttpServlet {

	UserService us = new UserServiceImpl();

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		doProcess(req, res);

	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		doProcess(req, res);

	}

	public void doProcess(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		req.setCharacterEncoding("utf-8");
		res.setCharacterEncoding("utf-8");
		res.setContentType("text/html; charset=utf-8");
		PrintWriter out = res.getWriter(); // 웹에 그려주는애 jsp에서의 out과 같은효과됨
		String cmd = req.getParameter("cmd");
		if (cmd == null) {
			res.sendRedirect("/error.jsp");
		} else if (cmd.equals("list")) {
			String html = "";
			ArrayList<UserInfo> userList = us.getUserList();

			Gson gs = new Gson();
			out.print(gs.toJson(userList));
		} else if (cmd.equals("logout")) {
			HttpSession hs = req.getSession();
			hs.invalidate();  //요놈은 세션을 가지고 있는 것들을 초기화하는 기능 
			res.sendRedirect("/user/longin.jsp");
		} else if (cmd.equals("join")){
			
			String params = req.getParameter("params");
			Gson gs = new Gson();
			UserInfo ui= gs.fromJson(params, UserInfo.class);
			
		
			int result = us.insertUser(ui);
			HashMap<String,String>hm = 
					new HashMap<String,String>();
			hm.put("result", "no");
			hm.put("msg", "회원가입에 실패하셨습니다");
			
			
			if(result!=0) {
			hm.put("result", "ok");
			hm.put("msg", "회원가입에 성공하셨습니다");
			hm.put("url", "/user/login,jsp");
			
			
		}
			out.print(gs.toJson(hm));
		}else {
			res.sendRedirect("/error.jsp");
		}
	}
}
