package com.itwillbs.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet2 extends HttpServlet {
  
	//http://localhost:8088/JSTL_ELJSP/test2
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("TestServlet2_doGet() 호출");
		
		// request 영역에 문자열 배열 (고정길이 배열)
		String[] foods={
			"짜장면","짬뽕","냉면","삼겹살","피자","돈까스"	
		};
		
		request.setAttribute("foods", foods);
		
		// request 영역에 ArrayList 저장 전달(가변길이 배열)
		// sports
		ArrayList sports = new ArrayList();
		
		sports.add("축구");
		sports.add("야구");
		sports.add("농구");
		sports.add("배구");
		sports.add("당구");
		sports.add("족구");
		
		request.setAttribute("sports", sports);
		
		
		
		
		
		//페이지 이동(./el/ArrayTest.jsp)-forward이동
		RequestDispatcher dis =
				request.getRequestDispatcher("./el/ArrayTest.jsp");
		
		dis.forward(request, response);	
	}
	
	
	

}
