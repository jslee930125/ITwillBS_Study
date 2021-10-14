package com.itwillbs.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class TestServlet1 extends HttpServlet {
 
	// http://localhost:8088/JSTL_ELJSP/test1
	
	// jsp -> jsp 정보 전달
	// java(서블릿) -> jsp 정보 전달
	
	
	// alt shift s + v
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		System.out.println("TestServlet1_doGet() 호출!");
		
		// request 영역에 데이터를 저장
		request.setAttribute("cnt", 100);
		
		// session 영역에 데이터를 저장
		// session.setAttrubute(); (x)
		
		// seesion 객체를 직접 생성(전달)
		HttpSession session = request.getSession();
		session.setAttribute("cnt", 200);		
		
		
		// jsp 페이지로 정보전달
		// jsp 페이지 이동 (./el/AttributeTest.jsp)
		// forward 방법을 사용 
		// 1) 주소처리  a->b    주소  a, 화면 b
		// 2) request 영역의 정보를 가지고 이동
		
		// [./] : 상대경로 
		//     - ./test1  : 가상주소 호출시 [./]의 의미 => 프로젝트명
		//     - ./el/AttributeTest.jsp : 실제주소 호출시 [./]의 의미 => WebContent 폴더
		
		
		RequestDispatcher dis = 
				request.getRequestDispatcher("./el/AttributeTest.jsp");
		
		dis.forward(request, response);	
	}
   
}
