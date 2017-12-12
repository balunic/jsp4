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
			ArrayList<HashMap<String, String>> userList = us.getUserList();

			for (HashMap<String, String> map : userList) { // 키값을 가져오는 부분
				html += "<tr>";
				Iterator<String> it = map.keySet().iterator();
				while (it.hasNext()) {
					String key = it.next();
					out.println("<td>" + map.get(key) + "</td>"); // 어떤키값인지 몰라도 불러낼수 있는 방법--> iterator패턴
				}
				html += "</tr>";
			}
			out.println(html);
		} else if (cmd.equals("login")) {
			String id = req.getParameter("id");
			String pwd = req.getParameter("pwd");

			HashMap<String, String> hm
			= new HashMap<String,String>();
			try {
				UserInfo ui = us.getUser(id, pwd);
				if (ui == null) {
					hm.put("result", "no");
					hm.put("msg", "아이디와 비번확인");
				} else {
					HttpSession hs = req.getSession();
					hs.setAttribute("user", ui);
					hm.put("result", "ok");
					hm.put("msg", ui.getUserName() + "님 환영!");
				}

				Gson gs = new Gson();
				out.print(gs.toJson(hm));
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (cmd.equals("logout")) {
			HttpSession hs = req.getSession();
			hs.invalidate();  //요놈은 세션을 가지고 있는 것들을 초기화하는 기능 
			res.sendRedirect("/user/longin.jsp");
		} else {
			res.sendRedirect("/error.jsp");
		}
	}
}
