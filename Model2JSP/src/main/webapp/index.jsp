<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!--  WebContent/index.jsp  -->
	
	<%
	  // model2 프로젝트의 시작페이지
	  // 실행가능한 유일한 jsp 페이지
	  // 회원가입 페이지 호출
	  // http://localhost:8088/Model2JSP/MemberJoin.me
	  // response.sendRedirect("./MemberJoin.me");
	  //response.sendRedirect("./MemberLogin.me");
	  
	  // 관리자 상품등록 페이지
	  // response.sendRedirect("./GoodsAdd.ag");	
	  // 관리자 상품목록 페이지'
	  // response.sendRedirect("./AdminGoodsList.ag");
	  
	  // 일반 사용자 상품목록 페이지
	  //response.sendRedirect("./GoodsList.go");
	  
	  // 메인 페이지
	  response.sendRedirect("./Main.me");
	%>
</body>
</html>