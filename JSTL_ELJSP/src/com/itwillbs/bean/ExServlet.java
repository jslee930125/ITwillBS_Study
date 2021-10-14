package com.itwillbs.bean;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 에노테이션 : @와같이 표현하는 형태로 특수한 기능을 수행/상태를 표현
// @WebServlet("/ex")
// => 해당 클래스(서블릿)을 주소로 매핑하는 동작 
// => 주소 호출시 해당파일을 실행

// http://localhost:8088/JSTL_ELJSP/*.nhn
//@WebServlet(value="가상주소")
@WebServlet("*.nhn")
public class ExServlet extends HttpServlet {

	// 서블릿 : jsp -> java -> class (실행)
	// => 자바파일을 사용하면서 동시에 웹페이지의 기능 활용가능한 파일
	
	// alt shift s + v
	
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println(" get방식 호출일때 실행 ");
		
		//forward을 사용하여 페이지 보여주기
		/*<jsp:> (x)*/
		RequestDispatcher dis
		   = request.getRequestDispatcher("/core/out.jsp");
		dis.forward(request, response);
		
				
		
		
		
		/*
		 * // 화면에 출력 response.setContentType("text/html; charset=UTF-8"); //
		 * 데이터를 출력하는 동작(출력스트림) PrintWriter out = response.getWriter();
		 * out.println("<html>"); out.println("<head>"); out.println("</head>");
		 * out.println("<body>"); out.println(" <h1> 서블릿 웹페이지 </h1> ");
		 * out.println("</body>"); out.println("</html>");
		 * 
		 * out.close();
		 */
	}

//	@Override
//	protected void doPost(HttpServletRequest request,
//			HttpServletResponse response) throws ServletException, IOException {
//		System.out.println(" post방식 호출일때 실행 ");
//	}
	

}
