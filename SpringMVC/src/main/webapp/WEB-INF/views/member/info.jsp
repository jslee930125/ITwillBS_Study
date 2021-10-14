<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
   <h1>WEB-INF/views/member/info.jsp</h1>
   
   <h2>회원정보 출력 (SpringMVC)</h2>
   
   <h3>아이디: ${vo.userid } </h3>
   <h3>비밀번호: ${vo.userpw }</h3>
   <h3>이름:${vo.username } </h3>
   <h3>이메일: ${vo.useremail } </h3>
   <h3>회원가입일: ${vo.regdate } </h3>
   
   <h2><a href="./main">메인</a></h2>
   
   
   
   
   
   
   
   
   
   
   
   
   
   
</body>
</html>