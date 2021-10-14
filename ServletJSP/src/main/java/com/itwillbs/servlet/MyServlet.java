package com.itwillbs.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet extends HttpServlet {

	private int cnt = 0; 
	
	@Override
	public void init() throws ServletException {
		System.out.println(" 서블릿 초기화 init() ");		
	}
	
//	@Override
//	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
//        System.out.println(" 서비스 동작 호출 service() ");	
//	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	   System.out.println("doGET() 호출");
	   doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	   System.out.println("doPOST() 호출");
	   
	   cnt++;
	   
	   resp.setContentType("text/html; charset=utf-8");
	   PrintWriter out = resp.getWriter();
	   
	   out.print("<html>");
	   out.print("<head>");
	   out.print("</head>");
	   out.print("<body>");
	   out.print("<h2> 홈페이지 방문자수 : "+cnt+"</h2>");
	   out.print("</body>");
	   out.print("</html>");
	   
	   out.close();
	   
	   
	   
	   
	}

	@Override
	public void destroy() {
	    System.out.println(" 서블릿 소멸 destroy() ");
	}

	
	

}
