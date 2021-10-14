<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
   <h1>WEB-INF/views/member/list.jsp</h1>
   
   <h2>회원 목록 관리자(SpringMVC)</h2>
   
   <%-- <h3>아이디: ${mList}</h3> --%>
   
   <table border="1">
   	<tr>
   		<td>아이디</td>
   		<td>비밀번호</td>
   		<td>이름</td>
   		<td>이메일</td>
   		<td>회원가입일</td>
   	</tr>
   		
  
   	<c:forEach var="mvo" items="${mList }">
   		<tr>
   		<td>${mvo.userid }</td>
   		<td>${mvo.userpw }</td>
   		<td>${mvo.username }</td>
   		<td>${mvo.useremail }</td>
   		<td>${mvo.regdate }</td>
   	    </tr>
 		  		
   		</c:forEach>
   
   </table>
   
   <h2><a href="./main">메인</a></h2>
   
   
   
   
   
   
   
   
   
   
   
   
   
   
</body>
</html>