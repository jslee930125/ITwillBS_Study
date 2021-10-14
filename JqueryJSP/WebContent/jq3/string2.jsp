<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h1>string2.jsp</h1>    
<%
  System.out.println("string2.jsp 호출");
  System.out.println(request.getParameter("name"));
  System.out.println(request.getParameter("age"));	
  
  String name = request.getParameter("name");
  String age = request.getParameter("age");
  
  // 이름 : 홍길동, 나이 : 20살
%>
  <h2>이름 : <%=name %>, 나이 : <%=age %>살 </h2>



