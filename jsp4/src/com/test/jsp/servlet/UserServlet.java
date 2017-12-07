package com.test.jsp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.jsp.service.UserService;
import com.test.jsp.service.UserServiceImpl;

public class UserServlet extends HttpServlet{

	UserService us = new UserServiceImpl();
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws 
	IOException, ServletException {
		doProcess(req,res);
	
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws 
	IOException, ServletException {
		doProcess(req,res);
	
	}
	
	public void doProcess(HttpServletRequest req, HttpServletResponse res) throws 
	IOException, ServletException {
		req.setCharacterEncoding("utf-8");
		res.setCharacterEncoding("utf-8");
		res.setContentType("text/html; charset=utf-8");
		PrintWriter out = res.getWriter(); //웹에 그려주는애
		String cmd = req.getParameter("cmd");
		if(cmd==null) {
			res.sendRedirect("/error.jsp");
		}else if(cmd.equals("list")) {
			String html = "";
			ArrayList<HashMap<String,String>> userList = us.getUserList();
			
			for(HashMap<String,String>map : userList){            //키값을 가져오는 부분
			html +="<tr>";
			 Iterator<String > it = map.keySet().iterator();
			 while(it.hasNext()){
				 String key = it.next();
				 out.println("<td>"+ map.get(key)+"</td>");   //어떤키값인지 몰라도 불러낼수 있는 방법--> iterator패턴
			 }
			 html +="</tr>";
			}
			out.println(html);
		}else {
			res.sendRedirect("/error.jsp");
		}
		
		
	}

	
}
