package com.test.jsp.servlet;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.jsp.dto.DepartInfo;
import com.test.jsp.service.DepartService;
import com.test.jsp.service.DepartServiceImpl;

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
		// 필터하면 일로 이동됨/
		String uri = req.getRequestURI();
		String cmd = getCommandForUri(uri);
		System.out.println(cmd);

		RequestDispatcher rd = null;

		if (cmd.equals("list")) {
			String search = req.getParameter("searchOption");
			String searchStr = req.getParameter("diName");

			req.setAttribute("departList", ds.selectDepartList(search, searchStr));
		} else if (cmd.equals("view")||cmd.equals("update")) {
			String diNo = req.getParameter("dino");
			System.out.println(diNo);
			req.setAttribute("depart", ds.selectDepart(Integer.parseInt(diNo)));

		} else if (cmd.equals("insert")) {

		} else if (cmd.equals("insert_ok")) {
			String diName = req.getParameter("diName");
			String diEtc = req.getParameter("diEtc");
			DepartInfo di = new DepartInfo();
			di.setDiName(diName);
			di.setDiEtc(diEtc);
			req.setAttribute("insert", ds.insertDepart(di));
			uri = "/depart/list";

		} else if (cmd.equals("delete")) {
			int diNo = Integer.parseInt(req.getParameter("dino"));
			DepartInfo di = new DepartInfo();
			di.setDiNo(diNo);
			int result = ds.deleteDepart(di);
			String msg = "삭제되었습니다";
			if (result != 1) {
				msg = "삭제실패";
			}
			req.setAttribute("msg", msg);
			uri = "/depart/list";
			
		} else if(cmd.equals("update_ok")){
			DepartInfo di = new DepartInfo();
			String diName = req.getParameter("diName");
			String diEtc = req.getParameter("diEtc");
			int diNo = Integer.parseInt(req.getParameter("diNo"));
			di.setDiNo(diNo);
			di.setDiName(diName);
			di.setDiEtc(diEtc);
			req.setAttribute("update", ds.updateDepart(di));
			uri= "/depart/update";
		}else {
			uri = "/error";
		}
			
		rd = req.getRequestDispatcher("/WEB-INF/view" + uri + ".jsp");
		rd.forward(req, res);
	}
}
