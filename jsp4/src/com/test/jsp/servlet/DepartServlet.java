package com.test.jsp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.jsp.service.DepartService;
import com.test.jsp.service.DepartServiceImpl;
import com.test.jsp.service.UserService;
import com.test.jsp.service.UserServiceImpl;

public class DepartServlet extends HttpServlet {
	DepartService ds = new DepartServiceImpl();
		
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		doProcess(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		doProcess(req, res);
	}

	private String getCommandForUri(String uri) {
		int idx = uri.lastIndexOf("/"); 
		if (idx != -1) {
			return uri.substring(idx + 1);
		}
		return uri;
	}

	public void doProcess(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		req.setCharacterEncoding("utf-8");
		res.setCharacterEncoding("utf-8");
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();
		String uri = req.getRequestURI();
		String cmd = getCommandForUri(uri);
		System.out.println(cmd);

		RequestDispatcher rd = null;
		uri = uri.replace("/s", "/");
		if (cmd.equals("list")) {
			ds.selectDepartList(req);
		} else if (cmd.equals("view")) {

		} else if (cmd.equals("insert")) {
			
		} else if (cmd.equals("update")) {
			
		} else {
			uri = "/error";
		}

		rd = req.getRequestDispatcher(uri + ".jsp");
		rd.forward(req, res);
	}
}
