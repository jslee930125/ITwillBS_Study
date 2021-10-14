<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>WebContent/member/deleteForm.jsp</h1>

	<h2>회원 삭제 (탈퇴)</h2>
	<!-- 
    회원 정보 확인(세션정보 체크)
    비밀번호 입력
   회원 삭제 페이지로 이동
  -->
	<%
		String id = (String) session.getAttribute("id");

		if (id == null) {
           response.sendRedirect("loginForm.jsp");
		}
	%>
	<form action="deletePro.jsp" method="post">
	 <input type="hidden" name="id" value="<%=id %>" >
	 비밀번호 : <input type="password" name="pass">
	  	
	  <input type="submit" value="탈퇴하기">
	</form>













</body>
</html>