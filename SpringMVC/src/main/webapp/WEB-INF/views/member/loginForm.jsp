<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
   <h1>Web-INF/views/member/loginForm.jsp</h1>
   
   <%
   	// JSP 페이지에는 
   	//session 내장객체가 있음.
   %>
   
   <h2> 로그인 페이지 </h2>
    <form action="" method="post" >
    	  <!-- 자기자신을 부르는 액션, post방식으로 submit함  -->
	      아이디 : <input type="text" name="userid"><br>
	      비밀번호 : <input type="password" name="userpw"><br>
      
      <input type="submit" value="로그인">    
    </form>
      <input type="button" value="회원가입"
      	onclick="location.href='./joins';">    
    
    
   
   
   
   
   
   
   
   
   
   
   
   
   
   
</body>
</html>