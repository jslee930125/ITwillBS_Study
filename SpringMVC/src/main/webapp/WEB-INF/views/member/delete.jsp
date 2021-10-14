<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>WEB-INF/views/member/delete.jsp</h1>

	<h2>회원 탈퇴(SpringMVC)</h2>
	
	<form action="./delete" method="post">
	 <!--id 정보 session 객체에서 사용 -->
	 <input type="hidden" name="userid" value=${vo.userid }>
	 비밀번호 입력 : <input type="password" name="userpw">
	  	
	  <input type="submit" value="탈퇴하기">
	</form>













</body>
</html>