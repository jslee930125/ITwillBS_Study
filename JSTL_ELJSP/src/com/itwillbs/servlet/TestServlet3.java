package com.itwillbs.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.bean.Person;
import com.itwillbs.bean.Phone;

@WebServlet("/test3")
public class TestServlet3 extends HttpServlet {
	// 해당클래스를 서블릿으로 변경
	// get방식으로 페이지 호출시 사용
	// Person 사람의 정보를 전달해서 BeanTest.jsp 페이지에서 출력
	
	// Person 사람 - 이름,나이,휴대폰(객체)
	// Phone 휴대폰 - 모델명,전화번호
	// alt shift s + v
	@Override
	protected void doGet(HttpServletRequest request,
              HttpServletResponse response) throws ServletException, IOException {
	
		Phone s21 = new Phone();
		s21.setModel("삼성 S21");
		s21.setTelNum("010-1234-7896");
		
		Person kim = new Person();
		kim.setName("김학생");
		kim.setAge(20);
		kim.setPhone(s21);
		
		// 사람의 정보를 저장해서 -> jsp페이지 전달
		request.setAttribute("person", kim);
	  
		
		RequestDispatcher dis =
				  request.getRequestDispatcher("./el/BeanTest.jsp");
		
		dis.forward(request, response);	
	}
	
	
	
	
}
