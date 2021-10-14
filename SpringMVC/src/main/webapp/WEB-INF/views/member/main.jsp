<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
   <h1>Web-INF/views/member/main.jsp</h1>
   
   <%
   	// 세션 제어
   	String id = (String) session.getAttribute("userid");
	
     if (id == null) {
    	 System.out.println("View: 메인 - > 로그인 페이지 이동");
		 //response.sendRedirect("/web/member/login");
		 //response.sendRedirect("./login");
		 response.sendRedirect(request.getContextPath()+"/member/login");
		 // context가 내 프로젝트, 프로젝트 경로를 의미 = web
	}
     
   %>
   
   <h2>메인 페이지(SpringMVC)</h2>

   <h3>${sessionScope.userid }님 환영합니다.</h3>
   
   <input type="button" value="로그아웃" onclick="location.href='./logout';">
                                                <!-- location.href의 의미: http://localhost:8080/  -->
   
   <hr><hr>
   
   <h3><a href="info">회원정보 조회(info)</a> </h3>
   <!--"/info"는 안된다. ./info(프로젝트 밑 info)는 상대경로라서 된다.  -->
   
   <h3><a href="./update">회원정보 수정(update)</a> </h3>
   <h3><a href="./delete">회원정보 삭제(delete)</a> </h3>
   
   <%
   	if(id != null && id.equals("admin")){
   		%>
   		
   		<hr><hr>
   		<h3><a href="./list">회원정보 목록(List)</a> </h3>
	   		
   		<%
   		
   		
   		
   	}
   
   %>
   
   
</body>
</html>