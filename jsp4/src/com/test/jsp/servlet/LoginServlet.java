package com.test.jsp.servlet;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws 
	IOException, ServletException {
		req.setCharacterEncoding("utf-8");
		
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");

		System.out.println("로그인 서블릿 호출 !!");
		res.setContentType("text/html;charset=utf-8");
		PrintWriter pw = res.getWriter();
		pw.print("입력하신 id = " + id);
		pw.print("입력하신 pwd = " + pwd);

	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws 
	IOException, ServletException {
		req.setCharacterEncoding("utf-8");
		
		System.out.println("로그인 서블릿 호출 !!");
		res.setContentType("text/html;charset=utf-8");
		PrintWriter pw = res.getWriter();
		
		
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		
		String testId = "test";
		String testPwd = "test";
		
		
		String msg = "";
		String str =null;
		if(testId.equals(id)) {
			if(testPwd.equals(pwd)) {
				str += "{\"result\":\"ok\",";
				str += "\"msg\":\"로그인에 성공하셨습니다.\"";
				str += "}";
			}else {
				str += "{\"result\":\"ok\",";
				str += "\"msg\":\"비밀번호.\"";
				str += "}";
			}
		}else {
			msg = id + "님 아이디가 없습니다";
		}
		if (!msg.equals("")) {
			pw.println("<script>");
			pw.println("alert('"+msg+"')");
			pw.println("location.href='/login.jsp'");
			pw.println("</script>");
			
		}
	}
}
