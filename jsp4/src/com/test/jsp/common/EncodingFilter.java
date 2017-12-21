package com.test.jsp.common;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodingFilter implements Filter{

	@Override //종료시에 
	public void destroy() {
	System.out.println("필터클래스 종료!");
	}
	
	
	@Override   //여기서 필터됨
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain fc)
			throws IOException, ServletException {
		req.setCharacterEncoding("utf-8");
		res.setCharacterEncoding("utf-8");
		res.setContentType("text/html;charset=utf-8");
		fc.doFilter(req, res); //여기서 dofilter하는 순간 departServlet으로 이동됨. 
	}

	
	@Override   //생성자 같은느낌
	public void init(FilterConfig fc) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("필터클래스 최초 생성");
	}
}
